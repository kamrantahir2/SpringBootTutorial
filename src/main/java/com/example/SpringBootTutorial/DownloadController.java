package com.example.SpringBootTutorial;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DownloadController {

    // Instead of just returning a byte[] array we are returning ResponseEntity<byte[]> which is part of Spring Boot because we have the byte[] array but we also want to send back some HTTP headers including the file name
    @GetMapping("/download/{id}")
    public ResponseEntity<byte[]> download(@PathVariable String id) {

        // THIS FIELD IS INCORRECT, this field should be uninitialized. It has been initialized as a stopping point
        byte[] data = new byte[1];

        // HttpHeaders is part of Spring Boot
        HttpHeaders headers = new HttpHeaders();

        return new ResponseEntity<>(data, headers, HttpStatus.OK);
    }

}