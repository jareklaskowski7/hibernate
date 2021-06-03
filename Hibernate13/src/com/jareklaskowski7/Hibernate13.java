// Hibernate13

package com.jareklaskowski7;

import com.jareklaskowski7.dto.User;
import com.jareklaskowski7.dto.Vehicle;
import com.jareklaskowski7.utilities.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Date;

public class Hibernate13 {
    public static void main(String[] args) {

        try (Session session = HibernateUtil
                .getSessionFactory()
                .openSession()) {
            Transaction transaction = session.getTransaction();
            transaction.begin();

            User user1 = new User();
            user1.setName("John Lennon");
            user1.setJoinedDate(new Date());
            user1.setDescription("First Beatle");
            Vehicle vehicle1 = new Vehicle();
            vehicle1.setName("subaru");
            user1.setVehicle(vehicle1);
            session.save(user1);
            session.save(vehicle1);

            User user2 = new User();
            user2.setName("Paul McCartney");
            user2.setJoinedDate(new Date());
            user2.setDescription("Second Beatle");
            Vehicle vehicle2 = new Vehicle();
            vehicle2.setName("honda");
            user2.setVehicle(vehicle2);
            session.save(user2);
            session.save(vehicle2);

            transaction.commit();
            session.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        HibernateUtil.shutdown();
    }
}
