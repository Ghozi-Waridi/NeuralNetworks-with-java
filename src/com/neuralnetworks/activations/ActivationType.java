package com.neuralnetworks.activations;

import com.neuralnetworks.math.Tensor;
import com.neuralnetworks.math.TensorMath;

public enum ActivationType implements ActivationFunction {
  RELU {
    private Tensor<Double> lastInput = null;

    @Override
    public Tensor<Double> forward(Tensor<Double> input) {
      this.lastInput = input;
      return Relu.forward(input);
    }

    @Override
    public Tensor<Double> backward(Tensor<Double> outputGradient) {
      if (lastInput == null) {
        throw new IllegalStateException("Metode forward harus dipanggil sebelum backward.");
      }
      Tensor<Double> localDerivative = Relu.derivative(this.lastInput);

      return TensorMath.multiply(outputGradient, localDerivative);
    }
  }
}
