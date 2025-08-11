package com.neuralnetworks.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import java.util.AbstractMap;
import java.awt.image.BufferedImage;
import java.io.File;

public class ImageFolderDataset implements Dataset<Map.Entry<BufferedImage, String>> {

  private List<File> images;// Menyimpan daftar file gambar yang dimuat
  private List<String> labels;// Menyimpan daftar label yang sesuai dengna gambar

  public ImageFolderDataset(String path) {

    this.images = new ArrayList<>();
    this.labels = new ArrayList<>();

    System.out.println("Memuat dataset dari folder: " + path);
    loadDataset(new File(path));
    System.out.println("Selesai memuat dataset dari folder: " + path);

  }

  /**
   * Memuat dataset dari folder yang diberikan.
   * 
   * @param folder Folder yang berisi gambar.
   */
  private void loadDataset(File folder) {
    // Mengambil daftar File Dari sebuah folder.
    File[] files = folder.listFiles();
    if (files == null) {
      System.out.println("Tidak dapat mengakses folder: " + folder.getAbsolutePath());
      return;
    }

    for (File file : files) {
      if (file.isDirectory()) {
        loadDataset(file);
      } else if (isImageFile(file.getName())) {
        this.labels.add(folder.getName());
        this.images.add(file);
      }
    }
  }

  /**
   * Memeriksa apakah file dengan nama yang diberikan adalah file gambar.
   * 
   * @param fileName Nama file yang akan diperiksa.
   * @return true jika file adalah gambar, false jika tidak.
   */
  public boolean isImageFile(String fileName) {
    String[] imageExtensions = { ".jpg", ".jpeg", ".png", ".bmp", ".gif" };
    for (String ext : imageExtensions) {
      if (fileName.toLowerCase().endsWith(ext)) {
        return true;
      }
    }
    return false;
  }

  /**
   * Mengembalikan daftar gambar yang dimuat.
   * 
   * @param index Indexs gambar yang ingin di ambil.
   * @return Daftar gambar yang dimuat.
   */
  @Override
  public Map.Entry<BufferedImage, String> get(int index) {
    if (index < 0 || index >= size()) {
      throw new IndexOutOfBoundsException("Index " + index + " di luar jangkauan dataset " + size());
    }
    File imageFile = this.images.get(index);
    String label = this.labels.get(index);

    try {
      BufferedImage image = ImageIO.read(imageFile);
      if (image != null) {
        return new AbstractMap.SimpleEntry<>(image, label);
      }

    } catch (Exception e) {
      System.out.println("Error saat memuat gambar: " + imageFile.getName() + " - " + e.getMessage());
      e.printStackTrace();
    }
    return null;
  }

  /**
   * Mengembalikan jumlah gambar yang dimuat dalam dataset.
   * 
   * @return Jumlah gambar dalam dataset.
   */
  @Override
  public int size() {
    return this.images.size();
  }
}
