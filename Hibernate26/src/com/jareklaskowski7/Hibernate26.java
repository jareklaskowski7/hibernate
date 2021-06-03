// Hibernate26

package com.jareklaskowski7;

import com.jareklaskowski7.dto.User;
import com.jareklaskowski7.utilities.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Hibernate26 {
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
            query1.setFirstResult(5);
            query1.setMaxResults(4);
            List<User> users1 = query1.getResultList();

            Query<User> query2 = session.createQuery("from user where id > 5", User.class);
            List<User> users2 = query2.getResultList();

            Query<String> query3 = session.createQuery("select name from user", String.class);
            query3.setFirstResult(6);
            query3.setMaxResults(3);
            List<String> names = query3.getResultList();

            @SuppressWarnings("unchecked")
            Query<Map<Long, String>> query4 = session.createQuery("select new map (id, name) from user");
            List<Map<Long, String>> users4 = query4.getResultList();

            Query<Long> query5 = session.createQuery("select max(id) from user", Long.class);
            long maxId = query5.getSingleResult();

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

            for (String name : names)
                System.out.println(name);
            System.out.println("Size of the list of names = " + names.size());
            System.out.println();

            for (Map<Long, String> users : users4) {
                for (Map.Entry<Long, String> user : users.entrySet()) {
                    System.out.println("User:");
                    System.out.println(user.getKey());
                    System.out.println(user.getValue());
                }
            }
            System.out.println("Size of the map of users4 = " + users4.size());
            System.out.println("Max id of user is: " + maxId);
        } catch (
                Exception ex) {
            ex.printStackTrace();
        }

        HibernateUtil.shutdown();
    }
}
