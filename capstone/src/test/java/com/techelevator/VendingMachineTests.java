package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class VendingMachineTests {

        @Test
        public void whenWrongSlotLocationSelected_returnIVALIDINPUT() {
            //arrange
            VendingMachine vendingMachine = new VendingMachine();
            String wrongSlotLocation = "D5";

            //act
            Item actual = vendingMachine.purchaseItem(wrongSlotLocation);


            //assert
            Assert.assertEquals("Invalid input", "D3", actual);
        }

        @Test
        public void whenNotEnoughMoney_returnINSUFFICIENTFUNDS() {
            VendingMachine vendingMachine = new VendingMachine();
            BigDecimal notEnoughFunds = new BigDecimal("1.00");

            BigDecimal actual = vendingMachine.getMoney().getBalance();

            Assert.assertEquals("Insufficient funds",notEnoughFunds,actual);
        }

        @Test
        public void whenNotWholeDollarAmount_returnNOTWHOLEDOLLAR() {

        }

}