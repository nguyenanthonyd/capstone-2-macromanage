package com.pluralsight.models;

public class Order {

    /* properties:
    macroBowl class Order {
    properties:
        bowls  (ArrayList<MacroBowl>)
        drinks (ArrayList<Drink>)
        sides  (ArrayList<Side>)

    methods:
        addBowl(bowl)
        addDrink(drink)
        addSide(side)
        isEmpty()  boolean                   // true if no bowls
        hasDrinkOrSide()  boolean            // for zero-items rule
        getTotal()  number                   // sums item prices
        summaryText()  string                // newest-first listing with line-item prices
}
method summaryText()  string
    text = ""
    text += "=== MacroManage Receipt ===\n"
    text += current date and time + "\n\n"

    // show bowls (newest first)
    IF bowls not empty:
        text += "Bowls:\n"
        FOR i from bowls.size()-1 down to 0:
            bowl = bowls[i]
            text += "  - " + bowl.describe() + "\n"
            text += "    $" + bowl.getPrice() + "\n\n"

    // show drinks (newest first)
    IF drinks not empty:
        text += "Drinks:\n"
        FOR i from drinks.size()-1 down to 0:
            drink = drinks[i]
            text += "  - " + drink.toString() + "  $" + drink.getPrice() + "\n"
        text += "\n"

    // show sides (newest first)
    IF sides not empty:
        text += "Sides:\n"
        FOR i from sides.size()-1 down to 0:
            side = sides[i]
            text += "  - " + side.toString() + "  $" + side.getPrice() + "\n"
        text += "\n"

    // show total
    text += "--------------------------\n"
    text += "TOTAL: $" + getTotal() + "\n"
    text += "Thank you for choosing MacroManage!\n"

    return text

     */
}
