/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.dao;

import com.sg.vendingmachine.dto.Item;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 *
 * @author skylarsamperi
 */
public interface VendingMachineDao { //dao is used to get items from the meory
        /**
  /**
     * Removes from the Vending Machine the item associated with the given name.Returns the item object that is being removed or null if
 there is no item associated with the given name
     *
     * @param itemId
     * @param name name of item to be removed
     * @return item object that was removed or null if no student
     * was associated with the given item name
     * @throws com.sg.vendingmachine.dao.VendingMachineDaoException
     */
    Item addItem(String itemId, Item item) throws VendingMachineDaoException;
    
    List<Item> getAllItem() throws VendingMachineDaoException;
    
    Item getItem(String itemId) throws VendingMachineDaoException;
    
    Item updateItem(String itemId, Item item)throws VendingMachineDaoException;
    
    Item removeItem(String itemId)throws VendingMachineDaoException;
    
    BigDecimal getBalance() throws VendingMachineDaoException;
    
    void updateBalance(BigDecimal newBalance) throws VendingMachineDaoException;
    
    void setBalanceTest();
    BigDecimal getBalanceTest();
    

    
}





