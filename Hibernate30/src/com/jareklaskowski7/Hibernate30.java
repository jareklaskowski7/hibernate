// Hibernate30

package com.jareklaskowski7;

import com.jareklaskowski7.dto.User;
import com.jareklaskowski7.utilities.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class Hibernate30 {
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

            Criteria criteria = session.createCriteria(User.class);
            criteria.add(Restrictions.eq("name", "user 9"))
                    .add(Restrictions.eq("id", 5L));
            @SuppressWarnings("unchecked")
            List<User> users = criteria.list();
             */

            CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
            Root<User> userRoot = criteriaQuery.from(User.class);
            criteriaQuery
                    .select(userRoot)
                    .where(
                            //criteriaBuilder.equal(userRoot.get("name"), "user 9"),
                            //criteriaBuilder.greaterThan(userRoot.get("id"), 5L)
                            //criteriaBuilder.like(userRoot.get("name"), "%user 7%"),
                            //criteriaBuilder.between(userRoot.get("id"), 5, 50)

                            criteriaBuilder.or(
                                    criteriaBuilder.between(userRoot.get("id"), 0, 3),
                                    criteriaBuilder.between(userRoot.get("id"), 7, 10)
                            )
                    );
            List<User> users = session.createQuery(criteriaQuery).getResultList();

            transaction.commit();
            session.close();

            for (User user : users)
                System.out.println(user.getName());
            System.out.println("Size of the list of users = " + users.size());
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        HibernateUtil.shutdown();
    }
}
