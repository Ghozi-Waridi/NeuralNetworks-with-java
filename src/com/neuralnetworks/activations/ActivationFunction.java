package com.neuralnetworks.activations;

import com.neuralnetworks.math.Tensor;

/**
 * ActivationFunction
 */
public interface ActivationFunction {
  /**
   * Menghitung output daru fungsi aktivasi untuk forward methode.
   *
   * @param input Tensor input yang akan diproses.
   * @return Tensor output yang dihasilkan dari fungsi aktivasi.
   * @param <T> Tipe data numerik yang digunakan dalam tensor.
   */
  Tensor<Double> forward(Tensor<Double> input);

  /**
   * Menghitung gradien dari fungsi aktivasi untuk backward methode.
   *
   * @param input Tensor input yang akan diproses.
   * @return Tensor output yang berisi gradien dari fungsi aktivasi.
   * @param <T> Tipe data numerik yang digunakan dalam tensor.
   */
  Tensor<Double> backward(Tensor<Double> input);

}
