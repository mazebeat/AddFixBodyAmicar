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
public class ClientesIT {
    
    public ClientesIT() {
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
     * Test of getIdCliente method, of class Clientes.
     */
    @Test
    public void testGetIdCliente() {
        System.out.println("getIdCliente");
        Clientes instance = new Clientes();
        Integer expResult = null;
        Integer result = instance.getIdCliente();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIdCliente method, of class Clientes.
     */
    @Test
    public void testSetIdCliente() {
        System.out.println("setIdCliente");
        Integer idCliente = null;
        Clientes instance = new Clientes();
        instance.setIdCliente(idCliente);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRutCliente method, of class Clientes.
     */
    @Test
    public void testGetRutCliente() {
        System.out.println("getRutCliente");
        Clientes instance = new Clientes();
        String expResult = "";
        String result = instance.getRutCliente();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setRutCliente method, of class Clientes.
     */
    @Test
    public void testSetRutCliente() {
        System.out.println("setRutCliente");
        String rutCliente = "";
        Clientes instance = new Clientes();
        instance.setRutCliente(rutCliente);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEmailCliente method, of class Clientes.
     */
    @Test
    public void testGetEmailCliente() {
        System.out.println("getEmailCliente");
        Clientes instance = new Clientes();
        String expResult = "";
        String result = instance.getEmailCliente();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEmailCliente method, of class Clientes.
     */
    @Test
    public void testSetEmailCliente() {
        System.out.println("setEmailCliente");
        String emailCliente = "";
        Clientes instance = new Clientes();
        instance.setEmailCliente(emailCliente);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNombreCliente method, of class Clientes.
     */
    @Test
    public void testGetNombreCliente() {
        System.out.println("getNombreCliente");
        Clientes instance = new Clientes();
        String expResult = "";
        String result = instance.getNombreCliente();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNombreCliente method, of class Clientes.
     */
    @Test
    public void testSetNombreCliente() {
        System.out.println("setNombreCliente");
        String nombreCliente = "";
        Clientes instance = new Clientes();
        instance.setNombreCliente(nombreCliente);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFonoCelular method, of class Clientes.
     */
    @Test
    public void testGetFonoCelular() {
        System.out.println("getFonoCelular");
        Clientes instance = new Clientes();
        String expResult = "";
        String result = instance.getFonoCelular();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFonoCelular method, of class Clientes.
     */
    @Test
    public void testSetFonoCelular() {
        System.out.println("setFonoCelular");
        String fonoCelular = "";
        Clientes instance = new Clientes();
        instance.setFonoCelular(fonoCelular);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFonoComercial method, of class Clientes.
     */
    @Test
    public void testGetFonoComercial() {
        System.out.println("getFonoComercial");
        Clientes instance = new Clientes();
        String expResult = "";
        String result = instance.getFonoComercial();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFonoComercial method, of class Clientes.
     */
    @Test
    public void testSetFonoComercial() {
        System.out.println("setFonoComercial");
        String fonoComercial = "";
        Clientes instance = new Clientes();
        instance.setFonoComercial(fonoComercial);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFonoParticular method, of class Clientes.
     */
    @Test
    public void testGetFonoParticular() {
        System.out.println("getFonoParticular");
        Clientes instance = new Clientes();
        String expResult = "";
        String result = instance.getFonoParticular();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFonoParticular method, of class Clientes.
     */
    @Test
    public void testSetFonoParticular() {
        System.out.println("setFonoParticular");
        String fonoParticular = "";
        Clientes instance = new Clientes();
        instance.setFonoParticular(fonoParticular);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMarcaAuto method, of class Clientes.
     */
    @Test
    public void testGetMarcaAuto() {
        System.out.println("getMarcaAuto");
        Clientes instance = new Clientes();
        String expResult = "";
        String result = instance.getMarcaAuto();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMarcaAuto method, of class Clientes.
     */
    @Test
    public void testSetMarcaAuto() {
        System.out.println("setMarcaAuto");
        String marcaAuto = "";
        Clientes instance = new Clientes();
        instance.setMarcaAuto(marcaAuto);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getModeloAuto method, of class Clientes.
     */
    @Test
    public void testGetModeloAuto() {
        System.out.println("getModeloAuto");
        Clientes instance = new Clientes();
        String expResult = "";
        String result = instance.getModeloAuto();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setModeloAuto method, of class Clientes.
     */
    @Test
    public void testSetModeloAuto() {
        System.out.println("setModeloAuto");
        String modeloAuto = "";
        Clientes instance = new Clientes();
        instance.setModeloAuto(modeloAuto);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getValorAuto method, of class Clientes.
     */
    @Test
    public void testGetValorAuto() {
        System.out.println("getValorAuto");
        Clientes instance = new Clientes();
        String expResult = "";
        String result = instance.getValorAuto();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setValorAuto method, of class Clientes.
     */
    @Test
    public void testSetValorAuto() {
        System.out.println("setValorAuto");
        String valorAuto = "";
        Clientes instance = new Clientes();
        instance.setValorAuto(valorAuto);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIdGrupo method, of class Clientes.
     */
    @Test
    public void testGetIdGrupo() {
        System.out.println("getIdGrupo");
        Clientes instance = new Clientes();
        Integer expResult = null;
        Integer result = instance.getIdGrupo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIdGrupo method, of class Clientes.
     */
    @Test
    public void testSetIdGrupo() {
        System.out.println("setIdGrupo");
        Integer idGrupo = null;
        Clientes instance = new Clientes();
        instance.setIdGrupo(idGrupo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIdBody method, of class Clientes.
     */
    @Test
    public void testGetIdBody() {
        System.out.println("getIdBody");
        Clientes instance = new Clientes();
        Integer expResult = null;
        Integer result = instance.getIdBody();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIdBody method, of class Clientes.
     */
    @Test
    public void testSetIdBody() {
        System.out.println("setIdBody");
        Integer idBody = null;
        Clientes instance = new Clientes();
        instance.setIdBody(idBody);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFecha method, of class Clientes.
     */
    @Test
    public void testGetFecha() {
        System.out.println("getFecha");
        Clientes instance = new Clientes();
        Date expResult = null;
        Date result = instance.getFecha();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFecha method, of class Clientes.
     */
    @Test
    public void testSetFecha() {
        System.out.println("setFecha");
        Date fecha = null;
        Clientes instance = new Clientes();
        instance.setFecha(fecha);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNombreJrn method, of class Clientes.
     */
    @Test
    public void testGetNombreJrn() {
        System.out.println("getNombreJrn");
        Clientes instance = new Clientes();
        String expResult = "";
        String result = instance.getNombreJrn();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNombreJrn method, of class Clientes.
     */
    @Test
    public void testSetNombreJrn() {
        System.out.println("setNombreJrn");
        String nombreJrn = "";
        Clientes instance = new Clientes();
        instance.setNombreJrn(nombreJrn);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDesinscrito method, of class Clientes.
     */
    @Test
    public void testGetDesinscrito() {
        System.out.println("getDesinscrito");
        Clientes instance = new Clientes();
        boolean expResult = false;
        boolean result = instance.getDesinscrito();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDesinscrito method, of class Clientes.
     */
    @Test
    public void testSetDesinscrito() {
        System.out.println("setDesinscrito");
        boolean desinscrito = false;
        Clientes instance = new Clientes();
        instance.setDesinscrito(desinscrito);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getProcesoList method, of class Clientes.
     */
    @Test
    public void testGetProcesoList() {
        System.out.println("getProcesoList");
        Clientes instance = new Clientes();
        List<Proceso> expResult = null;
        List<Proceso> result = instance.getProcesoList();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setProcesoList method, of class Clientes.
     */
    @Test
    public void testSetProcesoList() {
        System.out.println("setProcesoList");
        List<Proceso> procesoList = null;
        Clientes instance = new Clientes();
        instance.setProcesoList(procesoList);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class Clientes.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Clientes instance = new Clientes();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class Clientes.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object object = null;
        Clientes instance = new Clientes();
        boolean expResult = false;
        boolean result = instance.equals(object);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Clientes.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Clientes instance = new Clientes();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
