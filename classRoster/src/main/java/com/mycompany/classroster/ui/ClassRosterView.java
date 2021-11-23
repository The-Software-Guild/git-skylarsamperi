/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.classroster.ui;

import com.mycompany.classroster.dto.Student;
import java.util.List;

/**
 *
 * @author cwashingto
 */
public class ClassRosterView {
    UserIO io;
    
    public ClassRosterView(UserIO io){
        this.io = io;
    }
    
    public Student getNewStudentInfo(){
        String sID = io.readString("Please enter Student ID");
        String fName = io.readString("Please enter first name");
        String lName = io.readString("Please enter last name");
        String cohort = io.readString("Please enter Cohort");
        Student currentStudent = new Student(sID);
        currentStudent.setFirstName(fName);
        currentStudent.setLastName(lName);
        currentStudent.setCohort(cohort);
        return currentStudent;
        
    }
    
    public void displayCreateStudentBanner(){
        io.print("=== Create Student ===");
    }
    
    public void displayCreateSuccessBanner(){
        io.readString("Student Entered! Enter to Continue.");
    }
    
    public void displayStudentList(List<Student> studentList){
        for ( Student currentStudent : studentList){
            String studentInfo = String.format("#%s : %s %s", 
                                 currentStudent.getStudentId(),
                                  currentStudent.getFirstName(),
                                  currentStudent.getLastName());
            io.print(studentInfo);                                 
        }
        io.readString("Please hit enter to continue.");
    }
    
    public void displayDisplayAllBanner(){
        io.print("=== Display All Students ===");
    }

    public void displayDisplayStudentBanner(){
        io.print("=== Display Student ===");
    }
    
    public String getStudentIDChoice(){
        return io.readString("Please Enter the Student ID");
    }
    
    public void displayStudent( Student student){
        if(student != null){
            io.print(student.getStudentId());
            io.print(student.getFirstName() + " " + student.getLastName());
            io.print(student.getCohort());
            io.print("");
        } else{
            io.print("No such Student!");
        }
        io.readString("Please hit Enter to continue.");
    }
    
    public void displayDisplayRemoveStudentBanner(){
        io.print("=== Remove Student ===");
    }
    public void displayRemovedResult(Student student86){
        if(student86 != null){
            io.print("Student successfully 86'd");
        }else{
            io.print("No such Student.");
        }
        io.readString("Please hit enter to continue.");
    }
    
    public int printMenuAndGetSelection(){
        io.print("Main Menu");
        io.print("1. List Student IDs");
        io.print("2. Ceate New Student");
        io.print("3. View a Student");
        io.print("4. Remove a Student");
        io.print("5. Exit");

        return io.readInt("Please Pick From Above", 1, 5);
    }
    
    public void displayExitBanner(){
        io.print("Good Bye");
    }
    public void displayUnknown(){
        io.print("Unknown Command");
    }
    
    public void distplayErrorMessage( String errorMsg){
        io.print("=== ERROR ===");
        io.print(errorMsg);
    }
}
