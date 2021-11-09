package com.sales.interfaces.repository;

import com.sales.model.Salesman;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

@Repository
public interface ISalesmanRepository extends CrudRepository<Salesman, Long> {
}
