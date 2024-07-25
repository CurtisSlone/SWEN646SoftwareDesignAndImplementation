package com.art;

public class Painting extends Art{

    private final int height;
    private final int width;
    private final String style;
    private final String technique;

    public Painting(String id, ArtType type, float price, int yearCreated, String title, String description, int height, int width, String style, String technique ){
        super(id, type, price, yearCreated, title, description);
        this.height = height;
        this.width = width;
        this.style = style;
        this.technique = technique;
    }

    /*
     * GETTERS
     */
    public int getHeight(){
        return this.height;
    }

    public int getWidth(){
        return this.width;
    }

    public String getStyle(){
        return this.style;
    }

    public String getTechnique(){
        return this.technique;
    }

    /*
     * METHODS
     */

     public double calculatePrice(){
        return this.price + (this.height * this.width) < 100 ? 5.99 : 
        ((100 < (this.height * this.width) && (this.height * this.width) > 300) ? 10.99 : 15.99);
     }

     @Override
     public String toString(){
        return String.format("<Painting>\n%s\n<height>%s</height>\n<width>%s</width>\n<style>%s</style>\n<technique>%s</technique>\n</Painting>",super.toString(),this.height,this.width,this.style,this.technique);
     }
}
