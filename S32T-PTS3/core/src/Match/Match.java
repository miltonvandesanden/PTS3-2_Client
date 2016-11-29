/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Match;

import Map.Map;
import Player.CompetingPlayer;
import Player.SpectatingPlayer;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author Milton van de Sanden
 */
public class Match
{
    private List<SpectatingPlayer> spectatingPlayers;
    private List<CompetingPlayer> competingPlayers;
    private Map map;
    
    private long dnfTime;
    private int maxLaps;
    private List<CompetingPlayer> finishedPlayers;
    private Timer dnfTimer;
    private state currentState;
    private enum state
    {
        READY,
        STARTED,
        ENDED;
    }
    
    
    public Match(List<SpectatingPlayer> spectatingPlayers, List<CompetingPlayer> competingPlayers, Map map, long dnfTime, int maxLaps)
    {
        this.spectatingPlayers = spectatingPlayers;
        this.competingPlayers = competingPlayers;
        this.map = map;
        this.finishedPlayers = new ArrayList<>();
        this.dnfTime = dnfTime;
        this.maxLaps = maxLaps;
        
        dnfTimer = new Timer();
        currentState = state.READY;
    }

    public List<CompetingPlayer> getFinishedPlayers() {
        return finishedPlayers;
    }

    public void addFinishedPlayer(CompetingPlayer finishedPlayer) {
        if(!finishedPlayers.contains(finishedPlayer))
        {
            finishedPlayers.add(finishedPlayer);            
        }
    }
    
    public List<SpectatingPlayer> getSpectatingPlayers()
    {
        return spectatingPlayers;
    }

    public void setSpectatingPlayers(List<SpectatingPlayer> spectatingPlayers)
    {
        this.spectatingPlayers = spectatingPlayers;
    }
    
    public void addSpectatingPlayer(SpectatingPlayer spectatingPlayer)
    {
        if(!spectatingPlayers.contains(spectatingPlayer))
        {
            spectatingPlayers.add(spectatingPlayer);
            
        }
    }
    
    public void removeSpectatingPlayer(SpectatingPlayer spectatingPlayer)
    {
        spectatingPlayers.remove(spectatingPlayer);
    }

    public List<CompetingPlayer> getCompetingPlayers() {
        return competingPlayers;
    }

    public void setCompetingPlayers(List<CompetingPlayer> competingPlayers) {
        this.competingPlayers = competingPlayers;
    }
    
        public void addCompetingPlayer(CompetingPlayer competingPlayer)
    {
        if(!competingPlayers.contains(competingPlayer))
        {
            competingPlayers.add(competingPlayer);
        }
    }
    
    public void removeCompetingPlayer(CompetingPlayer competingPlayer)
    {
        competingPlayers.remove(competingPlayer);
    }    

    public Map getMap()
    {
        return map;
    }

    public void setMap(Map map)
    {
        this.map = map;
    }

    public long getDnfTime()
    {
        return dnfTime;
    }

    public void setDnfTime(int dnfTime)
    {
        this.dnfTime = dnfTime;
    }
    
    public Timer getDnfTimer()
    {
        return dnfTimer;
    }

    public void setDnfTimer(Timer dnfTimer)
    {
        this.dnfTimer = dnfTimer;
    }
    
    public int getMaxLaps()
    {
        return maxLaps;
    }

    public void setMaxLaps(int maxLaps)
    {
        this.maxLaps = maxLaps;
    }
    
    public void startMatch()
    {
        currentState = state.STARTED;
        
        //move for MP version
        //dnfTimer.schedule(new dnfTimerTask(), dnfTime);
    }
    
    public void endMatch()
    {
        currentState = state.ENDED;
    }
    
    public float getTimeLeft()
    {
        return -1;
    }
    
    public void startTimer()
    {
       /* int finishedPlayers = 0;
        
        for(CompetingPlayer competingPlayer : competingPlayers)
        {
            if(competingPlayer.isHasFinished())
            {
                finishedPlayers++;
            }
        }
        */
        if(true/*finishedPlayers.size() >= (competingPlayers.size() * 0.5)*/)
        {
            dnfTimer.schedule(new dnfTimerTask(), dnfTime);
        }
    }
    
    class dnfTimerTask extends TimerTask
    {
        @Override
        public void run()
        {
            endMatch();
        }   
    }
}