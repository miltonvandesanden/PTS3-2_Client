/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Player;

import player2.PlayerCar;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
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
public class PlayerCarTest {
    
    public PlayerCarTest() {
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
     * Test of getRectangle method, of class PlayerCar.
     */
    @Test
    public void testGetRectangle() {
        System.out.println("getRectangle");
        PlayerCar instance = new PlayerCar(new Texture("images/car_black_3.png"), new Point(1, 3));
        Sprite sprite = new Sprite(new Texture("images/car_black_3.png"));
        sprite.setSize(17.5f, 32.75f );
        sprite.setOrigin((float) 6.5, 10);
        sprite.rotate(-90f);
        sprite.setPosition(1, 3);
        Rectangle expResult = sprite.getBoundingRectangle();
        Rectangle result = instance.getRectangle();
        assertEquals(expResult, result);
    }

    /**
     * Test of moveForward method, of class PlayerCar.
     */
    @Test
    public void testMoveForward() {
        System.out.println("moveForward");
        PlayerCar instance = new PlayerCar(new Texture("images/car_black_3.png"), new Point(1, 3));
        instance.moveForward();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of turnRight method, of class PlayerCar.
     */
    @Test
    public void testTurnRight() {
        System.out.println("turnRight");
        PlayerCar instance = null;
        instance.turnRight();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of turnLeft method, of class PlayerCar.
     */
    @Test
    public void testTurnLeft() {
        System.out.println("turnLeft");
        PlayerCar instance = null;
        instance.turnLeft();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSpeed method, of class PlayerCar.
     */
    @Test
    public void testGetSpeed() {
        System.out.println("getSpeed");
        PlayerCar instance = new PlayerCar(new Texture("images/car_black_3.png"), new Point(1, 3));
        float expResult = 0.0F;
        float result = instance.getSpeed();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of setSpeed method, of class PlayerCar.
     */
    @Test
    public void testSetSpeed() {
        System.out.println("setSpeed");
        float speed = 2.3F;
        PlayerCar instance = new PlayerCar(new Texture("images/car_black_3.png"), new Point(1, 3));
        instance.setSpeed(speed);
        assertEquals(speed, instance.getSpeed(), 2.3);
    }

    /**
     * Test of getSprite method, of class PlayerCar.
     */
    @Test
    public void testGetSprite() {
        System.out.println("getSprite");
        PlayerCar instance = new PlayerCar(new Texture("images/car_black_3.png"), new Point(1, 3));
        Sprite expResult = new Sprite(new Texture("images/car_black_3.png"));
        expResult.setSize(17.5f, 32.75f );
        expResult.setOrigin((float) 6.5, 10);
        expResult.rotate(-90f);
        expResult.setPosition(1, 3);
        Sprite result = instance.getSprite();
        assertEquals(expResult, result);
    }

    /**
     * Test of increaseSpeed method, of class PlayerCar.
     */
    @Test
    public void testIncreaseSpeed() {
        System.out.println("increaseSpeed");
        PlayerCar instance = new PlayerCar(new Texture("images/car_black_3.png"), new Point(1, 3));
        instance.increaseSpeed();
        assertEquals(1, instance.getSpeed());
    }

    /**
     * Test of decreaseSpeed method, of class PlayerCar.
     */
    @Test
    public void testDecreaseSpeed() {
        System.out.println("decreaseSpeed");
        PlayerCar instance = new PlayerCar(new Texture("images/car_black_3.png"), new Point(1, 3));
        instance.increaseSpeed();
        instance.decreaseSpeed();
        assertEquals(0.9F, instance.getSpeed());
    }

    /**
     * Test of getMaxSpeed method, of class PlayerCar.
     */
    @Test
    public void testGetMaxSpeed() {
        System.out.println("getMaxSpeed");
        PlayerCar instance = new PlayerCar(new Texture("images/car_black_3.png"), new Point(1, 3));
        float expResult = 4.5f;
        float result = instance.getMaxSpeed();
        assertEquals(expResult, result, 4.5);
    }

    /**
     * Test of setMaxSpeed method, of class PlayerCar.
     */
    @Test
    public void testSetMaxSpeed() {
        System.out.println("setMaxSpeed");
        int maxSpeed = 0;
        PlayerCar instance = new PlayerCar(new Texture("images/car_black_3.png"), new Point(1, 3));
        instance.setMaxSpeed(maxSpeed);
        assertEquals(maxSpeed, instance.getMaxSpeed(), 0.0);
    }
    
}
