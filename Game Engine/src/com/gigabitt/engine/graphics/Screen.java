package com.gigabitt.engine.graphics;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.gigabitt.engine.graphics.gui.Gui;

public class Screen {
	public int width, height;
	public int[] pixels;
	public Screen(int width, int height)
	{
		this.width = width;
		this.height = height;
		pixels = new int[width * height];
	}
	public void clear()
	{
		for(int i = 0; i<pixels.length; i++)
		{
			pixels[i] = 0;
		}
	}
	public void renderGui(int x, int y, Image image)
	{
		for(y = 0; y < height; y++)
		{
			for(x = 0; x < width; x++)
			{
				if(x < 0 || x >= width || y < 0 || y >= height) break;
				if (x < 0) x= 0;
				
				pixels[x + y * width] = Image.main.pixels[x + y * Image.main.size];
			}
		}
	}

}
