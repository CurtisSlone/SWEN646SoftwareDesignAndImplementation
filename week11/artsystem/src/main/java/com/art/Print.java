package com.art;

public class Print extends Art {

    private final String openEdition;

    public Print(String id, ArtType type, float price, int yearCreated, String title, String description, String openEdition){
        super(id, type, price, yearCreated, title, description);
        this.openEdition = openEdition;
    }

    /*
     * GETTERS
     */

     public String getOpenEdition(){
        return this.openEdition;
     }
     /*
      * METHODS
      */
      public double calculatePrice(){
        return this.price;
     }

     @Override
     public String toString(){
        return String.format("<Print>\n%s\n<openEdition>%s</openEdition>\n</Print>",super.toString(),this.openEdition);
     }
}
