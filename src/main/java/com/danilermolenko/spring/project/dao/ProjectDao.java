package com.danilermolenko.spring.project.dao;

import com.danilermolenko.spring.project.entity.Project;

import java.sql.SQLException;
import java.util.List;

public interface ProjectDao {
    public List<Project> findAll() throws SQLException;
    public Project findById(long id) throws SQLException;
    public void save(Project project) throws SQLException;
    public void update(Project project, long id) throws SQLException;
    public void delete(long id) throws SQLException;
}
