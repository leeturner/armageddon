package com.leeturner.armageddon.nasa.apod.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

class ApodUnitTest {

    @Test
    void testApodJacksonSerialisation() throws IOException {
        Apod apod = new ObjectMapper().readValue(this.getClass().getResourceAsStream("/apod/apod.json"), Apod.class);

        assertThat(apod.getCopyright()).isEqualTo("Anton Komlev");
        assertThat(apod.getExplanation()).isEqualTo("What do you see when you look into this sky? In the center, in the dark, do you see a night sky filled with stars?");
        assertThat(apod.getDate()).isEqualTo("2019-09-22");
        assertThat(apod.getHdurl()).isEqualTo("https://apod.nasa.gov/apod/image/1909/EyeDragonSky_Komlev_2000.jpg");
        assertThat(apod.getMediaType()).isEqualTo("image");
        assertThat(apod.getServiceVersion()).isEqualTo("v1");
        assertThat(apod.getTitle()).isEqualTo("Eye Sky a Dragon");
        assertThat(apod.getUrl()).isEqualTo("https://apod.nasa.gov/apod/image/1909/EyeDragonSky_Komlev_960.jpg");
    }
}
