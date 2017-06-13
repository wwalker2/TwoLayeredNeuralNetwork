package wes;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Welcome to Two Layered Neural Network");

        System.out.println("Enter two input values.");
        Scanner in = new Scanner(System.in);
        double val1 = in.nextDouble();
        double val2 = in.nextDouble();

        NeuralNetwork neuralNetwork = new NeuralNetwork();
        neuralNetwork.calcLayer(val1,val2);
        System.out.println("Calculation completed.");
    }
}
