// Hibernate22

package com.jareklaskowski7;

import com.jareklaskowski7.dto.User;
import com.jareklaskowski7.utilities.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Hibernate22 {
    public static void main(String[] args) {

        try {
            Session session = HibernateUtil
                    .getSessionFactory()
                    .openSession();
            Transaction transaction = session.getTransaction();
            transaction.begin();

            User user = new User();
            user.setName("Test User");

            session.save(user);
            user.setName("Updated User");
            user.setName("Updated User Again");

            transaction.commit();
            session.close();

            user.setName("Updated User After Session is closed");
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        HibernateUtil.shutdown();
    }
}
