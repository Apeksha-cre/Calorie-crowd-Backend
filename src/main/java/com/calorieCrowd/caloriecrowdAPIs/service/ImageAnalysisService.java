package com.calorieCrowd.caloriecrowdAPIs.service;


import com.calorieCrowd.caloriecrowdAPIs.model.AnalysisResponse;

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
public class ImageAnalysisService implements IimageAnalysisService{

    private final String logmealApiUrl="https://api.logmeal.es/v2/image/segmentation/complete/v1.0";
    WebClient webClient = WebClient.create();
    public AnalysisResponse imageAnalysis(String image)
    {
        Path tempFilePath = null;
        try {
            // Create a temporary file with a generated name
             tempFilePath = Files.createTempFile(null, ".jpg");

            // Content to be written to the file

            Files.write(tempFilePath, Base64.getDecoder().decode(image));

            System.out.println("File stored at: " + tempFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        URI url = UriComponentsBuilder.fromHttpUrl(logmealApiUrl).build().toUri();

        MultipartBodyBuilder builder = new MultipartBodyBuilder();
        builder.part("image",new FileSystemResource(tempFilePath));
        AnalysisResponse response=null;
        try {
        response= webClient.post()
                .uri(url)
                .contentType(MediaType.MULTIPART_FORM_DATA)
                .header("Authorization","Bearer 3c6ab6d44be89505943e1bfda67649a3218985c9")
                .body(BodyInserters.fromMultipartData(builder.build()))
                .retrieve()

               .bodyToMono(AnalysisResponse.class).block();
}catch (WebClientResponseException e) {
    System.out.println(e.getResponseBodyAsString());
}

//        RestTemplate restTemplate=new RestTemplate();
//
////        MultipartBodyBuilder builder = new MultipartBodyBuilder();
////        builder.part("image","");
//        HttpHeaders headers=new HttpHeaders();
//        headers.set("Authorization","Bearer 3c6ab6d44be89505943e1bfda67649a3218985c9");
//        headers.set("Content-Type","multipart/form-data");
//       //headers.setContentType(MediaType.MULTIPART_FORM_DATA);
////        MultiValueMap<String, HttpEntity<?>> body = builder.build();
//        MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
//        body.add("image", image);
//
//        HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, headers);
//        ResponseEntity<AnalysisResponse> analysisResponse = restTemplate.exchange(
//                logmealApiUrl,
//                HttpMethod.POST,
//                requestEntity,
//                AnalysisResponse.class
//        );
      // return analysisResponse.getBody();
        return response;
    }

}
