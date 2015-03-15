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
public class VendedoresIT {
    
    public VendedoresIT() {
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
     * Test of getIdVendedor method, of class Vendedores.
     */
    @Test
    public void testGetIdVendedor() {
        System.out.println("getIdVendedor");
        Vendedores instance = new Vendedores();
        Integer expResult = null;
        Integer result = instance.getIdVendedor();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIdVendedor method, of class Vendedores.
     */
    @Test
    public void testSetIdVendedor() {
        System.out.println("setIdVendedor");
        Integer idVendedor = null;
        Vendedores instance = new Vendedores();
        instance.setIdVendedor(idVendedor);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRutVendedor method, of class Vendedores.
     */
    @Test
    public void testGetRutVendedor() {
        System.out.println("getRutVendedor");
        Vendedores instance = new Vendedores();
        String expResult = "";
        String result = instance.getRutVendedor();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setRutVendedor method, of class Vendedores.
     */
    @Test
    public void testSetRutVendedor() {
        System.out.println("setRutVendedor");
        String rutVendedor = "";
        Vendedores instance = new Vendedores();
        instance.setRutVendedor(rutVendedor);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNombreVendedor method, of class Vendedores.
     */
    @Test
    public void testGetNombreVendedor() {
        System.out.println("getNombreVendedor");
        Vendedores instance = new Vendedores();
        String expResult = "";
        String result = instance.getNombreVendedor();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNombreVendedor method, of class Vendedores.
     */
    @Test
    public void testSetNombreVendedor() {
        System.out.println("setNombreVendedor");
        String nombreVendedor = "";
        Vendedores instance = new Vendedores();
        instance.setNombreVendedor(nombreVendedor);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLocalesidLocal method, of class Vendedores.
     */
    @Test
    public void testGetLocalesidLocal() {
        System.out.println("getLocalesidLocal");
        Vendedores instance = new Vendedores();
        Locales expResult = null;
        Locales result = instance.getLocalesidLocal();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLocalesidLocal method, of class Vendedores.
     */
    @Test
    public void testSetLocalesidLocal() {
        System.out.println("setLocalesidLocal");
        Locales localesidLocal = null;
        Vendedores instance = new Vendedores();
        instance.setLocalesidLocal(localesidLocal);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getProcesoList method, of class Vendedores.
     */
    @Test
    public void testGetProcesoList() {
        System.out.println("getProcesoList");
        Vendedores instance = new Vendedores();
        List<Proceso> expResult = null;
        List<Proceso> result = instance.getProcesoList();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setProcesoList method, of class Vendedores.
     */
    @Test
    public void testSetProcesoList() {
        System.out.println("setProcesoList");
        List<Proceso> procesoList = null;
        Vendedores instance = new Vendedores();
        instance.setProcesoList(procesoList);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class Vendedores.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Vendedores instance = new Vendedores();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class Vendedores.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object object = null;
        Vendedores instance = new Vendedores();
        boolean expResult = false;
        boolean result = instance.equals(object);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Vendedores.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Vendedores instance = new Vendedores();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
