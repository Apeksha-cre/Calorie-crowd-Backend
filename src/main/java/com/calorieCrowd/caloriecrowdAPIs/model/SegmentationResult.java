package com.calorieCrowd.caloriecrowdAPIs.model;

import java.util.List;

public class SegmentationResult {

   public List<RecognizationResult> recognition_results;

   public List<RecognizationResult> getRecognition_results() {
      return recognition_results;
   }

   public void setRecognition_results(List<RecognizationResult> recognition_results) {
      this.recognition_results = recognition_results;
   }
}
