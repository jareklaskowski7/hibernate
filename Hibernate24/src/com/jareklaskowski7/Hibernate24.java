// Hibernate24

package com.jareklaskowski7;

import com.jareklaskowski7.dto.User;
import com.jareklaskowski7.utilities.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Date;

public class Hibernate24 {
    public static void main(String[] args) {

        try {
            Session session = HibernateUtil
                    .getSessionFactory()
                    .openSession();
            Transaction transaction = session.getTransaction();
            transaction.begin();

            User user = session.get(User.class, 1L);

            transaction.commit();
            session.close();

            //user.setName("Updated name after session is closed");
            //user.setJoinedDate(new Date());
            //user.setDescription("First Beatle");

            session = HibernateUtil
                    .getSessionFactory()
                    .openSession();
            transaction = session.getTransaction();
            transaction.begin();

            session.update(user);
            //user.setName("Change name after update");
            //user.setJoinedDate(new Date());
            //user.setDescription("First Beatle");

            transaction.commit();
            session.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        HibernateUtil.shutdown();
    }
}
