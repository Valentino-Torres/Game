package com.gigabitt.engine.graphics.gui;


import com.gigabitt.engine.graphics.Image;
import com.gigabitt.engine.graphics.Screen;

public class Menu extends Gui{
	public int x, y;
	private Image image;
	public Menu(int x, int y)
	{
		this.x=x;
		this.y=y;
	}
	public void render(Screen screen)
	{
		image = Image.main;
		screen.renderGui(x, y, image);
	}

}
