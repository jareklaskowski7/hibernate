// Hibernate01
//https://www.boraji.com/hibernate-5-save-or-persist-an-entity-example

package com.jareklaskowski7;

import com.jareklaskowski7.dto.User;
import com.jareklaskowski7.utilities.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Date;

public class Hibernate01 {
    public static void main(String[] args) {

        try {
            Session session = HibernateUtil
                    .getSessionFactory()
                    .openSession();
            Transaction transaction = session.getTransaction();
            transaction.begin();

            User user1 = new User();
            //user.setUserId(1L);
            user1.setName("John Lennon");
            user1.setAddress("37 Hamburg St");
            user1.setJoinedDate(new Date());
            user1.setDescription("First Beatle");
            session.save(user1);

            User user2 = new User();
            user2.setName("Paul McCartney");
            user2.setAddress("45 Cavern St");
            user2.setJoinedDate(new Date());
            user2.setDescription("Second Beatle");
            session.save(user2);

            transaction.commit();
            session.close();

            //user = null;
            /*
            session = HibernateUtil
                    .getSessionFactory()
                    .openSession();
             */
            //transaction = session.getTransaction();
            //transaction.begin();
            //user = (User) session.get(User.class, 1L);
            //user = session.get(User.class, 1L);
            //System.out.println("User Name retrieved is " + user.getUserName());
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        HibernateUtil.shutdown();
    }
}
