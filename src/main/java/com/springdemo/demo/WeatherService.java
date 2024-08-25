package com.springdemo.demo;

import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {

    private static final String API_URL = "http://api.weatherstack.com/current?access_key=4b609c3eeb1f57b25df9898e7dc935d1&query=";
    
    public String getWeatherMessage(String location) {
            RestTemplate restTemplate = new RestTemplate();
            String url = API_URL + location;
            String response = restTemplate.getForObject(url, String.class);
            
            JSONObject jsonResponse = new JSONObject(response);
            
            if (jsonResponse.has("error")) {
                return "Unable to fetch weather data. Please try again later.";
            }
            
            JSONObject currentWeather = jsonResponse.getJSONObject("current");
            
            String temperature = currentWeather.get("temperature").toString();
            String weatherDescription = currentWeather.getJSONArray("weather_descriptions").getString(0);
            String humidity = currentWeather.get("humidity").toString();
            
            return String.format("Current weather in %s:\nTemperature: %s°C\nCondition: %s\nHumidity: %s%%",
                    location, temperature, weatherDescription, humidity);
        }

/*
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
                "Humidity: " + humidity + "%";*/
    }
