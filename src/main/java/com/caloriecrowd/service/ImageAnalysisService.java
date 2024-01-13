package com.caloriecrowd.service;

import com.caloriecrowd.model.ImageAnalysisResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.MediaType;
import org.springframework.http.client.MultipartBodyBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Base64;

@Component
public class ImageAnalysisService implements IImageAnalysisService {

  private final String logmealApiUrl = "https://api.logmeal.es/v2/image/segmentation/complete/v1.0";
  WebClient webClient = WebClient.create();

  @Value("${logmeal.api.token}")
  private String bearerToken;

  public ImageAnalysisResponse analyzeImage(String image) {
    Path tempFilePath = null;
    try {
      // Create a temporary file with a generated name
      tempFilePath = Files.createTempFile(null, ".jpg");

      // Content to be written to the file

      Files.write(tempFilePath, Base64.getDecoder().decode(image));
    } catch (IOException e) {
      e.printStackTrace();
    }
    URI url = UriComponentsBuilder.fromHttpUrl(logmealApiUrl).build().toUri();

    MultipartBodyBuilder builder = new MultipartBodyBuilder();
    builder.part("image", new FileSystemResource(tempFilePath));
    ImageAnalysisResponse response = null;
    try {
      response =
          webClient
              .post()
              .uri(url)
              .contentType(MediaType.MULTIPART_FORM_DATA)
              .header("Authorization", "Bearer " + bearerToken)
              .body(BodyInserters.fromMultipartData(builder.build()))
              .retrieve()
              .bodyToMono(ImageAnalysisResponse.class)
              .block();
    } catch (WebClientResponseException e) {
      System.out.println(e.getResponseBodyAsString());
    }
    return response;
  }
}
