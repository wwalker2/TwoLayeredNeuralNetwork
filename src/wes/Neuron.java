package wes;

import java.util.ArrayList;

/**
 * Created by wes19_000 on 6/14/2017.
 */
public class Neuron {
    private double val;
    private ArrayList<Double> weights;

    public Neuron(double in){
        setVal(in);
        setWeights(new ArrayList<>());
    }
    public Neuron(){
        setVal(0);
        setWeights(new ArrayList<>());
    }

    public double getVal() {
        return val;
    }

    public void setVal(double val) {
        this.val = val;
    }

    public ArrayList<Double> getWeights() {
        return weights;
    }

    public void setWeights(ArrayList<Double> weights) {
        this.weights = weights;
    }
}
