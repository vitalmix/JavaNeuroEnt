package view.drawTraining;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import model.neural.Neuron;
import model.neural.Synapse;

import java.util.ArrayList;

public class DrawProcess {
    public ArrayList<Neuron> inputNeurons;
    public ArrayList<Neuron> hideNeurons1;
    public ArrayList<Neuron> hideNeurons2;
    public ArrayList<Neuron> outputNeurons;

    public DrawProcess(Stage stage, ArrayList<Neuron> inputNeurons, ArrayList<Neuron> hideNeurons1,
                       ArrayList<Neuron> hideNeurons2, ArrayList<Neuron> outputNeurons) {

        this.inputNeurons = inputNeurons;
        this.hideNeurons1 = hideNeurons1;
        this.hideNeurons2 = hideNeurons2;
        this.outputNeurons = outputNeurons;
        //Line line = new Line(3,3,303,303);
        //Circle circle = new Circle(100 ,100,10);

        //line.setStrokeWidth(4);

        //Creating a Group
        Group root = new Group(drawNeurons());

        //Creating a Scene
        Scene scene = new Scene(root, 1376, 768);

        //Setting title to the scene
        stage.setTitle("Neural Network");

        //Adding the scene to the stage
        stage.setScene(scene);

        //Displaying the contents of a scene
        stage.show();

    }

    private ArrayList<Node> drawNeurons() {

        ArrayList<Node> circlesNeurons = new ArrayList<>();


        for (Neuron inputN :
                inputNeurons) {
            inputN.circle = new Circle(inputN.x, inputN.y, 20);
            circlesNeurons.add(inputN.circle);

            for (Synapse s :
                    inputN.rightSynapses) {
                s.line = new Line(s.getLNeuronX(), s.getLNeuronY(), s.getRNeuronX(), s.getRNeuronY());
                circlesNeurons.add(s.line);

            }
        }

        for (Neuron hide1N :
                hideNeurons1) {
            hide1N.circle = new Circle(hide1N.x, hide1N.y, 20);
            circlesNeurons.add(hide1N.circle);

            for (Synapse s :
                    hide1N.rightSynapses) {
                s.line = new Line(s.getLNeuronX(), s.getLNeuronY(), s.getRNeuronX(), s.getRNeuronY());
                circlesNeurons.add(s.line);

            }
        }

        for (Neuron hide2N :
                hideNeurons2) {
            hide2N.circle = new Circle(hide2N.x, hide2N.y, 20);
            circlesNeurons.add(hide2N.circle);

            for (Synapse s :
                    hide2N.rightSynapses) {
                s.line = new Line(s.getLNeuronX(), s.getLNeuronY(), s.getRNeuronX(), s.getRNeuronY());
                circlesNeurons.add(s.line);

            }

        }

        for (Neuron outN :
                outputNeurons) {
            outN.circle = new Circle(outN.x, outN.y, 20);
            circlesNeurons.add(outN.circle);

        }

        return circlesNeurons;
    }

    private ArrayList<Node> drawSynapses() {

        ArrayList<Node> lineSynapses = new ArrayList<>();


        return lineSynapses;
    }
}