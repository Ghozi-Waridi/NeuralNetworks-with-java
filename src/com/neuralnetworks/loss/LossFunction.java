package com.neuralnetworks.loss;

import com.neuralnetworks.math.Tensor;
/**
 * LossFunction
 */
public interface LossFunction<T> {
  T derivative(Tensor<Double> x, Tensor<Double> y); 
}
