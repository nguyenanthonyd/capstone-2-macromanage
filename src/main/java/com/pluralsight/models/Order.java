package com.pluralsight.models;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private final List<MacroBowl> bowls = new ArrayList<>();
    private final List<Drink> drinks = new ArrayList<>();
    private final List<Side> sides = new ArrayList<>();

    public void addBowl(MacroBowl bowl) {
        bowls.add(bowl);
    }

    public void addDrink(Drink drink) {
        drinks.add(drink);
    }

    public void addSide(Side side) {
        sides.add(side);
    }

    // True if no bowls in the order ("must buy drink/side rule")
    public boolean isEmpty() {
        return bowls.isEmpty();
    }

    public boolean hasDrinkOrSide() {
        return !drinks.isEmpty() || !sides.isEmpty();
    }

    public double getTotal(PriceTable priceTable) {
        double total = 0.0;

        for (MacroBowl bowl : bowls) {
            total += bowl.getPrice(priceTable);
        }

        for (Drink drink: drinks) {
            total += drink.getPrice(priceTable);
        }

        for (Side side: sides) {
            total += side.getPrice(priceTable);
        }

        return total;
    }

    // (
        public String orderSummary(PriceTable priceTable) {
            StringBuilder stringBuilder = new StringBuilder();

            stringBuilder.append("--- MacroManage Receipt ---\n\n");

            if (!bowls.isEmpty()) {
                stringBuilder.append("Bowls:\n");
                for (int i = bowls.size() - 1; i >= 0; i--) {
                    MacroBowl bowl = bowls.get(i);
                    stringBuilder.append("  - ").append(bowl.description()).append("\n");
                    stringBuilder.append("    $").append(String.format("%.2f", bowl.getPrice(priceTable))).append("\n\n");
                }
            }

            if (!drinks.isEmpty()) {
                stringBuilder.append("Drinks:\n");
                for (int i = drinks.size() - 1; i >= 0; i--) {
                    Drink drink = drinks.get(i);
                    stringBuilder.append("  - ").append(drink.toString())
                            .append("  $").append(String.format("%.2f", drink.getPrice(priceTable))).append("\n");
                }
                stringBuilder.append("\n");
            }

            if (!sides.isEmpty()) {
                stringBuilder.append("Sides:\n");
                for (int i = sides.size() - 1; i >= 0; i--) {
                    Side side = sides.get(i);
                    stringBuilder.append("  - ").append(side.toString())
                            .append("  $").append(String.format("%.2f", side.getPrice(priceTable))).append("\n");
                }
                stringBuilder.append("\n");
            }

            stringBuilder.append("--------------------------\n");
            stringBuilder.append("TOTAL: $").append(String.format("%.2f", getTotal(priceTable))).append("\n");

            return stringBuilder.toString();
        }

    }






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
    if bowls not empty:
        text += "Bowls:\n"
        FOR i from bowls.size()-1 down to 0:
            bowl = bowls[i]
            text += "  - " + bowl.describe() + "\n"
            text += "    $" + bowl.getPrice() + "\n\n"

    // show drinks (newest first)
    if drinks not empty:
        text += "Drinks:\n"
        FOR i from drinks.size()-1 down to 0:
            drink = drinks[i]
            text += "  - " + drink.toString() + "  $" + drink.getPrice() + "\n"
        text += "\n"

    // show sides (newest first)
    if sides not empty:
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

