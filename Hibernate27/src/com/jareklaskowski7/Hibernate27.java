// Hibernate27

package com.jareklaskowski7;

import com.jareklaskowski7.dto.User;
import com.jareklaskowski7.utilities.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class Hibernate27 {
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

            long minUserId1 = 4;
            String minUserId2 = " 5 or 1 = 1";
            String minUserId3 = "6";
            String minUserId4 = "7";
            String name4 = "user 8";
            String minUserId5 = "3";
            String name5 = "user 9";

            Query<User> query1 = session.createQuery("from user where id > " + minUserId1, User.class);

            Query<User> query2 = session.createQuery("from user where id > " + minUserId2, User.class);

            //Query<User> query3 = session.createQuery("from user where id > ?", User.class);
            Query<User> query3 = session.createQuery("from user where id > :id", User.class);
            query3.setParameter("id", Long.parseLong(minUserId3));

            Query<User> query4 = session.createQuery("from user where id > :id and name = :name", User.class);
            query4.setParameter("id", Long.parseLong(minUserId4));
            query4.setParameter("name", name4);

            Query<User> query5 = session.createQuery("from user where id > :id and name = :name", User.class);
            query5.setParameter("id", Long.parseLong(minUserId5));
            query5.setParameter("name", name5);

            List<User> users1 = query1.getResultList();
            List<User> users2 = query2.getResultList();
            List<User> users3 = query3.getResultList();
            List<User> users4 = query4.getResultList();
            List<User> users5 = query5.getResultList();

            transaction.commit();
            session.close();

            for (User user : users1)
                System.out.println(user.getName());
            System.out.println("Size of the list of users1 = " + users1.size());

            System.out.println();

            for (User user : users2)
                System.out.println(user.getName());
            System.out.println("Size of the list of users2 = " + users2.size());

            System.out.println();

            for (User user : users3)
                System.out.println(user.getName());
            System.out.println("Size of the list of users3 = " + users3.size());

            System.out.println();

            for (User user : users4)
                System.out.println(user.getName());
            System.out.println("Size of the list of users4 = " + users4.size());

            System.out.println();

            for (User user : users5)
                System.out.println(user.getName());
            System.out.println("Size of the list of users5 = " + users5.size());
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        HibernateUtil.shutdown();
    }
}
