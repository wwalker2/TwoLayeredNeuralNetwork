package wes;

import java.util.Random;

/**
 * Created by wes19_000 on 6/10/2017.
 */
class Layer{
    public Neuron[] getNeurons() {
        return neurons;
    }

    public void setNeurons(Neuron[] neurons) {
        this.neurons = neurons;
    }

    class Neuron{
        private double val;

        public Neuron(double in){
            setVal(in);
        }
        public Neuron(){
            setVal(0);
        }

        public double getVal() {
            return val;
        }

        public void setVal(double val) {
            this.val = val;
        }
    }

    private Neuron[] neurons;

    public Layer(){
        setNeurons(new Neuron[2]);
        initilize();
    }

    public Layer(int n){
        setNeurons(new Neuron[n]);
        initilize();
    }

    public void initilize(){
        for (int i = 0; i < neurons.length; i++){
            neurons[i] = new Neuron();
        }
    }

    public void fillLayer(double v1, double v2){
        getNeurons()[0].setVal(v1);
        getNeurons()[1].setVal(v2);
    }
}

public class NeuralNetwork {


    private Layer[] layers;

    public NeuralNetwork(){
        layers = new Layer[2];
        initilize();
    }

    public void initilize(){
        for(int i = 0; i < layers.length; i++){
            layers[i] = new Layer();
        }
    }

    public double calcNeurons(Layer.Neuron n1, Layer.Neuron n2){
        Random random = new Random();

        double x = (n1.getVal() * random.nextDouble()) + (n2.getVal() * random.nextDouble());
        //double x = (n1.getVal() * 0.9) + (n2.getVal() * 0.3);
        //double x = (n1.getVal() * 0.2) + (n2.getVal() * 0.8);
        double y = 1/(1 + Math.pow(2.71828, -x));

        return y;
    }

    public void calcLayer(double n1, double n2){
        layers[0].fillLayer(n1,n2);
        layers[1].fillLayer(calcNeurons(layers[0].getNeurons()[0], layers[0].getNeurons()[1]), calcNeurons(layers[0].getNeurons()[0], layers[0].getNeurons()[1]));
    }
}
