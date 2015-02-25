package com.ky1emart.area51.desktop;

import com.badlogic.gdx.Files;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.ky1emart.area51.game.Game;

public class DesktopLauncher {

	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();

        config.title = Game.TITLE + " - Demo Build";
        config.height = Game.V_HEIGHT;
        config.width = Game.V_WIDTH;
        config.resizable = false;
        config.addIcon("icons/windows.png", Files.FileType.Internal);

		new LwjglApplication(new Game(), config);
	}
}
