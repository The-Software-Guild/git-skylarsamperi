/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sg.vendingmachine.service;

import com.sg.vendingmachine.dao.VendingMachineAuditDao;
import com.sg.vendingmachine.dao.VendingMachineAuditDaoFileImpl;
import com.sg.vendingmachine.dao.VendingMachineDao;
import com.sg.vendingmachine.dao.VendingMachineDaoException;
import com.sg.vendingmachine.dao.VendingMachinePersistenceException;
import com.sg.vendingmachine.dto.Balance;
import com.sg.vendingmachine.dto.Item;
import com.sg.vendingmachine.ui.UserIO;
import com.sg.vendingmachine.ui.UserIOConsoleImpl;
import com.sg.vendingmachine.ui.VendingMachineView;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Map;

/**
 *
 * @author skylarsamperi
 */
public class VendingMachineServiceLayerImpl implements VendingMachineServiceLayer{
     //The service layer is responsible for the business logic of an application. It sits between
    //the controller and DAOs.
    
    VendingMachineDao dao;
    private VendingMachineAuditDao auditDao;

    public UserIO testio = new UserIOConsoleImpl();
    public VendingMachineView test = new VendingMachineView(testio);

    /*@Override
    public void checkIfEnoughMoney(Item item, BigDecimal inputMoney) throws InsufficientFundsException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeOneItemFromInventory(String name) throws NoItemInventoryException, VendingMachinePersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Map<String, BigDecimal> getItemsInStockWithCosts() throws VendingMachinePersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Item getItem(String name, BigDecimal inputMoney) throws InsufficientFundsException, NoItemInventoryException, VendingMachinePersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Map<BigDecimal, BigDecimal> getChangePerCoin(Item item, BigDecimal money) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
*/

    public VendingMachineServiceLayerImpl(VendingMachineDao dao, VendingMachineAuditDaoFileImpl auditDao) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
 
 
    
    public enum Money {
        PENNY,
        NICKEL,
        DIME,
        QUARTER,
        DOLLAR,
        FIVEDOLLAR
        
    }
    
    
  
    public BigDecimal addingMoney(Money coin, BigDecimal currenMoney){
        
         BigDecimal bigPenny = new BigDecimal(.01);
         BigDecimal bigNickel = new BigDecimal(.05);   
         BigDecimal bigDime = new BigDecimal(.10);
         BigDecimal bigQuarter = new BigDecimal(.25);
         BigDecimal bigDollar = new BigDecimal(1.00);
         BigDecimal bigFiver = new BigDecimal(5.00);
         
         switch(coin){
             case PENNY:
                 return currenMoney.add(bigPenny);
             case NICKEL:
                 return currenMoney.add(bigNickel);
             case DIME:
                 return currenMoney.add(bigDime);
             case QUARTER:
                 return currenMoney.add(bigQuarter);
             case DOLLAR:
                 return currenMoney.add(bigDollar);
             case FIVEDOLLAR:
                 return currenMoney.add(bigFiver);
             default:
                  throw new UnsupportedOperationException();
              
         }
        
     }

    public VendingMachineServiceLayerImpl(VendingMachineDao dao, VendingMachineAuditDao auditDao) {
        this.dao = dao;
        this.auditDao = auditDao;
    }

    @Override
    public List<Item> getAllItem() throws VendingMachineDaoException {
        return dao.getAllItem();
    }

    @Override
    public Item getItem(String itemId) throws VendingMachineDaoException {
        if(itemId==null){
            throw new VendingMachineDaoException("Invalid ID");
        }
        return dao.getItem(itemId);
    }
    
    @Override
    public BigDecimal addingPenny() throws VendingMachineDaoException{
        BigDecimal CurrentBalance = dao.getBalance();
        BigDecimal newCurrentBalance = addingMoney(Money.PENNY, CurrentBalance);
        dao.updateBalance(newCurrentBalance);
        
        
        return newCurrentBalance.setScale(2, RoundingMode.FLOOR);
    }
    
       @Override
    public BigDecimal addingNickel() throws VendingMachineDaoException {
        BigDecimal CurrentBalance = dao.getBalance();
        BigDecimal newCurrentBalance = addingMoney(Money.NICKEL, CurrentBalance);
        dao.updateBalance(newCurrentBalance);
        
        return newCurrentBalance.setScale(2, RoundingMode.FLOOR);
    }

    @Override
    public BigDecimal addingDime() throws VendingMachineDaoException {
        BigDecimal CurrentBalance = dao.getBalance();
        BigDecimal newCurrentBalance = addingMoney(Money.DIME, CurrentBalance);
        dao.updateBalance(newCurrentBalance);
        
        return newCurrentBalance.setScale(2, RoundingMode.FLOOR);
    }

    @Override
    public BigDecimal addingQuarter() throws VendingMachineDaoException {
        BigDecimal CurrentBalance = dao.getBalance();
        BigDecimal newCurrentBalance = addingMoney(Money.QUARTER, CurrentBalance);
        dao.updateBalance(newCurrentBalance);
        
        return newCurrentBalance.setScale(2, RoundingMode.FLOOR);
    }

    @Override
    public BigDecimal addingDollar() throws VendingMachineDaoException {
        BigDecimal CurrentBalance = dao.getBalance();
        BigDecimal newCurrentBalance = addingMoney(Money.DOLLAR, CurrentBalance);
        dao.updateBalance(newCurrentBalance);
        
        return newCurrentBalance.setScale(2, RoundingMode.FLOOR);   
    }
    

    @Override
    public BigDecimal addingFiver() throws VendingMachineDaoException {
        BigDecimal CurrentBalance = dao.getBalance();
        BigDecimal newCurrentBalance = addingMoney(Money.FIVEDOLLAR, CurrentBalance);
        dao.updateBalance(newCurrentBalance);
        
        return newCurrentBalance.setScale(2, RoundingMode.FLOOR);
    }
    
    @Override
    public BigDecimal getBalance() throws VendingMachineDaoException{
        BigDecimal returnStatement = dao.getBalance();
        
        
        return returnStatement.setScale(2, RoundingMode.FLOOR);
        
    }
    
    @Override
    public int[] returnChange(BigDecimal change) throws VendingMachineDaoException {
        int quarter = 0;
        int penny = 0;
        int dime= 0;
        int nickel = 0;
        int dollar = 0;
        int five = 0;
       
       
        
        BigDecimal bigComp = (new BigDecimal(.00)).setScale(2, RoundingMode.FLOOR);
        BigDecimal bigPenny = (new BigDecimal(.01)).setScale(2, RoundingMode.FLOOR);
        BigDecimal bigNickel = (new BigDecimal(.05)).setScale(2, RoundingMode.FLOOR); 
        BigDecimal bigDime = (new BigDecimal(.10)).setScale(2, RoundingMode.FLOOR);
        BigDecimal bigQuarter =(new BigDecimal(.25)).setScale(2, RoundingMode.FLOOR);
        BigDecimal bigDollar = (new BigDecimal(1.00)).setScale(2, RoundingMode.FLOOR);
        BigDecimal bigFiver = (new BigDecimal(5.00)).setScale(2, RoundingMode.FLOOR);
               
        
        while(change.compareTo(bigComp)==1){
  
            if((change.subtract(bigFiver)).compareTo(bigComp)==1 || (change.subtract(bigFiver)).compareTo(bigComp)==0){
                five += 1;
                change = change.subtract(bigFiver);
            }
            else if((change.subtract(bigDollar)).compareTo(bigComp)==1 || (change.subtract(bigDollar)).compareTo(bigComp)==0){
                dollar += 1;
                change = change.subtract(bigDollar);
            }
            else if((change.subtract(bigQuarter)).compareTo(bigComp)==1 || (change.subtract(bigQuarter)).compareTo(bigComp)==0){
                quarter += 1;
                change = change.subtract(bigQuarter);
            }
            else if((change.subtract(bigDime)).compareTo(bigComp)==1 || (change.subtract(bigDime)).compareTo(bigComp)==0){
                dime += 1;
                change = change.subtract(bigDime);
            }
            else if((change.subtract(bigNickel)).compareTo(bigComp)==1 || (change.subtract(bigNickel)).compareTo(bigComp)==0){
                nickel += 1;
                change = change.subtract(bigNickel);
            }
            else if((change.subtract(bigPenny)).compareTo(bigComp)==1 || (change.subtract(bigPenny)).compareTo(bigComp)==0){
                penny += 1;
                change = change.subtract(bigPenny);
            }
        }
        
        int [] changeAmount = {five,dollar,quarter,dime,nickel,penny};
        return changeAmount;
    }
    
    @Override
    public int[] buyItem(String itemId)  throws VendingMachineDaoException, InsufficientFundsException, NoItemInventoryException{
        BigDecimal currentBalance = dao.getBalance();
        currentBalance = currentBalance.setScale(2, RoundingMode.FLOOR);
        Item vendingItem = dao.getItem(itemId);
        if (vendingItem == null){
            throw new VendingMachineDaoException("Invalid ID");
        }
        BigDecimal currentCost = new BigDecimal(vendingItem.getItemCost());
        currentCost = currentCost.setScale(2, RoundingMode.FLOOR);
        int res = currentBalance.compareTo(currentCost);
        
        String id = vendingItem.getItemId();
        String name = vendingItem.getItemName();
        double cost = vendingItem.getItemCost();
        int max = vendingItem.getMaxQuantity();
        
        if (vendingItem.getCurrentQuantity() < 1){
            throw new NoItemInventoryException(vendingItem.getItemName() + " is out of stock right now");
        }
        
        
        if(res==-1){
            throw new InsufficientFundsException("Insufficient Funds!");
        }
        
        int currentQuant = vendingItem.getCurrentQuantity();
        int newQuant = currentQuant -1;
        System.out.println(newQuant);
        
        
        
        vendingItem.setItemName(name);
        vendingItem.setItemCost(cost);
        vendingItem.setCurrentQuantity(newQuant);
        vendingItem.setMaxQuantity(max);
        
        
        dao.updateItem(itemId, vendingItem);
        
        auditDao.writeAuditEntry(name +" was purchased");
        BigDecimal change = currentBalance.subtract(currentCost);
        
        
        int[] changeAmount = returnChange(change);
       
        return changeAmount;
        
    }
}
