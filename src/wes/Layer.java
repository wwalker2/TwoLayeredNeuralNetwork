package wes;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by wes19_000 on 6/30/2017.
 */
public class Layer {

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
    }

    private ArrayList<Neuron> neurons;

    public Layer(int num){
        neurons = new ArrayList<>();
        initilizeLayer(num);
    }

    public void initilizeLayer(int num){
        int i;

        for (i = 0; i < num; i++) {
            neurons.add(new Neuron());
        }
    }

    public void giveWeights(Layer nxtLayer){
        Random random = new Random();
        for (int i = 0; i < neurons.size(); i++) {
            for (int j = 0; j < nxtLayer.neurons.size(); j++) {
                neurons.get(i).getWeights().add(random.nextDouble());
            }
        }
    }
}
