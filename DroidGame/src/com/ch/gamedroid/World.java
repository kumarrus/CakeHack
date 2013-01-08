package com.ch.gamedroid;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
//Rushab
public class World {
    static final int WORLD_WIDTH = 10;
    static final int WORLD_HEIGHT = 15;
    static final int SCORE_INCREMENT = 10;
    static final int MAX_OBJECTS = 20;
    static final float TICK_INITIAL = 0.5f;
    static final float VTIME_INITIAL = 0.15f;

    public CharacterOne mario;
    public List<ObjectDrop> coins = new ArrayList<ObjectDrop>();
    public boolean gameOver = false;
    public int score = 0;
    public int index = 0;

    Random random = new Random();
    float tickTime = 0;
    static float tick = TICK_INITIAL;

    public World() {
        mario = new CharacterOne(5, 13);
        //placeObject();
    }

    private void placeObject() {
        int objX = random.nextInt(WORLD_WIDTH);

        coins.add(new ObjectDrop(objX, 1, VTIME_INITIAL));
    }

    public void update(float deltaTime) {
        if (gameOver)
            return;

        tickTime += deltaTime;
        
        for(int i = 0; i < index; i++) {
        	coins.get(i).velocityTime += deltaTime;
        	while (coins.get(i).velocityTime > coins.get(i).vTime) {
        		coins.get(i).velocityTime -= coins.get(i).vTime;
        		coins.get(i).positionY += 1;
        	}
        }
        
        while (tickTime > tick && index < MAX_OBJECTS) {
            tickTime -= tick;
            placeObject();
            index++;
        }
        
        for(int i = 0; i < index; i++) {
        	if(coins.get(i).positionY >= 14) {
        		coins.get(i).State = ObjectDrop.DESTROYED;
        		coins.remove(i);
        		index--;
        	}
        }
    }
}
