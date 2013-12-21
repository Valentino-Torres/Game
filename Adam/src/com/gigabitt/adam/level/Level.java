package com.gigabitt.adam.level;

import com.gigabitt.adam.graphics.Screen;
import com.gigabitt.adam.level.tile.Tile;

public class Level {
	
	protected int width, height;
	protected int[] tilesInt;
	protected int[] tiles;
	
	public Level(int width, int height)
	{
		this.width = width;
		this.height = height;
		tilesInt = new int[width * height];
		generateLevel();
	}
	
	public Level(String path)
	{
		loadLevel(path);
		generateLevel();
	}
	
	protected void generateLevel()
	{
		
	}
	protected void loadLevel(String path)
	{
		
	}
	public void update()
	{
		
	}
	
	private void time()
	{
		
	}
	
	private void accessible()
	{
		
	}
	public void render(int xScroll, int yScroll, Screen screen)
	{
		screen.setOffset(xScroll, yScroll);
		int x0 = xScroll >> 4;
		int x1 = (xScroll + screen.WIDTH + 16) >> 4;
		int y0 = yScroll >> 4;
		int y1 = (yScroll + screen.HEIGHT + 16) >> 4;	
		
		for(int y = y0; y < y1; y++)
		{
			for(int x = x0; x < x1; x++)
			{
				getTile(x, y).render(x, y, screen);
			}
		}
	}
	public Tile getTile(int x, int y)
	{
		if (x < 0 || y < 0 || x >= width || y>= height) return Tile.voidTile;
		if (tiles[x+y*width] == 0xff139b10) return Tile.grass;
		if (tiles[x+y*width] == 0xff00473e) return Tile.tree;
		if (tiles[x+y*width] == 0xff00473e) return Tile.treel;
		if (tiles[x+y*width] == 0xff00473e) return Tile.treer;
		if (tiles[x+y*width] == 0xff4e2f00) return Tile.trees;
		if (tiles[x+y*width] == 0xff888888) 
			{
			return Tile.rock;
			}
		return Tile.voidTile;
	}
}
