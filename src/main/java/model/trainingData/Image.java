package model.trainingData;

public class Image {

    public double[] images;

    public Image(double[] images) {
        this.images = images;
    }

    public double[] getImage() {
        return images;
    }

    public void setImage(double[] images) {
        this.images = images;
    }
}
