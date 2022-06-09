package com.techelevator;

import java.math.BigDecimal;
import java.util.Scanner;

public class PurchaseMenu {
    public void run() {

        String chips = "Crunch crunch, Yum!";
        String candy = "Munch munch, Yum!";
        String drink = "Glug glug, Yum!";
        String gum = "Chew chew, Yum!";
        BigDecimal defaultBalance = new BigDecimal("0.00");
        BigDecimal balance = defaultBalance;
        boolean addmore = true;
        ;


        String[] mainMenu = {"[1] Feed Money", "[2] Select Product", "[3] Finish Transaction"};

        Scanner userInput = new Scanner(System.in);

        System.out.println("Purchase Menu\n");
        for (int i = 0; i < mainMenu.length; i++) {
            System.out.println(mainMenu[i]);
        }
        System.out.println("\n");
        System.out.println("Please make a selection by number: ");
        Integer userSelection = Integer.parseInt(userInput.nextLine());
        Money newMoney = new Money(balance, addmore);

// account for wrong input (wrong format, less than 0 val)

        if (userSelection.equals(1)) {

        } else if (userSelection.equals(2)) {
            Inventory items = new Inventory();
            boolean anotherPurchase = true;


            for (Item item : items.getInventory()) {
                System.out.printf("%s %s %s %s\n", item.getSlotLocation(), item.getProductName(), item.getPrice(), item.getProductType());
            }
            System.out.println("==========================================");
            Scanner codeSelection = new Scanner(System.in);
            System.out.println(newMoney.calculatingMoney()); //this should be currentBalance
            System.out.println("Enter product code (i.e. A1, D3, etc.): \n");
            String userCodeSelection = codeSelection.nextLine();

            for (Item item : items.getInventory()) {
                if (userCodeSelection.equalsIgnoreCase(item.getSlotLocation())) {
                    switch (item.getProductType()) {
                        case "Chip":
                            System.out.println(chips);
                            break;
                        case "Candy":
                            System.out.println(candy);
                            break;
                        case "Drink":
                            System.out.println(drink);
                            break;
                        case "Gum":
                            System.out.println(gum);
                            break;
                    }
                }
            }
            System.out.printf("Your remaining balance is: %s", balance);

            Scanner anotherProduct = new Scanner(System.in);
            String wantAnotherSelection = "Do you want to make another selection? Y/N";
            System.out.println(wantAnotherSelection);
            String wantsAnother = anotherProduct.nextLine();

            if(wantsAnother.equalsIgnoreCase("y")){
                anotherPurchase = true;
            } else if (wantsAnother.equalsIgnoreCase("n")) {
                //return to purchase menu
                anotherPurchase = false;
                System.out.println("purchase menu");
            }

            // errors - if product doesn't exist & if SOLD OUT
            // if no more, go back to main menu
        } else if (userSelection.equals(3)) {
            // to return change

            BigDecimal updatedBalance = balance;
            balance = BigDecimal.valueOf(0);
            System.out.printf("here is your change: %s", balance);
            System.out.printf("Machine balance: %s", updatedBalance);
        }

    }
}



