package com.sales.interfaces.service;

import com.sales.model.Salesman;
import io.micronaut.core.annotation.Introspected;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Introspected
public interface ISalesmanService {
    String validateAndInsertSalesman(Salesman salesman) throws Exception;
    String validateAndInsertSalesmansList(List<Salesman> salesmans) throws Exception;
    Iterator<Salesman> getAllSalesmans() throws Exception;
    Optional<Salesman> getSalesmanById(Long id) throws Exception;
    Salesman updateSalesman(Salesman salesman) throws Exception;
    String deleteSalesman(Long id) throws Exception;
}
