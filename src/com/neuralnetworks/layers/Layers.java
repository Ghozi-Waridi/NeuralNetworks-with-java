package com.neuralnetworks.layers;

import com.neuralnetworks.math.Tensor;

/**
 * InnerLayers
 */
public abstract class Layers {

  protected Tensor input;

  protected Tensor output;

  public abstract Tensor forward(Tensor input);

  public abstract Tensor backward(Tensor outputGradient, Tensor activation);
} 
