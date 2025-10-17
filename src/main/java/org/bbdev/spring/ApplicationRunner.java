package org.bbdev.spring;

import org.bbdev.spring.config.ApplicationConfiguration;
import org.bbdev.spring.database.pool.ConnectionPool;
import org.bbdev.spring.database.repository.CrudRepository;
import org.bbdev.spring.service.CompanyService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationRunner {
    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class)) {
            context.register(ApplicationRunner.class);
            context.getEnvironment().setActiveProfiles("web","prod");
            context.refresh();
            var connectionPool = context.getBean("pool1", ConnectionPool.class);
            System.out.println(connectionPool);

             var companyService = context.getBean("companyService", CompanyService.class);
            System.out.println(companyService.findById(1));
        }
    }
}
