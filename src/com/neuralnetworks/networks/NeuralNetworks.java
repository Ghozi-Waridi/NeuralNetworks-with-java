package com.neuralnetworks.networks;

import java.util.ArrayList;
import java.util.List;

import com.neuralnetworks.math.Tensor;

public class NeuralNetworks {

  private List<Tensor> weights;
  private Tensor bias;
  private List<Integer> numLayers;

  public NeuralNetworks(Tensor input, Tensor label, int... layers) {
    numLayers = new ArrayList<>();
    for (int i = 0; i < layers.length; i++) {
      numLayers.add(layers[i]);
      Tensor weight = Tensor.random(i, i + 1);
      Tensor bias = Tensor.zeros(Double.class, layers[i], 1);

      weights.add(weight);

    }

  }
}
