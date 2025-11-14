package com.pluralsight.models;

import com.pluralsight.models.enums.ToppingCategory;

import java.util.ArrayList;
import java.util.List;

public class MenuData {

    private List<Topping> proteins = new ArrayList<>();
    private List<Topping> premiumToppings = new ArrayList<>();
    private List<Topping> regularToppings = new ArrayList<>();
    private List<Topping> condiments = new ArrayList<>();

    private List<String> sides = new ArrayList<>();
    private List<String> drinks = new ArrayList<>();

    //Methods

    public void addProtein(String name, int calories) {
        proteins.add(new Topping(name, ToppingCategory.PROTEIN, false, calories));
    }

    public void addPremiumTopping(String name, int calories) {
        premiumToppings.add(new Topping(name, ToppingCategory.PREMIUM, true, calories));
    }

    public void addRegularTopping(String name, int calories) {
        regularToppings.add(new Topping(name, ToppingCategory.REGULAR_TOPPING, false, calories));
    }

    public void addCondiment(String name, int calories) {
        condiments.add(new Topping(name, ToppingCategory.CONDIMENTS, false, calories));
    }

    public void addSide(String name, int calories) {
        sides.add(name + " (" + calories + " cal)");
    }

    public void addDrink(String name, int calories) {
        drinks.add(name + " (" + calories + " cal)");
    }

    //getters

    public List<Topping> getProteins() {
        return proteins;
    }

    public List<Topping> getPremiumToppings() {
        return premiumToppings;
    }

    public List<Topping> getRegularToppings() {
        return regularToppings;
    }

    public List<Topping> getCondiments() {
        return condiments;
    }

    public List<String> getSides() {
        return sides;
    }

    public List<String> getDrinks() {
        return drinks;
    }
}