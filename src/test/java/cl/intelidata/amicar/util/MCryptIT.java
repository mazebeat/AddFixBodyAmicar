/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.intelidata.amicar.util;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
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
public class MCryptIT {
    
    public MCryptIT() {
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
     * Test of bytesToHex method, of class MCrypt.
     */
    @Test
    public void testBytesToHex() {
        System.out.println("bytesToHex");
        byte[] data = null;
        String expResult = "";
        String result = MCrypt.bytesToHex(data);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hexToBytes method, of class MCrypt.
     */
    @Test
    public void testHexToBytes() {
        System.out.println("hexToBytes");
        String str = "";
        byte[] expResult = null;
        byte[] result = MCrypt.hexToBytes(str);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIvspec method, of class MCrypt.
     */
    @Test
    public void testGetIvspec() {
        System.out.println("getIvspec");
        MCrypt instance = new MCrypt();
        IvParameterSpec expResult = null;
        IvParameterSpec result = instance.getIvspec();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIvspec method, of class MCrypt.
     */
    @Test
    public void testSetIvspec() {
        System.out.println("setIvspec");
        IvParameterSpec ivspec = null;
        MCrypt instance = new MCrypt();
        instance.setIvspec(ivspec);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getKeyspec method, of class MCrypt.
     */
    @Test
    public void testGetKeyspec() {
        System.out.println("getKeyspec");
        MCrypt instance = new MCrypt();
        SecretKeySpec expResult = null;
        SecretKeySpec result = instance.getKeyspec();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setKeyspec method, of class MCrypt.
     */
    @Test
    public void testSetKeyspec() {
        System.out.println("setKeyspec");
        SecretKeySpec keyspec = null;
        MCrypt instance = new MCrypt();
        instance.setKeyspec(keyspec);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCipher method, of class MCrypt.
     */
    @Test
    public void testGetCipher() {
        System.out.println("getCipher");
        MCrypt instance = new MCrypt();
        Cipher expResult = null;
        Cipher result = instance.getCipher();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCipher method, of class MCrypt.
     */
    @Test
    public void testSetCipher() {
        System.out.println("setCipher");
        Cipher cipher = null;
        MCrypt instance = new MCrypt();
        instance.setCipher(cipher);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of encrypt method, of class MCrypt.
     */
    @Test
    public void testEncrypt() throws Exception {
        System.out.println("encrypt");
        String text = "";
        MCrypt instance = new MCrypt();
        byte[] expResult = null;
        byte[] result = instance.encrypt(text);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of decrypt method, of class MCrypt.
     */
    @Test
    public void testDecrypt() throws Exception {
        System.out.println("decrypt");
        String code = "";
        MCrypt instance = new MCrypt();
        byte[] expResult = null;
        byte[] result = instance.decrypt(code);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
