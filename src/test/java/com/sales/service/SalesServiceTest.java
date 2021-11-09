package com.sales.service;

import com.sales.interfaces.repository.ISalesRepository;
import com.sales.interfaces.service.ISalesService;
import com.sales.model.Product;
import com.sales.model.Sales;
import com.sales.model.Salesman;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@MicronautTest
public class SalesServiceTest {
    @Inject
    private final ISalesService salesService;

    @Mock
    private final ISalesRepository salesRepository = mock(ISalesRepository.class);

    public SalesServiceTest(ISalesService salesService) {
        this.salesService = salesService;
    }
    
    @Test
    public void validateAndInsertSales_validParams_returnSuccess(){
        Sales sales = new Sales();
        Salesman salesman = new Salesman();

        salesman.setName("José");
        salesman.setMatriculaId(0505L);

        sales.setSalesman(salesman);

        Product product = new Product();

        product.setId(1L);
        product.setName("Ventilador");
        product.setPrice(100.00);

        List<Product> productList = new ArrayList<>();
        productList.add(product);

        sales.setProduct(productList);

        when(salesRepository.save(sales)).thenReturn(sales);

        String response = salesService.validateAndInsertSales(sales);

        Assertions.assertEquals("Cadastro de venda efetuado com sucesso!", response);
    }
}
