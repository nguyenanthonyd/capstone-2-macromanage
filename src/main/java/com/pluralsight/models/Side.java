package com.pluralsight.models;



public class Side {
    private final String name;

    public Side(String name) {
        this.name = name;
    }

    public double getPrice(PriceTable priceTable) {
        return priceTable.side();
    }

    @Override
    public String toString() {
        return name;
    }
}


    /* properties:
        name //
        method: getString() String
                getPrice() number int
     */

