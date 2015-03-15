/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.intelidata.amicar.jpa;

import java.util.List;
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
public class LocalesIT {
    
    public LocalesIT() {
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
     * Test of getIdLocal method, of class Locales.
     */
    @Test
    public void testGetIdLocal() {
        System.out.println("getIdLocal");
        Locales instance = new Locales();
        Integer expResult = null;
        Integer result = instance.getIdLocal();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIdLocal method, of class Locales.
     */
    @Test
    public void testSetIdLocal() {
        System.out.println("setIdLocal");
        Integer idLocal = null;
        Locales instance = new Locales();
        instance.setIdLocal(idLocal);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNombreLocal method, of class Locales.
     */
    @Test
    public void testGetNombreLocal() {
        System.out.println("getNombreLocal");
        Locales instance = new Locales();
        String expResult = "";
        String result = instance.getNombreLocal();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNombreLocal method, of class Locales.
     */
    @Test
    public void testSetNombreLocal() {
        System.out.println("setNombreLocal");
        String nombreLocal = "";
        Locales instance = new Locales();
        instance.setNombreLocal(nombreLocal);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getVendedoresList method, of class Locales.
     */
    @Test
    public void testGetVendedoresList() {
        System.out.println("getVendedoresList");
        Locales instance = new Locales();
        List<Vendedores> expResult = null;
        List<Vendedores> result = instance.getVendedoresList();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setVendedoresList method, of class Locales.
     */
    @Test
    public void testSetVendedoresList() {
        System.out.println("setVendedoresList");
        List<Vendedores> vendedoresList = null;
        Locales instance = new Locales();
        instance.setVendedoresList(vendedoresList);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEjecutivosList method, of class Locales.
     */
    @Test
    public void testGetEjecutivosList() {
        System.out.println("getEjecutivosList");
        Locales instance = new Locales();
        List<Ejecutivos> expResult = null;
        List<Ejecutivos> result = instance.getEjecutivosList();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEjecutivosList method, of class Locales.
     */
    @Test
    public void testSetEjecutivosList() {
        System.out.println("setEjecutivosList");
        List<Ejecutivos> ejecutivosList = null;
        Locales instance = new Locales();
        instance.setEjecutivosList(ejecutivosList);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class Locales.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Locales instance = new Locales();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class Locales.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object object = null;
        Locales instance = new Locales();
        boolean expResult = false;
        boolean result = instance.equals(object);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Locales.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Locales instance = new Locales();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
