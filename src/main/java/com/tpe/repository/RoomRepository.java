package com.tpe.repository;

import com.tpe.config.HibernateUtils;
import com.tpe.domain.Room;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class RoomRepository {
    //ÖDEV: save, findById, findAll
    private Session session;


    //4-c
    public void save(Room room) {

        try {
            session = HibernateUtils.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            session.save(room);
            transaction.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            HibernateUtils.closeSession(session);

        }
    }


    public Room findById(Long roomId) {
        try {
            session = HibernateUtils.getSessionFactory().openSession();
            Room room = session.get(Room.class, roomId);
            return room;
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            HibernateUtils.closeSession(session);
        }
        return null;
    }


    //6-c:
    public List<Room> findAll() {
        try {
            session = HibernateUtils.getSessionFactory().openSession();
            List<Room> rooms = session.createQuery("FROM Room", Room.class).getResultList();
            return rooms;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            HibernateUtils.closeSession(session);
        }
    }

    public void delete(Room room) {
        try {


            session = HibernateUtils.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            //delete from t_hotel where id =
            session.delete(room);
            transaction.commit();
            //insert
        } catch (Exception e) {
            System.err.println(e.getMessage());

        } finally {
            HibernateUtils.closeSession(session);
        }
    }

}
