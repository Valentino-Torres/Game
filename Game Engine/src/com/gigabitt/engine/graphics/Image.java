package com.gigabitt.engine.graphics;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Image {
	public int width;
	public int height;
    private int x, y;
    public int[] pixels;
    public String path;
    public int size;
    public static Image main = new Image(300, 168, 0, 0, "/textures/gui/main.png");
	public Image(int width, int height, int x, int y, String path)
    {
		this.width = width;
		this.height = height;
		size = width * height;
    	pixels = new int[height * width];
    	this.x = x*width;
    	this.y = y * height;
    	this.path = path;
    	load();
    }
	private void load()
    {
		try {
			BufferedImage image = ImageIO.read(Screen.class.getResource(path));
			int w = image.getWidth();
			int h = image.getHeight();
			image.getRGB(0, 0, w, h, pixels, 0, w);
		} catch (IOException e) {
			System.out.println("Could not find gui!");
			e.printStackTrace();
		}
    }
}
