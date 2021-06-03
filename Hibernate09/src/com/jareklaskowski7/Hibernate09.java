// Hibernate09

package com.jareklaskowski7;

import com.jareklaskowski7.dto.Address;
import com.jareklaskowski7.dto.User;
import com.jareklaskowski7.utilities.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Date;

public class Hibernate09 {
    public static void main(String[] args) {

        try {
            Session session = HibernateUtil
                    .getSessionFactory()
                    .openSession();
            Transaction transaction = session.getTransaction();
            transaction.begin();

            User user1 = new User();
            user1.setName("John Lennon");
            Address homeAddr1 = new Address();
            homeAddr1.setStreet("37 Hamburg St");
            homeAddr1.setCity("Liverpool");
            homeAddr1.setState("New Jersey");
            homeAddr1.setZipCode("08401");
            user1.setHomeAddress(homeAddr1);
            Address officeAddr1 = new Address();
            officeAddr1.setStreet("28 Abbey Road");
            officeAddr1.setCity("London");
            officeAddr1.setState("New York");
            officeAddr1.setZipCode("1000");
            user1.setOfficeAddress(officeAddr1);
            user1.setJoinedDate(new Date());
            user1.setDescription("First Beatle");
            session.save(user1);

            User user2 = new User();
            user2.setName("Paul McCartney");
            Address homeAddr2 = new Address();
            homeAddr2.setStreet("45 Cavern St");
            homeAddr2.setCity("Liverpool");
            homeAddr2.setState("New Jersey");
            homeAddr2.setZipCode("08401");
            user2.setHomeAddress(homeAddr2);
            Address officeAddr2 = new Address();
            officeAddr2.setStreet("28 Abbey Road");
            officeAddr2.setCity("London");
            officeAddr2.setState("New York");
            officeAddr2.setZipCode("1000");
            user2.setOfficeAddress(officeAddr2);
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
