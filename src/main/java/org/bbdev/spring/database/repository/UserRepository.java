package org.bbdev.spring.database.repository;

import org.bbdev.spring.database.pool.ConnetionPool;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

@Repository
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class UserRepository {
    private final ConnetionPool connetionPool;

    public UserRepository(ConnetionPool connetionPool) {
        this.connetionPool = connetionPool;
    }
}
