package org.bbdev.spring.database.repository;

import jakarta.annotation.PostConstruct;
import org.bbdev.spring.bpp.Auditing;
import org.bbdev.spring.bpp.Transaction;
import org.bbdev.spring.database.entity.Company;
import org.bbdev.spring.database.pool.ConnetionPool;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Scope(BeanDefinition.SCOPE_SINGLETON)
@Transaction
@Auditing
public class CompanyRepository implements CrudRepository<Integer, Company> {
    private final ConnetionPool pool1;
    private final List<ConnetionPool> pools;
    private final Integer poolSize;

    public CompanyRepository(ConnetionPool pool1,
                             List<ConnetionPool> pools,
                             @Value("${db.pool.size}") Integer poolSize) {
        this.pool1 = pool1;
        this.pools = pools;
        this.poolSize = poolSize;
    }

    @PostConstruct
    private void init() {
        System.out.println("init company repository");
    }

    @Override
    public Optional<Company> findById(Integer id) {
        System.out.println("findById");
        return Optional.of(new Company(id));
    }

    @Override
    public void deleteById(Company id) {
        System.out.println("deleteById");
    }
}
