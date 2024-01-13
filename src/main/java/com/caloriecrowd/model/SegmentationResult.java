package com.caloriecrowd.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class SegmentationResult {

  @JsonProperty("recognition_results")
   public List<RecognitionsResult> recognitionsResults;

   public List<RecognitionsResult> getRecognitionsResults() {
      return recognitionsResults;
   }

   public void setRecognitionsResults(List<RecognitionsResult> recognitionsResults) {
      this.recognitionsResults = recognitionsResults;
   }
}
