package com.pluralsight.models;

import com.pluralsight.models.enums.Size;

import static com.pluralsight.models.enums.Size.SMALL;

public class ToppingSelection {

    private final Topping topping;
    private final boolean extra;

    public ToppingSelection(Topping topping, boolean extra) {
        this.topping = topping;
        this.extra = extra;
    }

    public Topping getTopping() {
        return topping;
    }

    public boolean isExtra() {
        return extra;
    }


    public String label(Size size) {
        int scaledCalories = scaleToppingCaloriesBySize(topping.getCalories(), size);

        if (extra) {
            // Show both regular portion and extra portion calories
            return topping.getName() + " (" + WHITE + scaledCalories + " cal" + RESET + ")(+extra: " + WHITE + scaledCalories + " cal" + RESET + ")";
        }
        return topping.getName() + " (" + WHITE + scaledCalories + " cal" + RESET + ")";
    }

    // Helper method to scale calories
    private int scaleToppingCaloriesBySize(int baseCalories, Size size) {
        switch (size) {
            case SMALL:
                return baseCalories;
            case MEDIUM:
                return (int) (baseCalories * 1.5);
            case LARGE:
                return baseCalories * 2;
            default:
                return baseCalories;
        }
    }

    // Add color constants at the top of the class
    public static final String WHITE = "\u001B[97m";
    public static final String RESET = "\u001B[0m";
}//