package com.example.demo.api.response;



// import com.fasterxml.jackson.databind.ObjectMapper; // version 2.11.1
// import com.fasterxml.jackson.annotation.JsonProperty; // version 2.11.1
/* ObjectMapper om = new ObjectMapper();
Root root = om.readValue(myJsonString, Root.class); */

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@Getter
@Setter
public class WeatherResponse {
    public Current current;

    @Getter
    @Setter
    public class Current{
        public int temperature;

        @JsonProperty("weather_descriptions")
        public ArrayList<String> weather_descriptions;

        public int feelslike;
    }
}