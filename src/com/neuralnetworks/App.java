package com.neuralnetworks;

import com.neuralnetworks.math.Tensor;
import com.neuralnetworks.math.TensorMath;

public class App {
  public static void main(String[] args) {

    double[] data = { 1.0, 2.0, 3.0, 4.0, 5.0, 6.0 };
    double[] data2 = { 1.0, 2.0, 3.0, 4.0, 5.0, 6.0 };
    Tensor<Double> tensor = Tensor.fromArray(data, 2, 3);
    Tensor<Double> tensor2 = Tensor.fromArray(data2, 2, 3);

    Tensor<Double> hasilPenjumlahan = TensorMath.add(tensor, tensor2);

    System.out.println("Hasil Penjumlahan Tensor:" + hasilPenjumlahan);
  }
}
