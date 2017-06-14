package wes;

/**
 * Created by wes19_000 on 6/14/2017.
 */
public class Neuron {
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
