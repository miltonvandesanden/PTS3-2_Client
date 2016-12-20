/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chat;

import player2.Player;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Marouan Bakour
 * @author Milton van de Sanden
 */
public class Chat implements IChat
{
    private List<Chatmessage> ChatMessages;

    public List<Chatmessage> getChatMessages() {
        return ChatMessages;
    }

    public void setChatMessages(List<Chatmessage> ChatMessages) {
        this.ChatMessages = ChatMessages;
    }

    public Chat(List<Chatmessage> ChatMessages) {
        this.ChatMessages = new ArrayList<>();
    }
    
    
    public void receiveMessage(Chatmessage chatMessage) {
        ChatMessages.add(chatMessage);
    }
    
    public void sendMessage(Chatmessage chatMessage) {
        //guf
    }

    @Override
    public void ReceiveMessage(Chatmessage chatMessage) {
        ChatMessages.add(chatMessage);
    }

    @Override
    public void SendMessage(Chatmessage chatMessage, Player self) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
