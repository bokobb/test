package org.bbdev.spring.database.pool;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("pool1")
public class ConnetionPool {
    private final String username;
    private final Integer poolSize;

    @Autowired
    public ConnetionPool(@Value("${db.username}") String username,
                         @Value("${db.pool.size}") Integer poolSize) {
        this.username = username;
        this.poolSize = poolSize;

    }

    @PostConstruct
    private void init(){
        System.out.println("ConnetionPool init");
    }

    @PreDestroy
    private void destroy() {
        System.out.println("ConnetionPool destroy");
    }
}
