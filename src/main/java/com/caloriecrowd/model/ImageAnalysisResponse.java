package com.caloriecrowd.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ImageAnalysisResponse {

  @JsonProperty("segmentation_results")
  public List<SegmentationResult> segmentationResults;

  public List<SegmentationResult> getSegmentationResults() {
    return segmentationResults;
  }

  public void setSegmentationResults(List<SegmentationResult> segmentationResults) {
    this.segmentationResults = segmentationResults;
  }
}
