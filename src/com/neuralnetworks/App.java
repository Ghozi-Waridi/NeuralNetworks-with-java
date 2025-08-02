package com.neuralnetworks;

import java.text.DecimalFormat;
import java.util.concurrent.ThreadLocalRandom;

import com.neuralnetworks.math.Tensor;

public class App {
  public static void main(String[] args) {
    // Membuat tensor integer 2x3 yang berisi nol
    System.out.println("Membuat Tensor Integer 2x3...");
    Tensor<Integer> intZeros = Tensor.zeros(Integer.class, 2, 3);
    System.out.println(intZeros);

    System.out.println("\n----------------------------------\n");

    // Membuat tensor double 3x4 yang berisi nol
    System.out.println("Membuat Tensor Double 3x4...");
    Tensor<Double> doubleZeros = Tensor.ones(Double.class, 3, 4);
    System.out.println(doubleZeros);

    System.out.println("\n----------------------------------\n");
    System.out.println("Contoh penggunaan Random di java");

    Tensor<Double> weight = Tensor.random(5, 5);
    System.out.println(weight);

  }
}
