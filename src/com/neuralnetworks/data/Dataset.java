package com.neuralnetworks.data;

/**
 * Dataset
 */
public interface Dataset <T>{
T get(int index);
int size();
int sizeLabels();
  
}
