package com.example.exam_practice.dao.impl;

import com.example.exam_practice.dao.EmployeeDAO;
import com.example.exam_practice.entities.EmployeeEntity;
import com.example.exam_practice.util.PersistenceUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {
    EntityManager entityManager;
    EntityTransaction transaction;
    public EmployeeDAOImpl(){
        entityManager = PersistenceUtil.createEntityManagerFactory().createEntityManager();
        transaction = entityManager.getTransaction();
    }
    @Override
    public List<EmployeeEntity> getAll() {
        List<EmployeeEntity> employees = new ArrayList<>();
        try{
            Query query  = entityManager.createQuery("select s from EmployeeEntity s ORDER BY s.id DESC");
            return query.getResultList();
        }catch (Exception ex){
            System.out.printf(ex.getMessage());
        }
        return employees;
    }

    @Override
    public void createEmployee(EmployeeEntity employee) {
        try{
            transaction.begin();
            entityManager.persist(employee);
            transaction.commit();
        }catch(Exception ex){
            System.out.printf(ex.getMessage());
            transaction.rollback();
        }
    }
}
