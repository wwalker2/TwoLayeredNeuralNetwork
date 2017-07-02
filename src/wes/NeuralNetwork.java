package wes;

import java.util.ArrayList;

/**
 * Created by wes19_000 on 6/30/2017.
 */
public class NeuralNetwork {
    private ArrayList<Layer> layers;
    private double learningRate;
    private double target;
    private int actFunct;

    public NeuralNetwork(double lr, double t, int af){
        layers = new ArrayList<>();
        learningRate = lr;
        target = t;
        actFunct = af;
    }

    public void addLayers(int l, int[] neurons){
        for (int i = 0; i < l; i++) {
            layers.add(new Layer(neurons[i]));
        }
    }

    //Gives weight values to the neurons in each layer.
    public void giveWeights(){
        int i;
        for(i = 1; i < layers.size(); i++){
            layers.get(i-1).giveWeights(layers.get(i));
        }
    }

    //Implements forward propagation.
    public void forwardPropagation(double[] inputs){
        giveWeights();

        layers.get(0).giveValues(inputs);
        int i;
        for(i = 1; i < layers.size(); i++){
            double[] outputs = layers.get(i-1).calculate(layers.get(i),actFunct);
            layers.get(i).giveValues(outputs);
        }
    }

    //Outputs each value in the output layer.
    public void printOutputs(){
        for(int i = 0; i < layers.get(layers.size()-1).getNeurons().size(); i++){
            System.out.println(layers.get(layers.size()-1).getNeurons().get(i).getVal());
        }
    }

    //Implements back propagation.
    public void backPropagation(){
        int i;

        for(i = layers.size()-1; i > 0; i--){
            layers.get(i-1).updateWeights(target,learningRate,layers.get(i));
        }
    }
}
