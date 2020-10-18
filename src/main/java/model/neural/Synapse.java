package model.neural;

import javafx.scene.shape.Line;

public class Synapse {
     private double weight;
     private Neuron lNeuron;
     private Neuron rNeuron;

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

    public Neuron getlNeuron() {
        return lNeuron;
    }

    public void setlNeuron(Neuron lNeuron) {
        this.lNeuron = lNeuron;
    }

    public Neuron getrNeuron() {
        return rNeuron;
    }

    public void setrNeuron(Neuron rNeuron) {
        this.rNeuron = rNeuron;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setLNeuron(Neuron lNeuron) {
        this.lNeuron = lNeuron;
    }

    public void setRNeuron(Neuron rNeuron) {
        this.rNeuron = rNeuron;
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
