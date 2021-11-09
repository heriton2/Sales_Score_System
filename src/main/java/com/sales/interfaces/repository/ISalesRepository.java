package com.sales.interfaces.repository;

import com.sales.model.Sales;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public abstract class ISalesRepository implements CrudRepository<Sales, Long> {
    private final EntityManager entityManager;

    protected ISalesRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    public List rankingSellersAmount(){
        return entityManager.createQuery("SELECT m.name, m.matriculaId FROM Sales s " +
                        "join Salesman m on s.salesman.id = m.id " +
                        "group by m.id " +
                        "order by SUM(s.amount) desc ")
                .getResultList();
    }

    @Transactional
    public List rankingSellersCount(){
        return entityManager.createQuery("SELECT  m.name, m.matriculaId FROM Sales s " +
                        "join Salesman m on s.salesman.id = m.id " +
                        "group by m.id " +
                        "order by COUNT(s.id) desc")
                .getResultList();
    }
}
