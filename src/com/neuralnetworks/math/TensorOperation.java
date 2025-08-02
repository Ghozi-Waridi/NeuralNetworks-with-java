package com.neuralnetworks.math;


import com.neuralnetworks.math.Tensor;
/**
 * Tensor
 *
 * class Tensor yang menyediakan struktur data sebagai tensor untuk penyimpanan data 
 * dan operasi matematika pada neural networks.
 */
public class TensorOperation<T> extends Tensor<T>{


  /**
   * Kontruktor untuk membuat tensor denagn dimensi tertentu
   * @param shape dimensi dari tensor
   * @param data yang di jadikan sebagia struktur data tensor
   */

  public TensorOperation(int[] shape, T data) {
    super.shape = shape;
    super.data = data;
  }
  
  /**
   * getShape Mengambil dimensi dari tensor
   * @return dimensi dari tensor (nilai instance variabel dari shape)
   */

  public int[] getShape() {
    return super.shape;
  }

  
}
