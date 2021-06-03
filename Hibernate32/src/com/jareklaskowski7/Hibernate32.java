// Hibernate32

package com.jareklaskowski7;

import com.jareklaskowski7.dto.User;
import com.jareklaskowski7.utilities.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Hibernate32 {
    public static void main(String[] args) {

        try {
            Session session = HibernateUtil
                    .getSessionFactory()
                    .openSession();
            Transaction transaction = session.getTransaction();
            transaction.begin();

            User user1 = session.get(User.class, 1L);
            //user1.setName("user 11");
            //User user2 = session1.get(User.class, 1L);

            transaction.commit();
            session.close();

            session = HibernateUtil
                    .getSessionFactory()
                    .openSession();
            transaction = session.getTransaction();
            transaction.begin();

            User user2 = session.get(User.class, 1L);

            transaction.commit();
            session.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        HibernateUtil.shutdown();
    }
}
