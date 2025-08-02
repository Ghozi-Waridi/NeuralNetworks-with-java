package com.neuralnetworks.math;

import java.util.ArrayList;


/**
 * Tensor
 *
 * class Tensor yang menyediakan struktur data sebagai tensor untuk penyimpanan data 
 * dan operasi matematika pada neural networks.
 */
public class Tensor<T extends Number>{
  /**
   * @field shape menyimpan dimensi dari tensor
   * @field data menyimpan data yang disimpan dalam tensor
   */

  private int[] shape;
  private T data;
  
    /**
   * Kontruktor untuk membuat tensor denagn dimensi tertentu
   * @param shape dimensi dari tensor
   * @param data yang di jadikan sebagia struktur data tensor
   */

  public Tensor(int[] shape, T data) {
    this.shape = shape;
    this.data = data;
  }
  
  /**
   * getShape Mengambil dimensi dari tensor
   * @return dimensi dari tensor (nilai instance variabel dari shape)
   */

  public int[] getShape() {
    return this.shape;
  }

  

  public Tensor<T> fromArray(T array){
    return null;
  };
  public Tensor<T> addF(Tensor<T>[] A) {
    return null;
  };
  public Tensor<T> addB(Tensor<T>[] A){
    return null;
  };
  public Tensor<T> copy(Tensor<T> A){
    return null;
  };
  
}
