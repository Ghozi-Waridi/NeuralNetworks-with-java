package com.neuralnetworks.data;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.Map;

public class Resize implements Transform<Map.Entry<BufferedImage, String>, Map.Entry<BufferedImage, String>> {
  private final int targetWidth;
  private final int targetHeight;

  public Resize(int targetWidth, int targetHeight) {
    if (targetWidth <= 0 || targetHeight <= 0) {
      throw new IllegalArgumentException("Ukuran target haru lebih besar dari nol.");
    }
    this.targetWidth = targetWidth;
    this.targetHeight = targetHeight;
  }

  @Override
  public Map.Entry<BufferedImage, String> apply(Map.Entry<BufferedImage, String> input) {
    BufferedImage originalImage = input.getKey();
    BufferedImage resizedImage = new BufferedImage(this.targetWidth, this.targetHeight, originalImage.getType());
    Graphics2D g2d = resizedImage.createGraphics();
    g2d.drawImage(originalImage, 0, 0, this.targetWidth, this.targetHeight, null);
    g2d.dispose();

    return Map.entry(resizedImage, input.getValue());
  }

}
