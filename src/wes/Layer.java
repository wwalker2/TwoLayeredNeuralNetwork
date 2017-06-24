package wes;

import java.util.ArrayList;

/**
 * Created by wes19_000 on 6/14/2017.
 */
public class Layer {
    public Neuron[] getNeurons() {
        return neurons;
    }

    public void setNeurons(Neuron[] neurons) {
        this.neurons = neurons;
    }

    private Neuron[] neurons;
    private ArrayList<Double> weights;

    public Layer(){
        setNeurons(new Neuron[2]);
        initilize();
    }

    public Layer(int n){
        setNeurons(new Neuron[n]);
        setWeights(new ArrayList<>());
        initilize();
    }

    //Gives each neuron a number of weight values (the total # weights in the layer / the total # neurons in the layer).
    public void giveWeights(){
        int weightsGiven = weights.size()/neurons.length;
        int i,j;
        for(i = 0; i < weights.size(); i++){
            for (j = 0; j < weightsGiven; j++){
                neurons[j].getWeights().add(weights.get(i));
            }
        }
    }

    //Declares N Neurons in the neurons array.
    public void initilize(){
        for (int i = 0; i < neurons.length; i++){
            neurons[i] = new Neuron();
        }
    }


    public ArrayList<Double> getWeights() {
        return weights;
    }

    public void setWeights(ArrayList<Double> weights) {
        this.weights = weights;
    }
}
