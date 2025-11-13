package com.pluralsight.models;

import com.pluralsight.models.enums.DrinkType;
import com.pluralsight.models.enums.Size;

public class Drink {
    private final DrinkType type;
    private final Size size;

    public Drink(DrinkType type, Size size) {
        this.type = type;
        this.size = size;
    }

    public double getPrice(PriceTable priceTable) {
        return priceTable.drink(size);
    }

    @Override
    public String toString() {
        return type + " (" + size + ")";
    }
}


  /*  properties:
        type // Green fiend , acai potion, Protein Powah ,

        size // small, medium, large

        methods: getPrice() number int
                 getString() String
   */
}

