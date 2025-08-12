package com.neuralnetworks.data;

import java.util.List;
import java.io.File;
// import com.sun.org.apache.xml.internal.security.transforms.Transform; 

public class DataLoader {
  private Dataset<?> datasets;
  private List<Transform> pipelines;
  private int currentIndex = 0;

  public DataLoader(Dataset<?> datasets, List<Transform> pipelines) {
    this.datasets = datasets;
    this.pipelines = pipelines;
  }

  /**
   * Proses data pada index tertentu dengan menerapkan transformasi yang telah
   * ditentukan.
   *
   * @param index indeks data yang akan diproses
   * @return hasil dari proses data setelah transformasi
   * @throws IndexOutOfBoundsException jika index tidak valid
   */
  public Object prosesData(int index) {
    // validasi index
    if (index < 0 || index >= datasets.size()) {
      throw new IndexOutOfBoundsException("Index out of bounds: " + index);
    }

    Object data = datasets.get(index);

    for (Transform transform : this.pipelines) {
      data = transform.apply(data);
    }
    return data;
  }

}
