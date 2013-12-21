package com.gigabitt.engine;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.swing.JFrame;

import com.gigabitt.engine.graphics.Screen;
import com.gigabitt.engine.graphics.gui.Gui;
import com.gigabitt.engine.graphics.gui.Menu;

public class Engine extends Canvas implements Runnable{
	private static final long serialVersionUID = 4057405920301965832L;
	public int width = 300;
	public int height = 168;
	public int scale = 3;
	
	private Thread thread;
	private JFrame jframe;
	private Screen screen;
	private Gui menu;
	public boolean running = false;
	
	private BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
	private int[] pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();
	
	public Engine()
	{
		Dimension d = new Dimension(width*scale, height*scale);
		setPreferredSize(d);
		screen = new Screen(width, height);
		jframe = new JFrame();
		menu = new Menu(0, 0);
	}

	@Override
	public void run() {
		long lastTime = System.nanoTime();
		long timer = System.currentTimeMillis();
		final double ns = 1000000000.0 / 60.0;
		double delta = 0;
		int frames = 0;
		int updates = 0;
		requestFocus();
		while(running)
		{
			long now = System.nanoTime();
			delta += (now-lastTime) / ns;
			lastTime = now;
			while(delta >= 1)
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
				System.out.println(updates + " Ups, " + frames + " FPS");
				updates = 0;
				frames = 0;
			}
		}
		stop();
	}
	public void update()
	{
		
	}
	public void render()
	{
		BufferStrategy bs = getBufferStrategy();
		if(bs == null)
		{
			createBufferStrategy(3);
			return;
		}
		screen.clear();
		menu.render(screen);
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
	public void start()
	{
		running = true;
		thread = new Thread(this, "Display");
		thread.start();
	}
	public void stop()
	{
		running = false;
		try{
			thread.join();
		}catch(InterruptedException e)
		{
			e.printStackTrace();
		}
	}
	public static void main(String[] args)
	{
		Engine e = new Engine();
		e.jframe.setResizable(false);
		e.jframe.setTitle("2D Engine");
		e.jframe.add(e);
		e.jframe.pack();
		e.jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		e.jframe.setLocationRelativeTo(null);
		e.jframe.setVisible(true);
		e.start();
		
	}
	

}
