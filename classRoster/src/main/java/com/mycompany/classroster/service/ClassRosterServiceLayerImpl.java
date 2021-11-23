/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.classroster.service;

import com.mycompany.classroster.dao.ClassRosterAuditDao;
import com.mycompany.classroster.dao.ClassRosterDao;
import com.mycompany.classroster.dao.ClassRosterPersistenceException;
import com.mycompany.classroster.dto.Student;
import java.util.List;

/**
 *
 * @author cwashingto
 */
public class ClassRosterServiceLayerImpl implements ClassRosterServiceLayer{

    private ClassRosterDao dao;
    private ClassRosterAuditDao auditDao;


    public ClassRosterServiceLayerImpl(ClassRosterDao dao, ClassRosterAuditDao auditDao) {
        this.dao = dao;
        this.auditDao = auditDao;
    }
    
    
    
    @Override
    public void createStudent(Student student) throws ClassRosterDuplicateIdException, ClassRosterDataValidationException, ClassRosterPersistenceException {
        //RULE ONE Does ID Exist?
        if(dao.getStudent(student.getStudentId()) != null){
            throw new ClassRosterDuplicateIdException("The ID "
                                                     + student.getStudentId() 
                                                     +" already exists");
        }
        
        //RULE TWO is the Student Valid?
        validateStudentData(student);
        
        //RULE THREE PASS DATA TO DAO(s)
        dao.addStudent(student.getStudentId(), student);
        
        auditDao.writeAuditEntry("Student " + student.getStudentId() + " created");
    }

    @Override
    public List<Student> getAllStudets() throws ClassRosterPersistenceException {
        return dao.getAllStudents();
    }

    @Override
    public Student getStudent(String studentId) throws ClassRosterPersistenceException {
        return dao.getStudent(studentId);
    }

    @Override
    public Student removeSTudent(String studentId) throws ClassRosterPersistenceException {
        Student removedStudent = dao.removeStudent(studentId);
        auditDao.writeAuditEntry("Student " + studentId +" REMOVED");
        return removedStudent;
    }
    
    private void validateStudentData(Student student) throws ClassRosterDataValidationException {
        
        if(student.getFirstName() == null
                || student.getFirstName().trim().length() == 0
                || student.getLastName() == null
                || student.getLastName().trim().length() == 0
                || student.getCohort() == null
                || student.getCohort().trim().length() == 0){
            
            throw new ClassRosterDataValidationException("ERROR: All Field Needed!");
        }  
    }
    
}
