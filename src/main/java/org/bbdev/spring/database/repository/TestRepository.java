package org.bbdev.spring.database.repository;

import org.bbdev.spring.database.pool.ConnectionPool;
import org.springframework.stereotype.Repository;

@Repository
public class TestRepository {
    private final ConnectionPool connetionPool;

    public TestRepository(ConnectionPool connetionPool) {
        this.connetionPool = connetionPool;
    }
}
