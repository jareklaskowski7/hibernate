// Hibernate31

package com.jareklaskowski7;

import com.jareklaskowski7.dto.User;
import com.jareklaskowski7.utilities.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class Hibernate31 {
    public static void main(String[] args) {

        try {
            Session session = HibernateUtil
                    .getSessionFactory()
                    .openSession();
            Transaction transaction = session.getTransaction();
            transaction.begin();
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();

            /*
            for (long i = 0; i < 10; i++) {
                User user = new User();
                user.setName("user " + i);
                session.save(user);
            }

            Criteria criteria1 = session.createCriteria(User.class)
                    .setProjection(Projections.property("id"));
            Criteria criteria2 = session.createCriteria(User.class)
                    .setProjection(Projections.max("id"));
            Criteria criteria3 = session.createCriteria(User.class)
                    .setProjection(Projections.count("id"));
            Criteria criteria4 = session.createCriteria(User.class)
                    .setProjection(Projections.count("id"))
                    .addOrder(Order.desc("id"));
            Criteria criteria5 = session.createCriteria(User.class)
                    .add(example);
            */

            CriteriaQuery<Long> criteriaQuery1 = criteriaBuilder.createQuery(Long.class);
            Root<User> userRoot1 = criteriaQuery1.from(User.class);
            criteriaQuery1.select(userRoot1.get("id"));
            List<Long> usersIds1 = session.createQuery(criteriaQuery1).getResultList();

            CriteriaQuery<Long> criteriaQuery2 = criteriaBuilder.createQuery(Long.class);
            Root<User> userRoot2 = criteriaQuery2.from(User.class);
            criteriaQuery2.select(criteriaBuilder.max(userRoot2.get("id")));
            Long maxId2 = session.createQuery(criteriaQuery2).getSingleResult();

            CriteriaQuery<Long> criteriaQuery3 = criteriaBuilder.createQuery(Long.class);
            Root<User> userRoot3 = criteriaQuery3.from(User.class);
            criteriaQuery3.select(criteriaBuilder.count(userRoot3));
            Long sizeUsers3 = session.createQuery(criteriaQuery3).getSingleResult();

            User user = new User();
            user.setId(5);
            //user.setName("user 4");
            user.setName("user 1%");
            Example example5 = Example.create(user).excludeProperty("name");
            Example example6 = Example.create(user).enableLike();

            transaction.commit();
            session.close();

            System.out.println("The number of users is:" + usersIds1.size());
            for (Long usersId1 : usersIds1)
                System.out.println("User id: " + usersId1);

            System.out.println();

            System.out.println("Highest Id from all of the users is: " + maxId2);

            System.out.println();

            System.out.println("The number of users is: " + sizeUsers3);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        HibernateUtil.shutdown();
    }
}
