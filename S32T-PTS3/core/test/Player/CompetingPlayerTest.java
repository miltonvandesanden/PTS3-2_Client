/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Player;

import com.badlogic.gdx.graphics.Texture;
import java.awt.Color;
import java.awt.Point;
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
public class CompetingPlayerTest {
    
    public CompetingPlayerTest() {
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
     * Test of getColor method, of class CompetingPlayer.
     */
    @Test
    public void testGetColor() {
        System.out.println("getColor");
        CompetingPlayer instance = new CompetingPlayer(Player.Color.Black, "test", 1, new Point(0, 0) );
        Player.Color expResult = Player.Color.Black;
        Player.Color result = instance.getColor();
        assertEquals(expResult, result);
    }

    /**
     * Test of setColor method, of class CompetingPlayer.
     */
    @Test
    public void testSetColor() {
        System.out.println("setColor");
        Player.Color color = Player.Color.Blue;
        CompetingPlayer instance = new CompetingPlayer(Player.Color.Red, "test", 1, new Point(0, 0));
        instance.setColor(color);
        assertEquals(color, instance.getColor());
    }

    /**
     * Test of isHasFinished method, of class CompetingPlayer.
     */
    @Test
    public void testIsHasFinished() {
        System.out.println("isHasFinished");
        CompetingPlayer instance = new CompetingPlayer(Player.Color.Black, "test", 1, new Point(0,0));
        boolean expResult = false;
        boolean result = instance.isHasFinished();
        assertEquals(expResult, result);
    }

    /**
     * Test of setHasFinished method, of class CompetingPlayer.
     */
    @Test
    public void testSetHasFinished() {
        System.out.println("setHasFinished");
        boolean hasFinished = true;
        CompetingPlayer instance = new CompetingPlayer(Player.Color.Black, "test", 1, new Point(0,0));
        instance.setHasFinished(hasFinished);
        assertEquals(hasFinished, instance.isHasFinished());
    }

    /**
     * Test of isIsReady method, of class CompetingPlayer.
     */
    @Test
    public void testIsIsReady() {
        System.out.println("isIsReady");
        CompetingPlayer instance = new CompetingPlayer(Player.Color.Black, "test", 1, new Point(0,0));
        boolean expResult = false;
        boolean result = instance.isIsReady();
        assertEquals(expResult, result);
    }

    /**
     * Test of setIsReady method, of class CompetingPlayer.
     */
    @Test
    public void testSetIsReady() {
        System.out.println("setIsReady");
        boolean isReady = true;
        CompetingPlayer instance = new CompetingPlayer(Player.Color.Black, "test", 1, new Point(0,0));
        instance.setIsReady(isReady);
        assertEquals(isReady, instance.isIsReady());
    }

    /**
     * Test of getCurrentLap method, of class CompetingPlayer.
     */
    @Test
    public void testGetCurrentLap() {
        System.out.println("getCurrentLap");
        CompetingPlayer instance = new CompetingPlayer(Player.Color.Black, "test", 1, new Point(0,0));
        int expResult = 0;
        int result = instance.getCurrentLap();
        assertEquals(expResult, result);
    }

    /**
     * Test of setCurrentLap method, of class CompetingPlayer.
     */
    @Test
    public void testSetCurrentLap() {
        System.out.println("setCurrentLap");
        int currentLap = 5;
        CompetingPlayer instance = new CompetingPlayer(Player.Color.Black, "test", 1, new Point(0,0));
        instance.setCurrentLap(currentLap);
        assertEquals(currentLap, instance.getCurrentLap());
    }

    /**
     * Test of getRank method, of class CompetingPlayer.
     */
    @Test
    public void testGetRank() {
        System.out.println("getRank");
        CompetingPlayer instance = new CompetingPlayer(Player.Color.Black, "test", 1, new Point(0,0));;
        int expResult = 1;
        int result = instance.getRank();
        assertEquals(expResult, result);
    }

    /**
     * Test of setRank method, of class CompetingPlayer.
     */
    @Test
    public void testSetRank() {
        System.out.println("setRank");
        int rank = 5;
        CompetingPlayer instance = new CompetingPlayer(Player.Color.Black, "test", 1, new Point(0,0));
        instance.setRank(rank);
        assertEquals(rank, instance.getRank());
    }

    /**
     * Test of getCharacter method, of class CompetingPlayer.
     */
    @Test
    public void testGetCharacter() {
        System.out.println("getCharacter");
        CompetingPlayer instance = new CompetingPlayer(Player.Color.Black, "test", 1, new Point(0,0));
        PlayerCar expResult = new PlayerCar(new Texture("images/car_black_3.png"), new Point(0,0));
        PlayerCar result = instance.getCharacter();
        assertEquals(expResult, result);
    }

    /**
     * Test of setCharacter method, of class CompetingPlayer.
     */
    @Test
    public void testSetCharacter() {
        System.out.println("setCharacter");
        PlayerCar character = new PlayerCar(new Texture("images/car_black_3.png"), new Point(3,2));
        CompetingPlayer instance = new CompetingPlayer(Player.Color.Red, "test", 1, new Point(0,0));
        instance.setCharacter(character);
        assertEquals(character, instance.getCharacter());
    }
    
}
