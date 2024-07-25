package com.art;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Manager {

    private List<String> inventory;
    private List<String> transactions;
    private Transaction currentTransaction;
    private Art currentArt;
    private List<Art> currentArtList;

    public Manager(){
        this._loadInventory();
        this._loadTransactions();
    }

    /*
     * GETTERS
     */
    
    public List<String> getInventory(){
        return this.inventory;
    }

    public List<String> getTransactions(){
        return this.transactions;
    }

    public List<Art> getArtList(){
        return this.currentArtList;
    }

     /*
     * METHODS
     */

     public Painting createPainting(String id, ArtType type, float price, int yearCreated, String title, String description, int height, int width, String style, String technique ){
        return new Painting(id, type, price, yearCreated, title, description, height, width, style, technique);
     }


     public Drawing createDrawing(String id, ArtType type, float price, int yearCreated, String title, String description, String style, String technique,String category){
        return new Drawing(id, type, price, yearCreated, title, description, style, technique, category);
     }

     public Print createPrint(String id, ArtType type, float price, int yearCreated, String title, String description, String openEdition){
        return new Print(id, type, price, yearCreated, title, description, openEdition);
     }

     public Sculpture createSculpture(String id, ArtType type, float price, int yearCreated, String title, String description, String material, int weight){
        return new Sculpture(id, type, price, yearCreated, title, description, material, weight);
     }

    public void loadTransactionFromFile(String id) throws Exception {
        ObjectMapper o = new ObjectMapper();
        String transactionFile = String.format("./transactions/%s.json", id);
        String transactionJson = new String(Files.readAllBytes(Paths.get(transactionFile)));
        this.currentTransaction = o.readValue(transactionJson, Transaction.class);
    }

    public void loadArtFromFile(String id) throws Exception {
        ObjectMapper o = new ObjectMapper();
        String inventoryFile = String.format("./inventory/%s.json", id);
        String artJson = new String(Files.readAllBytes(Paths.get(inventoryFile)));
        this.currentArt = o.readValue(artJson, Art.class);
    }


    public void saveTransactionToFile() throws Exception {
        ObjectMapper o = new ObjectMapper();
        String filename = String.format("%s.json", this.currentTransaction.getId());
        o.writeValue(new File(filename), this.currentTransaction);
    }

    public void saveArtToFile() throws Exception {
        ObjectMapper o = new ObjectMapper();
        String filename = String.format("%s.json", this.currentArt.getId());
        o.writeValue(new File(filename), this.currentArt);
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
