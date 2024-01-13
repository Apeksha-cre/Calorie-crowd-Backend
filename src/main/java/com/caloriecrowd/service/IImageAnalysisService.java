package com.caloriecrowd.service;

import com.caloriecrowd.model.ImageAnalysisResponse;

public interface IImageAnalysisService {

  public ImageAnalysisResponse analyzeImage(String image);
}
