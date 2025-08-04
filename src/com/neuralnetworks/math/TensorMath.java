package com.neuralnetworks.math;

import java.util.List;
import java.util.ArrayList;

// import com.sun.org.apache.xerces.internal.impl.xpath.regex.REUtil;

public class TensorMath<T extends Number> {

  /**
   * Melakukan operasi penjumlahan antara di matriks atau tensor,
   * Perlu diketahui bahwa operasi ini hanya mendukung tipe data Double.
   *
   * @param a Tensor pertama yang akan dijumlahkan.
   * @param b Tensor kedua yang akan dijumlahkan.
   * @return Tensor baru yang merupakan hasil penjumlahan dari a dan b.
   * @param T Tipe data numerik
   */
  @SuppressWarnings("unchecked")
  public static <T extends Number> Tensor<T> add(Tensor<T> a, Tensor<T> b) {
    // Validasi dimensi tensor
    if (a.getShapeArray().length != b.getShapeArray().length ||
        a.getShapeArray()[0] != b.getShapeArray()[0]
        || a.getShapeArray()[1] != b.getShapeArray()[1]) {
      throw new IllegalArgumentException("Tensor harus memiliki dimensi yang sama untuk penjumlahan.");
    }
    // Membuat tensor hasil dengan shape yang sama.
    Tensor<T> result = Tensor.create(a.getShapeArray());
    // Mengambil data internal dari tensor a dan b
    List<T> dataA = a.getInternalData();
    List<T> dataB = b.getInternalData();

    // Membuat list untuk menyimpan hasil penjumlahan
    List<T> hasil = new ArrayList<>(dataA.size());

    // Melakukan penjumlahan elemen demi elemen
    for (int i = 0; i < dataA.size(); i++) {
      T valueA = dataA.get(i);
      T valueB = dataB.get(i);
      double sum = valueA.doubleValue() + valueB.doubleValue();
      hasil.add((T) Double.valueOf(sum));
    }
    // Merubah nilai result dengan hasil penjumlahan
    result.set(hasil);
    return result;
  }

  /**
   * Melakukan operasi pengurangan antara dua matriks atau tensor,
   * Perlu diketahui bahwa operasi ini hanya mendukung tipe data Double.
   *
   * @param a Tensor pertama yang akan dikurangi.
   * @param b Tensor kedua yang akan dikurangi.
   * @return Tensor baru yang merupakan hasil pengurangan dari a dan b.
   * @param T Tipe data numerik (Double)
   */
  @SuppressWarnings("unchecked")
  public static <T extends Number> Tensor<T> subtract(Tensor<T> a, Tensor<T> b) {
    // validasi dimensi Tensor
    if (a.getShapeArray().length != b.getShapeArray().length || a.getShapeArray()[0] != b.getShapeArray()[0]
        || a.getShapeArray()[1] != b.getShapeArray()[1]) {
      throw new IllegalArgumentException("Tensor harus memiliki dimensi yang sama untuk pengurangan.");
    }

    // Membuat tensor hasil dengan shape yang sama dengan tensor a atau tensor b.
    Tensor<T> result = Tensor.create(a.getShapeArray());

    // Mengambil data internal dari tensor a dan b
    List<T> dataA = a.getInternalData();
    List<T> dataB = b.getInternalData();

    // Membuat list untuk menyimpan hasil pengurangan
    List<T> hasil = new ArrayList<>(dataA.size());

    // Melakukan pengurangan elemen demi elemen
    for (int i = 0; i < dataA.size(); i++) {
      T valueA = dataA.get(i);
      T valueB = dataB.get(i);
      double substraction = valueA.doubleValue() - valueB.doubleValue();
      hasil.add((T) Double.valueOf(substraction));
    }
    // Merubah nilai result dengan hasil pengurangan
    result.set(hasil);
    return result;
  }

  /**
   * Melakukan operasi perkalian antara dua matriks atau tensor,
   * Perlu diketahui bahwa operasi ini hanya mendukung tipe data Double.
   *
   * @param a Tensor pertama yang akan dikalikan.
   * @param b Tensor kedua yang akan dikalikan.
   * @return Tensor baru yang merupakan hasil perkalian dari a dan b.
   * @param T Tipe data numerik (Double)
   *
   *
   */

  @SuppressWarnings("unchecked")
  public static <T extends Number> Tensor<T> multiply(Tensor<T> a, Tensor<T> b) {
    // validasi dimensi Tensor
    if (a.getShapeArray().length != b.getShapeArray().length || a.getShapeArray()[0] != b.getShapeArray()[0]
        || a.getShapeArray()[1] != b.getShapeArray()[1]) {
      throw new IllegalArgumentException("Tensor harus memiliki dimensi yang sama untuk pengurangan.");
    }

    // Membuat tensor hasil dengan shape yang sama dengan tensor a atau tensor b.
    Tensor<T> result = Tensor.create(a.getShapeArray());

    // Mengambil data internal dari tensor a dan b
    List<T> dataA = a.getInternalData();
    List<T> dataB = b.getInternalData();

    // Membuat list untuk menyimpan hasil perkalian
    List<T> hasil = new ArrayList<>(dataA.size());

    for (int i = 0; i < dataA.size(); i++) {
      T valueA = dataA.get(i);
      T valueB = dataB.get(i);
      double multiplication = valueA.doubleValue() * valueB.doubleValue();
      hasil.add((T) Double.valueOf(multiplication));
    }
    result.set(hasil);
    return result;
  }

  /**
   * Melakukan operasi dot product antara dua matriks atau tensor,
   * Perlu diketahui bahwa operasi ini hanya bisa menggunakan tipe data Double.
   *
   * @param a data matriks pertama.
   * @param b data matriks kedua.
   * @return instance baru hasil dari perkalian antara matriks a dan matriks b.
   * @param T Tipe data numerik.
   */
  @SuppressWarnings("unchecked")
  public static <T extends Number> Tensor<T> dotProduct(Tensor<T> a, Tensor<T> b) {

    // inisialisasi ukruan rows dan cols untuk operasi.
    int rowsA = a.getShapeArray()[0];
    int colsA = a.getShapeArray()[1];
    int colsB = b.getShapeArray()[1];

    // validasi dimensi untuk dot Product (antara Rows A dan Cols B)
    if (rowsA != colsB) {
      throw new IllegalArgumentException(
          "Jumlah baris dari tensor A harus sama dengan jumlah kolom dari tensor B untuk dot product.");
    }

    // Inisialisasi tensor baru untuk menampung hasil perkalian.
    Tensor<T> result = Tensor.create(rowsA, colsB);

    // Mengambil data matirks dari data a dan data b.
    List<T> dataA = a.getInternalData();
    List<T> dataB = b.getInternalData();

    // inisialisasi aray baru unttk hasil perkalian.
    List<T> hasil = new ArrayList<>(rowsA * colsB);
    // Melakukan operasi perkalian
    for (int i = 0; i < rowsA; i++) {

      for (int j = 0; j < colsB; j++) {
        double sum = 0.0;
        for (int k = 0; k < colsA; k++) {
          double valueA = dataA.get(i * colsA + k).doubleValue();
          double valueB = dataB.get(k * colsB + j).doubleValue();
          sum += valueA * valueB;
        }
        hasil.add((T) Double.valueOf(sum));
      }
    }
    result.set(hasil);
    return result;
  }

}
