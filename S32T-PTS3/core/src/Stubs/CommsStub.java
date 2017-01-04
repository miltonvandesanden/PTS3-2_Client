/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Stubs;

import Chat.Chatmessage;
import Game.ClientManager;
import Game.IComms;
import com.badlogic.gdx.graphics.g2d.Sprite;
import java.awt.Point;
import player2.CompetingPlayer;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
<<<<<<< HEAD
import match2.Match;
=======
import java.util.HashMap;
>>>>>>> shootingbranch
import player2.Player;
import utils2.Color;
import utils2.Projectile;

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
        Match match = clientManager.getMainMatch();
        Player player = match.getPlayer(username);
        CompetingPlayer competingPlayer = (CompetingPlayer) player;

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
<<<<<<< HEAD

    @Override
    public void receiveNewChatmessage(Chatmessage chatmessage) throws RemoteException {
   
        clientManager.ReceiveNewChatmessage(chatmessage);
    
    }
}
=======
>>>>>>> shootingbranch


public void pushProjectile(Projectile projectile)
    {
        //Map<Projectile,Sprite> projectilesmap = (HashMap<Projectile,Sprite>)clientManager.getProjectiles();
        clientManager.getProjectiles().add(projectile);
    }

  
}