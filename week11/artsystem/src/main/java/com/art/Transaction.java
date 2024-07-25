package com.art;

import java.util.List;

public class Transaction {

    private final String id;
    private Customer customer;
    private List<Art> art;
    private double cost;
    private final double BASIC_SHIPPING = 10.99;
    private String transactionDate;

    public Transaction(String id, Customer customer, List<Art> art){
        this.id = id;
        this.customer = customer;
        this.art = art;
        this.transactionDate = null;
    }
}
