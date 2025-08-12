package com.neuralnetworks.data;

import java.awt.image.BufferedImage;
import java.util.Map;
import java.util.List;
import com.neuralnetworks.math.Tensor;

public class ToTensor implements Transform<Map.Entry<BufferedImage, String>, Map.Entry<Tensor<Double>, Tensor<Double>>> {

  private final List<String> classLabels;

  public ToTensor(List<String> classLabels) {
    if (classLabels == null || classLabels.isEmpty()) {
      throw new IllegalArgumentException("Daftar label kelas tidak boleh kosong atau null.");
    }
    this.classLabels = classLabels;
  }

  @Override
  public Map.Entry<Tensor<Double>, Tensor<Double>> apply(Map.Entry<BufferedImage, String> input) {
    int width = input.getKey().getWidth();
    int height = input.getKey().getHeight();
    int panjangLabel = input.getValue().length();

    int channel = input.getKey().getColorModel().getNumComponents();

    double[] imageData = new double[width * height * channel];
    int arrIndex = 0;
    for (int y = 0; y < height; y++) {
      for (int x = 0; x < width; x++) {
        int pixel = input.getKey().getRGB(x, y);

        double r = ((pixel >> 16) & 0xFF) / 255.0;
        double g = ((pixel >> 8) & 0xFF) / 255.0;
        double b = ((pixel) & 0xFF) / 255.0;

        imageData[arrIndex++] = r;
        imageData[arrIndex++] = g;
        imageData[arrIndex++] = b;
          
      }
    }


    double[] labels = new double[panjangLabel];

    Tensor<Double> imageTensor = Tensor.fromArray(imageData, width, height, channel);
    Tensor<Double> labelTensor = Tensor.fromArray(labels, panjangLabel, 1);
    return Map.entry(imageTensor, labelTensor);

  }
}
