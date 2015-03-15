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
public class ClientealgoritmoIT {
    
    public ClientealgoritmoIT() {
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
     * Test of getIdClienteAlgoritmo method, of class Clientealgoritmo.
     */
    @Test
    public void testGetIdClienteAlgoritmo() {
        System.out.println("getIdClienteAlgoritmo");
        Clientealgoritmo instance = new Clientealgoritmo();
        Integer expResult = null;
        Integer result = instance.getIdClienteAlgoritmo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIdClienteAlgoritmo method, of class Clientealgoritmo.
     */
    @Test
    public void testSetIdClienteAlgoritmo() {
        System.out.println("setIdClienteAlgoritmo");
        Integer idClienteAlgoritmo = null;
        Clientealgoritmo instance = new Clientealgoritmo();
        instance.setIdClienteAlgoritmo(idClienteAlgoritmo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIdCliente method, of class Clientealgoritmo.
     */
    @Test
    public void testGetIdCliente() {
        System.out.println("getIdCliente");
        Clientealgoritmo instance = new Clientealgoritmo();
        Integer expResult = null;
        Integer result = instance.getIdCliente();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIdCliente method, of class Clientealgoritmo.
     */
    @Test
    public void testSetIdCliente() {
        System.out.println("setIdCliente");
        Integer idCliente = null;
        Clientealgoritmo instance = new Clientealgoritmo();
        instance.setIdCliente(idCliente);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIdBody method, of class Clientealgoritmo.
     */
    @Test
    public void testGetIdBody() {
        System.out.println("getIdBody");
        Clientealgoritmo instance = new Clientealgoritmo();
        Integer expResult = null;
        Integer result = instance.getIdBody();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIdBody method, of class Clientealgoritmo.
     */
    @Test
    public void testSetIdBody() {
        System.out.println("setIdBody");
        Integer idBody = null;
        Clientealgoritmo instance = new Clientealgoritmo();
        instance.setIdBody(idBody);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class Clientealgoritmo.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Clientealgoritmo instance = new Clientealgoritmo();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class Clientealgoritmo.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object object = null;
        Clientealgoritmo instance = new Clientealgoritmo();
        boolean expResult = false;
        boolean result = instance.equals(object);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Clientealgoritmo.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Clientealgoritmo instance = new Clientealgoritmo();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
