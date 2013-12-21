package com.gigabitt.adam.graphics;

import java.util.Random;

import com.gigabitt.adam.level.tile.Tile;

public class Screen {
	
	public int WIDTH, HEIGHT;
	public int[] pixels;
	public int[] tiles = new int[64 * 64];
	public int xOffset, yOffset;
	
	private Random random = new Random();
	
	public Screen(int width, int height)
	{
		this.WIDTH = width;
		this.HEIGHT = height;
		pixels = new int[width*height];
		
		for (int i = 0; i<64 * 64; i++)
		{
			tiles[i] = random.nextInt(0xffffff);
		}
	}
	public void clear()
	{
		for(int i = 0; i<pixels.length; i++)
		{
			pixels[i] = 0;
		}
	}
	public void renderTile(int xp, int yp, Tile tile)
	{
		xp -= xOffset;
		yp -= yOffset;
		for (int y = 0; y < tile.sprite.SIZE; y++)
		{
			int ya = y + yp;
			for (int x = 0; x < tile.sprite.SIZE; x++)
			{
				int xa = x + xp;
				if(xa < -tile.sprite.SIZE || xa >= WIDTH || ya < 0 || ya >= HEIGHT) break;
				if (xa < 0) xa= 0;
				pixels[xa + ya * WIDTH] = tile.sprite.pixels[x+y*tile.sprite.SIZE];
			}
		}
	}
	public void renderPlayer(int xp, int yp, Sprite sprite, int flip)
	{
		xp -= xOffset;
		yp -= yOffset;
		for (int y = 0; y < 16; y++)
		{
			int ya = y + yp;
			int ys = y;
			if(flip == 2 || flip == 3) 
			{
				ys = 31 - y;
			}
			for (int x = 0; x < 16; x++)
			{
				int xa = x + xp;
				int xs = x;
				if(flip == 1 || flip ==3)
				{
					xs = 15 - x;
				}
				if(xa < -16 || xa >= WIDTH || ya < 0 || ya >= HEIGHT) break;
				if (xa < 0) xa= 0;
				int col = sprite.pixels[xs + ys * 16];
				if(col != 0xffff00ff) pixels[xa + ya * WIDTH] = col;
			}
		}
	}
	public void setOffset(int xOffset, int yOffset)
	{
		this.xOffset = xOffset;
		this.yOffset = yOffset;
	}
}
