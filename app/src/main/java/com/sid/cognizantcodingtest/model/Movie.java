package com.sid.cognizantcodingtest.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Movie implements Parcelable {
    private String Title;
    private String Year;
    private String imdbID;
    private String Type;
    private String Poster;
    private String Runtime;
    private String Director;
    private String Writer;
    private String Actors;
    private String Plot;
    private String imdbRating;
    private String imdbVotes;

    public Movie(String title, String year, String imdbID, String type, String poster, String runtime, String director, String writer, String actors, String plot, String imdbRating, String imdbVotes) {
        Title = title;
        Year = year;
        this.imdbID = imdbID;
        Type = type;
        Poster = poster;
        Runtime = runtime;
        Director = director;
        Writer = writer;
        Actors = actors;
        Plot = plot;
        this.imdbRating = imdbRating;
        this.imdbVotes = imdbVotes;
    }

    public Movie(){

    }

    protected Movie(Parcel in) {
        Title = in.readString();
        Year = in.readString();
        imdbID = in.readString();
        Type = in.readString();
        Poster = in.readString();
        Runtime = in.readString();
        Director = in.readString();
        Writer = in.readString();
        Actors = in.readString();
        Plot = in.readString();
        imdbRating = in.readString();
        imdbVotes = in.readString();
    }

    public static final Creator<Movie> CREATOR = new Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel in) {
            return new Movie(in);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getYear() {
        return Year;
    }

    public void setYear(String year) {
        Year = year;
    }

    public String getImdbID() {
        return imdbID;
    }

    public void setImdbID(String imdbID) {
        this.imdbID = imdbID;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getPoster() {
        return Poster;
    }

    public void setPoster(String poster) {
        Poster = poster;
    }

    public static Creator<Movie> getCREATOR() {
        return CREATOR;
    }

    public String getRuntime() {
        return Runtime;
    }

    public void setRuntime(String runtime) {
        Runtime = runtime;
    }

    public String getDirector() {
        return Director;
    }

    public void setDirector(String director) {
        Director = director;
    }

    public String getWriter() {
        return Writer;
    }

    public void setWriter(String writer) {
        Writer = writer;
    }

    public String getActors() {
        return Actors;
    }

    public void setActors(String actors) {
        Actors = actors;
    }

    public String getPlot() {
        return Plot;
    }

    public void setPlot(String plot) {
        Plot = plot;
    }

    public String getImdbRating() {
        return imdbRating;
    }

    public void setImdbRating(String imdbRating) {
        this.imdbRating = imdbRating;
    }

    public String getImdbVotes() {
        return imdbVotes;
    }

    public void setImdbVotes(String imdbVotes) {
        this.imdbVotes = imdbVotes;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "Title='" + Title + '\'' +
                ", Year='" + Year + '\'' +
                ", imdbID='" + imdbID + '\'' +
                ", Type='" + Type + '\'' +
                ", Poster='" + Poster + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(Title);
        dest.writeString(Year);
        dest.writeString(imdbID);
        dest.writeString(Type);
        dest.writeString(Poster);
    }
}
