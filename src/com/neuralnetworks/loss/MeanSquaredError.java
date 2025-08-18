package com.neuralnetworks.loss;

import com.neuralnetworks.math.Tensor;

import java.util.ArrayList;
import java.util.List;

/**
 * MeanSquaredError
 */

public class MeanSquaredError implements LossFunction<Tensor<Double>> {

  @Override
  public Tensor<Double> derivative(Tensor<Double> x, Tensor<Double> y) {
    int width = x.getInternalData().size();
    int height = y.getShapeArray()[0];
    System.out.println("Shape array dari COST : ");
    y.getShape();

    double[] hasil = new double[height * width];

    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {

        int oneDIndex = i * width + j;

        double angka1 = x.get(j);
        int index = y.linearIndex(i, j);
        double angka2 = y.get(index);

        hasil[oneDIndex] = angka1 - angka2;
      }
    }

    Tensor<Double> result = Tensor.fromArray(hasil, height, width);
    return result;
  }
}
