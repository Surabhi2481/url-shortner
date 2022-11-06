package org.alien.heimdall.controllers;

import org.alien.heimdall.services.HeimdallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class HeimdallController {

    @Autowired
    private HeimdallService heimdallService;

    @PostMapping("/shortUrl")
    public ResponseEntity<String> createShortUrl(@RequestBody String url){
        String shortUrl = heimdallService.createShortUrl(url);
        return new ResponseEntity<>(shortUrl, HttpStatus.OK);
    }

    @GetMapping("/{longUrl}")
    public ResponseEntity<String> getOriginalUrl(@PathVariable String shortUrl){
        String originalUrl = heimdallService.getOriginalUrl(shortUrl);
        return new ResponseEntity<>(originalUrl, HttpStatus.OK);
    }

}
