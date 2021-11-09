package com.sales.controller;

import com.sales.interfaces.service.ISalesService;
import com.sales.model.Product;
import com.sales.model.Sales;
import com.sales.model.Salesman;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.validation.Validated;
import jakarta.inject.Inject;

import javax.validation.Valid;
import java.util.List;

@Validated
@Controller("/Sales")
public class SalesController {
    private final ISalesService salesService;

    @Inject
    public SalesController(ISalesService salesService) {
        this.salesService = salesService;
    }

    @Post(uri = "/InsertSales", consumes = MediaType.APPLICATION_JSON,produces = MediaType.APPLICATION_JSON)
    public String insertSales(@Valid Sales sales) throws Exception {
        return this.salesService.validateAndInsertSales(sales);
    }

    @Get(uri="rankingSellersByAmount", consumes = MediaType.APPLICATION_JSON,produces = MediaType.APPLICATION_JSON)
    public List rankingSellersByAmount(){
        return this.salesService.rankingSellersAmount();
    }

    @Get(uri = "rankingSellersCount", consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
    public List rankingSellersCount(){return this.rankingSellersCount();}
}
