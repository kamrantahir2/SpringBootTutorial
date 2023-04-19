package com.example.SpringBootTutorial;

// The Controller classes handle JSON well but have issues interacting with databases, instead of using a controller we made this PhotozService class to handle talking with databases

import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


// We can use both @Component or @Service here, We chose @Service since it has more features
// @Component
@Service
public class PhotozService {

    // This mock db was moved over from PhotozController
    private Map<String, Photo> db = new HashMap<>(){{
        put("1", new Photo("1", "hello.jpeg"));
    }};

    public static Collection<Photo> get() {
        return db.values();
    }

    public Photo get(String id) {
        return db.get(id);
    }

    public Photo remove(String id) {
        return db.remove(id);
    }

    // These parameters are inserted in PhotozController where we can make use of file.getOriginalFilename() and file.getBytes() as part of the MultipartFile class that we use in PhotozController
    public Photo save(String filename, byte[] data) {
        Photo photo = new Photo();
        photo.setId(UUID.randomUUID().toString());
        photo.setFilename(filename);
        photo.setData(data);
        db.put(photo.getId(), photo);
        return photo;
    }


}