/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Stubs;

import Game.ClientManager;
import Game.IComms;
import java.awt.Point;
import player2.CompetingPlayer;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import player2.Player;
import utils2.Color;

/**
 *
 * @author Milton van de Sanden
 */
public class CommsStub extends UnicastRemoteObject implements IComms
{   
    private ClientManager clientManager;
    
    public CommsStub() throws RemoteException{}
    
    public CommsStub(ClientManager clientManager) throws RemoteException
    {
        this.clientManager = clientManager;
    }

    @Override
    public void pushPlayerPosition(String username, Point position, float rotation) throws RemoteException
    {     
        CompetingPlayer competingPlayer = (CompetingPlayer) clientManager.getMainMatch().getPlayer(username);

        if(competingPlayer != null)
        {
            competingPlayer.getPlayerCar().getRectangle().setPosition((float) position.getX(), (float) position.getY());
            competingPlayer.getPlayerCar().setRotation(rotation);            
        }
        else
        {
            competingPlayer = new CompetingPlayer(username, Color.BLUE, position);
            competingPlayer.getPlayerCar().setRotation(rotation);
            clientManager.getMainMatch().addPlayer(competingPlayer);
        }
    }
}


 