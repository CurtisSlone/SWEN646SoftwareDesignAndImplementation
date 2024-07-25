package com.art;

public abstract class Art {

    protected final String id;
    protected final ArtType type;
    protected final double price;
    protected final int yearCreated;
    protected final String title;
    protected final String description;

    public Art(String id, ArtType type, double price, int yearCreated, String title, String description){
        this.id = id;
        this.type = type;
        this.price = price;
        this.yearCreated = yearCreated;
        this.title = title;
        this.description = description;
    }

    /*
     * GETTERS
     */
    public String getId(){
        return this.id;
    }

    public ArtType getArtType(){
        return this.type;
    }

    public double getPrice(){
        return this.price;
    }

    public int getYearCreated(){
        return this.yearCreated;
    }

    public String getTitle(){
        return this.title;
    }

    public String getDescription(){
        return this.description;
    }

    /*
     * METHODS
     */

     public abstract double calculatePrice();
}
