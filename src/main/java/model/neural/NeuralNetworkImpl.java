package model.neural;

import model.Const;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class NeuralNetworkImpl {
    public ArrayList<Neuron> inputNeurons = new ArrayList<>();
    public ArrayList<Neuron> hideNeurons1 = new ArrayList<>();
    public ArrayList<Neuron> hideNeurons2 = new ArrayList<>();
    public ArrayList<Neuron> outputNeurons = new ArrayList<>();

    public NeuralNetworkImpl() {
        neuronImpl();
        synapseImpl();
    }

    private void neuronImpl() {

        int dy = 0;

        for (int i = 0; i < Const.INPUT_L; i++) {
            inputNeurons.add(new Neuron(nextFloatBetween(),'I'));
            inputNeurons.get(i).x = 50;
            inputNeurons.get(i).y = 50 - dy;
            dy = dy - 70;
        }

        dy = 0;

        for (int i = 0; i < Const.HIDE1_L; i++) {
            hideNeurons1.add(new Neuron(nextFloatBetween(),'1'));
            hideNeurons1.get(i).x = 200;
            hideNeurons1.get(i).y = 120 - dy;
            hideNeurons2.add(new Neuron(nextFloatBetween(),'2'));
            hideNeurons2.get(i).x = 350;
            hideNeurons2.get(i).y = 120 - dy;
            dy = dy - 70;
        }

        dy = 0;

        for (int i = 0; i < Const.OUTPUT_L; i++) {
            outputNeurons.add(new Neuron(nextFloatBetween(),'O'));
            outputNeurons.get(i).x = 500;
            outputNeurons.get(i).y = 90 - dy;
            dy = dy - 70;
        }
    }

    private void synapseImpl() {

        for (Neuron inputN :
                inputNeurons) {
            for (Neuron hide1N :
                    hideNeurons1) {
                Synapse synapse = new Synapse(nextFloatBetween(), inputN, hide1N);
                inputN.rightSynapses.add(synapse);
                hide1N.leftSynapses.add(synapse);
            }
        }
        for (Neuron hide1N :
                hideNeurons1) {
            for (Neuron hide2N :
                    hideNeurons2) {
                Synapse synapse = new Synapse(nextFloatBetween(), hide1N, hide2N);
                hide1N.rightSynapses.add(synapse);
                hide2N.leftSynapses.add(synapse);
            }
        }

        for (Neuron hide2N :
                hideNeurons2) {
            for (Neuron outputN :
                    outputNeurons) {
                Synapse synapse = new Synapse(nextFloatBetween(), hide2N, outputN);
                hide2N.rightSynapses.add(synapse);
                outputN.leftSynapses.add(synapse);
            }
        }
    }

    private static double nextFloatBetween() {
        double min = 0f;
        double max = 0.5f;
        return (ThreadLocalRandom.current().nextFloat() * (max - min)) + min;
    }
}
