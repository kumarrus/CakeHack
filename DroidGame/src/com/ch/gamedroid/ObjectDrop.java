package com.ch.gamedroid;

public class ObjectDrop {
	public int positionX;
	public int positionY;
	public int velocityY;
	
	public static final int FALLING = 0;
	public static final int LANDED = 1;
	public static final int DESTROYED = 2;
	
	ObjectDrop(int positionX, int positionY, int velocityY )
	{
		this.positionX = positionX;
		this.positionY = positionX;
		this.velocityY = velocityY;
	}
}
