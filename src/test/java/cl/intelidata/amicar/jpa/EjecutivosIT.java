/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.intelidata.amicar.jpa;

import java.util.Date;
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
public class EjecutivosIT {
    
    public EjecutivosIT() {
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
     * Test of getIdEjecutivo method, of class Ejecutivos.
     */
    @Test
    public void testGetIdEjecutivo() {
        System.out.println("getIdEjecutivo");
        Ejecutivos instance = new Ejecutivos();
        Integer expResult = null;
        Integer result = instance.getIdEjecutivo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIdEjecutivo method, of class Ejecutivos.
     */
    @Test
    public void testSetIdEjecutivo() {
        System.out.println("setIdEjecutivo");
        Integer idEjecutivo = null;
        Ejecutivos instance = new Ejecutivos();
        instance.setIdEjecutivo(idEjecutivo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNombreEjecutivo method, of class Ejecutivos.
     */
    @Test
    public void testGetNombreEjecutivo() {
        System.out.println("getNombreEjecutivo");
        Ejecutivos instance = new Ejecutivos();
        String expResult = "";
        String result = instance.getNombreEjecutivo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNombreEjecutivo method, of class Ejecutivos.
     */
    @Test
    public void testSetNombreEjecutivo() {
        System.out.println("setNombreEjecutivo");
        String nombreEjecutivo = "";
        Ejecutivos instance = new Ejecutivos();
        instance.setNombreEjecutivo(nombreEjecutivo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCorreoEjecutivo method, of class Ejecutivos.
     */
    @Test
    public void testGetCorreoEjecutivo() {
        System.out.println("getCorreoEjecutivo");
        Ejecutivos instance = new Ejecutivos();
        String expResult = "";
        String result = instance.getCorreoEjecutivo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCorreoEjecutivo method, of class Ejecutivos.
     */
    @Test
    public void testSetCorreoEjecutivo() {
        System.out.println("setCorreoEjecutivo");
        String correoEjecutivo = "";
        Ejecutivos instance = new Ejecutivos();
        instance.setCorreoEjecutivo(correoEjecutivo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFechaIngreso method, of class Ejecutivos.
     */
    @Test
    public void testGetFechaIngreso() {
        System.out.println("getFechaIngreso");
        Ejecutivos instance = new Ejecutivos();
        Date expResult = null;
        Date result = instance.getFechaIngreso();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFechaIngreso method, of class Ejecutivos.
     */
    @Test
    public void testSetFechaIngreso() {
        System.out.println("setFechaIngreso");
        Date fechaIngreso = null;
        Ejecutivos instance = new Ejecutivos();
        instance.setFechaIngreso(fechaIngreso);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFechaModificacion method, of class Ejecutivos.
     */
    @Test
    public void testGetFechaModificacion() {
        System.out.println("getFechaModificacion");
        Ejecutivos instance = new Ejecutivos();
        String expResult = "";
        String result = instance.getFechaModificacion();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFechaModificacion method, of class Ejecutivos.
     */
    @Test
    public void testSetFechaModificacion() {
        System.out.println("setFechaModificacion");
        String fechaModificacion = "";
        Ejecutivos instance = new Ejecutivos();
        instance.setFechaModificacion(fechaModificacion);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getProcesoList method, of class Ejecutivos.
     */
    @Test
    public void testGetProcesoList() {
        System.out.println("getProcesoList");
        Ejecutivos instance = new Ejecutivos();
        List<Proceso> expResult = null;
        List<Proceso> result = instance.getProcesoList();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setProcesoList method, of class Ejecutivos.
     */
    @Test
    public void testSetProcesoList() {
        System.out.println("setProcesoList");
        List<Proceso> procesoList = null;
        Ejecutivos instance = new Ejecutivos();
        instance.setProcesoList(procesoList);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLocalesidLocal1 method, of class Ejecutivos.
     */
    @Test
    public void testGetLocalesidLocal1() {
        System.out.println("getLocalesidLocal1");
        Ejecutivos instance = new Ejecutivos();
        Locales expResult = null;
        Locales result = instance.getLocalesidLocal1();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLocalesidLocal1 method, of class Ejecutivos.
     */
    @Test
    public void testSetLocalesidLocal1() {
        System.out.println("setLocalesidLocal1");
        Locales localesidLocal1 = null;
        Ejecutivos instance = new Ejecutivos();
        instance.setLocalesidLocal1(localesidLocal1);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class Ejecutivos.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Ejecutivos instance = new Ejecutivos();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class Ejecutivos.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object object = null;
        Ejecutivos instance = new Ejecutivos();
        boolean expResult = false;
        boolean result = instance.equals(object);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Ejecutivos.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Ejecutivos instance = new Ejecutivos();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
