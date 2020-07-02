package com.sid.cognizantcodingtest.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MovieResponse {
    @SerializedName("Title")
    @Expose()
    private String title;

    @SerializedName("Year")
    @Expose()
    private String year;

    @SerializedName("Runtime")
    @Expose()
    private String runtime;

    @SerializedName("imdbRating")
    @Expose()
    private String imdbRating;

    @SerializedName("Plot")
    @Expose()
    private String plot;

    @SerializedName("imdbVotes")
    @Expose()
    private String imdbVotes;

    @SerializedName("Director")
    @Expose()
    private String director;

    @SerializedName("Writer")
    @Expose()
    private String writer;

    @SerializedName("Actors")
    @Expose()
    private String actors;

    @SerializedName("imdbID")
    @Expose()
    private String imdbID;

    @SerializedName("Poster")
    @Expose()
    private String poster;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getImdbID() {
        return imdbID;
    }

    public void setImdbID(String imdbID) {
        this.imdbID = imdbID;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getRuntime() {
        return runtime;
    }

    public void setRuntime(String runtime) {
        this.runtime = runtime;
    }

    public String getImdbRating() {
        return imdbRating;
    }

    public void setImdbRating(String imdbRating) {
        this.imdbRating = imdbRating;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public String getImdbVotes() {
        return imdbVotes;
    }

    public void setImdbVotes(String imdbVotes) {
        this.imdbVotes = imdbVotes;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    @Override
    public String toString() {
        return "MovieResponse{" +
                "title='" + title + '\'' +
                ", year='" + year + '\'' +
                ", runtime='" + runtime + '\'' +
                ", imdbRating='" + imdbRating + '\'' +
                ", plot='" + plot + '\'' +
                ", imdbVotes='" + imdbVotes + '\'' +
                ", director='" + director + '\'' +
                ", writer='" + writer + '\'' +
                ", actors='" + actors + '\'' +
                ", imdbID='" + imdbID + '\'' +
                ", poster='" + poster + '\'' +
                '}';
    }
}
