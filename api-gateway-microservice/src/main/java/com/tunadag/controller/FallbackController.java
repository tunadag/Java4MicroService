package com.tunadag.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class FallbackController {

    @GetMapping("/fallbackauth")
    public ResponseEntity<String> fallbackauth(){
        return ResponseEntity.ok("Servis şu an çalışmıyor. Başka zaman... :)");
    }

    @GetMapping("/fallbackproduct")
    public ResponseEntity<String> fallbackproduct(){
        return ResponseEntity.ok("Servis şu an çalışmıyor. Başka zaman... :)");
    }

    @GetMapping("/fallbacksales")
    public ResponseEntity<String> fallbacksales(){
        return ResponseEntity.ok("Servis şu an çalışmıyor. Başka zaman... :)");
    }

    @GetMapping("/fallbackuser")
    public ResponseEntity<String> fallbackuser(){
        return ResponseEntity.ok("Servis şu an çalışmıyor. Başka zaman... :)");
    }
}
