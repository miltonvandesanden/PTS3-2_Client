/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Player;

import java.io.Serializable;
import Utils.Color;

/**
 *
 * @author Milton van de Sanden
 */
public class SpectatingPlayer extends Player implements ISpectatingPlayer, Serializable
{
    public SpectatingPlayer(String username, Color color)
    {
        super(username, color);
    }
    
}