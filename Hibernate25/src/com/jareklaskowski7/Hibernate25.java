// Hibernate25

package com.jareklaskowski7;

import com.jareklaskowski7.dto.User;
import com.jareklaskowski7.utilities.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class Hibernate25 {
    public static void main(String[] args) {

        try {
            Session session = HibernateUtil
                    .getSessionFactory()
                    .openSession();
            Transaction transaction = session.getTransaction();
            transaction.begin();

            /*
            for (long i = 0; i < 10; i++) {
                User user = new User();
                user.setName("user " + i);
                session.save(user);
            }
             */

            Query<User> query1 = session.createQuery("from user", User.class);
            Query<User> query2 = session.createQuery("from user where id > 5", User.class);
            List<User> users1 = query1.list();
            List<User> users2 = query2.list();

            transaction.commit();
            session.close();
            System.out.println("Size of the list of users1 = " + users1.size());
            System.out.println("Size of the list of users2 = " + users2.size());
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        HibernateUtil.shutdown();
    }
}
