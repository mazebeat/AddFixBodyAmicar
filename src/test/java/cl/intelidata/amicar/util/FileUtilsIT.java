/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.intelidata.amicar.util;

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
public class FileUtilsIT {
    
    public FileUtilsIT() {
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
     * Test of writeFile method, of class FileUtils.
     */
    @Test
    public void testWriteFile() throws Exception {
        System.out.println("writeFile");
        String file = "";
        String whereOut = "";
        List<String> list = null;
        Boolean expResult = null;
        Boolean result = FileUtils.writeFile(file, whereOut, list);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of readDirectory method, of class FileUtils.
     */
    @Test
    public void testReadDirectory() {
        System.out.println("readDirectory");
        String directory = "";
        String findByExt = "";
        List<String> expResult = null;
        List<String> result = FileUtils.readDirectory(directory, findByExt);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of fullReadFile method, of class FileUtils.
     */
    @Test
    public void testFullReadFile() {
        System.out.println("fullReadFile");
        String filename = "";
        String expResult = "";
        String result = FileUtils.fullReadFile(filename);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
