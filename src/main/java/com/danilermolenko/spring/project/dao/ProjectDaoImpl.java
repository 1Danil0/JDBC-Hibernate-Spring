package com.danilermolenko.spring.project.dao;

import com.danilermolenko.spring.project.entity.Employee;
import com.danilermolenko.spring.project.entity.Project;
import com.danilermolenko.spring.project.util.Connector;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProjectDaoImpl implements ProjectDao{
    private final Connector connector;
    private Connection connection;
    private Statement statement;
    private PreparedStatement preparedStatement;
    public ProjectDaoImpl(Connector connector) {
        this.connector = connector;
    }
    @Override
    public List<Project> findAll() throws SQLException {
        List<Project> allProjects = new ArrayList<>();
        String sql = "select * from projects;";
        try {
            connection = connector.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                Project project = new Project();
                project.setId(resultSet.getLong("id"));
                project.setTitle(resultSet.getString("title"));
                allProjects.add(project);
            }
            resultSet.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if(preparedStatement != null){
                preparedStatement.close();
            }
            if(connection != null){
                connection.close();
            }
        }
        return allProjects;
    }

    @Override
    public Project findById(long id) throws SQLException {
        Project project = new Project();
        String sql = "select * from projects where id = ?;";
        try {
            connection = connector.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            project.setId(resultSet.getLong("id"));
            project.setTitle(resultSet.getString("title"));
            resultSet.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if(preparedStatement != null){
                preparedStatement.close();
            }
            if(connection != null){
                connection.close();
            }
        }
        return project;
    }

    @Override
    public void save(Project project) throws SQLException {
        String sql = "insert into projects (title) values(?);";
        try {
            connection = connector.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, project.getTitle());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if(preparedStatement != null){
                preparedStatement.close();
            }
            if(connection != null){
                connection.close();
            }
        }
    }

    @Override
    public void update(Project project, long id) throws SQLException {
        String sql = "update projects set title = ? where  id = ?;";
        try {
            connection = connector.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, project.getTitle());
            preparedStatement.setLong(2, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if(preparedStatement != null){
                preparedStatement.close();
            }
            if(connection != null){
                connection.close();
            }
        }
    }

    @Override
    public void delete(long id) throws SQLException {
        String sql = "delete from projects where id = ?;";
        try {
            connection = connector.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if(preparedStatement != null){
                preparedStatement.close();
            }
            if(connection != null){
                connection.close();
            }
        }
    }
}
