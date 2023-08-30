package com.danilermolenko.spring.project.dao;

import com.danilermolenko.spring.project.entity.EmpProjConnector;
import com.danilermolenko.spring.project.util.Connector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmpProjDaoConnImpl implements EmpProjConnDao{
    private  final Connector connector;
    private Connection connection;
    private PreparedStatement preparedStatement;
    public EmpProjDaoConnImpl(Connector connector) {
        this.connector = connector;
    }

    @Override
    public void save(EmpProjConnector empProjConnector) throws SQLException {
        String sql = "insert into empl_proj_conn (employee_id, project_id) values (?, ?);";
        try {
            connection = connector.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, empProjConnector.getEmployeeId());
            preparedStatement.setLong(2, empProjConnector.getProjectId());
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
