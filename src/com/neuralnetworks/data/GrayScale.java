package com.neuralnetworks.data;

import java.awt.image.BufferedImage;
import java.util.List;
import java.util.Map;

public class GrayScale implements Transform<Map.Entry<BufferedImage, String>, Map.Entry<BufferedImage, String>> {



  /**
   * Mengubah gambar berwarna menjadi grayscale.
   *
   * @param input Map.Entry yang berisi BufferedImage dan label kelas.
   * @return Map.Entry yang berisi BufferedImage dalam grayscale dan label kelas.
   */
  @Override
  public Map.Entry<BufferedImage, String> apply(Map.Entry<BufferedImage, String> input) {

    // mengambil ukuran gambar
    int width = input.getKey().getWidth();
    int height = input.getKey().getHeight();
    
    // membuat BufferedImage baru untuk menyimpan gambar grayscale
    BufferedImage grayImage = new BufferedImage(width, height, BufferedImage.TYPE_BYTE_GRAY);
    
    // mengonversi setiap pixel dari gambar 3 channel menjadi 1 channel grayscale
    for (int i = 0; i < width; i++) {
      for (int j = 0; j < height; j++) {
        int pixel = input.getKey().getRGB(i, j);
 
        int r = (pixel >> 16) & 0xFF;
        int g = (pixel >> 8) & 0xFF;
        int b = pixel & 0xFF;

        int grayValue = (int) (0.299 * r + 0.587 * g + 0.114 * b);

        int newPixel = (grayValue << 16) | (grayValue << 8) | grayValue;
        grayImage.setRGB(i, j, newPixel);
      }

    }

    return Map.entry(grayImage, input.getValue());
  }
}
