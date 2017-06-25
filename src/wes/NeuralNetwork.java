package wes;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by wes19_000 on 6/10/2017.
 */


public class NeuralNetwork {


    private Layer[] layers;
    private int actFunc;

    public NeuralNetwork() {
        setLayers(new Layer[2]);
        initilize();
    }

    public NeuralNetwork(int l, int af) {
        setLayers(new Layer[l]);
        actFunc = af;
        initilize();
        giveWeights();
    }


    //Gives each layer a number of weight values determined by the product of # neurons in the first layer and the # in the next layer.
    private void giveWeights() {
        Random random = new Random();
        int i, j;
        for (i = 0; i < layers.length - 1; i++) {
            int numofWeights = (layers[i].getNeurons().length * layers[i + 1].getNeurons().length);
            for (j = 0; j < numofWeights; j++) {
                layers[i].getWeights().add(random.nextDouble());
            }
        }
    }

    //Declares N Layers in the layers array with N number of Neurons.
    public void initilize() {
        Scanner keyboard = new Scanner(System.in);

        for (int i = 0; i < getLayers().length; i++) {
            System.out.println("Enter the number of neurons in layer " + (i + 1));
            int n = keyboard.nextInt();
            getLayers()[i] = new Layer(n);
        }
    }


    //Sets each Neuron's value to an input value.
    public void startNetwork(double[] inputs) {
        for (int i = 0; i < inputs.length; i++) {
            getLayers()[0].getNeurons()[i].setVal(inputs[i]);
        }
    }


    //Multiplies the value of each Neuron in the first Layer times a random weight value and returns the logisticFunction function result.
    public double calcNeurons(Layer layer, int weight) {
        layer.giveWeights();
        double x = 0;

        for (int i = 0; i < layer.getNeurons().length; i++) {
            x += (layer.getNeurons()[i].getVal() * layer.getNeurons()[i].getWeights().get(weight));
        }


        double y = 0;
        switch (actFunc) {
            case 1:
                y = linearFunction(x);
                break;
            case 2:
                y = logisticFunction(x);
                break;

            default:
                break;
        }

        return y;
    }

    //Uses the Logistic activation function.
    public double logisticFunction(double x) {
        return (1 / (1 + Math.pow(Math.E, -x)));
    }

    //Uses the Linear activation function.
    public double linearFunction(double x) {
        return x;
    }

    //Sets the values of the next Layer to the results of calcNeurons.
    public double[] calculate() {
        int i, j;
        double[] output = new double[layers[layers.length - 1].getNeurons().length];

        for (i = 1; i < layers.length; i++) {
            int weight = 0;
            for (j = 0; j < layers[i].getNeurons().length; j++) {
                layers[i].getNeurons()[j].setVal(calcNeurons(layers[i - 1], weight));
                weight++;
            }
        }

        for (i = 0; i < layers[layers.length - 1].getNeurons().length; i++) {
            output[i] = layers[layers.length - 1].getNeurons()[i].getVal();
        }

        return output;
    }

    public Layer[] getLayers() {
        return layers;
    }

    public void setLayers(Layer[] layers) {
        this.layers = layers;
    }

    public void backprop() {

    }
}
