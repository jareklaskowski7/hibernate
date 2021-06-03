// Hibernate08

package com.jareklaskowski7;

import com.jareklaskowski7.dto.Address;
import com.jareklaskowski7.dto.User;
import com.jareklaskowski7.utilities.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Date;

public class Hibernate08 {
    public static void main(String[] args) {

        try {
            Session session = HibernateUtil
                    .getSessionFactory()
                    .openSession();
            Transaction transaction = session.getTransaction();
            transaction.begin();

            User user1 = new User();
            user1.setName("John Lennon");
            Address addr1 = new Address();
            addr1.setStreet("37 Hamburg St");
            addr1.setCity("Liverpool");
            addr1.setState("New Jersey");
            addr1.setZipCode("08401");
            user1.setAddress(addr1);
            user1.setJoinedDate(new Date());
            user1.setDescription("First Beatle");
            session.save(user1);

            User user2 = new User();
            user2.setName("Paul McCartney");
            Address addr2 = new Address();
            addr2.setStreet("45 Cavern St");
            addr2.setCity("Liverpool");
            addr2.setState("New Jersey");
            addr2.setZipCode("08401");
            user2.setAddress(addr2);
            user2.setJoinedDate(new Date());
            user2.setDescription("Second Beatle");
            session.save(user2);

            transaction.commit();
            session.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        HibernateUtil.shutdown();
    }
}
