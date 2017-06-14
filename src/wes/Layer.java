package wes;

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

    public Layer(){
        setNeurons(new Neuron[2]);
        initilize();
    }

    public Layer(int n){
        setNeurons(new Neuron[n]);
        initilize();
    }

    //Declares N Neurons in the neurons array.
    public void initilize(){
        for (int i = 0; i < neurons.length; i++){
            neurons[i] = new Neuron();
        }
    }


}
