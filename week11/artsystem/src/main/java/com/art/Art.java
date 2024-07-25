package com.art;

public abstract class Art {

    protected final String id;
    protected final ArtType type;
    protected final float price;
    protected final int yearCreated;
    protected final String title;
    protected final String description;

    public Art(String id, ArtType type, float price, int yearCreated, String title, String description){
        this.id = id;
        this.type = type;
        this.price = price;
        this.yearCreated = yearCreated;
        this.title = title;
        this.description = description;
    }
}
