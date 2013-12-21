package com.gigabitt.adam.graphics;

import java.awt.Color;

public class Sprite {
	
	public final int SIZE;
    private int x, y;
    public int[] pixels;
    private SpriteSheet sheet;
    
    public static Sprite grass = new Sprite(16, 0, 0, SpriteSheet.terrain);
    public static Sprite tree = new Sprite(16, 1, 1, SpriteSheet.terrain);
    public static Sprite treet = new Sprite(16, 1, 0, SpriteSheet.terrain);
    public static Sprite treel = new Sprite(16, 1, 2, SpriteSheet.terrain);
    public static Sprite treer = new Sprite(16, 1, 3, SpriteSheet.terrain);
    public static Sprite trees = new Sprite(16, 6, 0, SpriteSheet.terrain);
    public static Sprite rock = new Sprite(16, 2, 0, SpriteSheet.terrain);
    public static Sprite voidTile = new Sprite(16, 0x000000);
    public static Sprite playerf = new Sprite(16, 0 , 0, SpriteSheet.player);
    public static Sprite playeru = new Sprite(16, 1 , 0, SpriteSheet.player);
    public static Sprite players = new Sprite(16, 2 , 0, SpriteSheet.player);
    
    public static Sprite playerf_1 = new Sprite(16, 0 , 1, SpriteSheet.player);
    public static Sprite playerf_2 = new Sprite(16, 0 , 2, SpriteSheet.player);
    public static Sprite playeru_1 = new Sprite(16, 1 , 1, SpriteSheet.player);
    public static Sprite playeru_2 = new Sprite(16, 1 , 2, SpriteSheet.player);
    public static Sprite players_1 = new Sprite(16, 2 , 1, SpriteSheet.player);
    public static Sprite players_2 = new Sprite(16, 2 , 2, SpriteSheet.player);
    
    public Sprite(int size, int x, int y, SpriteSheet sheet)
    {
    	SIZE = size;
    	pixels = new int[SIZE * SIZE];
    	this.x = x*size;
    	this.y = y * size;
    	this.sheet = sheet;
    	load();
    }
    public Sprite(int size, int color)
    {
    	SIZE = size;
    	pixels = new int[SIZE*SIZE];
    	setColor(color);
    }
    private void setColor(int color) {
		for (int i = 0; i <SIZE * SIZE; i++)
		{
			pixels[i] = color;
		}
	}
	private void load()
    {
    	for (int y= 0; y < SIZE; y++)
    	{
    		for (int x = 0; x<SIZE; x++)
    		{
    			pixels[x+y*SIZE] = sheet.pixels[(x + this.x) + (y+this.y) * sheet.SIZE];
    		}
    	}
    }

}
