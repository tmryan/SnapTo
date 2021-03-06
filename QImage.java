package tryan.snapto;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class QImage {	
	private QImage(String file) {}
	
	public static BufferedImage createBufferedImage(String file) {
		BufferedImage img = null;
		
		try {
			img = ImageIO.read(new File(file));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return img;
	}
}
