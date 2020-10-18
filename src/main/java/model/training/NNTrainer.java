package model.training;

import model.neural.NeuralNetworkImpl;
import model.neural.Neuron;
import model.neural.Synapse;
import model.trainingData.Image;
import model.trainingData.ImageImpl;

public class NNTrainer {
     NeuralNetworkImpl neuralNetwork = new NeuralNetworkImpl();
     ImageImpl trainingImage = new ImageImpl();

    public NNTrainer() {

        //startTraining();
        setTestData();

    }
    
    private void setTestData() {
        neuralNetwork.hideNeurons1.get(0).setWeight(1);
        neuralNetwork.hideNeurons2.get(0).leftSynapses.get(0).setWeight(0.45);
        neuralNetwork.hideNeurons2.get(0).leftSynapses.get(1).setWeight(-0.12);
        neuralNetwork.hideNeurons2.get(1).leftSynapses.get(0).setWeight(0.78);
        neuralNetwork.hideNeurons2.get(1).leftSynapses.get(1).setWeight(0.13);

        neuralNetwork.hideNeurons1.get(1).setWeight(0);
        //neuralNetwork.hideNeurons1.get(1).rightSynapses.get(0).setWeight(0.48);
        //neuralNetwork.hideNeurons1.get(1).rightSynapses.get(1).setWeight(0.13);

        neuralNetwork.hideNeurons2.get(0).setWeight(0);
        neuralNetwork.hideNeurons2.get(0).rightSynapses.get(0).setWeight(1.5);

        neuralNetwork.hideNeurons2.get(1).setWeight(0);
        neuralNetwork.hideNeurons2.get(1).rightSynapses.get(0).setWeight(-2.3);

        trainingHide2Test();
        trainingOutPutTest();
        System.out.println("ERROR:" + getError(neuralNetwork.outputNeurons.get(0).getWeight())  * 100 + "");

    }

    private void setInputData(Image inputImg) {

        int i = 0;
        for (Neuron n :
                neuralNetwork.inputNeurons) {
            n.setWeight(inputImg.images[i]);
            i++;
        }
    }

    private void trainingHide1() {

        double buff = 0;
        for (Neuron n :
                neuralNetwork.hideNeurons1) {
            for (Synapse s :
                    n.rightSynapses) {
                buff = buff + s.getNeuronSynapseWeight();
            }
            n.setWeight(normalizeSigmoidFunc(buff));
            buff = 0;



        }
    }

    private void trainingHide2() {
        double buff = 0;

        for (Neuron n :
                neuralNetwork.hideNeurons2) {
            for (Synapse s :
                    n.rightSynapses) {
                buff = buff + s.getNeuronSynapseWeight();
            }
            n.setWeight(normalizeSigmoidFunc(buff));
            buff = 0;

        }

    }

    private void trainingHide2Test() {
        double buff = 0;

        for (Neuron n :
                neuralNetwork.hideNeurons2) {
            for (Synapse s :
                    n.leftSynapses) {
                buff = buff + s.getNeuronSynapseWeightTest();
            }
            n.setWeight(normalizeSigmoidFunc(buff));
            buff = 0;
            System.out.println("W H2 :  " + n.getWeight());
        }

    }

    private void trainingOutPutTest() {
        double buff = 0;
        for (Neuron n :
                neuralNetwork.outputNeurons) {
            for (Synapse s :
                    n.leftSynapses) {
                buff = buff + s.getNeuronSynapseWeightTest();
            }
            n.setWeight(normalizeSigmoidFunc(buff));
            buff = 0;
            System.out.println("W:  " + n.getWeight());
        }
    }

    private void trainingOutPut() {
        double buff = 0;
        for (Neuron n :
                neuralNetwork.outputNeurons) {
            for (Synapse s :
                    n.leftSynapses) {
                buff = buff + s.getNeuronSynapseWeight();
            }
            n.setWeight(normalizeSigmoidFunc(buff));
            buff = 0;
            System.out.println("W:  " + n.getWeight());
        }
    }

    private double normalizeSigmoidFunc(double x) {

        double E = 2.718281828;

        return 1 / (1 + Math.pow(E,-x));

    }

    private double getError(double answer) {
        double z = 1;
        int countOfAnswers = 1;

        double res = 0;

        for (int i = 0; i < answer; i++) {
            res += Math.pow(z - answer,2);
            res /= countOfAnswers;
        }

        return res;
    }

    private void startTraining() {

        for (Image i :
                trainingImage.images) {
            setInputData(i);
            trainingHide1();
            trainingHide2();
            trainingOutPut();
            System.out.println("Iteration-------------------");
        }
    }

}
