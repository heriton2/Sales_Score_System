package com.sales.controller;

import com.sales.interfaces.service.IProductService;
import com.sales.model.Product;
import io.micronaut.context.annotation.Parameter;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Delete;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.Put;
import io.micronaut.validation.Validated;
import jakarta.inject.Inject;

import javax.validation.Valid;
import java.util.List;

@Validated
@Controller("/Product")
public class ProductController {

    private final IProductService productService;

    @Inject
    public ProductController(IProductService productService){
        this.productService=productService;
    }

    @Post(uri = "/InsertAProduct", consumes = MediaType.APPLICATION_JSON,produces = MediaType.APPLICATION_JSON)
    public String insertAProduct(@Valid Product product) throws Exception {
        return this.productService.validateAndInsertProduct(product);
    }

    @Get(uri = "/GetProductById",consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
    public Product getProductById(@Parameter @Valid Long id) throws Exception {

        return this.productService.getProductById(id);
    }

    @Get(uri = "/GetAllProducts", produces = MediaType.APPLICATION_JSON)
    public List<Product> GetAllProducts() throws Exception {
        return this.productService.getAllProducts();
    }

    @Put(uri = "/UpdateProduct", produces = MediaType.APPLICATION_JSON)
    public Product deleteProduct(@Valid Product product) throws Exception {
        return this.productService.updateProduct(product);
    }

    @Delete(uri = "/DeleteProduct", produces = MediaType.APPLICATION_JSON)
    public String deleteProduct(@Valid Long id) throws Exception {
        return this.productService.deleteProduct(id);
    }
}
