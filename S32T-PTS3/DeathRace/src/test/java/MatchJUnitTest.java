/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Match.*;
import Player.CompetingPlayer;
import Player.Player;
import Player.SpectatingPlayer;
import java.awt.Color;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Danny
 */
public class MatchJUnitTest {
    
    public MatchJUnitTest() {
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

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    @Test
    public void matchBeginTest()
    {
        Match match = new Match(new Map());
        
        match.timer.start();
        Thread.sleep(200);
        match.timer.stop();
        try
        {
            assertEquals(match.timer.getcompleteTime(),200);
        }
        catch(Exception e)
        {
            fail("timer didn't time correctly");
        }
    }
    
    @Test
    public void matchEndTest()
    {
        Match match = new Match(new Map());
        CompetingPlayer danny = new CompetingPlayer(Color.RED,"dannyracertop2000",1);
        CompetingPlayer soufyan = new CompetingPlayer(Color.RED,"soufsouf",2);
        SpectatingPlayer herman = new SpectatingPlayer("mongol",3);
        match.getAllPlayers.add(danny);
        match.getAllPlayers.add(soufyan);
        
        danny.setCurrentLap(danny.getCurrentLap()+2);
        soufyan.setCurrentLap(soufyan.getCurrentLap()+2);
        //Alle players zijn gefinished
        //if(match.getAllPlayers.size() == match.getFinishedPlayers.size())
        //{
            //match.end();
            assertEquals(match.getStatus(),false);
        //}
        
        
    }
    
    @Test
    public void leaderboardTest()
    {
        Match match = new Match(new Map());
        CompetingPlayer danny = new CompetingPlayer(Color.RED,"dannyracertop2000",1);
        CompetingPlayer soufyan = new CompetingPlayer(Color.RED,"soufsouf",2);
        SpectatingPlayer herman = new SpectatingPlayer("mongol",3);
        match.getAllPlayers.add(danny);
        match.getAllPlayers.add(soufyan);
        
        danny.setCurrentLap(danny.getCurrentLap()+2);
        soufyan.setCurrentLap(soufyan.getCurrentLap()+1);
        assertEquals(match.getStatus(),true);
        match.timer.stop();
        assertEquals(match.getStatus(),false);
        assertEquals(match.getFinishedPlayers.size(),1);
    }
    
    @Test
    public void lapPlayerTest()
    {
        Match match = new Match(new Map());
        CompetingPlayer danny = new CompetingPlayer(Color.RED,"dannyracertop2000",1);
        CompetingPlayer soufyan = new CompetingPlayer(Color.RED,"soufsouf",2);
        SpectatingPlayer herman = new SpectatingPlayer("mongol",3);
        match.getAllPlayers.add(danny);
        match.getAllPlayers.add(soufyan);
        
        danny.setCurrentLap(danny.getCurrentLap()+2);
        soufyan.setCurrentLap(soufyan.getCurrentLap()+1);
        
        assertEquals(danny.getCurrentLap(),3);
        
    }
    
    @Test
    public void finishPlayerTest()
    {
        Match match = new Match(new Map());
        CompetingPlayer danny = new CompetingPlayer(Color.RED,"dannyracertop2000",1);
        CompetingPlayer soufyan = new CompetingPlayer(Color.RED,"soufsouf",2);
        SpectatingPlayer herman = new SpectatingPlayer("mongol",3);
        match.getAllPlayers.add(danny);
        match.getAllPlayers.add(soufyan);
        
        danny.setCurrentLap(danny.getCurrentLap()+2);
        soufyan.setCurrentLap(soufyan.getCurrentLap()+1);
        
        ArrayList<CompetingPlayer> temp_finishedList = new ArrayList<>();
        for(CompetingPlayer cp : match.getAllPlayers())
        {
            if(cp.getCurrentLap()==4)
            {
                temp_finishedList.add(cp);
            }
        }
        assertEquals(temp_finishedList.size(),match.getFinishedPlayers());
    }
    
    @Test
    public void timerRunOutTest()
    {
        Match match = new Match(new Map());
        
        //De timer is voorbij
        if(match.timer.equals(0))
        {
            //match.end();
            assertEquals(match.getStatus(),false);
        }
    }
    
}
