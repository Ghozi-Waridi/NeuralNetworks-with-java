package com.neuralnetworks.data;

import java.util.List;

public class DataLoader {
  private Dataset<?> datasets;
  private List<Transform<?, ?>> pipelines;

  public DataLoader(Dataset<?> datasets, List<Transform<?, ?>> pipelines) {
    this.datasets = datasets;
    this.pipelines = pipelines;
  }

}
