package com.ch.gamedroid;

import com.ch.framework.Graphics.PixmapFormat;
import com.ch.framework.Graphics;
import com.ch.framework.Game;
import com.ch.framework.Screen;

public class LoadingScreen extends Screen {

	public LoadingScreen(Game game) 
	{
		super(game);
	}

	@Override
	public void update(float deltaTime) 
	{
		Graphics g = game.getGraphics();
		Assets.coin_fall = g.newPixmap("coin_falling.png", PixmapFormat.ARGB4444);
		Assets.coin_land = g.newPixmap("coin_landed.png", PixmapFormat.ARGB4444);
		Assets.characterOne = g.newPixmap("character1.png", PixmapFormat.ARGB4444);
		Assets.gameOver = g.newPixmap("gameover.png", PixmapFormat.ARGB4444);
		Assets.ready = g.newPixmap("ready.png", PixmapFormat.ARGB4444);
		Assets.background = g.newPixmap("background.png", PixmapFormat.RGB565);
		game.setScreen(new GameScreen(game));
	}

	@Override
	public void present(float deltaTime) 
	{
		
	}

	@Override
	public void pause() 
	{
		
	}

	@Override
	public void resume() 
	{
		
	}

	@Override
	public void dispose() 
	{
		
	}

}
