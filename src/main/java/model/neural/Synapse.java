package model.neural;

import javafx.scene.shape.Line;

public class Synapse {
     private double weight;
     private double deltaWeight;
     private Neuron lNeuron;
     private Neuron rNeuron;
     private double grad;
     private double pastWeight = 0;

    //---------------For drawing

    public Line line;

      public Synapse(double weight, Neuron lNeuron, Neuron rNeuron){
          this.weight = weight;
          this.lNeuron = lNeuron;
          this.rNeuron = rNeuron;

      }

    public double getNeuronSynapseWeight(){
          return lNeuron.getWeight() * rNeuron.getWeight();
    }

    public double getNeuronSynapseWeightTest(){
        return lNeuron.getWeight() * this.weight;
    }

    public double getRightNeuronDelta() {
          return rNeuron.getDeltaWeight();
    }

    public double getRightNeuronWeight() {
        return rNeuron.getWeight();
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
          //pastWeight = this.weight;
          this.weight = weight;
    }

    public double getGrad() {
        return grad;
    }

    public void setGrad(double grad) {
        this.grad = grad;
    }

    public double getPastWeight() {
        return pastWeight;
    }

    public void setPastWeight(double pastWeight) {
        this.pastWeight = pastWeight;
    }

    public double getDeltaWeight() {
        return deltaWeight;
    }

    public void setDeltaWeight(double deltaWeight) {
        this.deltaWeight = deltaWeight;
    }

    //---------------For drawing

    public int getRNeuronX() {
          return rNeuron.x;
    }

    public int getRNeuronY() {
          return rNeuron.y;
    }

    public int getLNeuronX() {
        return lNeuron.x;
    }

    public int getLNeuronY() {
        return lNeuron.y;
    }

}
