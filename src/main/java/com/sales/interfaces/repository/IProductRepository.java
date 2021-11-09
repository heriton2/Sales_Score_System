package com.sales.interfaces.repository;

import com.sales.model.Product;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

@Repository
public interface IProductRepository extends CrudRepository<Product, Long> {

}
