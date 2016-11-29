/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chat;

import Player.Player;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Marouan Bakour
 * @author Milton van de Sanden
 */
public class Chat implements IChat
{
    private List<ChatMessage> ChatMessages;

    public List<ChatMessage> getChatMessages() {
        return ChatMessages;
    }

    public void setChatMessages(List<ChatMessage> ChatMessages) {
        this.ChatMessages = ChatMessages;
    }

    public Chat(List<ChatMessage> ChatMessages) {
        this.ChatMessages = new ArrayList<>();
    }
    
    
    public void receiveMessage(ChatMessage chatMessage) {
        ChatMessages.add(chatMessage);
    }
    
    public void sendMessage(ChatMessage chatMessage) {
        //guf
    }

    @Override
    public void ReceiveMessage(ChatMessage chatMessage) {
        ChatMessages.add(chatMessage);
    }

    @Override
    public void SendMessage(ChatMessage chatMessage, Player self) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
