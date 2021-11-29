/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sg.vendingmachine.dao;

import com.sg.vendingmachine.dto.Item;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author skylarsamperi
 */
public class VendingMachineDaoStubImpl {
    public Item onlyItem;
    public BigDecimal currentMoney= new BigDecimal(00.00);
    
    public VendingMachineDaoStubImpl() {
        onlyItem = new Item("0022");
        onlyItem.setItemName("Mars");
        onlyItem.setItemCost(6.00);
        onlyItem.setCurrentQuantity(3);
        onlyItem.setMaxQuantity(30);
    }
    
    
    public VendingMachineDaoStubImpl(Item testItem){
         this.onlyItem = testItem;
     }

    public Item addItem(String itemId, Item item) throws VendingMachineDaoException {
            if (itemId.equals(onlyItem.getItemId())) {
            return onlyItem;
        } else {
            return null;
        }
    }

    public List<Item> getAllItem() throws VendingMachineDaoException {
         List<Item> itemList = new ArrayList<>();
        itemList.add(onlyItem);
        return itemList;
    }

    public Item getItem(String itemId) throws VendingMachineDaoException {
        if (itemId.equals(onlyItem.getItemId())) {
            return onlyItem;
        } else {
            return null;
    }
    }
    
    public Item updateItem(String itemId, Item item) throws VendingMachineDaoException {
        onlyItem = item;
        return onlyItem;
    }

    public Item removeItem(String itemId) throws VendingMachineDaoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public BigDecimal getBalance() throws VendingMachineDaoException {
        return currentMoney;
    }

    public void updateBalance(BigDecimal newBalance) throws VendingMachineDaoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setBalanceTest() {
        currentMoney = new BigDecimal(10.00); 
    }
    
    public BigDecimal getBalanceTest(){
        System.out.println("test");
        System.out.println(currentMoney);
        return currentMoney;
    }

    
    

    
}
