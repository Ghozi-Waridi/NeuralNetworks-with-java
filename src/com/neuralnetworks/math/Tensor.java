package com.neuralnetworks.math;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Arrays;

/**
 * Kelas Tensor yang menggunakan komposisi dengan List internal.
 * 
 * @param <T> Tipe data numerik seperti Integer, Double, dll.
 */
public class Tensor<T extends Number> {

  private int[] shape;
  private final List<T> internalData;

  /**
   * Konstruktor privat. Gunakan metode pabrik seperti .zeros() atau .ones()
   * untuk membuat instance baru.
   */
  private Tensor(int... shape) {
    this.shape = shape;
    // Membuat List dengan ukuran yang sudah ditentukan untuk efisiensi
    this.internalData = new ArrayList<>();
  }

  /**
   * Membuat Tensor baru dengan dimensi (shape),
   * di mana semua elemennya diinisialisasi dengan nilai nol.
   *
   * @param type  Tipe kelas dari angka (misal: Integer.class, Double.class).
   *              Diperlukan untuk membuat nilai nol yang sesuai dengan tipe
   *              generik T.
   * @param shape Dimensi dari tensor yang akan dibuat (misal: 2, 3 untuk matriks
   *              2x3).
   * @return Sebuah instance Tensor baru yang berisi nol.
   * @param <T> Tipe data numerik.
   */
  @SuppressWarnings("unchecked")
  public static <T extends Number> Tensor<T> zeros(Class<T> type, int... shape) {
    // 1. Buat instance Tensor kosong dengan shape yang benar
    Tensor<T> tensor = new Tensor<>(shape);
    System.out.println(tensor.shape.length + "D Tensor created with shape: " + java.util.Arrays.toString(tensor.shape));
    int size = getSize(shape);
    // 2. Tentukan nilai nol berdasarkan tipe data yang diberikan
    T zeroValue;
    if (type == Integer.class) {
      zeroValue = (T) Integer.valueOf(0);
    } else if (type == Double.class) {
      zeroValue = (T) Double.valueOf(0.0);
    } else if (type == Float.class) {
      zeroValue = (T) Float.valueOf(0.0f);
    } else if (type == Long.class) {
      zeroValue = (T) Long.valueOf(0L);
    } else {
      throw new IllegalArgumentException("Tipe data tidak didukung untuk operasi .zeros(): " + type.getName());
    }

    System.out.println("Class Di dapatkan: " + type.getName());

    // 3. Isi List internal dengan nilai nol secara efisien
    for (int i = 0; i < size; i++) {
      tensor.internalData.add(zeroValue);
    }
    return tensor;
  }

  /**
   * Membuat Tensor Baru dengan dimensi (shape),
   * di mana semua elemennya diinisialisasi dengan nilai satu.
   *
   *
   * @param type  Tipe kelas dari angka (misal: Integer.Class, Double.class).
   * @param shape Dimensi dari tensor yang akan di buat (misal: 2,3 untuk matriks
   *              2 x 3).
   * @return Sebuah instance Tensor baru yang berisi satu.
   * @param <T> Tipe data numerik.
   */
  @SuppressWarnings("unchecked")
  public static <T extends Number> Tensor<T> ones(Class<T> type, int... shape) {
    // 1. Buat instance Tensor kosong dengan shape.
    Tensor<T> tensor = new Tensor<>(shape);

    // 2. Tentukan nilai satu berdasarkan tipe data yang diberikan
    T oneValue;
    if (type == Integer.class) {
      oneValue = (T) Integer.valueOf(1);
    } else if (type == Double.class) {
      oneValue = (T) Double.valueOf(1.0);
    } else if (type == Float.class) {
      oneValue = (T) Float.valueOf(1.0f);
    } else if (type == Long.class) {
      oneValue = (T) Long.valueOf(1L);
    } else {
      throw new IllegalArgumentException("Tipe data tidak didukung untuk operasi .ones(): " + type.getName());
    }

    // 3. Isi List internal dengan nilai satu
    int size = getSize(shape);
    for (int i = 0; i < size; i++) {
      tensor.internalData.add(oneValue);
    }
    return tensor;
  }

  /**
   * Membuat Tensor baru dengan dimensi (shape),
   * di mana semua elemennya diinisialisasi dengan nilai acak,
   * antara 0 dan 1 dengan presisi 4 angka di belakang koma.
   * 
   * @param shape Dimensi dari tensor yang akan dibuat (misal: 5, 5 untuk matriks
   *              5x5).
   * @return Sebuah instance Tensor baru yang berisi nilai acak.
   * @param <T> Tipe data numerik.
   */
  @SuppressWarnings("unchecked")
  public static <T extends Number> Tensor<T> random(int... shape) {
    // 1 Buat instance Tensor kosong dengan shape dari parameter
    Tensor<T> tensor = new Tensor<>(shape);
    int size = getSize(shape);

    for (int i = 0; i < size; i++) {
      T value;
      // 2. Gunakan ThreadLocalRandom untuk menghasilkan anga acak antara 0 - 1 dengan
      // presisi 4 angka di belakang koma
      Double randomValue = ThreadLocalRandom.current().nextInt(0, 10000) / 10000.0;

      value = (T) randomValue;
      // 3. Tambahkan nilai acak ke dalam tensor
      tensor.internalData.add(value);
    }
    return tensor;
  }

  /**
   * Menghitung ukuran total dari tensor berdasarkan dimensi (shape).
   * 
   * @param shape Dimensi dari tensor (misal: 2, 3 untuk matriks 2x3).
   * @return Ukuran total dari tensor.
   */
  private static int getSize(int... shape) {
    int size = 1;
    for (int dim : shape) {
      if (dim <= 0) {
        throw new IllegalArgumentException("Dimensi shape harus positif.");
      }
      size *= dim;
    }
    return size;
  }

  /**
   * Membuat tenaor dari array double. (convert double array to tensor).
   *
   * @param array Array data yang akan di ubah menjadi tensor.
   * @param shape Dimensi yang ingin di buat untuk tensor.
   * @return Sebuah instance Tensor baru yang berisi data dari array.
   *
   * @Note: untuk ukuran shape dan array harus sesuai sebab array akan di jadikan
   *        ukuran sesuai dengan shape,
   */
  @SuppressWarnings("unchecked")
  public static <T extends Number> Tensor<T> fromArray(double[] array, int... shape) {
    // 1, Periksa apakah shape valid
    if (array == null || array.length == 0) {
      throw new IllegalArgumentException("Array tidak boleh null atau kosong.");
    }
    // 2. inisialisasi tensor dengan shape yang diberikan
    Tensor<T> tensor = new Tensor<>(shape);
    int size = getSize(shape);
    for (int i = 0; i < size; i++) {
      T value = (T) Double.valueOf(array[i]);
      tensor.internalData.add(value);
    }
    return tensor;
  }

  /**
   * Mengambil data internal dari tensor.
   * 
   * @return List yang berisi data internal dari tensor.
   */
  public void getShape() {
    System.out.print("Shape Tensor: ");
    if (shape.length == 0) {
      System.out.println("[]");
      return;
    }
    System.out.print("[");
    for (int dim : shape) {
      System.out.print(dim + " ");
    }
    System.out.println("]");
  }

  /**
   * Mengambil elemen dari tensor berdasarkan indeks multi-dimensi.
   * 
   * @param index Indeks multi-dimensi untuk mengambil elemen (misal: {0, 1} untuk
   * @return Elemen pada indeks yang diberikan sebagai List.
   */
  public List<T> get(int... index) {
    if (index.length != shape.length) {
      throw new IllegalArgumentException("Jumlah indeks harus sesuai dengan jumlah dimensi tensor.");
    }
    // Hitung indeks linear berdasarkan indeks multi-dimensi
    int linearIndex = index[0] * shape[1] + index[1];
    return internalData.subList(linearIndex, linearIndex + 1);
  }

  /**
   * Mengubah bentuk (reshape) tensor ke dimensi baru.
   * 
   * @param newShape Dimensi baru untuk tensor (misal: 3, 2 untuk matriks 3x2).
   *
   */
  public void reshape(int... newShape) {
    if (newShape.length < 2) {
      throw new IllegalArgumentException("Tensor harus memiliki setidaknya 2 dimensi untuk reshape.");
    }

    int newSize = getSize(newShape);
    if (newSize != internalData.size()) {
      throw new IllegalArgumentException("Ukuran baru tidak sesuai dengan ukuran data internal.");
    }
    this.shape = newShape;

  }
  public Tensor<T> flatten() {
    if (shape.length == 1) {
      return null; // Sudah dalam bentuk datar
    }
    Tensor<T> flattenedTensor = new Tensor<>(1, getSize(shape));
    for(int i = 0; i < internalData.size(); i++) {
      flattenedTensor.internalData.add(internalData.get(i));
    }
    return flattenedTensor;
  }

  // Override toString() untuk menampilkan tensor dengan format yang rapi (contoh
  // untuk 2D)
  @Override
  public String toString() {
    if (shape.length != 2) {
      return "Tensor (data=" + internalData.toString() + ")";
    }

    StringBuilder sb = new StringBuilder("Tensor shape: [" + shape[0] + ", " + shape[1] + "]\n");
    sb.append("[\n");
    for (int i = 0; i < shape[0]; i++) {
      sb.append("  [");
      StringJoiner sj = new StringJoiner(", ");
      for (int j = 0; j < shape[1]; j++) {
        int index = i * shape[1] + j;
        sj.add(internalData.get(index).toString());
      }
      sb.append(sj.toString());
      sb.append("]\n");
    }
    sb.append("]");
    return sb.toString();
  }
}
