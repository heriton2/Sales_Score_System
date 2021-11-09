package com.sales.interfaces.service;

import com.sales.model.Product;
import io.micronaut.core.annotation.Introspected;

import java.util.List;

@Introspected
public interface IProductService {
    String validateAndInsertProduct(Product product) throws Exception;
    List<Product> getAllProducts() throws Exception;
    Product getProductById(Long id) throws Exception;
    Product updateProduct(Product product) throws Exception;
    String deleteProduct(Long id) throws Exception;
}
