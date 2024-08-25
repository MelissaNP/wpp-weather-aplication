package com.springdemo.demo;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class WeatherController {
    
    private final TwilioService twilioService;
    private final WeatherService weatherService;
    
    public WeatherController(TwilioService twilioService, WeatherService weatherService) {
        this.twilioService = twilioService;
        this.weatherService = weatherService;
    }
    
    @PostMapping(value = "/whatsapp", consumes = "application/x-www-form-urlencoded")
    public void receiveMessage(@RequestParam Map<String, String> requestBody) {
        String from = requestBody.get("From");
        String body = requestBody.get("Body");
        
        if (from != null && body != null) {
            from = from.replace("whatsapp:", "");
            String weatherMessage = weatherService.getWeatherMessage(body.trim());
            twilioService.sendMessage(from, weatherMessage);
        } else {
            System.out.println("Received request with missing 'From' or 'Body'. Request body: " + requestBody);
        }
    }
}