// package com.neuralnetworks.activations;

import com.neuralnetworks.activations.ActivationFunction;
import com.neuralnetworks.activations.ActivationType;
import com.neuralnetworks.math.Tensor;

import com.neuralnetworks.math.Tensor;

public class ReluTest {

  public static void main(String[] args) {
    System.out.println("Memulai pengujian untuk fungsi aktivasi...");
    int testsPassed = 0;
    int totalTests = 3;

    try {
      testReluForward();
      System.out.println("✅ Test 1/3: testReluForward() BERHASIL.");
      testsPassed++;

      testReluBackward();
      System.out.println("✅ Test 2/3: testReluBackward() BERHASIL.");
      testsPassed++;

      testBackwardThrowsExceptionWithoutForward();
      System.out.println("✅ Test 3/3: testBackwardThrowsExceptionWithoutForward() BERHASIL.");
      testsPassed++;

    } catch (Exception e) {
      System.err.println("❌ TEST GAGAL!");
      e.printStackTrace();
    } finally {
      System.out.println("\n======================================");
      System.out.printf("Ringkasan Tes: %d dari %d tes berhasil.\n", testsPassed, totalTests);
      System.out.println("======================================");
      if (testsPassed != totalTests) {
        System.exit(1);
      }
    }
  }

  public static void testReluForward() {
    System.out.println("--- Menjalankan testReluForward ---");
    double[] inputData = { 1.0, -2.0, 0.0, 5.0, -0.5, 100.0 };
    Tensor<Double> inputTensor = Tensor.fromArray(inputData, 3, 2);
    double[] expectedData = { 1.0, 0.0, 0.0, 5.0, 0.0, 100.0 };
    Tensor<Double> expectedTensor = Tensor.fromArray(expectedData, 3, 2);

    Tensor<Double> actualTensor = ActivationType.RELU.forward(inputTensor);

    assertTensorEquals(expectedTensor, actualTensor, "testReluForward");
  }

  public static void testReluBackward() {
    System.out.println("--- Menjalankan testReluBackward ---");

    double[] inputData = { 10.0, -5.0, 0.0, -1.0, 8.0, 2.0 };
    Tensor<Double> inputTensor = Tensor.fromArray(inputData, 3, 2);
    ActivationType.RELU.forward(inputTensor);
    double[] gradientData = { 1.0, 2.0, 3.0, 4.0, 5.0, 6.0 };
    Tensor<Double> outputGradient = Tensor.fromArray(gradientData, 3, 2);
    double[] expectedData = { 1.0, 0.0, 0.0, 0.0, 5.0, 6.0 };
    Tensor<Double> expectedBackwardTensor = Tensor.fromArray(expectedData, 3, 2);

    Tensor<Double> actualBackwardTensor = ActivationType.RELU.backward(outputGradient);

    assertTensorEquals(expectedBackwardTensor, actualBackwardTensor, "testReluBackward");
  }

  public static void testBackwardThrowsExceptionWithoutForward() {
    System.out.println("--- Menjalankan testBackwardThrowsExceptionWithoutForward ---");

    Tensor<Double> dummyGradient = Tensor.zeros(Double.class, 2, 3);
    boolean exceptionThrown = false;

    try {

      ActivationType.RELU.backward(dummyGradient);
    } catch (IllegalStateException e) {

      exceptionThrown = true;
      System.out.println("   (Menangkap IllegalStateException seperti yang diharapkan)");
    }

    if (!exceptionThrown) {

      throw new RuntimeException("Test Gagal: Seharusnya melempar IllegalStateException, tetapi tidak.");
    }
  }

  public static void assertTensorEquals(Tensor<Double> expected, Tensor<Double> actual, String testName) {

    if (expected.getShapeArray()[0] != actual.getShapeArray()[0]
        || expected.getShapeArray()[1] != actual.getShapeArray()[1]) {
      throw new RuntimeException(
          String.format("[%s] Gagal: Dimensi tensor tidak cocok. Diharapkan [%d,%d], didapat [%d,%d]",
              testName, expected.getShapeArray()[0], expected.getShapeArray()[1], actual.getShapeArray()[0],
              actual.getShapeArray()[1]));
    }

    for (int i = 0; i < expected.getShapeArray()[0]; i++) {
      for (int j = 0; j < expected.getShapeArray()[1]; j++) {

        if (Math.abs(expected.get(i, j) - actual.get(i, j)) > 0.0001) {
          throw new RuntimeException(
              String.format("[%s] Gagal: Nilai elemen di [%d,%d] tidak cocok. Diharapkan %.4f, didapat %.4f",
                  testName, i, j, expected.get(i, j), actual.get(i, j)));
        }
      }
    }
  }
}
