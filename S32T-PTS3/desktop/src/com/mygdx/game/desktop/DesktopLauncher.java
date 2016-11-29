package com.mygdx.game.desktop;

import Game.ClientManager;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
                config.title = "Deathrace";
                config.width = 1024;
                config.height = 768;
                config.fullscreen = true;
		new LwjglApplication(new ClientManager(), config);       
	}
}
