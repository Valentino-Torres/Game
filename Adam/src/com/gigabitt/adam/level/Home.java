package com.gigabitt.adam.level;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.gigabitt.adam.level.tile.Tile;

public class Home extends Level {
	
	public Home(String path) {
		super(path);
	}
	protected void loadLevel(String path)
	{
		try
		{
			BufferedImage image = ImageIO.read(Home.class.getResource(path));
			int w = width = image.getWidth();
			int h = height = image.getHeight();
			tiles = new int[w*h];
			image.getRGB(0, 0, w, h, tiles, 0, w);
		}catch (IOException e)
		{
			e.printStackTrace();
			System.out.println("Exception! Could not load level file");
		}
	}
	//if (tiles[i] == 0xff139b10) tiles[i] = Tile.grass;
	//if (tiles[i] == 0xff00473e) tiles[i] = Tile.tree;
	protected void generateLevel()
	{
		
	}

}
