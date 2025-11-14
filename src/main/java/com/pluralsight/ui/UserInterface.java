package com.pluralsight.ui;

import com.pluralsight.models.*;
import com.pluralsight.models.enums.BaseType;
import com.pluralsight.models.enums.Size;
import com.pluralsight.models.enums.SpecialOption;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class UserInterface {

    private final PriceTable priceTable;
    private final MenuData menuData;
    private final Scanner scanner = new Scanner(System.in);
    private static final String RESET = "\u001B[0m";
    private static final String WHITE = "\u001B[97m";   // bright white


    public UserInterface(PriceTable priceTable, MenuData menuData) {
        this.priceTable = priceTable;
        this.menuData = menuData;
    }

    //Home Screen

    public void displayHomeScreen() {
        while (true) {
            System.out.println("\n\n┏━━━ W E L C O M E   T O   M A C R O M A N A G E ━━━┓˚ ༘⋆｡˚ ❀\n");
            System.out.println("1) New Order");
            System.out.println("0) Exit");
            System.out.print("Choose an option: ");


            int choice = readInt();

            pause(300);
            if (choice == 1) {
                startNewOrder();
            } else if (choice == 0) {
                pause(300);
                System.out.println("Thank You!");
                break;
            } else {
                pause(300);
                System.out.println("\nInvalid choice. Please try again.\n");
            }
        }
    }

    // Order Screen Loops
    private void startNewOrder() {
        Order order = new Order();

        while (true) {
            System.out.println("\n━━━ O R D E R   S C R E E N ━━━ ");
            ;
            System.out.println();
            System.out.println("1) Add Bowl");
            System.out.println("2) Add Drink");
            System.out.println("3) Add Side");
            System.out.println("4) Checkout");
            System.out.println("0) Cancel Order");
            System.out.print("Choose an option: ");

            int choice = readInt();

            pause(300);
            if (choice == 1) {
                addBowl(order);
            } else if (choice == 2) {
                addDrink(order);
            } else if (choice == 3) {
                addSide(order);
            } else if (choice == 4) {
                checkout(order);
                break;
            } else if (choice == 0) {
                System.out.println("Order cancelled.\n");
                break;
            } else {
                System.out.println("Invalid choice. Try again.");
            }
        }
    }



    //Adding bowl

    private void addBowl(Order order) {
        System.out.println("\n--- Add MacroBowl ---");

        // choose base
        BaseType baseType = chooseBaseType();

        // choose size
        Size size = chooseSize();

        MacroBowl bowl = new MacroBowl(size, baseType);

        // toppings loop
        boolean addingToppings = true;
        while (addingToppings) {
            System.out.println("\nAdd Toppings:");
            System.out.println("1) Add Protein");
            System.out.println("2) Add Premium Topping");
            System.out.println("3) Add Regular Topping");
            System.out.println("4) Add Condiment");
            System.out.println("0) Done with toppings");
            System.out.print("\nChoose an option: ");



            int choice = readInt();

            pause(300);
            switch (choice) {
                case 1:
                    if (bowl.hasProtein()) {
                        System.out.println("\nThis bowl already has a protein. Use extra when prompted if you want more.");
                    } else {
                        pickToppingFromList(menuData.getProteins(), bowl, true);
                    }
                    break;

                case 2:
                    pickToppingFromList(menuData.getPremiumToppings(), bowl, true);
                    break;
                case 3:
                    pickToppingFromList(menuData.getRegularToppings(), bowl, false);
                    break;
                case 4:
                    pickToppingFromList(menuData.getCondiments(), bowl, false);
                    break;
                case 0:
                    addingToppings = false;
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }

        // special option
        SpecialOption special = chooseSpecialOption();
        bowl.setSpecialOption(special);

        order.addBowl(bowl);
        System.out.println("\nBowl added!\n");
    }

    private BaseType chooseBaseType() {
        while (true) {
            System.out.println("\nChoose base:");
            BaseType[] bases = BaseType.values();

            for (int i = 0; i < bases.length; i++) {
                String label = bases[i].name().replace("_", " ").toLowerCase();
                label = Character.toUpperCase(label.charAt(0)) + label.substring(1);
                System.out.println((i + 1) + ") " + label);
            }
            System.out.print("Select base: ");
            int choice = readInt();
            int index = choice - 1;

            if (index >= 0 && index < bases.length) {
                return bases[index];
            }

            System.out.println("Invalid choice. Please pick a number on the screen.\n");
        }
    }

    private Size chooseSize() {
        while (true) {
            System.out.println("\nChoose size:");
            Size[] sizes = Size.values();
            for (int i = 0; i < sizes.length; i++) {
                String label_ = sizes[i].name().replace("_", " ").toLowerCase();
                label_ = Character.toUpperCase(label_.charAt(0)) + label_.substring(1);
                System.out.println((i + 1) + ") " + label_);
            }
            System.out.print("\nSelect size: ");
            int choice = readInt();
            int index = choice - 1;

            if (index >= 0 && index < sizes.length) {
                return sizes[index];
            }
            pause(300);
            System.out.println("\nInvalid choice. Please pick a number on the screen.\n");
        }
    }

    private SpecialOption chooseSpecialOption() {
        while (true) {
            System.out.println("\nSpecial option?");
            System.out.println("1) None");
            System.out.println("2) Power Sear");
            System.out.print("Choose: ");

            int choice = readInt();

            pause(300);
            if (choice == 1) {
                return SpecialOption.NONE;
            }
            if (choice == 2) {

                return SpecialOption.POWER_SEAR;
            }
            System.out.println("\nInvalid choice. Please pick 1 or 2.");
        }
    }
    // Uses a list of toppings, lets user pick one by number
    private void pickToppingFromList(List<Topping> list, MacroBowl bowl, boolean askExtra) {
        if (list.isEmpty()) {
            System.out.println("No options available.");
            return;
        }

        for (int i = 0; i < list.size(); i++) {
            System.out.println((i + 1) + ") " + list.get(i).getName());
        }
        System.out.print("Choose (0 to cancel): ");
        int choice = readInt();
        if (choice == 0) {
            return;
        }
        int index = choice - 1;
        if (index < 0 || index >= list.size()) {
            System.out.println("Invalid choice.");
            return;
        }

        Topping topping = list.get(index);
        boolean extra = false;

        if (askExtra) {
            pause(300);
            extra = yesNo("Extra? (y/n): ");
        }

        bowl.addTopping(topping, extra);
        System.out.println("\nAdded " + topping.getName() + (extra ? " (extra)" : ""));

    }

    // Add Drink

    private void addDrink(Order order) {
        System.out.println("\n--- Add Drink ---");

        List<String> drinks = menuData.getDrinks();
        if (drinks.isEmpty()) {
            System.out.println("No drink.");
            return;
        }

        for (int i = 0; i < drinks.size(); i++) {
            System.out.println((i + 1) + ") " + drinks.get(i));
        }
        System.out.print("Choose drink (0 to cancel): ");
        int choice = readInt();
        if (choice == 0) return;

        int index = choice - 1;
        if (index < 0 || index >= drinks.size()) {
            pause(300);
            System.out.println("Invalid choice.");
            return;
        }

        // choose size
        Size size = chooseSize();


        Drink drink = new Drink(drinks.get(index), size);


        order.addDrink(drink);
        System.out.println("\nDrink added!\n");
    }

    // Add side

    private void addSide(Order order) {
        System.out.println("\n--- Add Side ---");

        List<String> sides = menuData.getSides();
        if (sides.isEmpty()) {
            System.out.println("No sides configured.");
            return;
        }

        for (int i = 0; i < sides.size(); i++) {
            System.out.println((i + 1) + ") " + sides.get(i));
        }
        System.out.print("Choose side (0 to cancel): ");
        int choice = readInt();
        if (choice == 0) return;

        int index = choice - 1;
        if (index < 0 || index >= sides.size()) {
            System.out.println("Invalid choice.");
            return;
        }

        Side side = new Side(sides.get(index));
        order.addSide(side);
        System.out.println("Side added!\n");
    }

    // CHECKOUT

    private void checkout(Order order) {
        System.out.println("\n━━━ C H E C K   O U T ━━━\n\n");

        if (order.isEmpty() && !order.hasDrinkOrSide()) {
            System.out.println("You must add at least one bowl OR a drink/side.");
            return;
        }

        String summary = order.orderSummary(priceTable);
        System.out.println(summary);

        pause(300);
        System.out.print("Confirm order? (y/n): ");
        String choice = scanner.nextLine().trim().toLowerCase();

        if (!choice.startsWith("y")) {
            System.out.println("Checkout cancelled.");
            return;
        }

        // write receipt
        com.pluralsight.util.ReceiptWriter writer = new com.pluralsight.util.ReceiptWriter();
        try {
            java.io.File file = writer.saveReceipt(order, priceTable);
            System.out.println("Receipt saved to: " + file.getAbsolutePath());
        } catch (IOException e) {
            System.out.println("Error saving receipt: " + e.getMessage());
        }
    }

    // Input Helper

    private int readInt() {
        while (true) {
            String line = scanner.nextLine();
            try {
                return Integer.parseInt(line.trim());
            } catch (NumberFormatException ex) {
                pause(300);
                System.out.print("Please enter a number: ");
            }
        }

    }
    // helper method
    private boolean yesNo(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim().toLowerCase();

            if (input.startsWith("y")) {
                return true;
            }
            if (input.startsWith("n")) {
                return false;
            }
            pause(300);
            System.out.println("\nPlease enter 'y' (yes) or 'n' (no).");
        }

    }
        // For slight delay
        private void pause(long ms) {
            try {
                Thread.sleep(ms);
            } catch (Exception ignored) {
            }
        }

    }


    /* properties:
    private priceTable PriceTable
    private menu  menuData
    private Scanner

    UserInterface(priceTable, menu)
       this.priceTable = priceTable
        this.menu = menu
        new Scanner for user input

    methods: displayHomeScreen()
    loop:
    print 1) New order
    print 0) Exit
    choice = getUserChoice()
            if choice ==1 displayOrderScreen()
            else if choice == 0 break
            else print invalid option


    Method displayOrderScreen()
    Create new order
    loop
    display " Order Screen"
    display all orders (newest first)
        display:
        1) Add Bowl
        2) Add Drink
        3) Add Main Side
        4) Checkout
        0) Cancel Order - delete order and go back to home page
        prompt user choice
        choice = getUserChoice()

            if choice == 1 then
            addBowl(order)
            else if choice == 2 then
            addDrink(order)
            else if choice == 3 then
            addSide(order)
            else if choice == 4 then
            checkout(order)
            break // return to home screen
            else if choice == 0 then
            print "order cancelled"
            break
            else print "invalid choice, try again."
            end if
            end loop end method

addMacroBowl()
    baseType (mixed greens, brown rice, white rice, Sushi rice, no base
    bowlType ( build your own, signature items)
    size (small, medium, large)
    bowl = new MacroBowl(size , baseType , bowlType)
 optional: preload signature defaults based on bowlType

toppings loop
Loop:
    print add topping? 1 protein, 2 premium toppings, 3 other toppings ,4 select condiments,
          5 would you like items specialized

    itemChoice =getUserChoice()
    if itemChoice == 0 break
    if itemChoice == 1 2 3
    ask add extra? (y/n)

    route to addProtein, premium/regular topping ,

    if itemchoice == 4
        ask regular topping type bowl.addRegulartopping(type)

    if itemChoice = 5
        ask condiment type  bowl.addCondiment(type)

     ask "Special option? (none/power_sear/warm/chilled)"
                bowl.setSpecial(option)
                currentOrder.addBowl(bowl)
                print "Bowl added!"

    addDrink()

        ask size (s, m , l)
        ask drink type ( Green fiend , acai potion, Protein Powah)

        currentOrder.addDrink (new Drink(type, size)
        print drink added

    addSide()
        show list ( mixed veggies, sweet potatoe bites (main side), pita chips
        ask choice
        print side added

    checkoutScreen()
        if currentOrder.isEmpty() and not currentOrderhasDrinkorSide():
        print "please add a drink or main side if you have no bowls
        return

    print currentOrder.summaryText()
    print "total: $" + currentOrder.getTotal()
    ask confirm? (y/n)
    if yes:
                ReceiptWriter.saveReceipt(currentOrder)
                print "Saved!"
                else:
         print "Checkout canceled"


            getUserChoice() int
    */
