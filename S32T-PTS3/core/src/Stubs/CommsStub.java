/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Stubs;

import Game.IComms;
import Player.CompetingPlayer;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Milton van de Sanden
 */
public class CommsStub extends UnicastRemoteObject implements IComms
{   
    public CommsStub() throws RemoteException{}

    @Override
    public void pushPlayerPosition(CompetingPlayer player) throws RemoteException
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}   
 