// Hibernate31

package com.jareklaskowski7.utilities;

import com.jareklaskowski7.dto.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.HashMap;
import java.util.Map;

public class HibernateUtil {
    private static StandardServiceRegistry stdSerRegistry;
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                StandardServiceRegistryBuilder stdSerRegBuilder = new StandardServiceRegistryBuilder();
                Map<String, String> hibernateProperties = new HashMap<>();
                hibernateProperties.put("hibernate.connection.driver_class", "org.postgresql.Driver");
                hibernateProperties.put("hibernate.connection.url", "jdbc:postgresql://localhost:5432/hibernate");
                hibernateProperties.put("hibernate.connection.username", "postgres");
                hibernateProperties.put("hibernate.connection.password", "password");
                hibernateProperties.put("hibernate.connection.pool_size", "1");
                hibernateProperties.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
                hibernateProperties.put("hibernate.format_sql", "true");
                hibernateProperties.put("hibernate.show_sql", "true");
                hibernateProperties.put("hibernate.use_sql_comments", "true");
                hibernateProperties.put("hibernate.hbm2ddl.auto", "update");  // "create"
                hibernateProperties.put("hibernate.cache.region.factory_class", "org.hibernate.cache.internal.NoCachingRegionFactory");

                stdSerRegBuilder.applySettings(hibernateProperties);

                stdSerRegistry = stdSerRegBuilder.build();

                MetadataSources metadataSources = new MetadataSources(stdSerRegistry)
                        .addAnnotatedClass(User.class);

                Metadata metadata = metadataSources
                        .getMetadataBuilder()
                        .build();

                sessionFactory = metadata
                        .getSessionFactoryBuilder()
                        .build();
            } catch (Exception e) {
                System.out.println("SessionFactory creation failed");
                if (stdSerRegistry != null)
                    StandardServiceRegistryBuilder.destroy(stdSerRegistry);
            }
        }

        return sessionFactory;
    }

    public static void shutdown() {
        if (stdSerRegistry != null)
            StandardServiceRegistryBuilder.destroy(stdSerRegistry);
    }
}
