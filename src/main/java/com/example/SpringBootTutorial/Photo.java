package com.example.SpringBootTutorial;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotEmpty;

public class Photo {
    private String id;

    // The @NotEmpty annotation makes sure that the filename is not empty
    @NotEmpty
    private String filename;

    // Used to set headers in DownloadController

    private String contentType;

    // When we get the JSON on the web server it includes the metadata (bytes[] array) which is huge and clogs up the screen. To avoid this we simply add the annotation @JsonIgnore
    @JsonIgnore
    private byte[] data;

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

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }
}