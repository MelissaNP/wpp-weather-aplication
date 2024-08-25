package com.springdemo.demo;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {

    @Value("${weatherstack.api_key}")
    private String weatherApiKey;

    private final RestTemplate restTemplate;

    public WeatherService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String getWeatherMessage(String location) {
        String urlString = "http://api.weatherstack.com/current?access_key=" + weatherApiKey + "&query=" + location;
        String result = restTemplate.getForObject(urlString, String.class);

        JSONObject jsonResponse = new JSONObject(result);
        JSONObject currentWeather = jsonResponse.getJSONObject("current");
        int temperature = currentWeather.getInt("temperature");
        String weatherDescription = currentWeather.getJSONArray("weather_descriptions").getString(0);
        int humidity = currentWeather.getInt("humidity");

        return "Current weather in " + location + ":\n" +
                "Temperature: " + temperature + "°C\n" +
                "Condition: " + weatherDescription + "\n" +
                "Humidity: " + humidity + "%";
    }
}