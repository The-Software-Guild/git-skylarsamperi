/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.classroster.dao;

import com.mycompany.classroster.dto.Student;
import java.util.List;

/**
 *
 * @author cwashingto
 */
public interface ClassRosterDao {
    
    Student addStudent(String studentID, Student student)  throws ClassRosterPersistenceException;
    
    List<Student> getAllStudents() throws ClassRosterPersistenceException;
    
    Student getStudent(String studentID) throws ClassRosterPersistenceException;
    
    Student removeStudent(String studentID) throws ClassRosterPersistenceException;
    
}
