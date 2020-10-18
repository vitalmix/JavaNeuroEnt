import model.extractData.ImageNormaliser;
import javafx.application.Application;
import javafx.stage.Stage;
import model.training.NNTrainer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
       /*  NeuralNetworkImpl neuralNetworkImpl = new NeuralNetworkImpl();
        new DrawProcess(stage, neuralNetworkImpl.getInputNeurons(), neuralNetworkImpl.getHideNeurons1(),
                neuralNetworkImpl.getHideNeurons2(), neuralNetworkImpl.getOutputNeurons());*/
        //TrainingImageImpl trainingImage = new TrainingImageImpl();

        simpleNN();

    }

    public static void normTest() {
        ImageNormaliser imageNormaliser = new ImageNormaliser();

        BufferedImage image;
        File imgFiles = new File(
                "E:\\MAG Diploma\\test_img\\notes\\testpng.png");
        try {
            image = ImageIO.read(imgFiles);
            image =  imageNormaliser.scale(image,1080,1980);
            imageNormaliser.imageWriter(image);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static void simpleNN() {

        NNTrainer nnTrainer = new NNTrainer();

    }
}
