/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import Player.Player;
import java.util.List;
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
public class ClientManagerTest {
    
    public ClientManagerTest() {
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
     * Test of getSelf method, of class ClientManager.
     */
    @Test
    public void testGetSelf() {
        System.out.println("getSelf");
        ClientManager instance = new ClientManager();
        Player expResult = null;
        Player result = instance.getSelf();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSelf method, of class ClientManager.
     */
    @Test
    public void testSetSelf() {
        System.out.println("setSelf");
        Player self = null;
        ClientManager instance = new ClientManager();
        instance.setSelf(self);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPlayers method, of class ClientManager.
     */
    @Test
    public void testGetPlayers() {
        System.out.println("getPlayers");
        ClientManager instance = new ClientManager();
        List<Player> expResult = null;
        List<Player> result = instance.getPlayers();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPlayers method, of class ClientManager.
     */
    @Test
    public void testSetPlayers() {
        System.out.println("setPlayers");
        List<Player> players = null;
        ClientManager instance = new ClientManager();
        instance.setPlayers(players);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addPlayer method, of class ClientManager.
     */
    @Test
    public void testAddPlayer() {
        System.out.println("addPlayer");
        Player player = null;
        ClientManager instance = new ClientManager();
        instance.addPlayer(player);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removePlayer method, of class ClientManager.
     */
    @Test
    public void testRemovePlayer() {
        System.out.println("removePlayer");
        Player player = null;
        ClientManager instance = new ClientManager();
        instance.removePlayer(player);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
