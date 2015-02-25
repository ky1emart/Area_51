package com.ky1emart.area51.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

import java.util.HashMap;

public class ResourceManager {

    private HashMap<String, Texture> textures;

    private HashMap<String, Music> music;

    private HashMap<String, Sound> sounds;

    private HashMap<String, BitmapFont> fonts;

    /**
     *
     */
    ResourceManager() {
        textures = new HashMap<String, Texture>();
        music = new HashMap<String, Music>();
        sounds = new HashMap<String, Sound>();
        fonts = new HashMap<String, BitmapFont>();
    }

    /**
     *
     * @param path
     */
    void loadTexture(String path) {
        int slashIndex = path.lastIndexOf('/');
        String key;
        if(slashIndex == -1) {
            key = path.substring(0, path.lastIndexOf('.'));
        } else {
            key = path.substring(slashIndex + 1, path.lastIndexOf('.'));
        }
        loadTexture(path, key);
    }

    /**
     *
     * @param path
     * @param key
     */
    void loadFont(String path, String key) {
        BitmapFont font = new BitmapFont(Gdx.files.internal(path));
        fonts.put(key, font);
    }

    /**
     *
     * @param key
     * @return
     */
    public BitmapFont getFont(String key) {
        return fonts.get(key);
    }

    /**
     *
     * @param key
     */
    void removeFont(String key) {
        BitmapFont font = fonts.get(key);
        if(font != null) {
            fonts.remove(key);
            font.dispose();
        }
    }

    /**
     *
     * @param path
     */
    void loadFont(String path) {
        int slashIndex = path.lastIndexOf('/');
        String key;
        if(slashIndex == -1) {
            key = path.substring(0, path.lastIndexOf('.'));
        } else {
            key = path.substring(slashIndex + 1, path.lastIndexOf('.'));
        }
        loadFont(path, key);
    }

    /**
     *
     * @param path
     * @param key
     */
    void loadTexture(String path, String key) {
        Texture tex = new Texture(Gdx.files.internal(path));
        textures.put(key, tex);
    }

    /**
     *
     * @param key
     * @return
     */
    public Texture getTexture(String key) {
        return textures.get(key);
    }

    /**
     *
     * @param key
     */
    void removeTexture(String key) {
        Texture tex = textures.get(key);
        if(tex != null) {
            textures.remove(key);
            tex.dispose();
        }
    }

    /**
     *
     * @param path
     */
    void loadMusic(String path) {
        int slashIndex = path.lastIndexOf('/');
        String key;
        if(slashIndex == -1) {
            key = path.substring(0, path.lastIndexOf('.'));
        } else {
            key = path.substring(slashIndex + 1, path.lastIndexOf('.'));
        }
        loadMusic(path, key);
    }

    /**
     *
     * @param path
     * @param key
     */
    void loadMusic(String path, String key) {
        Music m = Gdx.audio.newMusic(Gdx.files.internal(path));
        music.put(key, m);
    }

    /**
     *
     * @param key
     * @return
     */
    public Music getMusic(String key) {
        return music.get(key);
    }

    /**
     *
     * @param key
     */
    void removeMusic(String key) {
        Music m = music.get(key);
        if(m != null) {
            music.remove(key);
            m.dispose();
        }
    }

    /**
     *
     * @param path
     */
    void loadSound(String path) {
        int slashIndex = path.lastIndexOf('/');
        String key;
        if(slashIndex < 0) {
            key = path.substring(0, path.lastIndexOf('.'));
        } else {
            key = path.substring(slashIndex + 1, path.lastIndexOf('.'));
        }
        loadSound(path, key);
    }

    /**
     *
     * @param path
     * @param key
     */
    void loadSound(String path, String key) {
        Sound sound = Gdx.audio.newSound(Gdx.files.internal(path));
        sounds.put(key, sound);
    }

    /**
     *
     * @param key
     * @return
     */
    public Sound getSound(String key) {
        return sounds.get(key);
    }

    /**
     *
     * @param key
     */
    void removeSound(String key) {
        Sound sound = sounds.get(key);
        if(sound != null) {
            sounds.remove(key);
            sound.dispose();
        }
    }

    /**
     *
     */
    void removeAll() {
        for(Texture texture : textures.values()) {
            texture.dispose();
        }
        textures.clear();

        for(Music music : this.music.values()) {
            music.dispose();
        }
        music.clear();

        for(Sound sound : this.sounds.values()) {
            sound.dispose();
        }
        sounds.clear();
    }
}
