package com.gigabitt.adam;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.swing.JFrame;

import com.gigabitt.adam.entity.mob.Player;
import com.gigabitt.adam.graphics.Screen;
import com.gigabitt.adam.input.Keyboard;
import com.gigabitt.adam.level.Home;
import com.gigabitt.adam.level.Level;
import com.gigabitt.adam.level.RandomLevel;

public class Game extends Canvas implements Runnable{
	private static final long serialVersionUID = 1L;
	public static int WIDTH= 300;
	public static int HEIGHT = WIDTH / 16 * 9;
	public static int scale = 3;

	private Thread thread;
	private JFrame jframe;
	private Keyboard key;
	private Level level;
	private Player player;
	private boolean running = false;
	
	private Screen screen;
	
	private BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
	private int[] pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();
	
	public Game()
	{
		Dimension size = new Dimension(WIDTH*scale, HEIGHT *scale);
		setPreferredSize(size);
		screen = new Screen(WIDTH, HEIGHT);
		
		jframe = new JFrame();
		key = new Keyboard();
		level = new Home("/textures/Levels/Home.png");
		player = new Player(8 * 16, 8 * 16, key);
		addKeyListener(key);
	}
	
	public synchronized void start()
	{
		running = true;
		thread = new Thread(this, "Display");
		thread.start();
	}
	
	public synchronized void stop()
	{
		running = false;
		try{
		thread.join();
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}
	
	public void run()
	{
		long lastTime = System.nanoTime();
		long timer= System.currentTimeMillis();
		final double ns = 1000000000.0 / 60.0;
		double delta = 0;
		int frames = 0;
		int updates = 0;
		requestFocus();
		while (running)
		{
			long now = System.nanoTime();
			delta += (now-lastTime) / ns;
			lastTime = now;
			while (delta >= 1)
			{
				update();
				updates++;
				delta--;
			}
			render();
			frames++;
			
			if(System.currentTimeMillis() - timer > 1000)
			{
				timer += 1000;
				System.out.println(updates + " ups, " + frames + " fps");
				updates = 0;
				frames = 0;
			}
		}
		stop();
	}

	public void update()
	{
		key.update();
		player.update();
	}
	public void render()
	{
		BufferStrategy bs = getBufferStrategy();
		if (bs == null)
		{
			createBufferStrategy(3);
			return;
		}
		screen.clear();
		int xScroll = player.x-screen.WIDTH / 2;
		int yScroll = player.y-screen.HEIGHT / 2;
		level.render(xScroll, yScroll, screen);
		player.render(screen);
		for(int i = 0; i<pixels.length; i++)
		{
			pixels[i] = screen.pixels[i];
		}
		Graphics g = bs.getDrawGraphics();
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, getWidth(), getHeight());
		g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
		g.dispose();
		bs.show();
	}
	public static void main(String[] args)
	{
		Game game = new Game();
		game.jframe.setResizable(false);
		game.jframe.setTitle("Adam");
		game.jframe.add(game);
		game.jframe.pack();
		game.jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		game.jframe.setLocationRelativeTo(null);
		game.jframe.setVisible(true);
		
		game.start();
	}

}
