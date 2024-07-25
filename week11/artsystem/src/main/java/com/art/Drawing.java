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
}
