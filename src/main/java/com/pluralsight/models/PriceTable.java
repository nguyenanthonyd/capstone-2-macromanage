package com.pluralsight.models;

import com.pluralsight.models.enums.Size;
import com.pluralsight.models.enums.ToppingCategory;
import com.pluralsight.models.enums.SpecialOption;

public class PriceTable {

    // Base bowl price by size
    public double baseBowl(Size size) {
        switch (size) {
            case SMALL:
                return 5.50;
            case MEDIUM:
                return 7.00;
            case LARGE:
                return 8.50;
            default:
                return 0.0;
        }
    }

    // Topping pricing
    public double toppingCharge(ToppingCategory category, Size size, boolean extra, boolean premium) {

        // regular toppings & condiments are free
        if (category == ToppingCategory.REGULAR_TOPPING ||
                category == ToppingCategory.CONDIMENTS) {
            return 0.0;
        }

        // proteins: 1 / 2 / 3 + extra meat .5 / 1.0 / 1.5
        if (category == ToppingCategory.PROTEIN) {
            double price;
            switch (size) {
                case SMALL:
                    price = 1.00;
                    if (extra) price += 0.50;
                    break;
                case MEDIUM:
                    price = 2.00;
                    if (extra) price += 1.00;
                    break;
                case LARGE:
                    price = 3.00;
                    if (extra) price += 1.50;
                    break;
                default:
                    price = 0.0;
            }
            return price;
        }

        // premium add-ons (avocado, fried egg, feta, sweet potato cubes)
        // .75 / 1.50 / 2.25
        if (category == ToppingCategory.PREMIUM) {
            switch (size) {
                case SMALL:
                    return 0.75;
                case MEDIUM:
                    return 1.50;
                case LARGE:
                    return 2.25;
                default:
                    return 0.0;
            }
        }

        // fallback
        return 0.0;
    }

    // Special option surcharge (only POWER_SEAR costs extra)
    public double specialSurcharge(SpecialOption option, Size size) {
        if (option == SpecialOption.POWER_SEAR) {
            switch (size) {
                case SMALL:
                    return 0.50;
                case MEDIUM:
                    return 0.75;
                case LARGE:
                    return 1.00;
                default:
                    return 0.0;
            }
        }
        // NONE or anything else
        return 0.0;
    }

    // Drink price by size
    public double drink(Size size) {
        switch (size) {
            case SMALL:
                return 2.00;
            case MEDIUM:
                return 2.50;
            case LARGE:
                return 3.00;
            default:
                return 0.0;
        }
    }

    // Flat price for a side
    public double side() {
        return 1.50;
    }
}

    /* methods:
 baseBowl(bowlType, size)  number
// base by size
     //      if size == small   return 5.50
            if size == medium  return 7.00
            if size == large   return 8.50

        toppingCharge(category, size, extra, premium) number
             regular topping& sauces are included
            if category == regularTopping or category == condiments:
                return 0.00

            proteins: 1/2/3 + extra meat surcharge .5/1/1.5
            if category == protein:
                price = (size == small?1.00 : size == medium?2.00 : 3.00)
                if extra == true:
                    price += (size==small?0.50 : size == medium?1.00 : 1.50)
                return price

            topping extra: .30/.60/.90 (treat extra == true )
            if category == topping extra:
                if extra == true:
                    return (size==small?0.30 : size == medium?0.60 : 0.90)
                else:
                    return 0.00

            // premium addons : .75/1.50/2.25  (premium*)
            if category == addon:
                if premium == true:
                    return (size==small?0.75 : size == medium?1.50 : 2.25)
                else:
                    return 0.00

        specialSurcharge(opt, size)  number
            if opt == power_sear  return (size == small?0.50 : size == medium?0.75 : 1.00)

               return 0.00

        drink(size)  number
            if size == small  2.00
            if size == medium 2.50
            if size == large 3.00

         side() number
            return 1.50
*/
