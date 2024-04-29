package com.sci.dao;

import com.sci.models.*;

import java.sql.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class DBJobHistory {

    public List<JobHistory> get() {

        try (Session session = DBConfig.SESSION_FACTORY.openSession()) {

            // noinspection unchecked
            return session.createQuery("FROM JobHistory").list();

        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }

        return null;
    }

    public JobHistory get(Integer employeeId, Date startDate) {
        JobHistoryKey key = new JobHistoryKey(employeeId, startDate);

        try (Session session = DBConfig.SESSION_FACTORY.openSession()) {

            return session.get(JobHistory.class, key);

        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }

        return null;
    }


    public JobHistoryKey insert(JobHistory jobHistory) {

        Transaction transaction = null;
        JobHistoryKey key = null;

        try (Session session = DBConfig.SESSION_FACTORY.openSession()) {

            transaction = session.beginTransaction();

            key = (JobHistoryKey) session.save(jobHistory);

            transaction.commit();

        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.err.println(ex.getMessage());
        }

        return key;
    }

    public void update(JobHistory jobHistory) {

        Transaction transaction = null;

        try (Session session = DBConfig.SESSION_FACTORY.openSession()) {

            transaction = session.beginTransaction();

            session.update(jobHistory);

            transaction.commit();

        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.err.println(ex.getMessage());
        }
    }

    public void delete(Integer employeeId, Date date) {
        JobHistoryKey key = new JobHistoryKey(employeeId, date);
        Transaction transaction = null;

        try (Session session = DBConfig.SESSION_FACTORY.openSession()) {

            transaction = session.beginTransaction();

            JobHistory jobHistory = get(employeeId, date);

            session.delete(jobHistory);

            transaction.commit();

        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.err.println(ex.getMessage());
        }
    }

}