package wes;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by wes19_000 on 6/30/2017.
 */
public class Layer {

    public ArrayList<Neuron> getNeurons() {
        return neurons;
    }

    public void setNeurons(ArrayList<Neuron> neurons) {
        this.neurons = neurons;
    }

    public class Neuron{
        private double val;
        private ArrayList<Double> weights;

        public Neuron(){
            setVal(0);
            setWeights(new ArrayList<>());
        }
        public Neuron(double v){
            setVal(v);
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

        public double getWeight(int weight){
            return weights.get(weight);
        }
    }

    private ArrayList<Neuron> neurons;

    public Layer(int num){
        setNeurons(new ArrayList<>());
        initilizeLayer(num);
    }

    public void initilizeLayer(int num){
        int i;

        for (i = 0; i < num; i++) {
            getNeurons().add(new Neuron());
        }
    }

    public void giveWeights(Layer nxtLayer){
        Random random = new Random();
        for (int i = 0; i < getNeurons().size(); i++) {
            for (int j = 0; j < nxtLayer.getNeurons().size(); j++) {
                getNeurons().get(i).getWeights().add(random.nextDouble());
            }
        }
    }

    public void giveValues(double[] inputs){
        int i;
        for(i = 0; i < getNeurons().size(); i++){
            getNeurons().get(i).setVal(inputs[i]);
        }
    }

    public double[] calculate(Layer nxtLayer, int actFunct){
        double[] outputs = new double[nxtLayer.getNeurons().size()];
        int i,j;

        for (i = 0; i < outputs.length; i++){
            double x = 0;
            for (j = 0; j < this.getNeurons().size(); j++){
                x += this.getNeurons().get(j).getVal() * this.getNeurons().get(j).getWeight(i);
            }
            if(actFunct == 1){
                outputs[i] = linearFunction(x);
            } else if (actFunct == 2){
                outputs[i] = logisticFunction(x);
            }
        }
        return outputs;
    }

    //Uses the Logistic activation function.
    public double logisticFunction(double x) {
        return (1 / (1 + Math.pow(Math.E, -x)));
    }

    //Uses the Linear activation function.
    public double linearFunction(double x) {
        return x;
    }
}
