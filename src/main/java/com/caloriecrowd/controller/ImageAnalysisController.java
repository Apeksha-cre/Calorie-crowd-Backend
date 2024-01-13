package com.caloriecrowd.controller;

import com.caloriecrowd.model.ImageAnalysisResponse;
import com.caloriecrowd.service.IImageAnalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class ImageAnalysisController {

    @Autowired
    public IImageAnalysisService imageAnalysisService;

    @PostMapping(value="/image/analyze")
    public ImageAnalysisResponse getImageAnalysis(@RequestBody String image)
    {
    ImageAnalysisResponse analysisResponse=imageAnalysisService.analyzeImage(image);
    return analysisResponse;

    }
}
