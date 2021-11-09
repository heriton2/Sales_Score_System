package com.sales.service;

import com.sales.interfaces.repository.ISalesRepository;
import com.sales.interfaces.service.ISalesService;
import com.sales.model.Product;
import com.sales.model.Sales;
import com.sales.model.Salesman;
import io.micronaut.core.annotation.Introspected;
import jakarta.inject.Inject;
import org.hibernate.Session;

import java.util.List;

@Introspected
public class SalesService implements ISalesService {

    private final ISalesRepository salesRepository;
    private final Session session;

    @Inject
    public SalesService(ISalesRepository salesRepository, Session session) {

        this.salesRepository = salesRepository;
        this.session = session;
    }

    @Override
    public String validateAndInsertSales(Sales sales){
        if(sales != null){
            double sumAmount = 0;
            for(Product product : sales.getProduct()){
               sumAmount += product.getPrice();
            }
            sales.setAmount(sumAmount);
            this.salesRepository.save(sales);
            return "Cadastro de venda efetuado com sucesso!";
        }else{
            return "A venda informada é nula";
        }
    }

    public List rankingSellersAmount(){
        return this.salesRepository.rankingSellersAmount();
    }

    public List rankingSellersCount(){
        return this.salesRepository.rankingSellersCount();
    }
}
