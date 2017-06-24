package wes;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Welcome to Multi-Layered Neural Network");
        Scanner in = new Scanner(System.in);

        System.out.println("Enter the amount of input values.");
        int amt = in.nextInt();

        System.out.println("Enter the number of layers.");
        int layers = in.nextInt();

        NeuralNetwork neuralNetwork = new NeuralNetwork(layers);

        System.out.println("Enter input values.");
        double[] inputs = new double[amt];
        enterInputs(inputs);
        neuralNetwork.startNetwork(inputs);

        double[] outputs = neuralNetwork.calculate();
        System.out.println("The outputs for each Neuron are: ");
        printOutputs(outputs);

        System.out.println("Calculation completed.");

    }

    public static void enterInputs(double[] inputs) {
        Scanner keyboard = new Scanner(System.in);
        for (int i = 0; i < inputs.length; i++) {
            inputs[i] = keyboard.nextDouble();
        }
    }

    public static void printOutputs(double[] outputs) {
        for (int i = 0; i < outputs.length; i++) {
            System.out.println(outputs[i]);
        }
    }
}
