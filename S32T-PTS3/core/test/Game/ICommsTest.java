/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

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
public class ICommsTest {
    
    public ICommsTest() {
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
     * Test of sendMessage method, of class IComms.
     */
    @Test
    public void testSendMessage() {
        System.out.println("sendMessage");
        String ip = "";
        String message = "";
        IComms instance = new ICommsImpl();
        instance.sendMessage(ip, message);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class ICommsImpl implements IComms {

        public void sendMessage(String ip, String message) {
        }
    }
    
}
