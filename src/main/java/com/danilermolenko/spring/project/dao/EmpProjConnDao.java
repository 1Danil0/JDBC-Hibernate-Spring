package com.danilermolenko.spring.project.dao;

import com.danilermolenko.spring.project.entity.EmpProjConnector;

import java.sql.SQLException;

public interface EmpProjConnDao {

    public void save(EmpProjConnector empProjConnector) throws SQLException;

}
