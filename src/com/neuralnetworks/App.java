package com.neuralnetworks;

import java.awt.Image;
import java.awt.image.BufferedImage;

import com.neuralnetworks.data.ImageLoad;
import java.util.List;

public class App {
  public static void main(String[] args) {
   System.out.println("Testing Load Image dataset"); 
   String path = "/Users/ghoziwaridi/PEMOGRAMAN/java/NeuralNetworks-with-java/data/raw";
   ImageLoad imageLoad = new ImageLoad(path);
   imageLoad.loadDataset(path);

   List<BufferedImage> images = imageLoad.getImages();
   System.out.println("Jumlah gambar yang dimuat: " + images.size());
   
   List<String> labels = imageLoad.getLabels();
   System.out.println("Jumlah label yang dimuat: " + labels.toString());
  }
}


