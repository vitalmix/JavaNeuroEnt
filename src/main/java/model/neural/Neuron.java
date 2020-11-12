package model.neural;

import javafx.scene.shape.Circle;

import java.util.ArrayList;

public class Neuron {
    private double weight;
    private double DeltaWeight;
    public ArrayList<Synapse> rightSynapses;
    public ArrayList<Synapse> leftSynapses;
    private char position;

    //---------------For drawing

    public Circle circle;
    public int x;
    public int y;

    public Neuron(double weight, char position) {
        this.position = position;
        rightSynapses = new ArrayList<>();
        leftSynapses = new ArrayList<>();
        this.weight = weight;
    }

    public double getRightSynNeuronsWeight() {
        double rez = 0;

        for (Synapse s :
                rightSynapses) {
           rez = rez + s.getRightNeuronWeight();
        }
        return rez;
    }

    public ArrayList<Synapse> getRightSynapses() {
        return rightSynapses;
    }

    public void setRightSynapses(ArrayList<Synapse> rightSynapses) {
        this.rightSynapses = rightSynapses;
    }

    public char getPosition() {
        return position;
    }

    public void setPosition(char position) {
        this.position = position;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getDeltaWeight() {
        return DeltaWeight;
    }

    public void setDeltaWeight(double deltaWeight) {
        DeltaWeight = deltaWeight;
    }
}
