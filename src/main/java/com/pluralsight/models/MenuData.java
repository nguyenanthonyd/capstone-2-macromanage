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

    //Protein

    public void addProtein(String name) {
        proteins.add(new Topping(name, ToppingCategory.PROTEIN, true));
    }

    public List<Topping> getProteins() {
        return proteins;
    }

    //Premium Toppings

    public void addPremiumTopping(String name) {
        premiumToppings.add(new Topping(name, ToppingCategory.PREMIUM, true));
    }

    public List<Topping> getPremiumToppings() {
        return premiumToppings;
    }

    //Regular Toppings

    public void addRegularTopping(String name) {
        regularToppings.add(new Topping(name, ToppingCategory.REGULAR_TOPPING, false));
    }

    public List<Topping> getRegularToppings() {
        return regularToppings;
    }

    //Condiments

    public void addCondiment(String name) {
        condiments.add(new Topping(name, ToppingCategory.CONDIMENTS, false));
    }

    public List<Topping> getCondiments() {
        return condiments;
    }

    //Sides

    public void addSide(String name) {
        sides.add(name);
    }

    public List<String> getSides() {
        return sides;
    }

    //Drinks

    public void addDrink(String name) {
        drinks.add(name);
    }

    public List<String> getDrinks() {
        return drinks;
    }
}
