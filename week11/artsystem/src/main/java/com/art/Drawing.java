package com.art;

public class Drawing extends Art {

    private final String style;
    private final String technique;
    private final String category;

    public Drawing(String id, ArtType type, float price, int yearCreated, String title, String description, String style, String technique,String category){
        super(id, type, price, yearCreated, title, description);
        this.style = style;
        this.technique = technique;
        this.category = category;
    }

    /*
     * GETTERS
     */

     public String getStyle(){
        return this.style;
     }

     public String getTechnique(){
        return this.technique;
     }

     public String getCategory(){
        return this.category;
     }

     /*
      * METHODS
      */
      public double calculatePrice(){
        return this.price;
     }

     @Override
     public String toString(){
        return String.format("<Drawing>\n%s\n<style>%s</style>\n<technique>%s</technique>\n<category>%s</category>\n</Drawing>",super.toString(), this.style,this.technique, this.category);
     }
}
