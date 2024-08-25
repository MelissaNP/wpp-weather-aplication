package com.springdemo.demo;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @PostMapping("/whatsapp")
    public void receiveMessage(@RequestBody Map<String, String> requestBody) {
        String from = requestBody.get("From").replace("whatsapp:", "+14155238886");
        String body = requestBody.get("Body");

        String weatherMessage = weatherService.getWeatherMessage(body.trim());

        twilioService.sendMessage(from, weatherMessage);
    }
}