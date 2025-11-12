package com.pluralsight.models;
import  com.pluralsight.models.enums.ToppingCategory;

public class Topping {
    private final String name;
    private final ToppingCategory category;
    private final boolean premium; // true for premium toppings

    public Topping(String name, ToppingCategory category, boolean premium) {
        this.premium = premium;
        this.category = category;
        this.name = name;
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
    //Helper Method
    public boolean preventsExtra() {
        if (category == ToppingCategory.REGULAR_TOPPING||
        category == ToppingCategory.CONDIMENTS) {

            return true;
        }
        return false;
    }
    @Override
    public String toString() {
        return name;
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



