/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Stubs;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author marouano
 */
public class CommsStubTest {
    
    public CommsStubTest() {
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
     * Test of getServerIp method, of class CommsStub.
     */
    @Test
    public void testGetServerIp() {
        System.out.println("getServerIp");
        CommsStub instance = null;
        String expResult = "";
        String result = instance.getServerIp();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setServerIp method, of class CommsStub.
     */
    @Test
    public void testSetServerIp() {
        System.out.println("setServerIp");
        String serverIp = "";
        CommsStub instance = null;
        instance.setServerIp(serverIp);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getChatIp method, of class CommsStub.
     */
    @Test
    public void testGetChatIp() {
        System.out.println("getChatIp");
        CommsStub instance = null;
        String expResult = "";
        String result = instance.getChatIp();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setChatIp method, of class CommsStub.
     */
    @Test
    public void testSetChatIp() {
        System.out.println("setChatIp");
        String chatIp = "";
        CommsStub instance = null;
        instance.setChatIp(chatIp);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of sendMessage method, of class CommsStub.
     */
    @Test
    public void testSendMessage() {
        System.out.println("sendMessage");
        String ip = "";
        String message = "";
        CommsStub instance = null;
        instance.sendMessage(ip, message);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of receiveMessage method, of class CommsStub.
     */
    @Test
    public void testReceiveMessage() {
        System.out.println("receiveMessage");
        String message = "";
        CommsStub instance = null;
        instance.receiveMessage(message);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
