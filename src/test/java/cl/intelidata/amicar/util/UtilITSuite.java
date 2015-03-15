/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.intelidata.amicar.util;

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
@Suite.SuiteClasses({cl.intelidata.amicar.util.FileUtilsIT.class, cl.intelidata.amicar.util.ToolsIT.class, cl.intelidata.amicar.util.MCryptIT.class, cl.intelidata.amicar.util.TextIT.class})
public class UtilITSuite {

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
