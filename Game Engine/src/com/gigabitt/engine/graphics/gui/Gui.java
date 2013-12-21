package com.gigabitt.engine.graphics.gui;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import com.gigabitt.engine.graphics.Image;
import com.gigabitt.engine.graphics.Screen;


public abstract class Gui {
	public int x, y;
	protected final Random random = new Random();
	public int pixels[];
	public Image gui;
	
	public void update()
	{
		
	}
	public void render(Screen screen)
	{
	}
}