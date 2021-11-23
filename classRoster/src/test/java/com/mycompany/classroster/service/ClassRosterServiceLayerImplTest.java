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
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author cwashingto
 */
public class ClassRosterServiceLayerImplTest {
    
    private ClassRosterServiceLayer service;
    
    public ClassRosterServiceLayerImplTest() {
        /*
        ClassRosterDao dao = new ClassRosterDaoStubImpl();
        ClassRosterAuditDao auditDao = new ClassRosterAuditDaoStubImpl();
        
        service = new ClassRosterServiceLayerImpl(dao, auditDao);
        */
        ApplicationContext ctx = 
        new ClassPathXmlApplicationContext("applicationContext.xml");
    service = 
        ctx.getBean("serviceLayer", ClassRosterServiceLayer.class);
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testCreateValidStudent() {
        
        Student validS = new Student("0002");
        validS.setFirstName("Charles");
        validS.setLastName("Babbage");
        validS.setCohort("java");
        
        try{
            service.createStudent(validS);
        }catch(ClassRosterDuplicateIdException
            | ClassRosterDataValidationException
            | ClassRosterPersistenceException e){
            fail("If you don't Fail you Pass");
        }
        
    }
    
    @Test
    public void testCreateDupicateIdStudent(){
        Student notValidS = new Student("0001");
        notValidS.setFirstName("Charles");
        notValidS.setLastName("Babbage");
        notValidS.setCohort("java");
        
        try{
            service.createStudent(notValidS);
            fail("Should not have worked FAIL!!!");
        } catch(ClassRosterDataValidationException
                | ClassRosterPersistenceException e){
            //fail
            fail("This is not the Error we are looking for;");
        } catch( ClassRosterDuplicateIdException e){
            return;
        }
        
    }
    
    @Test
    public void testCreateStudentInvalidData(){
        Student validS = new Student("0002");
        validS.setFirstName("");
        validS.setLastName("Babbage");
        validS.setCohort("java");
        
        try{
            service.createStudent(validS);
            fail("Should not have worked FAIL");
            
        } catch( ClassRosterPersistenceException 
                | ClassRosterDuplicateIdException e){
            fail("Wrong Error! Fail");
        } catch (ClassRosterDataValidationException e){
            return;
        }
        
    }
    
    @Test
    public void testGetAllStudents() throws ClassRosterPersistenceException{
        Student validS = new Student("0001");
        validS.setFirstName("Ada");
        validS.setLastName("Lovelace");
        validS.setCohort("Java");
        
        assertEquals("The Size of list should be one!", 1
                     , service.getAllStudets().size()); 
        
        assertTrue("The One Student is Ada",
                     service.getAllStudets().contains(validS));
    }
    
    @Test
    public void testGetStudent() throws ClassRosterPersistenceException{
        Student validS = new Student("0001");
        validS.setFirstName("Ada");
        validS.setLastName("Lovelace");
        validS.setCohort("Java");
        
        Student ShouldB, ShouldNOTb;
        
        ShouldB = service.getStudent("0001");
        assertNotNull("Should Be Ada", ShouldB);
        assertEquals("They should be The Same",ShouldB, validS);
        
        ShouldNOTb = service.getStudent("0042");
        assertNull("Null is Correct", ShouldNOTb);
    }
    
    @Test
    public void testRemoveStudent() throws ClassRosterPersistenceException {
        Student validS = new Student("0001");
        validS.setFirstName("Ada");
        validS.setLastName("Lovelace");
        validS.setCohort("Java");
        
        Student ShouldB, shouldBeNull;
        
        ShouldB = service.removeSTudent("0001");
        assertNotNull("Not a Null Value",ShouldB);
        assertEquals("Should Be Ada", ShouldB, validS);
        
        shouldBeNull = service.removeSTudent("0042");
        assertNull("Should be null", shouldBeNull);
        
    }
}
