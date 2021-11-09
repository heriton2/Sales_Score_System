package com.sales.service;

import com.sales.interfaces.repository.IProductRepository;
import com.sales.interfaces.service.IProductService;
import com.sales.model.Product;
import io.micronaut.test.annotation.MockBean;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Spy;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@MicronautTest
@MockBean(IProductService.class)
public class ProductServiceTest {

    @Inject
    private final IProductService productService;

    @Mock
    private final IProductRepository productRepository = mock(IProductRepository.class);

    public ProductServiceTest(IProductService productService) {
        this.productService = productService;
    }

    @Test
    public void validateAndInsertProduct_passedValidParameters_returnSuccessMessage() throws Exception {
        Product product = new Product();

        product.setName("Ventilador");
        product.setPrice(100.00);

        when(productRepository.save(product)).thenReturn(product);

        String response = productService.validateAndInsertProduct(product);

        Assertions.assertEquals("Produto Ventilador inserido com sucesso", response);
    }

    @Test
    public void getProductById_validId_returnProduct() throws Exception {
        Product product = new Product();

        product.setId(1L);
        product.setName("Ventilador");
        product.setPrice(100.00);

        Long productId = 1L;

        Optional<Product> optProduct = Optional.of(product);

        when(productRepository.findById(productId)).thenReturn(optProduct);

        Product response = productService.getProductById(productId);

        verify(productRepository,times(1)).findById(productId);
    }

    @Test
    public void GetAllProducts_noParameters_returnProducts() throws Exception {
        Product product = new Product();

        product.setId(1L);
        product.setName("Ventilador");
        product.setPrice(100.00);

        List<Product> products = new ArrayList<>();
        products.add(product);

        when(productRepository.findAll()).thenReturn(products);

        List<Product> response = productService.getAllProducts();

        Assertions.assertEquals(response, products);

    }

    @Test
    public void UpdateProduct_newPrice_returnSuccessMessage() throws Exception {

        Product product = new Product();

        product.setId(1L);
        product.setName("Ventilador");
        product.setPrice(150.00);

        when(productRepository.update(product)).thenReturn(product);

        Product response = productService.updateProduct(product);

        Assertions.assertEquals(product.getPrice(), response.getPrice());

    }

    @Test
    public void deleteProduct_validProductId_expectedSuccessMessage() throws Exception {
        Product product = new Product();

        product.setId(1L);
        product.setName("Ventilador");
        product.setPrice(150.00);


        when(productRepository.findById(anyLong())).thenReturn(Optional.ofNullable(eq(product)));
        doNothing().when(productRepository).delete(product);

        String response = productService.deleteProduct(1L);

        Assertions.assertEquals("",response);
    }

}