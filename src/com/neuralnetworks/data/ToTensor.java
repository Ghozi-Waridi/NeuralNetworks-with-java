package com.neuralnetworks.data;

import java.awt.image.BufferedImage;
import java.util.Map;
import java.util.List;
import com.neuralnetworks.math.Tensor;

public class ToTensor
    implements Transform<Map.Entry<BufferedImage, String>, Map.Entry<Tensor<Double>, Tensor<Double>>> {

  private final List<String> classLabels;

  /**
   * Konstruktor untuk kelas ToTensor.
   *
   * @param classLabels Daftar label kelas yang digunakan untuk mengubah label
   *                    string menjadi Tensor.
   * @throws IllegalArgumentException jika daftar label kelas kosong atau null.
   */
  public ToTensor(List<String> classLabels) {
    if (classLabels == null || classLabels.isEmpty()) {
      throw new IllegalArgumentException("Daftar label kelas tidak boleh kosong atau null.");
    }
    this.classLabels = classLabels;
  }

  /**
   * Mengubah BufferedImage dan label kelas menjadi Tensor.
   *
   * @param input Map.Entry yang berisi BufferedImage dan label kelas.
   * @return Map.Entry yang berisi Tensor untuk gambar dan label.
   */
  @Override
  public Map.Entry<Tensor<Double>, Tensor<Double>> apply(Map.Entry<BufferedImage, String> input) {
    // Mengambil ukuran gambar dan jumlah channel
    int width = input.getKey().getWidth();
    int height = input.getKey().getHeight();
    int channel = input.getKey().getColorModel().getNumComponents();

    // Membuat array untuk menyimpan anga numerik dari gambar
    double[] imageData = new double[width * height * channel];
    int arrIndex = 0;

    for (int y = 0; y < height; y++) {
      for (int x = 0; x < width; x++) {

        // Mendapatkan nilai pixel RGB dari BufferedImage
        int pixel = input.getKey().getRGB(x, y);

        double r = ((pixel >> 16) & 0xFF) / 255.0;
        double g = ((pixel >> 8) & 0xFF) / 255.0;
        double b = ((pixel) & 0xFF) / 255.0;

        // Menyimpan nilai RGB ke dalam array
        imageData[arrIndex++] = r;
        imageData[arrIndex++] = g;
        imageData[arrIndex++] = b;

      }
    }

    // Membuat Tensor dari array gambar
    Tensor<Double> imageTensor = Tensor.fromArray(imageData, width, height, channel);

    // Mengubah label kelas menjadi Tensor
    String label = input.getValue();
    int panjangLabel = this.classLabels.size();

    double[] labels = new double[panjangLabel];
    int labelIndex = this.classLabels.indexOf(label);
    if (labelIndex == -1) {
      throw new IllegalArgumentException(
          "Label '" + label + "' tidak ditemukan dalam daftar kelas yang diberikan.");
    }
    labels[labelIndex] = 1.0;

    Tensor<Double> labelTensor = Tensor.fromArray(labels, panjangLabel);

    return Map.entry(imageTensor, labelTensor);
  }
}
