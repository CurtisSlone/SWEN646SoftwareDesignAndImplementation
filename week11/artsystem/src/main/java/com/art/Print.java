package com.art;

public class Print extends Art {

    private final String openEdition;

    public Print(String id, ArtType type, float price, int yearCreated, String title, String description, String openEdition){
        super(id, type, price, yearCreated, title, description);
        this.openEdition = openEdition;
    }
}
