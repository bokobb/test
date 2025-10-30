package org.bbdev.spring.database.repository;

import org.bbdev.spring.database.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CompanyRepository extends JpaRepository<Company, Integer> {


    @Query("select c from Company c " +
            "join fetch c.locales cl " +
            "where c.name = :name")
    Optional<Company> findByName(@Param("name") String name);
    List<Company> findByNameContainingIgnoreCase(String fragment);

}