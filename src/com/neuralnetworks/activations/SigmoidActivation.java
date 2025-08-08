package com.neuralnetworks.activations;

import com.neuralnetworks.math.Tensor;
import com.neuralnetworks.math.TensorMath;

public class SigmoidActivation implements ActivationFunction {
    private Tensor<Double> lastOutput; 

    @Override
    public Tensor<Double> forward(Tensor<Double> input) {
        this.lastOutput = input;
          return input.map(a -> 1.0 / (1.0 + Math.exp(-a)));    }

    @Override
    public Tensor<Double> backward(Tensor<Double> outputGradient) {
        if (lastOutput == null) {
            throw new IllegalStateException("Metode forward harus dipanggil sebelum backward.");
        }
        Tensor<Double> localDerivative = this.lastOutput.map( s -> s * (1.0 - s));
        return TensorMath.multiply(outputGradient, localDerivative);
    }
}
