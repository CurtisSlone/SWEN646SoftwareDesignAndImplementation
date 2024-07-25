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
        this.description = description.substring(0,500);
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

     @Override
     public String toString(){
        return String.format("<id>%s</id>\n<type>%s</type>\n<price>%s</price>\n<yearCreated>%s</yearCreated>\n<title>%s</title>\n<description>%s</description>", this.id,this.type,this.price,this.yearCreated,this.title,this.description);
     }

}
