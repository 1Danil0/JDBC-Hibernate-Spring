package com.danilermolenko.spring.project.entity;

public class EmpProjConnector {
    private long projectId;
    private long employeeId;

    public EmpProjConnector() {
    }

    public long getProjectId() {
        return projectId;
    }

    public void setProjectId(long projectId) {
        this.projectId = projectId;
    }

    public long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }
}
