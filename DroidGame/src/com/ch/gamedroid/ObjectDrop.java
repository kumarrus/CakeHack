package com.ch.gamedroid;

public class ObjectDrop {
	public int positionX;
	public int positionY;
	public float vTime;
	public float velocityTime = 0;
	public int State;
	
	public static final int FALLING = 0;
	public static final int LANDED = 1;
	public static final int DESTROYED = 2;
	
	ObjectDrop(int positionX, int positionY, float vTime )
	{
		this.positionX = positionX;
		this.positionY = positionY;
		this.vTime = vTime;
		this.State = FALLING;
	}
}
