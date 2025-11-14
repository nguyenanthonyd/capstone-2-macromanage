package com.pluralsight.models;
import  com.pluralsight.models.enums.ToppingCategory;

public class Topping {
    private final String name;
    private final ToppingCategory category;
    private final boolean premium; // true for premium toppings
    private int calories;

    public Topping(String name, ToppingCategory category, boolean premium, int calories) {
        this.premium = premium;
        this.category = category;
        this.name = name;
        this.calories = calories;

    }

    public String getName() {
        return name;
    }

    public ToppingCategory getCategory() {
        return category;
    }

    public boolean isPremium() {
        return premium;
    }

    public int getCalories() {
        return calories;
    }
    //Helper Method
    public boolean preventsExtra() {
        return category == ToppingCategory.REGULAR_TOPPING||
        category == ToppingCategory.CONDIMENTS;

    }
        // used on receipts
        public String label() {
            final String WHITE = "\u001B[97m";
            final String RESET = "\u001B[0m";

            return name + " (" + WHITE + calories + " cal" + RESET + ")";
    }
        @Override
        public String toString() {
            return label();
        }
    }
    /* properties:
        name
        category // protein, extra toppings ,addon ,regular_Topping, sauce
        premium: boolean // true protein, extra toppings ,premium addon false for regular_veg, sauce


        methods
         String name
         if extra == true:
         return topping.name + "extra"
         else return topping.name
         */



