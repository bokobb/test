package org.bbdev.spring.config;

import org.bbdev.spring.database.pool.ConnectionPool;
import org.bbdev.spring.database.repository.CrudRepository;
import org.bbdev.web.config.WebConfiguration;
import org.springframework.context.annotation.*;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.stereotype.Component;

//@ImportResource("classpath:application.xml")
@Import(WebConfiguration.class)
@Configuration
@PropertySource("classpath:application.properties")
@ComponentScan(basePackages = "org.bbdev.spring",
        useDefaultFilters = false,
        includeFilters = {
                @Filter(type = FilterType.ANNOTATION, value = Component.class),
                @Filter(type = FilterType.ASSIGNABLE_TYPE, value = CrudRepository.class),
                @Filter(type = FilterType.REGEX, pattern = "org\\..+Repository")
        })
public class ApplicationConfiguration {
        @Bean
        public ConnectionPool pool2(){
                return new ConnectionPool("testName", 20);
        }

}
