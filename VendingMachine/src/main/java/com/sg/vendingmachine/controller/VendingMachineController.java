/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.controller;

import com.sg.vendingmachine.dao.VendingMachineDaoException;
import com.sg.vendingmachine.dao.VendingMachinePersistenceException;
import com.sg.vendingmachine.dto.Item;
import com.sg.vendingmachine.service.InsufficientFundsException;
import com.sg.vendingmachine.service.NoItemInventoryException;
import com.sg.vendingmachine.service.VendingMachineServiceLayer;
import com.sg.vendingmachine.ui.UserIO;
import com.sg.vendingmachine.ui.UserIOConsoleImpl;
import com.sg.vendingmachine.ui.VendingMachineView;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 *
 * @author skylarsamperi
 */
public class VendingMachineController {
  
    private VendingMachineView view;
//    private VendingMachineDao dao = new VendingMachineDaoImpl();
    private VendingMachineServiceLayer service;

    public VendingMachineController(VendingMachineServiceLayer service, VendingMachineView view) {
        this.service = service;
        this.view = view;
    }

    private void getAllItems() throws VendingMachineDaoException {
        List<Item> itemList = service.getAllItem();
        view.getAllItem(itemList);

    }

//    private void AddItem() throws VendingMachineDaoException{
//        Item newItem = view.addViewItem();
//        String ID = newItem.getItemId();
//        dao.addItem(ID,newItem);
//        view.SuccessfulCreation();
//        
//        
//    }
    private void ViewSingleItem() throws VendingMachineDaoException {
        String itemId = view.getItemId();
        Item getItem = service.getItem(itemId);
        view.getSingleItem(getItem);

    }

    private void buyingItem() throws VendingMachineDaoException, InsufficientFundsException, NoItemInventoryException{
        view.askingForMoney();
        MoneyAdded();
    }

    public void getCurrentBalance() throws VendingMachineDaoException {
        BigDecimal balance = service.getBalance();
        view.showCurrentBalance(balance);
    }

    public void buyingScreen() throws VendingMachineDaoException, InsufficientFundsException, NoItemInventoryException {
        boolean hasErrors = false;
        do {

            try {
                String itemId = view.displayBuyingSelectionInput();
                int[] totalChange = service.buyItem(itemId);
                Item itemBought = service.getItem(itemId);
                view.displayBoughtItem(itemBought);
                view.displayChange(totalChange);
                break;
            } catch (InsufficientFundsException |VendingMachineDaoException| NoItemInventoryException e) {
                hasErrors = true;
                view.displayErrorMessage(e.getMessage());
                        view.askingForMoney();
        MoneyAdded();
            }
        } while (hasErrors);
    }

    public void MoneyAdded() throws VendingMachineDaoException, InsufficientFundsException, NoItemInventoryException{
        boolean adding = true;
        while (adding) {
            getCurrentBalance();
            int addingSelection = view.addCoinsOption();
            
            switch (addingSelection) {
                case 1:
                    service.addingPenny();
                    System.out.println("Penny Added");
                    break;
                case 2:
                    service.addingNickel();
                    System.out.println("Nickel Added");
                    break;
                case 3:
                    service.addingDime();
                    System.out.println("Dime Added");
                    break;
                case 4:
                    service.addingQuarter();
                    System.out.println("Quarter Added");
                    break;
                case 5:
                    service.addingDollar();
                    System.out.println("Dollar Added");
                    break;
                case 6:
                    service.addingFiver();
                    System.out.println("5 Dollar Added");
                    break;
                case 7:
                    System.out.println("Go to Selection");
                    buyingScreen();
                    adding = false;
                    break;
                case 8:
                    System.out.println("Exit");
                    adding = false;
                    break;

            }
        }
    }

    public void run() throws VendingMachineDaoException, InsufficientFundsException, NoItemInventoryException {

        boolean running = true;
        getAllItems();
        while (running) {
            int menuSelection = view.printMenuAndGetSelection();
            try {
                switch (menuSelection) {
                    case 1:

                        getAllItems();

                        break;
                    case 2:
//                AddItem();
                        System.out.println("Will be added soon!");

                        break;
                    case 3:
                        ViewSingleItem();

                        break;
                    case 4:
                        buyingItem();
                        running = false;
                        break;
                    case 5:

                        System.out.println("5");

                        break;
                    case 6:
                        System.out.println("Exiting");
                        running = false;
                        break;

                }
            } catch (VendingMachineDaoException e) {
                view.displayErrorMessage(e.getMessage());
            }

        }
    }

  }
    

