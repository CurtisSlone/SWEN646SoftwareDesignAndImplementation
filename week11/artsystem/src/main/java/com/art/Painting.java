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
        return 0;
     }
}
