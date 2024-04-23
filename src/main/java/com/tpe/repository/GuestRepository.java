package com.tpe.repository;

import com.tpe.config.HibernateUtils;
import com.tpe.domain.Guest;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class GuestRepository {
    private Session session;

    // ödev2
    public Guest findById(Long id) {
        try {
            session = HibernateUtils.getSessionFactory().openSession();
            return session.get(Guest.class, id);

        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            HibernateUtils.closeSession(session);
        }
        return null;
    }

    // ödev3
    public List<Guest> findAll() {

        try {
            session = HibernateUtils.getSessionFactory().openSession();
            List<Guest> guests = session.createQuery("FROM Guest", Guest.class).getResultList();
            return guests;
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            HibernateUtils.closeSession(session);
        }
        return null;
    }

    //9-c
    public void save(Guest guest) {


        try {
            session = HibernateUtils.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            session.save(guest);
            transaction.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            HibernateUtils.closeSession(session);

        }


    }

    //10-c
    public void delete(Guest guestFound) {

        try {
            session = HibernateUtils.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            //delete from t_hotel where id =
            session.delete(guestFound);
            transaction.commit();
            //insert
        } catch (Exception e) {
            System.err.println(e.getMessage());

        } finally {
            HibernateUtils.closeSession(session);
        }
    }
}
