/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.intelidata.amicar.conf;

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
public class ConfiguracionIT {
    
    public ConfiguracionIT() {
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
     * Test of getInstance method, of class Configuracion.
     */
    @Test
    public void testGetInstance() {
        System.out.println("getInstance");
        Configuracion expResult = null;
        Configuracion result = Configuracion.getInstance();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getInitParameter method, of class Configuracion.
     */
    @Test
    public void testGetInitParameter() {
        System.out.println("getInitParameter");
        String name = "";
        Configuracion instance = null;
        String expResult = "";
        String result = instance.getInitParameter(name);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setInitParameter method, of class Configuracion.
     */
    @Test
    public void testSetInitParameter() {
        System.out.println("setInitParameter");
        String key = "";
        String value = "";
        Configuracion instance = null;
        instance.setInitParameter(key, value);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
