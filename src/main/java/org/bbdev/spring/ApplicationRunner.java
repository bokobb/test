package org.bbdev.spring;

import org.bbdev.spring.config.ApplicationConfiguration;
import org.bbdev.spring.database.pool.ConnectionPool;
import org.bbdev.spring.database.repository.CrudRepository;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationRunner {
    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class)) {
            var connectionPool = context.getBean(ConnectionPool.class);
            System.out.println(connectionPool);

             var companyRepository = context.getBean("companyRepository", CrudRepository.class);
            System.out.println(companyRepository.findById(1));
        }
    }
}
