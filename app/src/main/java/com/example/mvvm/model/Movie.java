package com.example.mvvm.model;

public class Movie {

    private String title;
    private String genre;
    private double rating;
    private int image;
    private int backgroundColor;

    public Movie(String title, String genre,
                 double rating, int image,
                 int backgroundColor) {

        this.title = title;
        this.genre = genre;
        this.rating = rating;
        this.image = image;
        this.backgroundColor = backgroundColor;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public double getRating() {
        return rating;
    }

    public int getImage() {
        return image;
    }

    public int getBackgroundColor() {
        return backgroundColor;
    }
}