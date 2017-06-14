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

        for(i = 0; i < amt; i++){
            double val = in.nextDouble();
            neuralNetwork.getLayers()[0].getNeurons()[i].setVal(val);
        }
        neuralNetwork.calcLayer();

        System.out.println("The outputs for each Neuron are: ");
        for (i = 0; i < neuralNetwork.getLayers()[1].getNeurons().length; i++){
            System.out.println("\t" + neuralNetwork.getLayers()[1].getNeurons()[i].getVal());
        }
        System.out.println("Calculation completed.");
    }
}
