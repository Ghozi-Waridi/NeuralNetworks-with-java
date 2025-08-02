package com.neuralnetworks.math;

import java.awt.PrintJob;
import java.util.ArrayList;
// import java.util.Collections;
import java.util.List;
import java.util.StringJoiner;

/**
 * Kelas Tensor yang menggunakan komposisi dengan List internal.
 * @param <T> Tipe data numerik seperti Integer, Double, dll.
 */
public class Tensor<T extends Number> {

    private final int[] shape;
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
     * @param type Tipe kelas dari angka (misal: Integer.class, Double.class).
     * Diperlukan untuk membuat nilai nol yang sesuai dengan tipe generik T.
     * @param shape Dimensi dari tensor yang akan dibuat (misal: 2, 3 untuk matriks 2x3).
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
     * @param type Tipe kelas dari angka (misal: Integer.Class, Double.class).
     * @param shape Dimensi dari tensor yang akan di buat (misal: 2,3 untuk matriks 2 x 3).
     * @return Sebuah instance Tensor baru yang berisi satu.
     * @param <T> Tipe data numerik.
     */
    @SuppressWarnings("unchecked")
    public static <T extends Number> Tensor<T> ones(Class<T> type, int... shape) {
      // 1. Buat instance Tensor kosong dengan shape.
      Tensor<T> tensor = new Tensor<>(shape);

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

      int size = getSize(shape);
      for(int i = 0; i < size; i++) {
          tensor.internalData.add(oneValue);
      }
      return tensor; 
    }


    private static int getSize(int... shape){
        int size = 1;
        for (int dim : shape) {
            if (dim <= 0) {
                throw new IllegalArgumentException("Dimensi shape harus positif.");
            }
          size *= dim;
        }
      return size;
    }

       
    // Getter untuk shape
    public int[] getShape() {
        return shape;
    }

    // Override toString() untuk menampilkan tensor dengan format yang rapi (contoh untuk 2D)
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
