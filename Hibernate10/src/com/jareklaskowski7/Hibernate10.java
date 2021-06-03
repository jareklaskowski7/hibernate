// Hibernate10

package com.jareklaskowski7;

import com.jareklaskowski7.dto.Address;
import com.jareklaskowski7.dto.User;
import com.jareklaskowski7.utilities.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Date;

public class Hibernate10 {
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
            Address addr2 = new Address();
            addr2.setStreet("28 Abbey Road");
            addr2.setCity("London");
            addr2.setState("New York");
            addr2.setZipCode("1000");
            user1.getAddresses().add(addr1);
            user1.getAddresses().add(addr2);
            user1.setJoinedDate(new Date());
            user1.setDescription("First Beatle");
            session.save(user1);

            User user2 = new User();
            user2.setName("Paul McCartney");
            Address addr3 = new Address();
            addr3.setStreet("45 Cavern St");
            addr3.setCity("Liverpool");
            addr3.setState("New Jersey");
            addr3.setZipCode("08401");
            Address addr4 = new Address();
            addr4.setStreet("28 Abbey Road");
            addr4.setCity("London");
            addr4.setState("New York");
            addr4.setZipCode("1000");
            user2.getAddresses().add(addr3);
            user2.getAddresses().add(addr4);
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
