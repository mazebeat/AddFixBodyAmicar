/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.intelidata.amicar;

import cl.intelidata.amicar.jpa.Clientes;
import cl.intelidata.amicar.jpa.Clientesdiario;
import cl.intelidata.amicar.jpa.Proceso;
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
public class DBIT {
    
    public DBIT() {
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
     * Test of example method, of class DB.
     */
    @Test
    public void testExample() {
        System.out.println("example");
        String[] args = null;
        DB.example(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCliente method, of class DB.
     */
    @Test
    public void testGetCliente() throws Exception {
        System.out.println("getCliente");
        Integer id = null;
        DB instance = new DB();
        Clientes expResult = null;
        Clientes result = instance.getCliente(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of buscarCliente method, of class DB.
     */
    @Test
    public void testBuscarCliente() {
        System.out.println("buscarCliente");
        String rutCliente = "";
        String emailCliente = "";
        DB instance = new DB();
        Clientesdiario expResult = null;
        Clientesdiario result = instance.buscarCliente(rutCliente, emailCliente);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getProceso method, of class DB.
     */
    @Test
    public void testGetProceso() throws Exception {
        System.out.println("getProceso");
        Integer id = null;
        DB instance = new DB();
        Proceso expResult = null;
        Proceso result = instance.getProceso(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of actualizarProceso method, of class DB.
     */
    @Test
    public void testActualizarProceso() throws Exception {
        System.out.println("actualizarProceso");
        Proceso proceso = null;
        char queFecha = ' ';
        DB instance = new DB();
        instance.actualizarProceso(proceso, queFecha);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of actualizarCliente method, of class DB.
     */
    @Test
    public void testActualizarCliente() throws Exception {
        System.out.println("actualizarCliente");
        Clientes cliente = null;
        DB instance = new DB();
        instance.actualizarCliente(cliente);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
