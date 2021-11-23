/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.classroster.dao;

import com.mycompany.classroster.dto.Student;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author cwashingto
 */
public class ClassRosterDaoFileImplTest {
    
    ClassRosterDao testDao;
    
    public ClassRosterDaoFileImplTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws IOException {
        String testFile = "testroster.txt";
        new FileWriter(testFile);
        testDao = new ClassRosterDaoFileImpl(testFile);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testAddGetStudent() throws ClassRosterPersistenceException {
        //Arrage
        String studentID = "0001";
        Student student = new Student(studentID);
        student.setFirstName("Ada");
        student.setLastName("Lovelace");
        student.setCohort("Java");
        
        //ACT  
        testDao.addStudent(studentID, student);
        Student rStudent = testDao.getStudent(studentID);
        
        //ASSERT
        assertEquals("Check for same ID",
                     rStudent.getStudentId(),
                     student.getStudentId());

        assertEquals("Check for same first Name",
                     rStudent.getFirstName(),
                     student.getFirstName());

        assertEquals("Check for same last Name",
                     rStudent.getLastName(),
                     student.getLastName());

        assertEquals("Check for same Cohort",
                     rStudent.getCohort(),
                     student.getCohort());        
        
        
    }
    
    @Test
    public void testAddGetAllStudents() throws Exception{
        //Arrange
        
        Student firstStudent = new Student("0001");
        firstStudent.setFirstName("Ada");
        firstStudent.setLastName("Lovelace");
        firstStudent.setCohort("Java");
        
        Student nextStudent = new Student("0002");
        nextStudent.setFirstName("Charles");
        nextStudent.setLastName("Babbage");
        nextStudent.setCohort("Java");
        
        //ACT
        testDao.addStudent(nextStudent.getStudentId(), nextStudent);
        testDao.addStudent(firstStudent.getStudentId(), firstStudent);
        
        List<Student> roster = testDao.getAllStudents();
        
        //Assert
        
        assertNotNull("Must Not Be Null", roster);
        
        assertEquals("Add two students to empty DAO ",2, roster.size());
        
        assertTrue("Ada should be in list", 
                   testDao.getAllStudents().contains(firstStudent));
        
        assertTrue("Charles should be in list", 
                   testDao.getAllStudents().contains(nextStudent));
        
        
        
    }
    
    @Test
    public void testRemoveStudet() throws Exception{
         Student firstStudent = new Student("0001");
        firstStudent.setFirstName("Ada");
        firstStudent.setLastName("Lovelace");
        firstStudent.setCohort("Java");
        
        Student nextStudent = new Student("0002");
        nextStudent.setFirstName("Charles");
        nextStudent.setLastName("Babbage");
        nextStudent.setCohort("Java");
        
        //ACT
        testDao.addStudent(nextStudent.getStudentId(), nextStudent);
        testDao.addStudent(firstStudent.getStudentId(), firstStudent);
        
        Student removeS = testDao.removeStudent(firstStudent.getStudentId());
        
        //Assert
        assertEquals("This is Ada", removeS, firstStudent);
        
        //ACT 2
        List<Student> allStudents = testDao.getAllStudents();
        
        //Assert 2
        assertNotNull("Is Not Null", allStudents);
        
        assertEquals(1, allStudents.size());
        
        assertFalse("Ada is out", allStudents.contains(firstStudent));
        assertTrue("Charles stil in", allStudents.contains(nextStudent));
        
        //ACT 3
        testDao.removeStudent(nextStudent.getStudentId());
        allStudents = testDao.getAllStudents();
        //ASSERT 3
        
        assertTrue("Should Be empty",allStudents.isEmpty());
        
        removeS = testDao.getStudent(firstStudent.getStudentId());
        
        assertNull("should be null", removeS);
        
    }
}
