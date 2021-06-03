// Hibernate21

package com.jareklaskowski7;

import com.jareklaskowski7.dto.User;
import com.jareklaskowski7.utilities.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Hibernate21 {
    public static void main(String[] args) {

        try {
            Session session = HibernateUtil
                    .getSessionFactory()
                    .openSession();
            Transaction transaction = session.getTransaction();
            transaction.begin();

            // Create objects
            /*
            for (long i = 0; i < 10; i++) {
                User user = new User();
                user.setName("user " + i);
                session.save(user);
            }
             */

            // Fetch objects
            /*
            User user = session.get(User.class, 6L);
            System.out.println("User name pulled up is: " + user.getName());
             */

            // Delete objects
            /*
            User user = session.get(User.class, 6L);
            session.delete(user);
             */

            // Update objects
            User user = session.get(User.class, 5L);
            user.setName("Updated user");
            session.update(user);

            transaction.commit();
            session.close();

            //System.out.println("User name pulled up is: " + user.getName());
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        HibernateUtil.shutdown();
    }
}
