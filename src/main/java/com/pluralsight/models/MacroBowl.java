package com.pluralsight.models;

import com.pluralsight.models.enums.BaseType;
import com.pluralsight.models.enums.Size;
import com.pluralsight.models.enums.SpecialOption;
import com.pluralsight.models.enums.ToppingCategory;

import java.util.ArrayList;
import java.util.List;

public class MacroBowl {

    public static final String WHITE = "\u001B[97m";
    public static final String RESET = "\u001B[0m";

    private Size size;
    private BaseType baseType;
    private List<ToppingSelection> toppings = new ArrayList<>();
    private SpecialOption specialOption = SpecialOption.NONE;

    public MacroBowl(Size size, BaseType baseType) {
        this.size = size;
        this.baseType = baseType;
        this.toppings = new ArrayList<>();
    }

    // method to add any topping
    // uses preventsExtra() to disable "extra" for regular toppings/condiments
    public void addTopping(Topping topping, boolean extra) {
        if (topping.preventsExtra()) {
            extra = false; // regular toppings + condiments cannot be extra
        }
        toppings.add(new ToppingSelection(topping, extra));
    }

    // helper methods

    public void addProtein(Topping topping, boolean extra) {
        if (topping.getCategory() == ToppingCategory.PROTEIN) {
            addTopping(topping, extra);
        }
    }

    public void addPremiumTopping(Topping topping, boolean extra) {
        if (topping.getCategory() == ToppingCategory.PREMIUM) {
            addTopping(topping, extra);
        }
    }

    public void addRegularTopping(Topping topping) {
        if (topping.getCategory() == ToppingCategory.REGULAR_TOPPING) {
            addTopping(topping, false);
        }
    }

    public void addCondiment(Topping topping) {
        if (topping.getCategory() == ToppingCategory.CONDIMENTS) {
            addTopping(topping, false);
        }
    }

    public void setSpecialOption(SpecialOption option) {
        this.specialOption = option;
    }

    public boolean hasProtein() {
        for (ToppingSelection toppingSelection : toppings) {
            Topping topping = toppingSelection.getTopping();
            if (topping.getCategory() == ToppingCategory.PROTEIN) {
                return true;
            }
        }
        return false;
    }


    // Price calculation
    public double getPrice(PriceTable priceTable) {
        double total = priceTable.baseBowl(size);

        for (ToppingSelection toppingSelection : toppings) {
            Topping topping = toppingSelection.getTopping();
            total += priceTable.toppingCharge(topping.getCategory(), size, toppingSelection.isExtra(),
                    topping.isPremium());
        }

        total += priceTable.specialSurcharge(specialOption, size);

        return total;
    }

    // Receipt order screen description
    public String description () {
            StringBuilder stringBuilder = new StringBuilder();

            stringBuilder.append(size).append(" ").append(baseType).append("bowl");

            if (!toppings.isEmpty()) {
                stringBuilder.append(" with ");
                for (int i = 0; i < toppings.size(); i++) {
                    stringBuilder.append(toppings.get(i).label());
                    if (i < toppings.size() - 1) {
                        stringBuilder.append(", ");
                    }
                }
            } else {
                stringBuilder.append(" (no toppings)");
            }

            if (specialOption != SpecialOption.NONE) {
                stringBuilder.append(" + ").append(specialOption);
            }

            return stringBuilder.toString();
        }

        // Getters
        public Size getSize () {
            return size;
        }

        public BaseType getBaseType () {
            return baseType;
        }

        public SpecialOption getSpecialOption () {
            return specialOption;
        }

        public List<ToppingSelection> getToppings () {
            return new ArrayList<>(toppings);
        }
    }


    /* properties:
    size ( small,medium,large)
    baseType base
    toppings <List>
    add topping
    condiments
    price
    describe

    class MacroBowl {
    properties:
        size                 small, medium, large
        baseType             Mixed greens, rice, brown rice, white rice
        omit(bowlType)                      signature items: Super Saiyan 4 Remsey bowl, Mass Monster Markus, Brawn Amaan
        toppings (ArrayList of ToppingSelection)  // each has: topping + extra(boolean)
        specialOption        none, power_sear,

    methods:
        addProtein(type, extra)           steak, chicken, pork, salmon, shrimp, lamb
        addPremiumTopping(type, extra)    avocado,Fried-egg, Feta-cheese crumbles, japanese sweet potato cubes
        addRegularTopping(type)           broccoli, corn, tomato, cucumber, peppers,spinach ,mango salsa, caramelized
                                          onions , carrots

        addCondiment(type)                tzatziki, garlic lime aioli, honey sriracha, citrust soy vinaigrette ,
                                          thaichimichurri
        setSpecial(option)                 power_sear, none

        getPrice(): number
             calculate base price by size and bowlType
             add meat cost (+ extra-meat surcharge if extra == true)
             add extra toppings surcharge if extra == true
             add premium addon cost (avocado, portobello) by size
             add special option surcharge ( powersear)
             regular toppings and condiments are included
            return total


 */
