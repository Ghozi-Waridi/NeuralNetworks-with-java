package com.neuralnetworks.data;

/**
 * Transform
 */
public interface Transform<I, O> {
  O apply(I input);

}
