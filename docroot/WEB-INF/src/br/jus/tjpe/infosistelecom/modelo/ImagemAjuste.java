package br.jus.tjpe.infosistelecom.modelo;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImagemAjuste {

	
	public static BufferedImage resize(String f) {
		BufferedImage imageBuffer;
		BufferedImage imageTemp = null;
		
		try {

			imageBuffer = ImageIO.read(new File(f));
			System.out.println(imageBuffer.getHeight());
			System.out.println(imageBuffer.getWidth());

			imageTemp = new BufferedImage(
					imageBuffer.getWidth() / 2, imageBuffer.getHeight() / 2,
					imageBuffer.TYPE_INT_RGB);
			Graphics2D grafico = (Graphics2D) imageTemp.getGraphics();
			grafico.drawImage(imageBuffer, 0, 0, imageBuffer.getWidth() / 2,
					imageBuffer.getHeight() / 2, null);
			grafico.dispose();
			ImageIO.write(imageTemp, "jpg", new File(f));
			
		} catch (IOException e) {

			e.printStackTrace();
		}
		return imageTemp;

	}
}
