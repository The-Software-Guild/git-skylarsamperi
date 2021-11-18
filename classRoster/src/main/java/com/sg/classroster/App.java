/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.classroster;

import com.sg.classroster.controller.ClassRosterController;
import com.sg.classroster.dao.ClassRosterDaoFileImpl;
import com.sg.classroster.dao.classRosterDao;
import com.sg.classroster.ui.ClassRosterView;
import com.sg.classroster.ui.UserIO;
import com.sg.classroster.ui.UserIOConsoleImpl;

/**
 *
 * @author skylarsamperi
 */
public class App {
    
    public static void main(String[] args) {
  
        ClassRosterController controller = new ClassRosterController();
        controller.run();
    }
}
