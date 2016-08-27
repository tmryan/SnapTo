package tryan.snapto;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class QInventoryItem {
	private int x;
	private int y;
	private int width;
	private int height;
	private BufferedImage itemImg;
	
	public QInventoryItem(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		itemImg = null;
	}
	
	public QInventoryItem(int x, int y, int width, int height, BufferedImage itemImage) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		itemImg = itemImage;
	}
	
	public void draw(Graphics2D g2) {		
		if(itemImg != null) {
			g2.drawImage(itemImg, null, x, y);
		}
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
		
	public void setX(int x) {
		this.x = x;
	}
	
	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}	
	
	public BufferedImage getItemImage() {
		return itemImg;
	}
	
	public void setItemImage(BufferedImage newImg) {
		itemImg = newImg;
	}
	
	public void clearItemImage() {
		itemImg = null;
	}
	
}
