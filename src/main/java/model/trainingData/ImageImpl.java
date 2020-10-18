package model.trainingData;

import java.util.ArrayList;

public class ImageImpl {

    public ArrayList<Image> images = new ArrayList<Image>();

    public ImageImpl() {

        DataExtractor dataExtractor = new DataExtractor();

        for (int i = 1; i < 4; i++) {
            for (int j = 1; j < 6; j++) {
                try {
                    images.add(new Image(dataExtractor.dataExtract(i,j)));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public ArrayList<Image> getTrainingImages() {
        return images;
    }
}
