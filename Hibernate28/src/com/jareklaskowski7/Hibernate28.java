// Hibernate28

package com.jareklaskowski7;

import com.jareklaskowski7.dto.User;
import com.jareklaskowski7.utilities.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import javax.persistence.TypedQuery;

public class Hibernate28 {
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

            /*
            TypedQuery<User> query1 = session.createNamedQuery("user.byId", User.class);
            query1.setParameter("user_id", 2L);
            User user1 = query1.getSingleResult();
             */

            User user2 = (User) session
                    .createNamedQuery("user.byId")
                    .setParameter("user_id", 3L)
                    .getSingleResult();

            /*
            @SuppressWarnings("unchecked")
            NativeQuery<User> query3 = session.getNamedNativeQuery("user.byName");
            query3.setParameter("user_name", "user 8");
            User user3 = query3.getSingleResult();
             */

            User user4 = (User) session
                    .getNamedNativeQuery("user.byName")
                    .setParameter("user_name", "user 9")
                    .getSingleResult();

            transaction.commit();
            session.close();

            //System.out.println("The user of id = " + user1);
            System.out.println("The user of id = " + user2);
            //System.out.println("The user of name = " + user3);
            System.out.println("The user of name = " + user4);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        HibernateUtil.shutdown();
    }
}
