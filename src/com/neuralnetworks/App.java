package com.neuralnetworks;

import com.neuralnetworks.math.Tensor;
import com.neuralnetworks.math.TensorMath;

public class App {
  public static void main(String[] args) {

    double[] data = { 1.0, 2.0, 3.0, 4.0, 5.0, 6.0 };
    double[] data3 = { 10.0, 20.0, 30.0, 40.0, 50.0, 60.0 };
    double[] data2 = { 1.0, 2.0, 3.0, 4.0, 5.0, 6.0 };
    Tensor<Double> tensor = Tensor.fromArray(data, 2, 3);
    Tensor<Double> tensor2 = Tensor.fromArray(data2, 2, 3);

    Tensor<Double> hasilPenjumlahan = TensorMath.add(tensor, tensor2);

    System.out.println("Hasil Penjumlahan Tensor:" + hasilPenjumlahan);

    Tensor<Double> tensor3 = Tensor.fromArray(data3, 2, 3);
    Tensor<Double> hasilPengurangan = TensorMath.subtract(tensor3, tensor);
    System.out.println("Hasil Pengurangan Tensor: " + hasilPengurangan);

    Tensor<Double> hasilPerkalian = TensorMath.multiply(tensor, tensor2);
    System.out.println("Hasil Perkalian Tensor: " + hasilPerkalian);

    tensor2.reshape(3, 2);
    System.out.println("Tensor 1" + tensor);
    System.out.println("Tensor 2 " + tensor2);
    Tensor<Double> hasilDot = TensorMath.dotProduct(tensor, tensor2);
    System.out.println("Hasil Dot Product Tensor: " + hasilDot);

  }
}
