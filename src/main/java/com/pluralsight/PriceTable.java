package com.pluralsight;

public class PriceTable {
/* methods:
 baseBowl(bowlType, size)  number
// base by size
     //      if size == small   return 5.50
            if size == medium  return 7.00
            if size == large   return 8.50

        toppingCharge(category, size, extra, premium) → number
             regular veg & sauces are included
            if category == regularVeg or category == sauce:
                return 0.00

            proteins: 1/2/3 + extra meat surcharge .5/1/1.5
            if category == protein:
                price = (size==small?1.00 : size==medium?2.00 : 3.00)
                if extra == true:
                    price += (size==small?0.50 : size==medium?1.00 : 1.50)
                return price

            topping extra: .30/.60/.90 (treat extra==true )
            if category == cheese:
                if extra == true:
                    return (size==small?0.30 : size==medium?0.60 : 0.90)
                else:
                    return 0.00

            // premium addons : .75/1.50/2.25  (premium*)
            if category == addon:
                if premium == true:
                    return (size==small?0.75 : size==medium?1.50 : 2.25)
                else:
                    return 0.00

        specialSurcharge(opt, size)  number
            if opt == power_sear  return (size==small?0.50 : size==medium?0.75 : 1.00)
            if opt == warm        return 0.50
            if opt == chilled     return 0.00
            return 0.00

        drink(size) → number
            if size == small  2.00
            if size == medium 2.50
            if size == large 3.00

         side() number
            return 1.50
}
