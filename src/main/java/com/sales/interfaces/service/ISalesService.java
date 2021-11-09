package com.sales.interfaces.service;

import com.sales.model.Sales;

import java.util.List;

public interface ISalesService {
    String validateAndInsertSales(Sales sales);
    List rankingSellersAmount();
    List rankingSellersCount();
}
