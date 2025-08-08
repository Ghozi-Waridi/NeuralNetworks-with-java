package com.neuralnetworks.activations;

public enum ActivationType {
  RELU,
  SIGMOID;

  public ActivationFunction create() {
    switch (this) {
      case RELU:
        return new ReluActivation();
      case SIGMOID:
        return new SigmoidActivation();
      default:
        throw new IllegalArgumentException("Tipe aktivasi tidak diketahui.");
    }
  }
}
