package com.neuralnetworks.data;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.List;
import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

import com.neuralnetworks.math.Tensor;

public class ImageLoad {
  private String path;
  private List<BufferedImage> images;
  private List<String> labels;

  public ImageLoad(String path) {
    this.path = path;
    this.images = new ArrayList<BufferedImage>();
    this.labels = new ArrayList<String>();
  }

  /**
   * Memuat gambar dari folder yang diberikan.
   * @param path Path ke folder yang berisi gambar.
   */

  public void loadDataset(String path) {
    // Load / menjadikan path ke dalam bentuk object File
    File mainFolder = new File(path);
    // validasi apakah path valid
    if (!mainFolder.exists() || !mainFolder.isDirectory()) {
      System.out.println("Path tidak valid atau bukan sebuah folder (directory): " + path);
      return;
    }
    System.out.println("Mulai memuat gambar dari: " + path);
    // Panggil method laodImages untuk memuat gambar dari folder
    loadImages(mainFolder);
    System.out.println("Selesai memuat gambar dari: " + path);
     
  } 

  /**
   * Memuat gambar dari folder yang diberikan secara rekursif,
   * Untuk mengatasi subfolder yang mungkin ada di dalam folder utama.
   * @param folder Folder yang berisi gambar.
   */
  public void loadImages(File folder) {
    // mengambil semua file dalam folder
    File[] files = folder.listFiles();
    // validasi apakah list "files" memiliki gambar atau tidak
    if(files == null) {
      System.out.println("Tidak dapat mengakses folder: " + folder.getAbsolutePath());
      return;
    }
    for (File file : files) {{
      // validasi apakah file tersebut adalah sebuah folder atau file gambar
      if (file.isDirectory()) {
        System.out.println("Memuat folder: " + file.getName());
        // Jika file adalah sebuah folder, panggil loadImages secara rekursif
        loadImages(file);  
      } else {
        // Jika file adalah sebuah gambar, periksa apakah itu adalah file gambar
        if (isImageFile(file.getName())){
          try {
            // Memuat gambar menggunakan ImageIO
            BufferedImage image = ImageIO.read(file);
            // validasi apakah gambar berhasil dimuat
            if (image != null) {
              // Menambahkan gambar dan label ke dalam list
              images.add(image);
              labels.add(folder.getName());
              System.out.println("Gambar dimuat: " + file.getName());
            } else {
              System.out.println("Gagal memuat gambar: " + file.getName());
            }
          } catch (IOException e) {
            System.out.println("Error saat memuat gambar: " + file.getName() + " - " + e.getMessage());
          }
        }
      }
    }}
  }
  

  /**
   * Memeriksa apakah file dengan nama yang diberikan adalah file gambar.
   * @param fileName Nama file yang akan diperiksa.
   * @return true jika file adalah gambar, false jika tidak.
   */
  public boolean isImageFile(String fileName) {
    String[] imageExtensions = {".jpg", ".jpeg", ".png", ".bmp", ".gif"};
    for (String ext : imageExtensions) {
      if (fileName.toLowerCase().endsWith(ext)) {
        return true;
      }
    }
    return false;
  }
  public List<BufferedImage> getImages() {
    return images;
  }
  public List<String> getLabels() {
    return labels;
  }
  public void setGray(){
    for (int i = 0; i < images.size(); i++) {
      BufferedImage img = images.get(i);

      BufferedImage grayImage = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_BYTE_GRAY);
    for(int j = 0; j < img.getWidth(); j++) {
      for (int k = 0; k < img.getHeight(); k++) {
        int rgb = img.getRGB(j, k);
        int r = (rgb >> 16) & 0xFF;
        int g = (rgb >> 8) & 0xFF;
        int b = rgb & 0xFF;
        // Menghitung nilai grayscale
        int gray = (r + g + b) / 3;
        // Set pixel pada gambar grayscale
        grayImage.setRGB(j, k, (gray << 16) | (gray << 8) | gray);
      }
    } 
      
    }
  }

}
