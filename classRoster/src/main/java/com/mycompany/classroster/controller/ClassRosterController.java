/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.classroster.controller;

import com.mycompany.classroster.dao.ClassRosterPersistenceException;
import com.mycompany.classroster.dao.ClassRosterDaoFileImpl;
import com.mycompany.classroster.dto.Student;
import com.mycompany.classroster.ui.ClassRosterView;
import java.util.List;
import com.mycompany.classroster.dao.ClassRosterDao;
import com.mycompany.classroster.service.ClassRosterDataValidationException;
import com.mycompany.classroster.service.ClassRosterDuplicateIdException;
import com.mycompany.classroster.service.ClassRosterServiceLayer;

/**
 *
 * @author cwashingto
 */
public class ClassRosterController {

    private ClassRosterServiceLayer service;
    private ClassRosterView view;
    
    public ClassRosterController(ClassRosterServiceLayer service, ClassRosterView view){
        this.service = service;
        this.view = view;
    }
    
    public void run(){
        boolean keepGoing = true;
        int menuSelection = 0;
        try{
            while (keepGoing) {

                menuSelection = getMenuSelection();

                switch(menuSelection){
                    case 1:
                        this.listStudents();
                        break;
                    case 2:
                        this.createStudent();
                        break;
                    case 3:
                        viewStudent();
                        break;
                    case 4:
                        removeStudent();
                        break;
                    case 5:
                        keepGoing = false;
                        break;
                    default:
                        view.displayUnknown();
                }

            }

            view.displayExitBanner();
            
        }catch(ClassRosterPersistenceException e){
            view.distplayErrorMessage(e.getMessage());
        }
    }
    
    private int getMenuSelection(){
        return view.printMenuAndGetSelection();
    }
    
    private void createStudent() throws ClassRosterPersistenceException{
        view.displayCreateStudentBanner();
        boolean hasErrors = false;
        do{
            Student newStudent = view.getNewStudentInfo();
            try{
                service.createStudent(newStudent);
                view.displayCreateSuccessBanner();
                hasErrors = false;
            } catch (ClassRosterDuplicateIdException | ClassRosterDataValidationException e){
                hasErrors = true;
                view.distplayErrorMessage(e.getMessage());
            }
        } while(hasErrors);
    }
    
    private void listStudents() throws ClassRosterPersistenceException{
        view.displayDisplayAllBanner();
        List<Student> studentList = service.getAllStudets();
        view.displayStudentList(studentList);
    }
    
    private void viewStudent() throws ClassRosterPersistenceException{
        view.displayDisplayStudentBanner();
        String studentID = view.getStudentIDChoice();
        Student student = service.getStudent(studentID);
        view.displayStudent(student);
    }
    
    private void removeStudent() throws ClassRosterPersistenceException{
        view.displayDisplayRemoveStudentBanner();
        String sID = view.getStudentIDChoice();
        Student rid = service.removeSTudent(sID);
        view.displayRemovedResult(rid);
    }
}

