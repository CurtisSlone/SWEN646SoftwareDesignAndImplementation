package com.art;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.List;

public class Transaction {

    private final String id;
    private Customer customer;
    private List<Art> art;
    private double cost;
    private String transactionDate;
    private boolean isFinal;
    private final double BASIC_SHIPPING = 10.99;
    

    public Transaction(String id, Customer customer, List<Art> art){
        this.id = id;
        this.customer = customer;
        this.art = art;
        this.transactionDate = null;
        this.isFinal = false;
        setCost();
    }

    /*
     * GETTERS
     */
    public String getId(){
        return this.id;
    }

    public Customer getCustomer(){
        return this.customer;
    }

    public List<Art> getAllArt(){
        return this.art;
    }

    public double getCost(){
        return this.cost;
    }

    public String getTransactionDate(){
        return this.transactionDate;
    }

    public boolean getIsFinal(){
        return this.isFinal;
    }

     /*
     * SETTERS
     */

     public void setCustomer(Customer customer){
       if(!this.isFinal) this.customer = customer;
     }

     public void setArtList(List<Art> art){
        if(!this.isFinal){
            this.art = art;
        
            this.calculateTotalCost();
        }
     }

     private void setTransactionDate(){
        this.transactionDate = LocalDateTime.ofInstant(Instant.ofEpochMilli(Instant.now().toEpochMilli()), ZoneOffset.UTC).toString();
     }

     private void setCost(){
        this.cost = this.art.isEmpty() ? 0.0 : this.calculateTotalCost();
     }

     /*
      * METHODS
      */
      public double calculateTotalCost(){
        return this.BASIC_SHIPPING + this.art.stream().mapToDouble(Art::calculatePrice).sum();
      }

      public void addArt(Art art){
        if(!this.isFinal){
            this.art.add(art);
            this.calculateTotalCost();
        }
      }

      public void finalizeTransaction(){
        this.setCost();
        this.setTransactionDate();
        this.isFinal = true;
      }
}
