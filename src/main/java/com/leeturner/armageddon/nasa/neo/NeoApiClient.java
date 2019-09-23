package com.leeturner.armageddon.nasa.neo;

import java.time.LocalDate;

import com.leeturner.armageddon.nasa.neo.model.Neos;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NeoApiClient {

    private String nasaNeoEndpoint;

    public NeoApiClient(@Value("${nasa.neo.enpoint}") final String nasaNeoEndpoint) {
        this.nasaNeoEndpoint = nasaNeoEndpoint;
    }

    public Neos getNeos() {
        LocalDate now = LocalDate.now();
        return this.getNeos(now, now);
    }

    public Neos getNeos(LocalDate start, LocalDate end) {
        //start_date=2019-09-22&end_date=2019-09-23
        String fullEndpointUrl = this.nasaNeoEndpoint + "&start_date=" + start + "&end_date=" + end;
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Neos> response = restTemplate.getForEntity(fullEndpointUrl, Neos.class);
        return response.getBody();
    }
}
