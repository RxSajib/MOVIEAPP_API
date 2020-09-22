package com.example.moviestreaming.Model;

public class Catagory {

    private int Id;
    private String MovieName;
    private String ImageUri;
    private String FileUri;

    public Catagory(int id, String movieName, String imageUri, String fileUri) {
        Id = id;
        MovieName = movieName;
        ImageUri = imageUri;
        FileUri = fileUri;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getMovieName() {
        return MovieName;
    }

    public void setMovieName(String movieName) {
        MovieName = movieName;
    }

    public String getImageUri() {
        return ImageUri;
    }

    public void setImageUri(String imageUri) {
        ImageUri = imageUri;
    }

    public String getFileUri() {
        return FileUri;
    }

    public void setFileUri(String fileUri) {
        FileUri = fileUri;
    }
}
