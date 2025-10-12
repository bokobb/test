package org.bbdev.spring.database.repository;

import java.util.Optional;

public interface CrudRepository<K, E> {
    Optional<E> findById(K id);

    void deleteById(E id);
}
