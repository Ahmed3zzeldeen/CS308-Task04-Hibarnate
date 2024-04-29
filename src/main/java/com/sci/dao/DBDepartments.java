package com.sci.dao;

import com.sci.models.Department;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class DBDepartments {

    public List<Department> getAllDepartments(){
        try(Session session = DBConfig.SESSION_FACTORY.openSession()) {

            // noinspection unchecked
            return session.createQuery("FROM Department").list();

        } catch (Exception err){
            System.out.println(err.getMessage());
        }

        return null;
    }

    public Department getDepartmentById(Integer departmentId) {

        try (Session session = DBConfig.SESSION_FACTORY.openSession()) {
            return session.get(Department.class, departmentId);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }

        return null;
    }

    public Integer insert(Department department) {

        Transaction transaction = null;

        int departmentId = 0;

        try (Session session = DBConfig.SESSION_FACTORY.openSession()) {

            transaction = session.beginTransaction();

            departmentId = (Integer) session.save(department);

            transaction.commit();

        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.err.println(ex.getMessage());
        }

        return departmentId;
    }

    public void update(Department department) {

        Transaction transaction = null;

        try (Session session = DBConfig.SESSION_FACTORY.openSession()) {

            transaction = session.beginTransaction();

            session.update(department);

            transaction.commit();

        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.err.println(ex.getMessage());
        }
    }

    public void delete(Integer departmentId) {

        Transaction transaction = null;

        try (Session session = DBConfig.SESSION_FACTORY.openSession()) {

            transaction = session.beginTransaction();

            Department department = getDepartmentById(departmentId);

            session.delete(department);

            transaction.commit();

        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.err.println(ex.getMessage());
        }
    }
    
}
