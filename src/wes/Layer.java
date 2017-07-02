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

    public class Neuron {
        private double val;
        private ArrayList<Double> weights;

        public Neuron() {
            setVal(0);
            setWeights(new ArrayList<>());
        }

        public Neuron(double v) {
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

        //Returns a select weight value.
        public double getWeight(int weight) {
            return weights.get(weight);
        }
    }

    private ArrayList<Neuron> neurons;

    public Layer(int num) {
        setNeurons(new ArrayList<>());
        initilizeLayer(num);
    }

    public void initilizeLayer(int num) {
        int i;

        for (i = 0; i < num; i++) {
            getNeurons().add(new Neuron());
        }
    }

    //Gives each neuron in the layer random weight values.
    public void giveWeights(Layer nxtLayer) {
        Random random = new Random();
        for (int i = 0; i < getNeurons().size(); i++) {
            for (int j = 0; j < nxtLayer.getNeurons().size(); j++) {
                getNeurons().get(i).getWeights().add(random.nextDouble());
            }
        }
    }

    //Sets the values in an array as the values for each neuron in a layer.
    public void giveValues(double[] inputs) {
        int i;
        for (i = 0; i < getNeurons().size(); i++) {
            getNeurons().get(i).setVal(inputs[i]);
        }
    }

    //Calculates the output values for the current layer.
    public double[] calculate(Layer nxtLayer, int actFunct) {
        double[] outputs = new double[nxtLayer.getNeurons().size()];
        int i, j;

        for (i = 0; i < outputs.length; i++) {
            double x = 0;
            for (j = 0; j < this.getNeurons().size(); j++) {
                x += this.getNeurons().get(j).getVal() * this.getNeurons().get(j).getWeight(i);
            }
            if (actFunct == 1) {
                outputs[i] = linearFunction(x);
            } else if (actFunct == 2) {
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

    //Calculates how much to update a weight by.
    public double weightUpdate(double target, double learnRate, double output, int weight) {
        double error = target - output;

        int i, j;
        double x = 0;
        for (i = 0; i < this.getNeurons().size(); i++) {
            x += this.getNeurons().get(i).getWeight(weight) * this.getNeurons().get(i).getVal();

        }
        double logistic = logisticFunction(x);

        double update = -learnRate * (-error * (logistic * (1 - logistic)) * output);

        return update;
    }

    //Updates all the weight values for each of the layer's neurons.
    public void updateWeights(double target, double learnRate, Layer outLayer) {
        int i, j;

        for (i = 0; i < this.getNeurons().size(); i++) {
            int weight = 0;
            for (j = 0; j < this.getNeurons().get(i).weights.size(); j++) {
                double newWeight = this.getNeurons().get(i).getWeight(j) + this.weightUpdate(target, learnRate, outLayer.getNeurons().get(weight).getVal(), weight);
                this.getNeurons().get(i).getWeights().set(j, newWeight);
                weight++;
            }
        }
    }
}
