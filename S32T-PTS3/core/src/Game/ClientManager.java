/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import Chat.Chat;
import Chat.ChatMessage;
import match2.MapManager;
import match2.Map;
import match2.Match;
import match2.Obstacle;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import com.badlogic.gdx.graphics.Color;
import player2.CompetingPlayer;
import player2.Player;
import Stubs.CommsStub;
import utils2.Projectile;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import comms.IServerComms;
import java.awt.Point;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;
import player2.PlayerCar;

public class ClientManager extends ApplicationAdapter implements InputProcessor {

    private List<Projectile> projectiles = new ArrayList<>();
    
    //Map variables
    private MapManager mapManager;
    private Match mainMatch;
    private Texture mapTexture1;
    private Texture mapTexture2;
    //Player variables
    private CompetingPlayer self;
//    private List<Player> players;
    private SpriteBatch batch;
    private BitmapFont PlayernameTag;
    private boolean moveUp = false;
    private boolean moveRight = false;
    private boolean moveLeft = false;
    //Lap variables
    private int counter = 0;
    private boolean halfLap = false;
    private int interval;
    private Timer startTimer;
    private boolean toStart = true;
    //Timelapsed variables
    private BitmapFont TimeLapsedText;
    private BitmapFont StartCountdown;
    private long startTime = System.currentTimeMillis();
    //Member variable:
    float totalTime = 5 * 60;
    //Chat variables
    private TextField chatInput;
    private boolean pressedEnter = false;
    private Chat chatSystem;
    private Table chatBox;
    private List<ChatMessage> chatBoxContentTemp;

    boolean temp = false;
    
    private Registry clientRegistry;
    private int PORTNUMBER = 1100;
    private InetAddress IP;
    
    private Registry serverRegistry;
    private final int SERVERPORT = 1099;
    private final String SERVERIP = "169.254.254.48";
    
    private IComms clientComms;
    private IServerComms serverComms;
    
    private String username = "player1";
    
    private Sprite selfSprite;
    private Sprite sprite1;
    private Sprite sprite2;
    private Sprite sprite3;
    
    public ClientManager()
    {
        try
        {
            IP = InetAddress.getLocalHost();
            clientComms = new CommsStub(this);
            
            clientRegistry = LocateRegistry.createRegistry(PORTNUMBER);
            clientRegistry.rebind("Client", clientComms);
            
            System.out.println("Client running");
            System.out.println("IP: " + IP.toString());
            System.out.println("Port: " + PORTNUMBER);
            
//        mapManager = new MapManager();
//        players = new ArrayList<>();
//        map = mapManager.maps.get(1);
//        mainMatch = new Match(null, new ArrayList<>(), map, 10000L, 3);
        } catch (RemoteException | UnknownHostException ex)
        {
            Logger.getLogger(ClientManager.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("CLIENT HOST CRASHED");
        }
        
        try
        {
            serverRegistry = LocateRegistry.getRegistry(SERVERIP, SERVERPORT);
            
            System.out.println("client connected with server");
            System.out.println("IP: " + SERVERIP);
            System.out.println("PORT: " + SERVERPORT);
        } catch (RemoteException ex)
        {
            Logger.getLogger(ClientManager.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Connection failed");
        }
        
        try
        {
            serverComms = (IServerComms) serverRegistry.lookup("Server");
            System.out.println("ServerComms received");
        } catch (RemoteException | NotBoundException ex)
        {
            Logger.getLogger(ClientManager.class.getName()).log(Level.SEVERE, null, ex);            
        }
       mainMatch = logIn(username);
    }

    public List<Projectile> getProjectiles() {
        return projectiles;
    }

    public void setProjectiles(List<Projectile> projectiles) {
        this.projectiles = projectiles;
    }

    public MapManager getMapManager() {
        return mapManager;
    }

    public void setMapManager(MapManager mapManager) {
        this.mapManager = mapManager;
    }

    public Match getMainMatch() {
        return mainMatch;
    }

    public void setMainMatch(Match mainMatch) {
        this.mainMatch = mainMatch;
    }

    public Registry getClientRegistry() {
        return clientRegistry;
    }

    public void setClientRegistry(Registry clientRegistry) {
        this.clientRegistry = clientRegistry;
    }

    public int getPORTNUMBER() {
        return PORTNUMBER;
    }

    public void setPORTNUMBER(int PORTNUMBER) {
        this.PORTNUMBER = PORTNUMBER;
    }

    public InetAddress getIP() {
        return IP;
    }

    public void setIP(InetAddress IP) {
        this.IP = IP;
    }

    public Registry getServerRegistry() {
        return serverRegistry;
    }

    public void setServerRegistry(Registry serverRegistry) {
        this.serverRegistry = serverRegistry;
    }

    public IComms getClientComms() {
        return clientComms;
    }

    public void setClientComms(IComms clientComms) {
        this.clientComms = clientComms;
    }

    public IServerComms getServerComms() {
        return serverComms;
    }

    public void setServerComms(IServerComms serverComms) {
        this.serverComms = serverComms;
    }
    
    

    
    public  Match logIn(String username)
    {        

        try
        {
             return serverComms.Login(username, IP.getHostAddress(), PORTNUMBER);
        } catch (RemoteException ex)
        {
            Logger.getLogger(ClientManager.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    @Override
    public void create()
    {
        //play sound
        Music sound = Gdx.audio.newMusic(Gdx.files.internal("music/ftr.mp3"));
        sound.play();
        //standard
        Gdx.input.setInputProcessor(this);
        //map variables
        mapTexture1 = new Texture(mainMatch.getMap().getBackgroundPath());
        mapTexture2 = new Texture(mainMatch.getMap().getFinish().getSpritePath());
       

        
        //timelapse variables
//        startTimer = new Timer();
//        int delay = 1000;
//        int period = 1000;
//        interval = 3;
//        //playervariables
//        TimeLapsedText = new BitmapFont();
//        PlayernameTag = new BitmapFont();
//        StartCountdown = new BitmapFont();
////        //Startcountdown variables
//        StartCountdown.setColor(com.badlogic.gdx.graphics.Color.RED);
//        StartCountdown.getData().setScale(4);
//        //timer
//        startTimer.scheduleAtFixedRate(new TimerTask() {
//            @Override
//            public void run() {
//                System.out.println(setInterval());
//            }
//        }, delay, period);
//        //playervariables
        batch = new SpriteBatch();
//        self = new CompetingPlayer("Player1", Utils.Color.BLACK, new Point(350, 665));
        self = (CompetingPlayer) mainMatch.getPlayer(username);
        
        
//        self.getPlayerCar().setSprite(new Texture(carPath), new Point(335, 665));
//        mainMatch.addCompetingPlayer(self);



//        //chat variables
//        chatInput = new TextField("<PRESS ENTER TO TYPE>", new Skin(Gdx.files.internal("uiskin.json")));
//        chatInput.setPosition(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2);
//        chatInput.setSize(300, 40);
//        chatBox = new Table(new Skin(Gdx.files.internal("uiskin.json")));
//
//        chatBox.setPosition(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 20, Gdx.graphics.getHeight());
//        chatBoxContentTemp = new ArrayList<ChatMessage>();
        setPosition(self, selfSprite);
    }
    
    public Sprite setPosition(CompetingPlayer competingPlayer, Sprite sprite)
    {
        sprite = generateSprite(competingPlayer);
        sprite.setSize(competingPlayer.getPlayerCar().getRectangle().getWidth(), competingPlayer.getPlayerCar().getRectangle().getHeight());
        sprite.setPosition(competingPlayer.getPlayerCar().getRectangle().getX(), competingPlayer.getPlayerCar().getRectangle().getY());
        sprite.setRotation(competingPlayer.getPlayerCar().getRotation());
        sprite.setOrigin(6.5f, 10f);
        
        return sprite;
    }
    
    public Sprite generateSprite(Player player)
    {
        String carPath = "images/car";
        
        switch(player.getColor())
        {
            case BLUE:
                carPath += "_blue_3.png";
                break;
            case GREEN:
                carPath += "_green_3.png";
                break;
            case RED:
                carPath += "_red_3.png";
                break;
            case YELLOW:
                carPath += "_yellow_3.png";
                break;
            default:
                carPath += "_black_3.png";
                break;
        }        
        return new Sprite(new Texture(carPath));
    }

    @Override
    public void render()
    {
        //render necessities
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();

//        //garbage collector 
//        System.gc();
        //render map and map elementsjbjhbhjvhg
        renderMap();
//        //player input to car movement
        selfSprite = setPosition(self, selfSprite);
//        if (interval == 0) {
            handleMovement();
//            toStart = false;
//
//        } else {
//            StartCountdown.draw(batch, "" + interval, Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2);
//
//        }
//        //collision handeling
//        handleCollision();
//        //hanlelap
//        handleLap();
//        //draw player elements
//        self.getPlayerCar().getSprite().draw(batch);
        
        selfSprite.draw(batch);
        
        int playerCounter = 0;
        
        for(Player player : mainMatch.getPlayers())
        {
            if(player.getClass() == CompetingPlayer.class && player != self)
            {
                switch(playerCounter)
                {
                    case 0:
                        sprite1 = setPosition((CompetingPlayer) player, sprite1);
                        sprite1.draw(batch);
                        break;
                    case 1:
                        sprite2 = setPosition((CompetingPlayer) player, sprite2);
                        sprite2.draw(batch);
                        break;
                    case 2:
                        sprite3 = setPosition((CompetingPlayer) player, sprite3);
                        sprite3.draw(batch);
                        playerCounter = -1;
                }
                
                playerCounter++;
            }
        }
        
//        for(Player player : mainMatch.getPlayers()
//        {
//            if(player.getClass() == CompetingPlayer.class && player != self)
//            {
//                ((CompetingPlayer) player).getPlayerCar().getSprite().draw(batch);
//            }
//        }
        
//        if (mainMatch.getFinishedPlayers() != null) {
//            if (mainMatch.getCompetingPlayers().size() == mainMatch.getFinishedPlayers().size()) {
//                mainMatch.endMatch();
//            }
//        }
//        DrawPlayername();
//        //Displays game timelapse 
//        DisplayTimeLapsed();
//        chatBox.draw(batch, totalTime);
//        chatInput.draw(batch, totalTime);
//        handleShooting();
        batch.end();
    }

    public void handleLap() {
        if (!halfLap && mainMatch.getMap().getFinish2().getBox().overlaps(self.getPlayerCar().getRectangle())) {
            halfLap = true;
//            System.out.println(self.getUsername() + " is halfway");
        }

        if (halfLap && mainMatch.getMap().getFinish().getBox().overlaps(self.getPlayerCar().getRectangle())) {
            halfLap = false;
            self.setCurrentLap(self.getCurrentLap() + 1);
//            System.out.println(self.getUsername() + " Current Lap: " + self.getCurrentLap());
        }

       // if (self.getCurrentLap() >= mainMatch.getMaxLaps()) {
           // self.setPlayerState(PlayerState.FINISHED);
           // mainMatch.addFinishedPlayer(self);
//            System.out.println(self.getUsername() + " has finished");
          //  Gdx.app.exit();
      //  }
    }

    private final int setInterval() {
        if (interval == 1) {
            startTimer.cancel();
        }
        return --interval;
    }

//    public void DrawPlayername() {
//        PlayernameTag.draw(batch, self.getUsername(), self.getPlayerCar().getSprite().getX(), self.getPlayerCar().getSprite().getY() + 25);
//
//    }

    public void Startcountdown(int time) {
        StartCountdown.draw(batch, "" + setInterval(), Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2);
    }

    public void DisplayTimeLapsed() {

        TimeLapsedText.draw(batch, "" + ((System.currentTimeMillis() - startTime) / 10e2), Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight());
    }

//    public void handleCollision() {
//        for (Obstacle obstacle : mainMatch.getMap().getWalls()) {
//            if (obstacle.getBox().overlaps(self.getPlayerCar().getRectangle())) {
//                self.getPlayerCar().getSprite().rotate(180);
//                self.getPlayerCar().moveForward();
//                self.getPlayerCar().getSprite().rotate(180);
//            }
//        }
//
//    }

    public void renderMap() {
        batch.draw(mapTexture1, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        batch.draw(mapTexture2, mainMatch.getMap().getFinish().getBox().x, mainMatch.getMap().getFinish().getBox().y, mainMatch.getMap().getFinish().getBox().width, mainMatch.getMap().getFinish().getBox().height);
    }

    public void handleMovement() {
        if (moveUp) {
            self.getPlayerCar().increaseSpeed();
        } else {
            self.getPlayerCar().decreaseSpeed();
        }

        if (moveRight) {
            self.getPlayerCar().turnRight();
        }

        if (moveLeft) {
            self.getPlayerCar().turnLeft();
        }

        self.getPlayerCar().moveForward();
    }

    @Override
    public void dispose() {
        batch.dispose();
    }

    public Player getSelf() {
        return self;
    }

    public void setSelf(CompetingPlayer self) {
        this.self = self;
    }

//    public List<Player> getPlayers() {
//        return players;
//    }

//    public void setPlayers(List<Player> players) {
//        this.players = players;
//    }

//    public void addPlayer(Player player) {
//        players.add(player);
//    }

//    public void removePlayer(Player player) {
//        players.remove(player);
//    }

    @Override
    public boolean keyDown(int i) {
        switch (i) {
            case Input.Keys.W:
                if (pressedEnter == false) {
                    moveUp = true;
                } else {
                    chatInput.appendText("w");
                }
                break;
            case Input.Keys.D:
                if (pressedEnter == false) {
                    moveRight = true;
                } else {
                    chatInput.appendText("d");
                }
                break;
            case Input.Keys.A:
                if (pressedEnter == false) {
                    moveLeft = true;
                } else {
                    chatInput.appendText("a");
                }
                break;

            case Input.Keys.ENTER:

                if (pressedEnter == false) {
                    pressedEnter = true;

                    chatInput.setText("");
                } else {
                    if (chatBoxContentTemp.size() == 3) {
                       chatBoxContentTemp.remove(0);
                         chatBoxContentTemp.add(new ChatMessage(chatInput.getText(),self.getUsername(),Color.WHITE));
                        chatBox.clear();
                        for(ChatMessage chatmessage: chatBoxContentTemp)
                        {
                        chatBox.add(chatmessage.getPlayername()+":"+chatmessage.getMessage());
                        chatBox.row();
                        }
                       
                    } else {
                        chatBoxContentTemp.add(new ChatMessage(chatInput.getText(),self.getUsername(),Color.WHITE));
                        chatBox.clear();
                        for(ChatMessage chatmessage: chatBoxContentTemp)
                        {
                        chatBox.add(chatmessage.getPlayername()+":"+chatmessage.getMessage());
                        chatBox.row();
                        }
                      
                        
                    }

                    chatInput.setText("<PRESS ENTER TO TYPE>");
                    pressedEnter = false;
                }
                break;

        }
        if (pressedEnter == true) {
            switch (i) {
                case Input.Keys.Q:
                    chatInput.appendText("q");
                    break;
                case Input.Keys.E:
                    chatInput.appendText("e");
                    break;
                case Input.Keys.R:
                    chatInput.appendText("r");
                    break;
                case Input.Keys.T:
                    chatInput.appendText("t");
                    break;
                case Input.Keys.Y:
                    chatInput.appendText("y");
                    break;
                case Input.Keys.U:
                    chatInput.appendText("u");
                    break;
                case Input.Keys.I:
                    chatInput.appendText("i");
                    break;
                case Input.Keys.O:
                    chatInput.appendText("o");
                    break;
                case Input.Keys.P:
                    chatInput.appendText("p");
                    break;

                case Input.Keys.S:
                    chatInput.appendText("s");
                    break;

                case Input.Keys.F:
                    chatInput.appendText("f");
                    break;
                case Input.Keys.H:
                    chatInput.appendText("h");
                    break;
                case Input.Keys.J:
                    chatInput.appendText("j");
                    break;
                case Input.Keys.K:
                    chatInput.appendText("k");
                    break;
                case Input.Keys.L:
                    chatInput.appendText("l");
                    break;
                case Input.Keys.Z:
                    chatInput.appendText("z");
                    break;
                case Input.Keys.X:
                    chatInput.appendText("x");
                    break;
                case Input.Keys.C:
                    chatInput.appendText("c");
                    break;
                case Input.Keys.V:
                    chatInput.appendText("v");
                    break;
                case Input.Keys.B:
                    chatInput.appendText("b");
                    break;
                case Input.Keys.N:
                    chatInput.appendText("n");
                    break;
                case Input.Keys.M:
                    chatInput.appendText("m");
                    break;
                case Input.Keys.SPACE:
                    chatInput.appendText(" ");
                    break;
            }

        }
        return true;
    }

    @Override
    public boolean keyUp(int i) {
        switch (i) {
            case Input.Keys.W:
                moveUp = false;
                break;
            case Input.Keys.D:
                moveRight = false;
                break;
            case Input.Keys.A:
                moveLeft = false;
                break;
        }
        return true;
    }

    @Override
    public boolean keyTyped(char c) {
        return true;
    }

    @Override
    public boolean touchDown(int i, int i1, int i2, int i3) {
        return true;
    }

    @Override
    public boolean touchUp(int i, int i1, int i2, int i3) {
        return true;
    }

    @Override
    public boolean touchDragged(int i, int i1, int i2) {
        return true;
    }

    @Override
    public boolean mouseMoved(int i, int i1) {
        return true;
    }

    @Override
    public boolean scrolled(int i) {
        return true;
    }
    
    public void handleShooting()
     {
         //Shoot
         if(Gdx.input.isKeyJustPressed(Keys.SPACE))
         {
             projectiles.add(new Projectile(self.getPlayerCar().getRectangle().getX(),self.getPlayerCar().getRectangle().getY(), self.getPlayerCar()));
         }
         
         //Update
         ArrayList<Projectile> projectilesToRemove = new ArrayList<>();
         for(Projectile p : projectiles)
         {
             p.update(Gdx.graphics.getDeltaTime());
             if(p.isRemove())
             {
                 projectilesToRemove.add(p);
             }
         }
         projectiles.removeAll(projectilesToRemove);
         
         for(Projectile p : projectiles)
         {
             p.render(batch);
         }
     }
}
