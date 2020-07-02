package com.sid.cognizantcodingtest.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RoomResponse {
    @SerializedName("name")
    @Expose()
    private String name;

    @SerializedName("capacity")
    @Expose()
    private String capacity;

    @SerializedName("level")
    @Expose()
    private String level;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "RoomResponse{" +
                "name='" + name + '\'' +
                ", capacity='" + capacity + '\'' +
                ", level='" + level + '\'' +
                '}';
    }
}
