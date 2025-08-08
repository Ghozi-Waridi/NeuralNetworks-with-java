package com.neuralnetworks.activations;

import com.neuralnetworks.math.Tensor;
import com.neuralnetworks.math.TensorMath;

public class ReluActivation implements ActivationFunction {
    private Tensor<Double> lastInput;

    @Override
    public Tensor<Double> forward(Tensor<Double> input) {
        this.lastInput = input;
        return input.map(value -> value > 0 ? value : 0.0);
    }

    @Override
    public Tensor<Double> backward(Tensor<Double> outputGradient) {
        if (lastInput == null) {
            throw new IllegalStateException("Metode forward harus dipanggil sebelum backward.");
        }

        Tensor<Double> localDerivative = this.lastInput.map(value -> value > 0 ? 1.0 : 0.0);
        return TensorMath.multiply(outputGradient, localDerivative);
    }
}
