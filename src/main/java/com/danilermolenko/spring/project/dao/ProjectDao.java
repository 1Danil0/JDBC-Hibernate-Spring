package com.danilermolenko.spring.project.dao;

import com.danilermolenko.spring.project.entity.Project;

import java.sql.SQLException;
import java.util.List;

public interface ProjectDao {
    public List<Project> findAll();
    public Project findById(long id);
    public void save(Project project);
    public void update(Project project);
    public void delete(long id);
}
