package com.vnpt.entity;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class GreenImage{
	  public static void main(String args[])throws IOException{
	    BufferedImage img = null;
	    File file = null;
		 int a = 255;
	    //read image
	    try{
	    	file = new File("F:/VN.BMP");
	      img = ImageIO.read(file);
	    }catch(IOException e){
	      System.out.println(e);
	    };
	    //get width and height
	    int width = img.getWidth();
	    int height = img.getHeight();

	    //convert to green image
	    for(int y = 0; y < height; y++){
	    	for(int x = 0; x < width; x++){
	  	    Color c = new Color(img.getRGB(x,y));
	  
		    int red = c.getRed() + 1;
		    int green = c.getGreen() + 1;
		    int blue = c.getBlue() + 1;

		    double index = (double)(256-red)/80 + 1.8;
		    if (red/green>=index || red/blue>=index) {
               int temp = red ;
               red = blue;
               blue = temp;
		    }
			int p = (a << 24) | (red << 16) | (green << 8) | blue;
			img.setRGB(x, y, p);

	      }
	    }

	    //write image
	    try{
	    	file = new File("F:/VN2.BMP");
	      ImageIO.write(img, "png", file);
	      System.out.println("success");
	    }catch(IOException e){
	      System.out.println(e);
	    }
	  }
	}