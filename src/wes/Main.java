package wes;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Welcome to Two Layered Neural Network");
        Scanner in = new Scanner(System.in);
        int i;

        System.out.println("Enter the amount of input values.");
        int amt = in.nextInt();

        System.out.println("Enter input values.");
        NeuralNetwork neuralNetwork = new NeuralNetwork(amt);
        double[] inputs = new double[amt];

        for(i = 0; i < amt; i++){
            inputs[i] = in.nextDouble();
        }
        neuralNetwork.startNetwork(inputs);

        double[] ouputs = neuralNetwork.calculate();
        System.out.println("The outputs for each Neuron are: ");
        for(i = 0; i < ouputs.length; i++){
            System.out.println(ouputs[i]);
        }
        System.out.println("Calculation completed.");
    }
}
