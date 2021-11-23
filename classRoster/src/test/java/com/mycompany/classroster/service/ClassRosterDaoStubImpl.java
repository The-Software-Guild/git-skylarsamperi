/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.classroster.service;

import com.mycompany.classroster.dao.ClassRosterDao;
import com.mycompany.classroster.dao.ClassRosterPersistenceException;
import com.mycompany.classroster.dto.Student;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author cwashingto
 */
public class ClassRosterDaoStubImpl implements ClassRosterDao{

    public Student onlyStudent;

    
    public ClassRosterDaoStubImpl(){
        onlyStudent = new Student("0001");
        onlyStudent.setFirstName("Ada");
        onlyStudent.setLastName("Lovelace");
        onlyStudent.setCohort("Java");
    }
    
    public ClassRosterDaoStubImpl(Student onlyStudent) {
        this.onlyStudent = onlyStudent;
    }
    
    
    
    
    @Override
    public Student addStudent(String studentID, Student student) throws ClassRosterPersistenceException {
        if(studentID.equals(onlyStudent.getStudentId())){
            return onlyStudent;
        }
        return null;
    }

    @Override
    public List<Student> getAllStudents() throws ClassRosterPersistenceException {
        List<Student> sList = new ArrayList<>();
        sList.add(onlyStudent);
        return sList;
    }

    @Override
    public Student getStudent(String studentID) throws ClassRosterPersistenceException {
        return studentID.equals(onlyStudent.getStudentId()) ? onlyStudent : null;
    }

    @Override
    public Student removeStudent(String studentID) throws ClassRosterPersistenceException {
        return studentID.equals(onlyStudent.getStudentId()) ? onlyStudent : null;
    }
    
}
