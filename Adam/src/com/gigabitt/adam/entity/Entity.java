package com.gigabitt.adam.entity;

import java.util.Random;

import com.gigabitt.adam.graphics.Screen;
import com.gigabitt.adam.level.Level;


public abstract class Entity {
	public int x, y;
	private boolean removed = false;
	protected Level level;
	protected final Random random = new Random();
	
	public void update()
	{
		
	}
	public void render(Screen screen)
	{
		
	}
	public void remove()
	{
		removed = true;
	}

	public boolean isRemoved()
	{
		return removed;
	}
}
