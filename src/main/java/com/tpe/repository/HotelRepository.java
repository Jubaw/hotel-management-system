package com.tpe.repository;

import com.tpe.config.HibernateUtils;
import com.tpe.domain.Hotel;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

//Room,Guest ve Reservation için service ve repo classlarını oluşturalım. Ödev:
public class HotelRepository {

    private Session session;

    //1-B:
    public void save(Hotel hotel) {
        try {


            session = HibernateUtils.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            session.save(hotel);//insert into t_hotel value values
            transaction.commit();
            //insert
        }catch (Exception e){
            System.err.println(e.getMessage());

        }finally {
            HibernateUtils.closeSession(session);
        }

    }

    //2-b
    public Hotel findById(Long id){
        try {


            session = HibernateUtils.getSessionFactory().openSession();
            return session.get(Hotel.class,id);
        }catch (Exception e){
            System.err.println(e.getMessage());

        }finally {
            HibernateUtils.closeSession(session);
        }
        return null;
    }

    //3-b
    public List<Hotel> findAll(){
        try {


            session = HibernateUtils.getSessionFactory().openSession();
            //SELECT * FROM t_hotel
            return session.createQuery("FROM Hotel",Hotel.class).getResultList();
        }catch (Exception e){
            System.err.println(e.getMessage());

        }finally {
            HibernateUtils.closeSession(session);
        }
        return null;
    }

}
