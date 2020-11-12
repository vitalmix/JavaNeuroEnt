package model.neural;

import model.Const;

import java.util.ArrayList;

public class BackPropagation {

    public double setOutputDelta(double ideal, double actual){

        return (ideal - actual) * fSigmoid(actual);
    }

    public double setHideDelta(double neuronWeight, double rightNeuronsWeight) {

        return fSigmoid(neuronWeight) * rightNeuronsWeight;
    }

    public double fSigmoid(double actual){
        return (1 - actual) * actual;
    }



    public void calcOutputNeuronsDelta(ArrayList<Neuron> neurons) {

        for (Neuron outputNeuron: neurons) {
            outputNeuron.setDeltaWeight(setOutputDelta(1,outputNeuron.getWeight()));
            System.out.println("OUT DELTA: " + outputNeuron.getDeltaWeight());
        }
    }

    public void calcHideNeuronsDelta(ArrayList<Neuron> neurons) {

        for (Neuron hideNeuron :
                neurons) {
            hideNeuron.setDeltaWeight(setHideDelta(hideNeuron.getWeight(), hideNeuron.getRightSynNeuronsWeight()));
            System.out.println("HIDE DELTA: " + hideNeuron.getDeltaWeight());
        }

    }

    public void calcGradForSynapses(ArrayList<Neuron> neurons) {
        for (Neuron hideNeuron :
                neurons) {
            for (Synapse s :
                    hideNeuron.rightSynapses) {
                s.setGrad(hideNeuron.getWeight() * s.getRightNeuronDelta());
                System.out.println("SYNAPSE GRAD: " + s.getGrad());
            }
        }


    }

    public void calcDeltaForSynapses(ArrayList<Neuron> neurons) {

        for (Neuron hideNeuron :
                neurons) {
            for (Synapse s :
                    hideNeuron.rightSynapses) {
                s.setDeltaWeight(Const.EPSILON * s.getGrad() + Const.ALPHA * s.getPastWeight());
                System.out.println("PAST WEIGHT: " + s.getPastWeight());
                System.out.println("SYNAPSE DELTA: " + s.getDeltaWeight());
            }
        }

    }

    public void changeSynapseWeight(ArrayList<Neuron> neurons) {
        for (Neuron hideNeuron :
                neurons) {
            for (Synapse s :
                    hideNeuron.rightSynapses) {
                s.setWeight(s.getWeight() + s.getDeltaWeight());
                System.out.println("NEW SYNAPSE WEIGHT: " + s.getWeight());
            }
        }

    }
}
