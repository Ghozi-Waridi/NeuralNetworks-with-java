package com.neuralnetworks.activations;

import com.neuralnetworks.math.Tensor;

public class Relu {

  public static Tensor<Double> forward(Tensor<Double> input) {
    return input.map(value -> value > 0 ? value : 0);
  }

  public static Tensor<Double> derivative(Tensor<Double> outputGradient) {
    return outputGradient.map(value -> value > 0 ? 1.0 : 0.0);
  }
}
