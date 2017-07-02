package wes;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Welcome to Java Neural Network.\n");
        Scanner in = new Scanner(System.in);

        System.out.println("Please choose the number of input values you will be using.\n");
        int numInputs = in.nextInt();

        System.out.println("Choose the input values.");
        double[] inputs = new double[numInputs];
        setInputs(inputs);

        System.out.println("Choose how many layers you want.");
        int layers = in.nextInt();

        System.out.println("Select how many neurons are in each layer.");
        int[] neuronsPerLayer = new int[layers];
        howManyNeurons(neuronsPerLayer);

        System.out.println("Set the learning rate.");
        double learningrate = in.nextDouble();

        System.out.println("Choose a target value.");
        double target = in.nextDouble();

        System.out.println("Choose an activation function. (1 for Linear, 2 for Logistic)");
        int actFunct = in.nextInt();

        NeuralNetwork neuralNetwork = new NeuralNetwork(learningrate,target, actFunct);
        neuralNetwork.addLayers(layers,neuronsPerLayer);

        System.out.println("Starting forward propagation.");
        neuralNetwork.forwardPropagation(inputs);

        System.out.println("Here are the output values.");
        neuralNetwork.printOutputs();
    }

    public static void howManyNeurons(int[] neurons){
        Scanner keyboard = new Scanner(System.in);
        for (int i = 0; i < neurons.length; i++) {
            neurons[i] = keyboard.nextInt();
        }
    }

    public static void setInputs(double[] inputs){
        Scanner keyboard = new Scanner(System.in);
        for (int i = 0; i < inputs.length; i++) {
            inputs[i] = keyboard.nextDouble();
        }
    }
}
