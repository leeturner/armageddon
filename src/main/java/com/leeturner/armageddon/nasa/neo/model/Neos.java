package com.leeturner.armageddon.nasa.neo.model;

import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Neos {

    private Integer elementCount;
    private Map<String, List<NearEarthObject>> nearEarthObjectsDates;

    @JsonCreator
    public Neos(@JsonProperty("element_count") final Integer elementCount,
                @JsonProperty("near_earth_objects") final Map<String, List<NearEarthObject>> nearEarthObjectsDates) {
        super();
        this.elementCount = elementCount;
        this.nearEarthObjectsDates = nearEarthObjectsDates;
    }

    public Integer getElementCount() {
        return elementCount;
    }

    public Map<String, List<NearEarthObject>> getNearEarthObjectsDates() {
        return this.nearEarthObjectsDates;
    }

    public Integer getPotentiallyHazardousAsteroidCount() {
        AtomicReference<Integer> hazardousAsteroidCount = new AtomicReference<>(0);
        this.nearEarthObjectsDates.forEach((k,v) -> {v.forEach(nearEarthObject -> {
                if (nearEarthObject.getPotentiallyHazardousAsteroid()) {
                    hazardousAsteroidCount.getAndSet(hazardousAsteroidCount.get() + 1);
                };
            });}
        );
        return hazardousAsteroidCount.get();
    }
}
