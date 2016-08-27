package tryan.snapto;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class QInventoryCell {
	private int x;
	private int y;
	private int width;
	private int height;
	private BufferedImage backGroundImg;
	private QInventoryItem item;
	private boolean isEmpty;
	
	public QInventoryCell(int x, int y, int width, int height, BufferedImage bgImage) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		backGroundImg = bgImage;
		item = new QInventoryItem(x, y, width, height);
		isEmpty = true;
	}
	
	public boolean containsCoords(int x2, int y2) {
		boolean contained = false;
		
		if(x2 > x && y2 > y && x2 < x+width && y2 < y+height) {
			contained = true;
		}
		
		return contained;
	}
	
	public void draw(Graphics2D g2) {
		if(backGroundImg != null) {
			g2.drawImage(backGroundImg, null, x, y);
		}
		
		item.draw(g2);
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}

	public int getX() {
		return x;
	}
		
	public int getY() {
		return y;
	}
	
	public void setX(int x) {
		this.x = x;
	}
		
	public void setY(int y) {
		this.y = y;
	}	
	
	public void setItemImage(BufferedImage newImg) {
		item.setItemImage(newImg);
		isEmpty = false;
	}
	
	public void clearItemImage() {
		item.clearItemImage();
		isEmpty = true;
	}
	
	public BufferedImage getItemImage() {
		return item.getItemImage();
	}
	
	public boolean isEmpty() {
		return isEmpty;
	}
	
}
