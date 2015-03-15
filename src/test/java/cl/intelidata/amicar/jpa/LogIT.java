/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.intelidata.amicar.jpa;

import java.util.Date;
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
public class LogIT {
    
    public LogIT() {
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
     * Test of getIdlog method, of class Log.
     */
    @Test
    public void testGetIdlog() {
        System.out.println("getIdlog");
        Log instance = new Log();
        Integer expResult = null;
        Integer result = instance.getIdlog();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIdlog method, of class Log.
     */
    @Test
    public void testSetIdlog() {
        System.out.println("setIdlog");
        Integer idlog = null;
        Log instance = new Log();
        instance.setIdlog(idlog);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIdVendedor method, of class Log.
     */
    @Test
    public void testGetIdVendedor() {
        System.out.println("getIdVendedor");
        Log instance = new Log();
        Integer expResult = null;
        Integer result = instance.getIdVendedor();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIdVendedor method, of class Log.
     */
    @Test
    public void testSetIdVendedor() {
        System.out.println("setIdVendedor");
        Integer idVendedor = null;
        Log instance = new Log();
        instance.setIdVendedor(idVendedor);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIdCliente method, of class Log.
     */
    @Test
    public void testGetIdCliente() {
        System.out.println("getIdCliente");
        Log instance = new Log();
        Integer expResult = null;
        Integer result = instance.getIdCliente();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIdCliente method, of class Log.
     */
    @Test
    public void testSetIdCliente() {
        System.out.println("setIdCliente");
        Integer idCliente = null;
        Log instance = new Log();
        instance.setIdCliente(idCliente);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIdEjecutivo method, of class Log.
     */
    @Test
    public void testGetIdEjecutivo() {
        System.out.println("getIdEjecutivo");
        Log instance = new Log();
        Integer expResult = null;
        Integer result = instance.getIdEjecutivo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIdEjecutivo method, of class Log.
     */
    @Test
    public void testSetIdEjecutivo() {
        System.out.println("setIdEjecutivo");
        Integer idEjecutivo = null;
        Log instance = new Log();
        instance.setIdEjecutivo(idEjecutivo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFechaLog method, of class Log.
     */
    @Test
    public void testGetFechaLog() {
        System.out.println("getFechaLog");
        Log instance = new Log();
        Date expResult = null;
        Date result = instance.getFechaLog();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFechaLog method, of class Log.
     */
    @Test
    public void testSetFechaLog() {
        System.out.println("setFechaLog");
        Date fechaLog = null;
        Log instance = new Log();
        instance.setFechaLog(fechaLog);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class Log.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Log instance = new Log();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class Log.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object object = null;
        Log instance = new Log();
        boolean expResult = false;
        boolean result = instance.equals(object);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Log.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Log instance = new Log();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
