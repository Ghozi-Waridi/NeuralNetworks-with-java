package com.neuralnetworks.math;

abstract class Tensor<T> {
    /**
   * @field shape menyimpan dimensi dari tensor
   * @field data menyimpan data yang disimpan dalam tensor
   */

  protected int[] shape;
  protected T data;
  
}
