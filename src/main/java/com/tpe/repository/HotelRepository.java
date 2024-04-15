package com.tpe.repository;

import com.tpe.config.HibernateUtils;
import com.tpe.domain.Hotel;
import org.hibernate.Session;
import org.hibernate.Transaction;

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
}
