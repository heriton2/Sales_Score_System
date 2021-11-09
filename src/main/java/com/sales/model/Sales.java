package com.sales.model;

import io.micronaut.core.annotation.Introspected;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.List;

@Entity
@Introspected
public class Sales {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne//(cascade = {CascadeType.ALL},fetch= FetchType.EAGER)
    @JoinColumn
    private Salesman salesman;

    @ManyToMany//(cascade = {CascadeType.ALL},fetch= FetchType.EAGER)
    @JoinColumn
    private List<Product> product;

    @JoinColumn
    private double amount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Salesman getSalesman() {
        return salesman;
    }

    public void setSalesman(Salesman salesman) {
        this.salesman = salesman;
    }

    public List<Product> getProduct() {
        return product;
    }

    public void setProduct(List<Product> product) {
        this.product = product;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
