/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chat;

import player2.Player;

/**
 * @author Marouan Bakour
 * @author Milton van de Sanden
 */
public interface IChat 
{
    public void ReceiveMessage(ChatMessage chatMessage);
    public void SendMessage(ChatMessage chatMessage, Player self);
}
