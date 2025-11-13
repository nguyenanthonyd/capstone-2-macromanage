package com.pluralsight.models;


import com.pluralsight.models.enums.Size;

public class Drink {

    private final String name;
    private final Size size;

    public Drink(String name, Size size) {
        this.name = name;
        this.size = size;
    }

    public double getPrice(PriceTable priceTable) {
        return priceTable.drink(size);
    }

    @Override
    public String toString() {
        return name + " (" + size + ")";
    }
}


  /*  properties:
        type // Green fiend , acai potion, Protein Powah ,

        size // small, medium, large

        methods: getPrice() number int
                 getString() String
   */


