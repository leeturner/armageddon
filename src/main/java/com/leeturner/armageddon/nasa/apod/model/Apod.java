package com.leeturner.armageddon.nasa.apod.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Apod {

    private String copyright;
    private String date;
    private String explanation;
    private String hdurl;
    private String mediaType;
    private String serviceVersion;
    private String title;
    private String url;

    /**
     * No args constructor for use in serialization
     */
    public Apod() {
    }

    @JsonCreator
    public Apod(@JsonProperty("copyright") final String copyright,
                @JsonProperty("date") final String date,
                @JsonProperty("explanation") final String explanation,
                @JsonProperty("hdurl")final String hdurl,
                @JsonProperty("media_type") final String mediaType,
                @JsonProperty("service_version") final String serviceVersion,
                @JsonProperty("title") final String title,
                @JsonProperty("url")final String url) {
        super();
        this.copyright = copyright;
        this.date = date;
        this.explanation = explanation;
        this.hdurl = hdurl;
        this.mediaType = mediaType;
        this.serviceVersion = serviceVersion;
        this.title = title;
        this.url = url;
    }

    public String getCopyright() {
        return copyright;
    }

    public String getDate() {
        return date;
    }

    public String getExplanation() {
        return explanation;
    }

    public String getHdurl() {
        return hdurl;
    }

    public String getMediaType() {
        return mediaType;
    }

    public String getServiceVersion() {
        return serviceVersion;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }
}