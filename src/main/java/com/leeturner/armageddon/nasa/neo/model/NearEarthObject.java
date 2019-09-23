package com.leeturner.armageddon.nasa.neo.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class NearEarthObject {

    private String id;
    private String neoReferenceId;
    private String name;
    private String nasaJplUrl;
    private Double absoluteMagnitudeH;
    private Boolean isPotentiallyHazardousAsteroid;
    private Boolean isSentryObject;

    @JsonCreator
    public NearEarthObject(@JsonProperty("id") final String id,
                           @JsonProperty("neo_reference_id") final String neoReferenceId,
                           @JsonProperty("name") final String name,
                           @JsonProperty("nasa_jpl_url") final String nasaJplUrl,
                           @JsonProperty("absolute_magnitude_h") final Double absoluteMagnitudeH,
                           @JsonProperty("is_potentially_hazardous_asteroid") final Boolean isPotentiallyHazardousAsteroid,
                           @JsonProperty("is_sentry_object") final Boolean isSentryObject) {
        this.id = id;
        this.neoReferenceId = neoReferenceId;
        this.name = name;
        this.nasaJplUrl = nasaJplUrl;
        this.absoluteMagnitudeH = absoluteMagnitudeH;
        this.isPotentiallyHazardousAsteroid = isPotentiallyHazardousAsteroid;
        this.isSentryObject = isSentryObject;
    }

    public String getId() {
        return id;
    }

    public String getNeoReferenceId() {
        return neoReferenceId;
    }

    public String getName() {
        return name;
    }

    public String getNasaJplUrl() {
        return nasaJplUrl;
    }

    public Double getAbsoluteMagnitudeH() {
        return absoluteMagnitudeH;
    }

    public Boolean getPotentiallyHazardousAsteroid() {
        return isPotentiallyHazardousAsteroid;
    }

    public Boolean getSentryObject() {
        return isSentryObject;
    }
}
