package com.pluralsight.models;

import com.pluralsight.models.enums.BaseType;
import com.pluralsight.models.enums.Size;
import com.pluralsight.models.enums.SpecialOption;

public class MacroBowl {
    private Size size;
    private BaseType baseType;
    private List<ToppingSelection> topping;
    private SpecialOption specialOption;
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
}

 */
}
