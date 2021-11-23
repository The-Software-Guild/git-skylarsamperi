/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.classroster.dao;

import com.mycompany.classroster.dto.Student;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author cwashingto
 */
public class ClassRosterDaoFileImpl implements ClassRosterDao  {

    private Map<String, Student> students = new HashMap<>();
    
    public final String ROSTER_FILE;
    public static final String DELIMITER = "::";

    public ClassRosterDaoFileImpl() {
        ROSTER_FILE = "roster.txt";
    }
    
    public ClassRosterDaoFileImpl( String FileName) {
        ROSTER_FILE = FileName;
       
    }
    
    @Override
    public Student addStudent(String studentID, Student student)  throws ClassRosterPersistenceException{
        
        loadRoster();
        Student prevStudent = students.put(studentID, student);
        writeRoster();
        return prevStudent;
    }

    @Override
    public List<Student> getAllStudents() throws ClassRosterPersistenceException{
        loadRoster();
        return new ArrayList<Student>(students.values());
    }

    @Override
    public Student getStudent(String studentID)throws ClassRosterPersistenceException {
        loadRoster();
        return students.get(studentID);
    }

    @Override
    public Student removeStudent(String studentID) throws ClassRosterPersistenceException{
        loadRoster();
        Student removedStudent = students.remove(studentID);
        writeRoster();
        return removedStudent;
    }
    
    private Student unmarshallStudent(String studentAsText){
        
        String[] stringTokens = studentAsText.split(DELIMITER);
        
        String studentID = stringTokens[0];
        
        Student studentFromFile = new Student(studentID);
        
        studentFromFile.setFirstName(stringTokens[1]);
                
        studentFromFile.setLastName(stringTokens[2]);
               
        studentFromFile.setCohort(stringTokens[3]);
        
        return studentFromFile;
        
    }
    
    private void loadRoster() throws ClassRosterPersistenceException {
        
        Scanner scanner;
        
        try{
            
            scanner = new Scanner( new BufferedReader ( new FileReader(ROSTER_FILE)));
            
        } catch(FileNotFoundException e){
            throw new ClassRosterPersistenceException(">.< NoFileFound", e);
        }
        
        String currentLine;
        
        Student currentStudent;
        
        while(scanner.hasNextLine()){
            
            currentLine = scanner.nextLine();
            
            currentStudent = this.unmarshallStudent(currentLine);
            
            students.put(currentStudent.getStudentId(), currentStudent);
        }
        
        scanner.close();
    }
    
    private String marshallStudent(Student aStudent){
        
        String studentAsText = aStudent.getStudentId()+DELIMITER;
        
        studentAsText += aStudent.getFirstName() + DELIMITER;
                
        studentAsText += aStudent.getLastName()  + DELIMITER;
                
        studentAsText += aStudent.getCohort();
        
        return studentAsText;
    }
    
    private void writeRoster() throws ClassRosterPersistenceException{
        
        PrintWriter out;
        
        try{
          out = new PrintWriter(new FileWriter(ROSTER_FILE));  
        } catch (IOException e){
            throw new ClassRosterPersistenceException("Student Can't Be saved", e);
        }
        
        String studentAsText;
        
        List<Student> studentList = this.getAllStudents();
        
        for(Student cStudent : studentList){
            studentAsText = marshallStudent(cStudent);
            out.println(studentAsText);
            out.flush();
        }
        out.close();
    }
}
