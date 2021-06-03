// Hibernate19

package com.jareklaskowski7;

import com.jareklaskowski7.dto.FourWheeler;
import com.jareklaskowski7.dto.TwoWheeler;
import com.jareklaskowski7.dto.Vehicle;
import com.jareklaskowski7.utilities.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Hibernate19 {
    public static void main(String[] args) {

        try {
            Session session = HibernateUtil
                    .getSessionFactory()
                    .openSession();
            Transaction transaction = session.getTransaction();
            transaction.begin();

            Vehicle vehicle = new Vehicle();
            vehicle.setName("Vehicle");

            TwoWheeler bike = new TwoWheeler();
            bike.setName("Bianchi");
            bike.setSteeringHandle("Bianchi Steering Handle");

            FourWheeler car = new FourWheeler();
            car.setName("Subaru");
            car.setSteeringWheel("Subaru Steering Wheel");

            session.save(vehicle);
            session.save(bike);
            session.save(car);

            transaction.commit();
            session.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        HibernateUtil.shutdown();
    }
}
