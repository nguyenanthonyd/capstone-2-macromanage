package com.pluralsight.models;

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


    

    // Used for printing on receipt
    public String label() {
        if (extra) {
            return topping.toString() + "(+extra)";
        }
        return topping.toString();
    }
}
