/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package player2;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import java.awt.Point;
import java.io.Serializable;

/**
 *
 * @author Milton van de Sanden
 */
public class PlayerCar implements Serializable
{
    private float speed;
    public static final float MAXSPEED = 10.5f;
    private static final float ACCELERATION = 1.02f;
    
    private float rotation;
    private Rectangle rectangle;
    
    public static final long serialVersionUID = 1875;
        
    public PlayerCar(float rotation, Point location)
    {
        this.rotation = rotation;
        rectangle = new Rectangle(location.x, location.y, 17.5f, 32.75f);
        
        speed = 0.0f;
    }
    
    public void setPosition(Point location)
    {
        rectangle.setPosition(new Vector2(location.x, location.y));
    }
    
    public Rectangle getRectangle()
    {
        return rectangle;
    }
    
    public void moveForward()
    {
        float x = (float) Math.cos(Math.toRadians(rotation + 90));
        float y = (float) Math.sin(Math.toRadians(rotation + 90));

        rectangle.x += x * speed;
        rectangle.y += y * speed;
     }
    
    public void turnRight()
    {
        rotation += -5f;   
    }

    public void turnLeft()
    {
        rotation += 5f;
    }
    
    public float getSpeed()
    {
        return speed;
    }

    public void setSpeed(float speed)
    {
        this.speed = speed;
        
        if(this.speed > MAXSPEED)
        {
            this.speed = MAXSPEED;
        }
        
        if(this.speed < 0)
        {
            this.speed = 0;
        }
    }
        
    public void increaseSpeed()
    {
        if (speed < 1)
        {
            speed = 1;
        }

        speed *= ACCELERATION;

        
        if (speed > MAXSPEED)
        {
            speed = MAXSPEED;
        }
    }    
    
    public void decreaseSpeed()
    {
        if (speed > 0)
        {
            speed -= speed-10;
            //speed = 0;
        }
        
       
    }
    
    public void shootingspeedincrease()
    {
       speed += speed/8.2;
    }
    
    public float getMaxSpeed()
    {
        return MAXSPEED;
    }

    public float getRotation() {
        return rotation;
    }

    public void setRotation(float rotation) {
        this.rotation = rotation;
    }
}