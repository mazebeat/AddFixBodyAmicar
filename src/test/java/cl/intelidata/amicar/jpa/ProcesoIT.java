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
public class ProcesoIT {
    
    public ProcesoIT() {
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
     * Test of getIdProceso method, of class Proceso.
     */
    @Test
    public void testGetIdProceso() {
        System.out.println("getIdProceso");
        Proceso instance = new Proceso();
        Integer expResult = null;
        Integer result = instance.getIdProceso();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIdProceso method, of class Proceso.
     */
    @Test
    public void testSetIdProceso() {
        System.out.println("setIdProceso");
        Integer idProceso = null;
        Proceso instance = new Proceso();
        instance.setIdProceso(idProceso);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFechaEnvio method, of class Proceso.
     */
    @Test
    public void testGetFechaEnvio() {
        System.out.println("getFechaEnvio");
        Proceso instance = new Proceso();
        Date expResult = null;
        Date result = instance.getFechaEnvio();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFechaEnvio method, of class Proceso.
     */
    @Test
    public void testSetFechaEnvio() {
        System.out.println("setFechaEnvio");
        Date fechaEnvio = null;
        Proceso instance = new Proceso();
        instance.setFechaEnvio(fechaEnvio);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFechaAperturaMail method, of class Proceso.
     */
    @Test
    public void testGetFechaAperturaMail() {
        System.out.println("getFechaAperturaMail");
        Proceso instance = new Proceso();
        Date expResult = null;
        Date result = instance.getFechaAperturaMail();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFechaAperturaMail method, of class Proceso.
     */
    @Test
    public void testSetFechaAperturaMail() {
        System.out.println("setFechaAperturaMail");
        Date fechaAperturaMail = null;
        Proceso instance = new Proceso();
        instance.setFechaAperturaMail(fechaAperturaMail);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFechaClickLink method, of class Proceso.
     */
    @Test
    public void testGetFechaClickLink() {
        System.out.println("getFechaClickLink");
        Proceso instance = new Proceso();
        Date expResult = null;
        Date result = instance.getFechaClickLink();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFechaClickLink method, of class Proceso.
     */
    @Test
    public void testSetFechaClickLink() {
        System.out.println("setFechaClickLink");
        Date fechaClickLink = null;
        Proceso instance = new Proceso();
        instance.setFechaClickLink(fechaClickLink);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getVendedoresidVendedor method, of class Proceso.
     */
    @Test
    public void testGetVendedoresidVendedor() {
        System.out.println("getVendedoresidVendedor");
        Proceso instance = new Proceso();
        Vendedores expResult = null;
        Vendedores result = instance.getVendedoresidVendedor();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setVendedoresidVendedor method, of class Proceso.
     */
    @Test
    public void testSetVendedoresidVendedor() {
        System.out.println("setVendedoresidVendedor");
        Vendedores vendedoresidVendedor = null;
        Proceso instance = new Proceso();
        instance.setVendedoresidVendedor(vendedoresidVendedor);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEjecutivosidEjecutivo method, of class Proceso.
     */
    @Test
    public void testGetEjecutivosidEjecutivo() {
        System.out.println("getEjecutivosidEjecutivo");
        Proceso instance = new Proceso();
        Ejecutivos expResult = null;
        Ejecutivos result = instance.getEjecutivosidEjecutivo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEjecutivosidEjecutivo method, of class Proceso.
     */
    @Test
    public void testSetEjecutivosidEjecutivo() {
        System.out.println("setEjecutivosidEjecutivo");
        Ejecutivos ejecutivosidEjecutivo = null;
        Proceso instance = new Proceso();
        instance.setEjecutivosidEjecutivo(ejecutivosidEjecutivo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getClientesidCliente method, of class Proceso.
     */
    @Test
    public void testGetClientesidCliente() {
        System.out.println("getClientesidCliente");
        Proceso instance = new Proceso();
        Clientes expResult = null;
        Clientes result = instance.getClientesidCliente();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setClientesidCliente method, of class Proceso.
     */
    @Test
    public void testSetClientesidCliente() {
        System.out.println("setClientesidCliente");
        Clientes clientesidCliente = null;
        Proceso instance = new Proceso();
        instance.setClientesidCliente(clientesidCliente);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class Proceso.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Proceso instance = new Proceso();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class Proceso.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object object = null;
        Proceso instance = new Proceso();
        boolean expResult = false;
        boolean result = instance.equals(object);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Proceso.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Proceso instance = new Proceso();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
