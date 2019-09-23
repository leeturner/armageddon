package com.leeturner.armageddon.nasa.apod;

import com.leeturner.armageddon.nasa.apod.model.Apod;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ApodApiClient {

    private String nasaApodEndpoint;

    public ApodApiClient(@Value("${nasa.apod.endpoint}") final String nasaApodEndpoint) {
        this.nasaApodEndpoint = nasaApodEndpoint;
    }

    public Apod getApod() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Apod> response = restTemplate.getForEntity(this.nasaApodEndpoint, Apod.class);
        return response.getBody();
    }
}

