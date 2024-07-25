package com.art;

public class Sculpture extends Art {

    private final String material;
    private final int weight;
    public Sculpture(String id, ArtType type, float price, int yearCreated, String title, String description, String material, int weight){
        super(id, type, price, yearCreated, title, description);
        this.material = material;
        this.weight = weight;
    }

    /*
     * GETTERS
     */

     /*
      * METHODS
      */
      public double calculatePrice(){
        return 0;
     }
}
