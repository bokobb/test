package org.bbdev.spring.database.repository;

import org.bbdev.spring.database.pool.ConnectionPool;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

@Repository
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class UserRepository {
    private final ConnectionPool connetionPool;

    public UserRepository(@Qualifier("pool2")ConnectionPool connetionPool) {
        this.connetionPool = connetionPool;
    }
}
