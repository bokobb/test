package org.bbdev.spring.config;

import org.bbdev.spring.database.pool.ConnectionPool;
import org.bbdev.spring.database.repository.CrudRepository;
import org.bbdev.spring.database.repository.UserRepository;
import org.bbdev.web.config.WebConfiguration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.*;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.stereotype.Component;

//@ImportResource("classpath:application.xml")
@Import(WebConfiguration.class)
@Configuration(proxyBeanMethods = false)
@PropertySource("classpath:application.properties")
@ComponentScan(basePackages = "org.bbdev.spring",
        useDefaultFilters = false,
        includeFilters = {
                @Filter(type = FilterType.ANNOTATION, value = Component.class),
                @Filter(type = FilterType.ASSIGNABLE_TYPE, value = CrudRepository.class),
                @Filter(type = FilterType.REGEX, pattern = "org\\..+Repository")
        })
public class ApplicationConfiguration {
        @Bean("pool2")
        @Scope(BeanDefinition.SCOPE_SINGLETON)
        public ConnectionPool pool2(@Value("${db.username}") String username){
                return new ConnectionPool("testName", 20);
        }

        @Bean("pool3")
        @Primary
        @Scope(BeanDefinition.SCOPE_SINGLETON)
        public ConnectionPool pool3(){
                return new ConnectionPool("testPool", 25);
        }

        @Bean
        public UserRepository userRepository(ConnectionPool pool2){
                return new UserRepository(pool2);
        }

        @Bean
        public UserRepository userRepository3(){
                var connectionPool1 = pool3();
                var connectionPool2 = pool3();
                var connectionPool3 = pool3();
                return new UserRepository(pool3());
        }
}
