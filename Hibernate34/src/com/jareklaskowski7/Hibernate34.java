// Hibernate34

package com.jareklaskowski7;

import com.jareklaskowski7.dto.User;
import com.jareklaskowski7.utilities.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class Hibernate34 {
    public static void main(String[] args) {

        try {
            Session session = HibernateUtil
                    .getSessionFactory()
                    .openSession();
            Transaction transaction = session.getTransaction();
            transaction.begin();

            Query query1 = session.createQuery("from user where id = 1L", User.class);
            query1.setCacheable(true);
            @SuppressWarnings("unchecked")
            List<User> users = query1.getResultList();

            transaction.commit();
            session.close();

            session = HibernateUtil
                    .getSessionFactory()
                    .openSession();
            transaction = session.getTransaction();
            transaction.begin();

            Query query2 = session.createQuery("from user where id = 1L", User.class);
            query2.setCacheable(true);
            users = query2.getResultList();

            transaction.commit();
            session.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        HibernateUtil.shutdown();
    }
}
