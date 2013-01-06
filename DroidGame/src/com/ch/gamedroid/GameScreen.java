package com.ch.gamedroid;

import java.util.ArrayList;
import java.util.List;

import android.graphics.Color;

import com.ch.framework.Graphics;
import com.ch.framework.Pixmap;
import com.ch.framework.Input.TouchEvent;
import com.ch.gamedroid.Assets;
import com.ch.gamedroid.World;
import com.ch.gamedroid.GameScreen.GameState;
import com.ch.framework.Game;
import com.ch.framework.Screen;

public class GameScreen extends Screen {

	public GameScreen(Game game) 
	{
		super(game);
		world = new World();
	}

	enum GameState 
	{
        Ready,
        Running,
        GameOver
    }
    
    GameState state = GameState.Ready;
    World world;
    int oldScore = 0;
    String score = "0";

    @Override
    public void update(float deltaTime) 
    {
        List<TouchEvent> touchEvents = game.getInput().getTouchEvents();
        game.getInput().getKeyEvents();
        
        if(state == GameState.Ready)
            updateReady(touchEvents);
        if(state == GameState.Running)
            updateRunning(touchEvents, deltaTime);
        if(state == GameState.GameOver)
            updateGameOver(touchEvents);        
    }
    
    private void updateReady(List<TouchEvent> touchEvents) 
    {
        if(touchEvents.size() > 0)
            state = GameState.Running;
    }
    
    private void updateRunning(List<TouchEvent> touchEvents, float deltaTime) 
    {        
        // Set direction for the main character and call advance
    	
        world.update(deltaTime);
        if(world.gameOver) 
        {
            state = GameState.GameOver;
        }
        if(oldScore != world.score) 
        {
            oldScore = world.score;
            score = "" + oldScore;
        }
    }
    
    private void updateGameOver(List<TouchEvent> touchEvents) 
    {
        
    }
    
    @Override
    public void present(float deltaTime) 
    {       
        drawWorld(world);
        if(state == GameState.Ready) 
            drawReadyUI();
        if(state == GameState.Running)
            drawRunningUI();
        if(state == GameState.GameOver)
            drawGameOverUI();             
    }
    
    private void drawWorld(World world) 
    {
        Graphics g = game.getGraphics();
        List <ObjectDrop> coins = world.coins;
        CharacterOne mario = world.mario;
        
        for (int i = 0; i < coins.size(); i++)
        {
        	Pixmap coinPixmap = Assets.coin_fall;
            
            int x = coins.get(i).x * 32;
            int y = coins.get(i).y * 32;      
            g.drawPixmap(coinPixmap, x, y); 
        }
        
        Pixmap marioPixmap = Assets.characterOne;
        int x = 5 * 32;
        int y = 13 * 32;
        g.drawPixmap(marioPixmap, x, y);
    }
    
    private void drawReadyUI() 
    {
        Graphics g = game.getGraphics();
        
        g.drawPixmap(Assets.ready, 47, 100);
    }
    
    private void drawRunningUI() 
    {
    	// Add pause and back buttons later
    }

    private void drawGameOverUI() 
    {
        Graphics g = game.getGraphics();
        
        g.drawPixmap(Assets.gameOver, 62, 100);
    }
    
    @Override
    public void pause() 
    {
        if(state == GameState.Running)
            state = GameState.Paused;
        
        if(world.gameOver) 
        {
      
        }
    }

    @Override
    public void resume() {
        
    }

    @Override
    public void dispose() {
        
    }
}

