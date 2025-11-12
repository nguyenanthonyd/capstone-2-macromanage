package com.pluralsight.ui;

public class UserInterface {
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
    }
