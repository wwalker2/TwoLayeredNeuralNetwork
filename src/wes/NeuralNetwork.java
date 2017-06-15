package wes;

import java.util.Random;

/**
 * Created by wes19_000 on 6/10/2017.
 */


public class NeuralNetwork {


    private Layer[] layers;

    public NeuralNetwork(){
        setLayers(new Layer[2]);
        initilize();
    }

    public NeuralNetwork(int n){
        setLayers(new Layer[2]);
        initilize(n);
    }

    //Declares two Layers in the layers array with N number of Neurons.
    public void initilize(int n){
        for(int i = 0; i < getLayers().length; i++){
            getLayers()[i] = new Layer(n);
        }
    }

    //Declares two Layers in the layers array.
    public void initilize(){
        for(int i = 0; i < getLayers().length; i++){
            getLayers()[i] = new Layer();
        }
    }

    //Sets each Neuron's value to an input value.
    public void startNetwork(double[] inputs){
        for(int i = 0; i < inputs.length; i++){
            getLayers()[0].getNeurons()[i].setVal(inputs[i]);
        }
    }

    //Multiplies the value of each Neuron in the first Layer times a random weight value and returns the logistic function result.
    public double calcNeurons(){
        Random random = new Random();
        double x = 0;
        for(int i = 0; i < layers[0].getNeurons().length; i++){
           x += (layers[0].getNeurons()[i].getVal() * random.nextDouble());
        }

        //double x = (n1.getVal() * 0.9) + (n2.getVal() * 0.3);
        //double x = (n1.getVal() * 0.2) + (n2.getVal() * 0.8);
        double y = 1/(1 + Math.pow(Math.E, -x));

        return y;
    }

    //Sets the values of the second Layer to the results of calcNeurons.
    public double[] calculate(){
        int i;
        double[] output = new double[layers[0].getNeurons().length];
        for (i = 0; i < layers[1].getNeurons().length; i++){
            layers[1].getNeurons()[i].setVal(calcNeurons());
        }
        for (i = 0; i < layers[1].getNeurons().length; i++){
            output[i] = layers[1].getNeurons()[i].getVal();
        }
        return output;
    }

    public Layer[] getLayers() {
        return layers;
    }

    public void setLayers(Layer[] layers) {
        this.layers = layers;
    }
}
