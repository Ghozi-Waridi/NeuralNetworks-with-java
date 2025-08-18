package com.neuralnetworks;

import com.neuralnetworks.data.Transform;
import com.neuralnetworks.math.Tensor;
import com.neuralnetworks.data.DataLoader;
import com.neuralnetworks.data.Dataset;
import com.neuralnetworks.data.GrayScale;
import com.neuralnetworks.data.ImageFolderDataset;
import com.neuralnetworks.data.Resize;
import com.neuralnetworks.data.ToTensor;

import java.util.List;

public class App {
  public static void main(String[] args) {
    // List<String> labels = List.of("no", "yes");
    // String PATH = "data/raw";
    // ImageFolderDataset dataset = new ImageFolderDataset(PATH);
    //
    // // System.out.println(dataset.get(2).toString());
    // List<Transform> pipelines = List.of(
    // new GrayScale(),
    // new Resize(28, 28),
    // new ToTensor(labels)
    // );
    //
    // DataLoader loader = new DataLoader(dataset, pipelines);
    // Object data = loader.prosesData(100);
    // System.out.println(data);

  }
}
