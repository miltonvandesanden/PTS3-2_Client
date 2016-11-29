/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Map;

import com.badlogic.gdx.math.Rectangle;

/**
 *
 * @author Danny
 */
public class Obstacle
{
    private String spritePath;
    private Rectangle box;
    private ObstacleType obstacleType;
    
    public Obstacle(int x, int y, int width, int height, String spritePath, ObstacleType obstacleType)
    {
        box = new Rectangle(x, y, width, height);
        this.spritePath = spritePath;
        this.obstacleType = obstacleType;
    }

    public String getSpritePath()
    {
        return spritePath;
    }

    public void setSpritePath(String spritePath)
    {
        this.spritePath = spritePath;
    }
    
    public Rectangle getBox()
    {
        return box;
    }

    public void setBox(Rectangle box)
    {
        this.box = box;
    }

    public ObstacleType getObstacleType()
    {
        return obstacleType;
    }

    public void setObstacleType(ObstacleType obstacleType)
    {
        this.obstacleType = obstacleType;
    }
}
