package com.neuralnetworks.layers;

import java.util.Map;

import com.neuralnetworks.activations.ActivationFunction;
import com.neuralnetworks.activations.ActivationType;
import com.neuralnetworks.math.Tensor;
import com.neuralnetworks.math.TensorMath;

public class DenseLayer extends Layers{
  private Tensor weight;
  private Tensor bias;
  
  public DenseLayer(int inputSize, int outputSize){ 
    this.weight = Tensor.random(inputSize, outputSize);
    this.bias = Tensor.zeros(Double.class,  1, outputSize);
  }

  public Tensor getWeight(){
    return this.weight;
  }

  public Tensor getBias(){
    return this.bias;
  }

  /**
   * Methode forward untuk DenseLayer, melakukan perhitungan linear dengan weight dan bias.
   * @param input data yang akan digunakan untuk forward.
   * @return hasil peerhitungan dari liear regression.
   */

  @Override
  public Tensor forward(Tensor input) {
    // perkalian antara bobot dan input 
    Tensor perkalian = TensorMath.dotProduct(weight, input);
    // penambahan antara hasil sebelumnya dengan bias.
    Tensor result = TensorMath.add(perkalian, bias);
    return result;
  }

  /**
   * Methode backward untuk DenseLayer, melakukan update bobot dan bias, 
   * dan mengembalikan bobot dan bias
   * @param outputGradient hasil perhitungan delta dari layer sebelumnya.
   * @param activation hasil activasi pada layer sekarang.
   * @return mengembalikan hasil delta di layer sekarang.
  */
  @Override
  public Tensor backward(Tensor outputGradient, Tensor activation) {
    Tensor deactivate =  ActivationType.SIGMOID.backward(outputGradient);
    Tensor delta = TensorMath.multiply(TensorMath.dotProduct(this.weight, outputGradient), deactivate); // bobot (weight harus di transpose)
    this.bias = delta;
    this.weight = TensorMath.dotProduct(delta, activation); // activations harus di transpose
 
    return delta;
  }

}
