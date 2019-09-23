package com.leeturner.armageddon.nasa.neo.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class NeosUnitTest {

    private Neos neos;

    @BeforeEach
    void setup() throws IOException {
        this.neos = new ObjectMapper().readValue(this.getClass().getResourceAsStream("/neo/neo.json"), Neos.class);
    }

    @Test
    void testNeosJacksonSerialisation() throws IOException {
        assertThat(this.neos.getElementCount()).isEqualTo(15);
        assertThat(this.neos.getNearEarthObjectsDates()).hasSize(2);

        List<NearEarthObject> nearEarthObjects20190923 = this.neos.getNearEarthObjectsDates().get("2019-09-23");
        assertThat(nearEarthObjects20190923).hasSize(8);

        List<NearEarthObject> nearEarthObjects20190922 = this.neos.getNearEarthObjectsDates().get("2019-09-22");
        assertThat(nearEarthObjects20190922).hasSize(7);
    }

    @Test
    void testPotentiallyHazardousAsteroidCount() {
        assertThat(this.neos.getPotentiallyHazardousAsteroidCount()).isEqualTo(4);
    }
}
