package org.bbdev.spring.database.repository;

import org.bbdev.spring.database.pool.ConnetionPool;
import org.springframework.stereotype.Repository;

@Repository
public class TestRepository {
    private final ConnetionPool connetionPool;

    public TestRepository(ConnetionPool connetionPool) {
        this.connetionPool = connetionPool;
    }
}
