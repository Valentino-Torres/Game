package com.gigabitt.adam.level.tile;

import com.gigabitt.adam.graphics.Screen;
import com.gigabitt.adam.graphics.Sprite;

public class RockTile extends Tile {

	public RockTile(Sprite sprite) {
		super(sprite);
		}
	public void render(int x, int y, Screen screen)
	{
		screen.renderTile(x << 4, y <<4 , this);
	}

}
