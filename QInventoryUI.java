package tryan.snapto;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class QInventoryUI extends JPanel {
	private final int ROW_SIZE = 3;
	private final int CELL_WIDTH = 100;

	QInventoryCell[][] cellGrid;
	QInventoryItem heldItem;
	boolean mouseClicked;
	
	public QInventoryUI() {
		cellGrid = new QInventoryCell[ROW_SIZE][ROW_SIZE];
		heldItem = null;
		mouseClicked = false;
		
		init();
	}
	
	public void init() {
		addMouseMotionListener(new MouseAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				if(heldItem != null) {
					heldItem.setX(e.getX() - CELL_WIDTH/2);
					heldItem.setY(e.getY() - CELL_WIDTH/2);
					repaint();
				}
			}
		});
		
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				resolveMouseClick(e.getX(), e.getY());
				repaint();
			}
		});
		
		// Populating inventory with cells
		for(int i = 0; i < ROW_SIZE; i++) {
			for(int j = 0; j < ROW_SIZE; j++) {
				cellGrid[i][j] = new QInventoryCell(i*CELL_WIDTH, j*CELL_WIDTH, CELL_WIDTH, CELL_WIDTH, QImage.createBufferedImage("invCell2.jpg"));
			}
		}

		cellGrid[0][0].setItemImage(QImage.createBufferedImage("invItemTest.png"));
		cellGrid[2][2].setItemImage(QImage.createBufferedImage("invItemTestGreen.png"));
		cellGrid[1][2].setItemImage(QImage.createBufferedImage("invItemTestRed.png"));
		cellGrid[0][1].setItemImage(QImage.createBufferedImage("invItemTestPurple.png"));
	}
	
	public void resolveMouseClick(int x, int y) {
		if(heldItem == null) {
			for(QInventoryCell[] row : cellGrid) {
				for(QInventoryCell cell : row) {
					if(!cell.isEmpty() && cell.containsCoords(x, y)) {
						heldItem = new QInventoryItem(x - CELL_WIDTH/2, y - CELL_WIDTH/2, 
													  CELL_WIDTH, CELL_WIDTH, cell.getItemImage());
						cell.clearItemImage();
					}
				}
			}
		} else {
			QCoords cellLoc = getClickedCell(x, y);
			int row = cellLoc.getX() / CELL_WIDTH;
			int col = cellLoc.getY() / CELL_WIDTH;
			
			if(cellGrid[row][col].isEmpty()) {
				heldItem.setX(cellLoc.getX());
				heldItem.setY(cellLoc.getY());
				cellGrid[row][col].setItemImage(heldItem.getItemImage());
				heldItem = null;
			} else {
				BufferedImage tempItem = cellGrid[row][col].getItemImage();
				heldItem.setX(cellLoc.getX());
				heldItem.setY(cellLoc.getY());
				cellGrid[row][col].setItemImage(heldItem.getItemImage());
				heldItem = new QInventoryItem(x - CELL_WIDTH/2, y - CELL_WIDTH/2, 
						  CELL_WIDTH, CELL_WIDTH, tempItem);
			}
		}
	}
	
	public QCoords getClickedCell(int x, int y) {
		int row = 0;
		int col = 0;

		for(int i = 0; i < ROW_SIZE; i++) {
			if(i*CELL_WIDTH < x) {
				row = i*CELL_WIDTH;
			}
			
			if(i*CELL_WIDTH < y) {
				col = i*CELL_WIDTH;
			}
		}
		
		return new QCoords(row, col);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		
		for(QInventoryCell[] row : cellGrid) {
			for(QInventoryCell cell : row) {
				cell.draw(g2);
			}
		}
		
		if(heldItem != null) {
			heldItem.draw(g2);
		}
	}
	
}
