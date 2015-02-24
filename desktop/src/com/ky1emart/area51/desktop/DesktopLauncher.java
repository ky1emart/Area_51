package com.ky1emart.area51.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.ky1emart.area51.game.Game;

public class DesktopLauncher {

	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();

        config.title = Game.TITLE;
        config.height = Game.V_HEIGHT;
        config.width = Game.V_WIDTH;
        config.resizable = false;

        //config.fullscreen = true;

		new LwjglApplication(new Game(), config);
	}
}
