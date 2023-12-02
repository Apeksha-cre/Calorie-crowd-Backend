package com.calorieCrowd.caloriecrowdAPIs.model;

import java.util.List;

public class AnalysisResponse {

//    public List<Name> recofnitionResult;

   public List<SegmentationResult> segmentation_results;

   public List<SegmentationResult> getSegmentation_results() {
      return segmentation_results;
   }

   public void setSegmentation_results(List<SegmentationResult> segmentation_results) {
      this.segmentation_results = segmentation_results;
   }
}
