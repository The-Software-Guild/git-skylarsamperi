/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.ui;

import com.sg.vendingmachine.dao.VendingMachineDaoException;
import com.sg.vendingmachine.dto.Item;
import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

/**
 *
 * @author skylarsamperi
 */
public class VendingMachineView {
  private UserIO io;

    public VendingMachineView(UserIO io) {
        this.io = io;
    }

    public VendingMachineView() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void getAllItemBanner() {
        io.print("==== VENDING MACHINE PRODUCTS ===");
    }

    public void getAllItem(List<Item> itemList) {
        for (Item currentItem : itemList) {
           
            DecimalFormat dec = new DecimalFormat("#.00");
            String doubleCost = dec.format(currentItem.getItemCost());
       
            String itemInfo = String.format("ID:%s - Product: %s, Cost: $%s, Quanity: %s/%s",
                    currentItem.getItemId(),
                    currentItem.getItemName(),
                   doubleCost,
                    currentItem.getCurrentQuantity(),
                    currentItem.getMaxQuantity()
            );

            io.print(itemInfo);

        }
        io.readString("Please hit enter to continue");
    }

    public int addCoinsOption() {
        io.print("Add Money to the Vending Machine");
        io.print("1. Penny");
        io.print("2. Nickel");
        io.print("3. Dime");
        io.print("4. Quarter");
        io.print("5. Dollar");
        io.print("6. 5 Dollars");
        io.print("7. Done Adding Go To Item Selection");
        io.print("8. Exit");

        return io.readInt("Please select from the above choices.", 1, 8);

    }

    public void getSingleItem(Item item) {
        if (item != null) {
             DecimalFormat dec = new DecimalFormat("#.00");
               String doubleCost = dec.format(item.getItemCost());
            String itemInfo = String.format("ID:%s - Product: %s, Cost: $%s, Quanity: %s/%s",
                    item.getItemId(),
                    item.getItemName(),
                    doubleCost,
                    item.getCurrentQuantity(),
                    item.getMaxQuantity()
            );

            io.print(itemInfo);
        } else {
            io.print("No Such Item in the Vending Machine");
        }
        io.readString("Please hit enter to continue");
    }

    public void displayErrorMessage(String errorMsg) {
        io.print("=== ERROR ===");
        io.print(errorMsg);
    }

    public Item addViewItem() {
        String itemId = io.readString("Please enter product's ID #");
        String itemName = io.readString("Please enter product's name");
        String itemCost = io.readString("Please enter the cost of the product");
        String itemCurrentQuan = io.readString("Please enter the product's current quantity");
        String itemMaxQuan = io.readString("Please enter the product's max quantity");
        
        Item newItem = new Item(itemId);
        Double itemObj = parseDouble(itemCost);
        newItem.setItemName(itemName);
        newItem.setItemCost(itemObj);
        newItem.setCurrentQuantity(parseInt(itemCurrentQuan));
        newItem.setMaxQuantity(parseInt(itemMaxQuan));

        return newItem;

    }

    public String getItemId() {
        String itemId = io.readString("Please enter product's ID #");

        return itemId;
    }

    public void SuccessfulCreation() {
        io.print("Product added sucessfully");
    }
    
    public void showCurrentBalance(BigDecimal money){
        io.print("Your current Balance: " + money);
    }
    
    public String displayBuyingSelectionInput() throws VendingMachineDaoException{
        String itemId = io.readString("Please enter product's ID #");
        return itemId;
    }
    
    public void displayChange(int [] arr){
        io.print("Thank You For Purchasiing, Please Take Your Change!:");
        io.print(arr[0]+" Five Dollar Bills");
        io.print(arr[1]+" One Dollar Bills");
        io.print(arr[2]+" Quarters");
        io.print(arr[3]+" Dimes");
        io.print(arr[4]+" Nickels");
        io.print(arr[5]+" Pennys");
                
    }
    
    public void displayBoughtItem(Item item){
        String ItemName = item.getItemName();
        io.print("Purchasing "+ItemName);
    }
    public int printMenuAndGetSelection() {

        io.print("Main Menu");
        io.print("1. View All Items in Vending Machine");
        io.print("2. Add Item to The Vending Machine");
        io.print("3. View Item in Vending Machine");
        io.print("4. Buy Item in Vending Machine");
        io.print("5. Restock All Items (COMING SOON!)");
        io.print("6. Exit");

        return io.readInt("Please select from the above choices.", 1, 6);
    }
    
        public void askingForMoney(){
        io.print("Please Choose the follow Money to be added to balance then press 7 to continue:");
    }

           
    
}
