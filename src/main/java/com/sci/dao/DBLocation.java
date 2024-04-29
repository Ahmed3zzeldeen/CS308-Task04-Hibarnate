package com.sci.dao;

import com.sci.models.Location;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class DBLocation {

    public List<Location> getAllLocations() {

        try (Session session = DBConfig.SESSION_FACTORY.openSession()) {

            // noinspection unchecked
            return session.createQuery("FROM Location").list();

        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }

        return null;
    }

    public Location getLocationById(Integer locationId) {

        try (Session session = DBConfig.SESSION_FACTORY.openSession()) {

            return session.get(Location.class, locationId);

        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }

        return null;
    }


    public Integer insert(Location location) {

        Transaction transaction = null;
        int locationId = 0;

        try (Session session = DBConfig.SESSION_FACTORY.openSession()) {

            transaction = session.beginTransaction();

            locationId = (Integer) session.save(location);

            transaction.commit();

        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.err.println(ex.getMessage());
        }

        return locationId;
    }

    public void update(Location location) {

        Transaction transaction = null;

        try (Session session = DBConfig.SESSION_FACTORY.openSession()) {

            transaction = session.beginTransaction();

            session.update(location);

            transaction.commit();

        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.err.println(ex.getMessage());
        }
    }

    public void delete(Integer locationId) {

        Transaction transaction = null;

        try (Session session = DBConfig.SESSION_FACTORY.openSession()) {

            transaction = session.beginTransaction();

            Location location = getLocationById(locationId);

            session.delete(location);

            transaction.commit();

        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.err.println(ex.getMessage());
        }
    }

}