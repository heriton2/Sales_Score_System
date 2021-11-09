package com.sales.controller;

import com.sales.interfaces.service.ISalesmanService;
import com.sales.model.Salesman;
import io.micronaut.context.annotation.Parameter;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Delete;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import jakarta.inject.Inject;

import javax.validation.Valid;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Controller("/Salesman")
public class SalesmanController {
    @Inject
    private ISalesmanService salesmanService;

    public SalesmanController(ISalesmanService salesmanService){
        this.salesmanService = salesmanService;
    }

    @Post(uri = "/InsertASalesman", produces = MediaType.APPLICATION_JSON)
    public String insertASalesman(@Valid Salesman salesman) throws Exception {
        return this.salesmanService.validateAndInsertSalesman(salesman);
    }

    @Post(uri = "/InsertASalesmans", produces = MediaType.APPLICATION_JSON)
    public String insertSalesmans(@Valid List<Salesman> salesmans) throws Exception {
        return this.salesmanService.validateAndInsertSalesmansList(salesmans);
    }

    @Get(uri = "/GetSalesmanById", consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
    public Optional<Salesman> getSalesmanById(@Parameter @Valid Long id) throws Exception {
        return this.salesmanService.getSalesmanById(id);
    }

    @Get(uri = "/GetAllSalesmans", produces = MediaType.APPLICATION_JSON)
    public Iterator<Salesman> GetAllSalesmans() throws Exception {
        return this.salesmanService.getAllSalesmans();
    }

    @Post(uri = "/UpdateSalesman", produces = MediaType.APPLICATION_JSON)
    public Salesman updateSalesman(@Valid Salesman salesman) throws Exception {
        return this.salesmanService.updateSalesman(salesman);
    }

    @Delete(uri = "/DeleteSalesman", produces = MediaType.APPLICATION_JSON)
    public String deleteSalesman(@Valid Long id) throws Exception {
        return this.salesmanService.deleteSalesman(id);
    }
}
