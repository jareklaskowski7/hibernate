// Hibernate15

package com.jareklaskowski7;

import com.jareklaskowski7.dto.Gun;
import com.jareklaskowski7.dto.User;
import com.jareklaskowski7.dto.Vehicle;
import com.jareklaskowski7.utilities.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Date;

public class Hibernate15 {
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
            user1.getVehicles().add(vehicle1);
            vehicle1.setUser(user1);
            Vehicle vehicle2 = new Vehicle();
            vehicle2.setName("volvo");
            user1.getVehicles().add(vehicle2);
            vehicle2.setUser(user1);

            session.save(user1);
            session.save(vehicle1);
            session.save(vehicle2);

            User user2 = new User();
            user2.setName("Paul McCartney");
            user2.setJoinedDate(new Date());
            user2.setDescription("Second Beatle");
            Vehicle vehicle3 = new Vehicle();
            vehicle3.setName("honda");
            user2.getVehicles().add(vehicle3);
            vehicle3.setUser(user2);
            Vehicle vehicle4 = new Vehicle();
            vehicle4.setName("toyota");
            user2.getVehicles().add(vehicle4);
            vehicle4.setUser(user2);

            session.save(user2);
            session.save(vehicle3);
            session.save(vehicle4);

            User user3 = new User();
            user3.setName("George Harrison");
            user3.setJoinedDate(new Date());
            user3.setDescription("Third Beatle");
            Gun gun5 = new Gun();
            gun5.setName("ruger gp100");
            user3.getGuns().add(gun5);
            gun5.getUsers().add(user3);
            Gun gun6 = new Gun();
            gun6.setName("smith model 27");
            user3.getGuns().add(gun6);
            gun6.getUsers().add(user3);

            session.save(user3);
            session.save(gun5);
            session.save(gun6);

            transaction.commit();
            session.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        HibernateUtil.shutdown();
    }
}
