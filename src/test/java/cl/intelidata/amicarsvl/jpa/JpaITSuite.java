/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.intelidata.amicarsvl.jpa;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author Maze
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({cl.intelidata.amicar.jpa.LogIT.class, cl.intelidata.amicar.jpa.BodyIT.class, cl.intelidata.amicar.jpa.ClientealgoritmoIT.class, cl.intelidata.amicar.jpa.EjecutivosIT.class, cl.intelidata.amicar.jpa.ClientesIT.class, cl.intelidata.amicar.jpa.ClientessemanalIT.class, cl.intelidata.amicar.jpa.VendedoresIT.class, cl.intelidata.amicar.jpa.CorreoserrorformatoIT.class, cl.intelidata.amicar.jpa.ClientesdiarioIT.class, cl.intelidata.amicar.jpa.LocalesIT.class, cl.intelidata.amicar.jpa.ProcesoIT.class})
public class JpaITSuite {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
}
