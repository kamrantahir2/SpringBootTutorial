package com.example.SpringBootTutorial;

public class Photo {
    private String id;
    private String filename;
    // raw data

    // MAKE SURE TO ALWAYS HAVE AN EMPTY CONSTRUCTOR TO AVOID ISSUES WITH JSON
    public Photo() {

    }

    public Photo(String id, String filename) {
        this.id = id;
        this.filename = filename;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }
}