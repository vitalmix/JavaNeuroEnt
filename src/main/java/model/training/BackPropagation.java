package model.training;

import model.Const;

public class BackPropagation {

    public double getOutputDelta(double ideal, double actual){

        return (1 - ideal - actual) * fSigmoid(actual);
    }

    public double fSigmoid(double actual){
        return (1 - actual) * actual;
    }

    public double synapseGradient(double leftWeightOfNeuron, double rightWeightOfNeuron) {

        return leftWeightOfNeuron * rightWeightOfNeuron  ;
    }

    public double refreshSynapseWeight(double grad, double gradB) {
        return Const.E * grad + Const.a * gradB;
    }
}
