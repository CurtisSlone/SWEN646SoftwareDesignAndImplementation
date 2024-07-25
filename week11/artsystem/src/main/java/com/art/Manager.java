package com.art;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Manager {

    private List<String> inventory;
    private List<String> transactions;
    private Transaction currentTransaction;
    private Art currenArt;

    public Manager(){
        this._loadInventory();
        this._loadTransactions();
    }

    /*
     * GETTERS
     */

     /*
     * SETTERS
     */

     /*
     * METHODS
     */

    public void loadTransactionFromFile(String id){

    }

    public void loadArtFromFile(String id){

    }

    public void saveTransactionToFile(){
        
    }

    public void saveArtToFile(){

    }

    private void _loadInventory() {

        /*
         * If inventory directory does not exist, make directory
         * List all inventory from directory by id
         * Add to this.inventory List<String>
         */
        try {
            File inventoryDir = new File("./inventory");
            if(!inventoryDir.exists()) inventoryDir.mkdir();
            this.inventory = Arrays.asList(inventoryDir.list());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
    }

    private void _loadTransactions() {

        /*
         * If inventory directory does not exist, make directory
         * List all inventory from directory by id
         * Add to this.inventory List<String>
         */
        try {
            File transactionDir = new File("./transactions");
            if(!transactionDir.exists()) transactionDir.mkdir();
            this.transactions = Arrays.asList(transactionDir.list());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
    }

    public String generateUniqueID(){
        /*
         * Create unique ID
         * Stringbuilder to build random charachters
         */
        int leftLimit = 48; // numeral '0'
        int rightLimit = 122; // letter 'z'
        Random random = new Random();
    
        return String.format("%s", random.ints(leftLimit, rightLimit + 1)
          .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
          .limit(9)
          .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
          .toString());
    };


}
