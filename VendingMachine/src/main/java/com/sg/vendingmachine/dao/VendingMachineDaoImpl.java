/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.dao;

import com.sg.vendingmachine.dto.Item;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 *
 * @author skylarsamperi
 */
public class VendingMachineDaoImpl implements VendingMachineDao{

    @Override
    public void setBalanceTest() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public BigDecimal getBalanceTest() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

 interface StringFunction {
        String run(String str);
    }
    
    public Map<String, Item> itemMap = new HashMap<>();
    public final String ITEM_ROSTER_FILE;
    public static final String DELIMITER = "::";
    StringFunction delimiter = (s) -> s + "::";
    public BigDecimal currentMoney= new BigDecimal(0.00);

    
    public VendingMachineDaoImpl(){
         ITEM_ROSTER_FILE  =  "Inventory.txt";
   
                    }
    public VendingMachineDaoImpl(String TextFile) {
        ITEM_ROSTER_FILE = TextFile;
    }
  
    
    private Item unmarshallItem(String ItemfromFile) {
        String[] itemSplit = ItemfromFile.split(DELIMITER);
        String itemId = itemSplit[0];
        Item itemFile = new Item(itemId);
    
        itemFile.setItemName(itemSplit[1]);
        itemFile.setItemCost(parseDouble(itemSplit[2]));
        itemFile.setCurrentQuantity(parseInt(itemSplit[3]));
        itemFile.setMaxQuantity(parseInt(itemSplit[4]));
        

        return itemFile;
    }

    private void loadFromText() throws VendingMachineDaoException{
        Scanner scanner;

        try {
            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(ITEM_ROSTER_FILE)));
        } catch (FileNotFoundException e) {
            throw new VendingMachineDaoException("File not found. ");
        }

        String currentLine;
        Item currentItem;

        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            currentItem = unmarshallItem(currentLine);

            itemMap.put(currentItem.getItemId(), currentItem);
        }

        scanner.close();

    }
    
  public static String printFormatted(String str, StringFunction format) {
    String result = format.run(str);
    return result;
  }
    private String marshallItem(Item addedItem) {
        String itemId = addedItem.getItemId();
        String itemName = addedItem.getItemName();
        String itemCost = Double.toString(addedItem.getItemCost());
        String currentQuantity = String.valueOf(addedItem.getCurrentQuantity());
        String maxQuantity = String.valueOf(addedItem.getMaxQuantity());
        
        String ITEMTOBEADDED = printFormatted(itemId,delimiter) + printFormatted(itemName,delimiter) + printFormatted(itemCost,delimiter) + printFormatted(currentQuantity,delimiter)+printFormatted(maxQuantity,delimiter);
        System.out.println("This works!");
//        String ITEMTOBEADDED = addedItem.getItemId() + DELIMITER + addedItem.getItemName() + DELIMITER + addedItem.getItemCost() + DELIMITER + addedItem.getCurrentQuantity()+DELIMITER + addedItem.getMaxQuantity(); 
            
        return ITEMTOBEADDED;
    }

    private void writeToText() throws VendingMachineDaoException {
        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(ITEM_ROSTER_FILE));

        } catch (IOException e) {
            throw new VendingMachineDaoException("could not save Item to data", e);
        }

        String ItemAsText;
        List<Item> itemList = this.getAllItem();

        for (Item currentItem : itemList) {
            ItemAsText = marshallItem(currentItem);
            out.println(ItemAsText);
            out.flush();
        }
        out.close();
    }

    @Override
    public Item addItem(String itemId, Item item) throws VendingMachineDaoException {
     
       
       loadFromText();
       Item newItem;
       newItem = itemMap.put(itemId,item);
       writeToText();
       
       return newItem;
       
       
    }

    @Override
    public List<Item> getAllItem() throws VendingMachineDaoException {
        loadFromText();
        return new ArrayList<Item>(itemMap.values());
    }

    @Override
    public Item getItem(String itemId) throws VendingMachineDaoException {
        loadFromText();
        return itemMap.get(itemId);
    }

    @Override
    public Item updateItem(String itemId, Item item) throws VendingMachineDaoException {
        loadFromText();
        
        Item changedItem = itemMap.replace(itemId,item);
  
        writeToText();
        return changedItem;   
    }

    @Override
    public Item removeItem(String itemId) throws VendingMachineDaoException {
       loadFromText();
       Item removedItem = itemMap.remove(itemId);
       writeToText();
       return removedItem;
    }
    
    @Override
    public BigDecimal getBalance(){
        return currentMoney;
    }
    
    public void setBalance(){
        currentMoney= new BigDecimal(10.00);
    }
    
    @Override
    public void updateBalance(BigDecimal newBalance) throws VendingMachineDaoException {
        currentMoney = newBalance;
    }

    
}
