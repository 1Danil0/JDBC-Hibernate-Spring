package com.danilermolenko.spring.project.dao.implementation;

import com.danilermolenko.spring.project.dao.ProjectDao;
import com.danilermolenko.spring.project.entity.Project;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.List;

public class ProjectDAO implements ProjectDao {
    private final SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
    @Override
    public List<Project> findAll() {
        Session session = sessionFactory.openSession();
        List<Project> projects = session.createQuery("from Project ").getResultList();
        session.close();
        return projects;
    }

    @Override
    public Project findById(long id)  {
        Session session = sessionFactory.openSession();
        Project project = session.get(Project.class, id);
        session.close();
        return project;
    }

    @Override
    public void save(Project project)  {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.merge(project);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void update(Project project) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.merge(project);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(long id){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query<Project> query = session.createQuery("delete from Project where id =: projectID");
        query.setParameter("projectID", id);
        query.executeUpdate();
        session.getTransaction().commit();
        session.close();
    }
}
