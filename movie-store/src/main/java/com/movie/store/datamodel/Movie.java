package com.movie.store.datamodel;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("movie")
public class Movie {


    @Id
    private String _id;
    String title;
    List<String> genres = new ArrayList<>();
    List<String> cast = new ArrayList<>();
    Integer year;
    String extract;
    public Movie(){}
    public Movie(String id, String title, List<String> genres, List<String> cast, Integer year, String extract) {
        super();
        this._id = id;
        this.title = title;
        this.genres = genres;
        this.cast = cast;
        this.year = year;
        this.extract = extract;
    }

    public Movie(String title) {
        new Movie(title, title, new ArrayList<>(), new ArrayList<>(), 9999, title);
    }

    public String get_id() {
        return _id;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public List<String> getCast() {
        return cast;
    }

    public void setCast(List<String> cast) {
        this.cast = cast;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getExtract() {
        return extract;
    }

    public void setExtract(String extract) {
        this.extract = extract;
    }
}