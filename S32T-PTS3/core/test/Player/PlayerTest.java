/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Player;

import player2.Player;
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
public class PlayerTest {
    
    public PlayerTest() {
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
     * Test of getUsername method, of class Player.
     */
    @Test
    public void testGetUsername() {
        System.out.println("getUsername");
        Player instance = new Player("test", 1);
        String expResult = "test";
        String result = instance.getUsername();
        assertEquals(expResult, result);
    }

    /**
     * Test of setUsername method, of class Player.
     */
    @Test
    public void testSetUsername() {
        System.out.println("setUsername");
        String username = "test";
        Player instance = new Player("NotChanged", 1);
        instance.setUsername(username);
        assertEquals(username, instance.getUsername());
    }

    /**
     * Test of getId method, of class Player.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Player instance = new Player("test", 5);
        int expResult = 5;
        int result = instance.getId();
        assertEquals(expResult, result);
    }

    /**
     * Test of setId method, of class Player.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        int id = 6;
        Player instance = new Player("test", 1);
        instance.setId(id);
        assertEquals(id, instance.getId());
    }
    
}
