/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.intelidata.amicar.jpa;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Maze
 */
public class BodyIT {
    
    public BodyIT() {
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

    /**
     * Test of getIdBody method, of class Body.
     */
    @Test
    public void testGetIdBody() {
        System.out.println("getIdBody");
        Body instance = new Body();
        Integer expResult = null;
        Integer result = instance.getIdBody();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIdBody method, of class Body.
     */
    @Test
    public void testSetIdBody() {
        System.out.println("setIdBody");
        Integer idBody = null;
        Body instance = new Body();
        instance.setIdBody(idBody);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBodyNombre method, of class Body.
     */
    @Test
    public void testGetBodyNombre() {
        System.out.println("getBodyNombre");
        Body instance = new Body();
        String expResult = "";
        String result = instance.getBodyNombre();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setBodyNombre method, of class Body.
     */
    @Test
    public void testSetBodyNombre() {
        System.out.println("setBodyNombre");
        String bodyNombre = "";
        Body instance = new Body();
        instance.setBodyNombre(bodyNombre);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class Body.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Body instance = new Body();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class Body.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object object = null;
        Body instance = new Body();
        boolean expResult = false;
        boolean result = instance.equals(object);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Body.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Body instance = new Body();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
