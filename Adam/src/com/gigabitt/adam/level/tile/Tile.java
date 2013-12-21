package com.gigabitt.adam.level.tile;

import com.gigabitt.adam.graphics.Screen;
import com.gigabitt.adam.graphics.Sprite;

public class Tile {
	
	public int x, y;
	public Sprite sprite;
	public static Tile grass = new GrassTile(Sprite.grass);
	public static Tile voidTile = new VoidTile(Sprite.voidTile);
	public static Tile tree = new TreeTile(Sprite.tree);
	public static Tile treel = new TreeTile(Sprite.treel);
	public static Tile treer = new TreeTile(Sprite.treer);
	public static Tile trees = new TreeTile(Sprite.trees);
	public static Tile rock = new RockTile(Sprite.rock);
	public Tile(Sprite sprite)
	{
		this.sprite = sprite;
	}
	public void render(int x, int y, Screen screen) {
		
	}
	
	public boolean solid()
	{
		return false;
	}
}
