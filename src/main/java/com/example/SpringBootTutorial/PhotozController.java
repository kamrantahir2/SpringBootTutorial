package com.example.SpringBootTutorial;

// In this class we will handle methods relating to the web server

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

// We added @RestController. This will add an instance of a RestController for this class
@RestController
public class PhotozController {

    // This private List is used to represent a database, THIS WILL BE REPLACED
//    private List<Photo> db = List.of(new Photo(1, "hello.jpeg"));

//    The above List has been replaced with the below Map
    private Map<String, Photo> db = new HashMap<>(){{
        put("1", new Photo("1", "hello.jpeg"));
}};

    // To start off we will be making a simple class that prints out Hello World on our localhost:8080 server

    // In simple terms GetMapping activates the specified URL

    // To display something on the web server we need to map it using @GetMapping:
    // The @GetMapping annotation represents a GET request ("/" = homepage)
    @GetMapping("/")
    public String hello() {
        return "Hello World";
    }


    // RETURN A LIST OF PHOTOS AND THEIR DATA
    // Since Spring knows we are returning a List<photo> it automatically converts the data to JSON for the web server
    @GetMapping("/photoz")
    public Collection<Photo> get() {
        return db.values();
        // We need to use db.values to return the full array
    }

    // GET A SPECIFIC PHOTO
    // We have added an {id} parameter to the URL to get a specific photo
    @GetMapping("/photoz/{id}")
    public Photo get(@PathVariable String id) {
        // We have added a parameter of String id which will at as the URL {id} with the marker @PathVariable which tells Spring that the URL {id} will act as the String id

        Photo photo = db.get(id);

        // We only want to return a photo if it is available. To handle this error Spring has a specific exception called by throw new ResponseStatusException(HttpStatus.NOT_FOUND) where we call ResponseStatusException() and specify the error.
        if (photo == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        // We now are able to return the full array of photos in our db with /photoz and are able to get a specific photo by its ID. Since we have used @PathVariable in the method parameter it will input the URL id as the method parameter
        return photo;
    }

    // DeleteMapping()- Used to delete a record
    @DeleteMapping("/photoz/{id}")
    public void delete(@PathVariable String id) {
        Photo photo = db.remove(id);
        if (photo == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        // TO USE THIS DELETE FUNCTION WE NEED TO GO TO CONSOLE IN CHROME AND COPY AND PASTE THE FOLLOWING -
//        (async function deletePhoto(id) {
//                await fetch("http://localhost:8080/photoz/" + id, {
//                method: "DELETE"
//          })
//})("5")
    }

    // PostMapping() used to upload photos
    @PostMapping("/photoz/")
    public void create(Photo photo) {
        // For this method we want the front end to send some JSON and Spring should convert it to a photo object
        // WE NEED TO SET THE ID SINCE THE FRONT END WON'T DO THAT
        // The below code generates a random ID as a String .
        photo.setId(UUID.randomUUID().toString());
        db.put(photo.getId(), photo);
    }

}