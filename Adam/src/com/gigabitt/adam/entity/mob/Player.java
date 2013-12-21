package com.gigabitt.adam.entity.mob;

import com.gigabitt.adam.graphics.Screen;
import com.gigabitt.adam.graphics.Sprite;
import com.gigabitt.adam.input.Keyboard;

public class Player extends Mob {
	
	private Keyboard input;
	private Sprite sprite;
	private int anim = 0;
	private boolean walking = false;
	
	public Player(Keyboard input)
	{
		this.input = input;
		sprite = Sprite.playerf;
	}
	public Player(int x, int y, Keyboard input)
	{
		this.x = x;
		this.y = y;
		this.input = input;
	}
	public void update()
	{
		int xa=0;
		if(anim < 7500) anim++;
		else anim = 0;
		int ya=0;
		if(input.up) ya--;
		if(input.down) ya++;
		if(input.left) xa--;
		if(input.right) xa++;
		if(xa != 0 || ya != 0) {
			move(xa, ya);
			walking = true;
		}else
		{
			walking = false;
		}
	}
	public void render(Screen screen)
	{
		int flip = 0;
		sprite = Sprite.playerf;
		if(dir == 2) 
		{
			sprite = Sprite.playerf;
			if(walking)
			{
				if(anim % 20 > 10)
				{
					sprite = Sprite.playerf_1;
				}
				else
				{
					sprite = Sprite.playerf_2;
				}
			}
		}
		if(dir == 0) 
		{
			sprite = Sprite.playeru;
			if(walking)
			{
				if(anim % 20 > 10)
				{
					sprite = Sprite.playeru_1;
				}
				else
				{
					sprite = Sprite.playeru_2;
				}
			}
		}
		if(dir == 3) 
		{
			sprite = Sprite.players;
			if(walking)
			{
				if(anim % 20 > 10)
				{
					sprite = Sprite.players_1;
				}
				else
				{
					sprite = Sprite.players_2;
				}
			}
		}
		if(dir == 1) 
		{
			sprite = Sprite.players;
			if(walking)
			{
				if(anim % 20 > 10)
				{
					sprite = Sprite.players_1;
				}
				else
				{
					sprite = Sprite.players_2;
				}
			}
			flip = 1;
		}
		screen.renderPlayer(x, y, sprite, flip);
	}

}
