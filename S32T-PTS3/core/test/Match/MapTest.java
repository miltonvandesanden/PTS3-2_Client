/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Match;

import match2.Obstacle;
import match2.Map;
import player2.Player;
import java.util.ArrayList;
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
public class MapTest {
    
    public MapTest() {
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
     * Test of getBackgroundPath method, of class Map.
     */
    @Test
    public void testGetBackgroundPath() {
        System.out.println("getBackgroundpath");
        String BackgroundPath = "map/maps/racemap3.png";

        Map instance = new Map(BackgroundPath, new Obstacle(325, 410, 20, 50, "map/finish.png", ObstacleType.FINISH), new Obstacle(325, 10, 20, 50, "map/finish.png", ObstacleType.FINISH),
                new ArrayList<Obstacle>() {
            {

                add(new Obstacle(100, 60, 25, 350, "map/wall.jpg", ObstacleType.WALL));
            }
        });
        String expResult = BackgroundPath;
        String result = instance.getBackgroundPath();
        assertEquals(expResult, result);

    }
    
        /**
     * Test of setBackgroundPath method, of class Map.
     */
    @Test
    public void testsetBackgroundPath() {
        System.out.println("setBackgroundpath");
        String BackgroundPath = "map/maps/racemap3.png";

        Map instance = new Map(BackgroundPath, new Obstacle(325, 410, 20, 50, "map/finish.png", ObstacleType.FINISH), new Obstacle(325, 10, 20, 50, "map/finish.png", ObstacleType.FINISH),
                new ArrayList<Obstacle>() {
            {

                add(new Obstacle(100, 60, 25, 350, "map/wall.jpg", ObstacleType.WALL));
            }
        });
        instance.setbackgroundPath(BackgroundPath);
       
        assertEquals(BackgroundPath, instance.getBackgroundPath());

    }
    
      /**
     * Test of getFinish method, of class Map.
     */
    @Test
    public void testGetFinish() {
        System.out.println("getFinish");
        String BackgroundPath = "map/maps/racemap3.png";
       Obstacle finish = new Obstacle(325, 410, 20, 50, "map/finish.png",ObstacleType.FINISH) ;
        Map instance = new Map("Map1.png",  finish , new Obstacle(325, 10, 20, 50, "map/finish.png", ObstacleType.FINISH),
                new ArrayList<Obstacle>() {
            {

                add(new Obstacle(100, 60, 25, 350, "map/wall.jpg", ObstacleType.WALL));
            }
        });
        Obstacle expResult = finish;
        Obstacle result = instance.getFinish();
        assertEquals(expResult, result);

    }
    
         /**
     * Test of setFinish method, of class Map.
     */
    @Test
    public void testsetFinish() {
        System.out.println("setFinish");
        String BackgroundPath = "map/maps/racemap3.png";
       Obstacle finish = new Obstacle(325, 410, 20, 50, "map/finish.png",ObstacleType.FINISH) ;
        Map instance = new Map(BackgroundPath, new Obstacle(325, 10, 20, 50, "map/finish.png", ObstacleType.FINISH)  , new Obstacle(325, 10, 20, 50, "map/finish.png", ObstacleType.FINISH),
                new ArrayList<Obstacle>() {
            {

                add(new Obstacle(100, 60, 25, 350, "map/wall.jpg", ObstacleType.WALL));
            }
        });
      
        instance.setFinish(finish);
        assertEquals(finish, instance.getFinish());

    }
        /**
     * Test of getFinish2 method, of class Map.
     */
    @Test
    public void testGetFinish2() {
        System.out.println("getFinish2");
       
       Obstacle finish2 = new Obstacle(325, 410, 20, 50, "map/finish.png",ObstacleType.FINISH) ;
        Map instance = new Map("Map1.png",  finish2 , new Obstacle(325, 10, 20, 50, "map/finish.png", ObstacleType.FINISH),
                new ArrayList<Obstacle>() {
            {

                add(new Obstacle(100, 60, 25, 350, "map/wall.jpg", ObstacleType.WALL));
            }
        });
        Obstacle expResult = finish2;
        Obstacle result = instance.getFinish2();
        assertEquals(expResult, result);

    }
    
         /**
     * Test of setFinish method, of class Map.
     */
    @Test
    public void testsetFinish2() {
        System.out.println("setFinish2");
        String BackgroundPath = "map/maps/racemap3.png";
       Obstacle finish2 = new Obstacle(325, 410, 20, 50, "map/finish.png",ObstacleType.FINISH) ;
        Map instance = new Map(BackgroundPath, new Obstacle(325, 10, 20, 50, "map/finish.png", ObstacleType.FINISH)  , new Obstacle(325, 10, 20, 50, "map/finish.png", ObstacleType.FINISH),
                new ArrayList<Obstacle>() {
            {

                add(new Obstacle(100, 60, 25, 350, "map/wall.jpg", ObstacleType.WALL));
            }
        });
      
        instance.setFinish2(finish2);
        assertEquals(finish2, instance.getFinish2());

    }
         /**
     * Test of getWalls method, of class Map.
     */
    @Test
    public void testGetWalls() {
        System.out.println("getFinish2");
      List<Obstacle> walls =   new ArrayList<Obstacle>();
      walls.add(new Obstacle(100, 60, 25, 350, "map/wall.jpg", ObstacleType.WALL));
            
       Obstacle finish2 = new Obstacle(325, 410, 20, 50, "map/finish.png",ObstacleType.FINISH) ;
        Map instance = new Map("Map1.png",  finish2 , new Obstacle(325, 10, 20, 50, "map/finish.png", ObstacleType.FINISH),
            walls);
        List<Obstacle> expResult = walls;
       List<Obstacle> result = instance.getWalls();
        assertEquals(expResult, result);

    }
    
             /**
     * Test of setWalls method, of class Map.
     */
    @Test
    public void testsetWalls() {
        System.out.println("getFinish2");
      List<Obstacle> walls =   new ArrayList<Obstacle>();
      walls.add(new Obstacle(100, 60, 25, 350, "map/wall.jpg", ObstacleType.WALL));
            
       Obstacle finish2 = new Obstacle(325, 410, 20, 50, "map/finish.png",ObstacleType.FINISH) ;
        Map instance = new Map("Map1.png",  finish2 , new Obstacle(325, 10, 20, 50, "map/finish.png", ObstacleType.FINISH),
            walls);
       instance.setWalls(walls);
        assertEquals(walls, instance.getWalls());

    }
}
