    package com.pluralsight.util;

    import com.pluralsight.models.MenuData;
    import com.pluralsight.models.PriceTable;
    import com.pluralsight.models.enums.ToppingCategory;
    import com.pluralsight.ui.UserInterface;

    //TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
    // click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

    public class Main {
        public static void main(String[] args) {

            // create pricing rules
            PriceTable priceTable = new PriceTable();

            // create and seed menu
            MenuData menu = createMenuData();

            // create UI and start the home screen loop
            UserInterface ui = new UserInterface(priceTable, menu);
            ui.displayHomeScreen();
        }

        private static MenuData createMenuData() {
            MenuData menu = new MenuData();

    // proteins
            menu.addProtein("Steak",180);
            menu.addProtein("Chicken",140);
            menu.addProtein("Pork",220);
            menu.addProtein("Salmon",160);
            menu.addProtein("Shrimp",120);
            menu.addProtein("Lamb",200);

    // premium toppings
            menu.addPremiumTopping("Avocado",80);
            menu.addPremiumTopping("Fried Egg",90);
            menu.addPremiumTopping("Feta Cheese Crumbles",70);
            menu.addPremiumTopping("Japanese Sweet Potato Cubes",110);

    // regular toppings
            menu.addRegularTopping("Broccoli",20);
            menu.addRegularTopping("Corn",40);
            menu.addRegularTopping("Tomato",10);
            menu.addRegularTopping("Cucumber",10);
            menu.addRegularTopping("Bell Peppers",15);
            menu.addRegularTopping("Spinach",10);
            menu.addRegularTopping("Mango Salsa",30);
            menu.addRegularTopping("Caramelized Onions",35);
            menu.addRegularTopping("Sliced Carrots",25);


    // condiments
            menu.addCondiment("Tzatziki" +
                    " - Cool and creamy Greek yogurt sauce with cucumber, garlic, and fresh dill.",45);

            menu.addCondiment("Garlic Lime Aioli"+
                    " - Zesty aioli blended with roasted garlic and a bright squeeze of lime.",60);

            menu.addCondiment("Honey Sriracha"+
                    " - Sweet heat combo of honey and spicy sriracha for the perfect kick.",50);

            menu.addCondiment("Citrus Soy Vinaigrette"+
                    " - A light, tangy blend of citrus and soy for a refreshing savory finish.",35);

            menu.addCondiment("Thai Chimichurri" +
                    " - Herb-forward Thai-inspired chimichurri with cilantro, lime, and chili flakes.",40);

    // sides
            menu.addSide("Sweet Potato Bites" +
                    " - Oven-roasted sweet potato cubes — soft inside, lightly crisp outside.",220);

            menu.addSide("Mediterranean Salad" +
                    " - Crisp greens tossed with cucumber, tomato, olives, and a lemon-herb drizzle.",150);

            menu.addSide("Garlic Herb Pita Chips" +
                    " - Crunchy baked pita pieces seasoned with garlic, parsley, and olive oil.",190);

    // drinks
            menu.addDrink("Green Fiend" +
                    " - A vibrant green detox blend of spinach, apple, lime, and ginger.",120);

            menu.addDrink("Acai Potion" +
                    " - A refreshing berry-forward acai drink with a smooth, icy finish.",180);

            menu.addDrink("Protein Powah" +
                    " - High-protein vanilla shake boosted with whey and a hint of honey.",240);

            menu.addDrink("Fountain Drink"+
                    " - Classic carbonated favorites — your choice of soda on tap.",160);

            return menu;
        }
    }
    //
            // making sure repository pushes
           /* Pricetable pt = createPriceTable()
              MenuDate menu = createMenu()
              UserInterface ui = new UserInterface(

            //user interface
            ui = new UserInterface(priceTable, menuData)
            ui.displayHomeScreen


        method createPriceTable()  PriceTable
            // create and return new PriceTable object
            return new PriceTable()

        method createMenu()  MenuData
            menu = new MenuData()

            // add proteins
            menu.addProtein("Steak")
            menu.addProtein("Chicken")
            menu.addProtein("Pork")
            menu.addProtein("Salmon")
            menu.addProtein("Shrimp")
            menu.addProtein("Lamb")

            // add premium toppings
            menu.addAddon("Avocado")
            menu.addAddon("Fried-Egg)
            menu.addAddon("Feta Cheese Crumbles")
            menu.addAddon("Japanese Sweet Potato Cubes")

            // add regular toppings
            menu.addRegular("Broccoli")
            menu.addRegular("Corn")
            menu.addRegular("Tomato")
            menu.addRegular("Cucumber")
            menu.addRegular("Bell Peppers")
            menu.addRegular("Spinach")
            menu.addRegular("Mango Salsa")
            menu.addRegular("Caramelized Onions")
            menu.addRegular("Carrots")

            // add condiments/sauces
            menu.addSauce("Tzatziki Sauce ")
            menu.addSauce("Chili- Chimichurri")
            menu.addSauce("Honey Sriracha Glaze")
            menu.addSauce("Lemon Tahini Drizzle")
            menu.addSauce("Citrus-Soy Ginger Vinaigrette")
            menu.addSauce("Garlic Lime Aioli")

            // add sides
            menu.addSide("Sweet Potato Bites")
            menu.addSide("Mediterranean Salad")
            menu.addSide("Garlic Herb Pita Chips")

            // add drinks
            menu.addDrinkType("Green fiend")
            menu.addDrinkType("acai potion")
            menu.addDrinkType(" Protein Powah")
            menu.addDrinkType("Fountain Drink")
            return menu


            */

