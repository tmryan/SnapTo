package tryan.snapto;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Main {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setSize(306, 328);
		frame.setTitle("Snap to Grid");
		
		QInventoryUI inventory = new QInventoryUI();
		inventory.setPreferredSize(new Dimension(300, 300));
		frame.add(inventory, BorderLayout.CENTER);
		
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);
	}

}
