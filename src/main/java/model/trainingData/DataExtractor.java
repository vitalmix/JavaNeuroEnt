package model.trainingData;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class DataExtractor {

    public double[] dataExtract(int num1, int num2) throws Exception {
        int pixelCounter = 0;

        File file = new File("Z:\\MAG Diploma\\test_img\\nums\\num"+ num1 +"_"+ num2 +".png");
        BufferedImage img = ImageIO.read(file);
        double[] arrOfPixels = new double[img.getWidth()*img.getHeight()];
        for (int y = 0; y < img.getHeight(); y++) {
            for (int x = 0; x < img.getWidth(); x++) {
                int pixel = img.getRGB(x, y);
                Color color = new Color(pixel, true);
                arrOfPixels[pixelCounter] = color.getRed();
                arrOfPixels[pixelCounter] /= 1000;
                pixelCounter++;
            }
        }

        return arrOfPixels;
    }
}
