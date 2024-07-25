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

     public String getMaterial(){
        return this.material;
     }

     public int getWeight(){
        return this.weight;
     }

     /*
      * METHODS
      */
      public double calculatePrice(){
        return this.price + (this.weight * .2);
     }

     @Override
     public String toString(){
        return String.format("<Sculpture>\n%s\n<material>%s</material>\n<weight>%s</weight>\n</Sculpture>",super.toString(), this.material, this.weight);
     }
}
