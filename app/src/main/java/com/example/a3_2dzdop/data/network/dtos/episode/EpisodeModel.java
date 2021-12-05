package com.example.a3_2dzdop.data.network.dtos.episode;

import com.google.gson.annotations.SerializedName;
import java.util.Objects;

public class EpisodeModel {

    @SerializedName("id")
    private int id;
    @SerializedName("name")
    private String name;
    @SerializedName("air_date")
    private String air_date;
    @SerializedName("episode")
    private String episode;
    @SerializedName("url")
    private String url;
    @SerializedName("created")
    private String created;

    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAir_date() {
        return air_date;
    }

    public void setAir_date(String air_date) {
        this.air_date = air_date;
    }

    public String getEpisode() {
        return episode;
    }

    public void setEpisode(String episode) {
        this.episode = episode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EpisodeModel that =
                (EpisodeModel) o;
        return id == that.id &&
                Objects.equals(name, that.name) &&
                Objects.equals(air_date, that.air_date) &&
                Objects.equals(episode, that.episode) &&
                Objects.equals(url, that.url) &&
                Objects.equals(created, that.created);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, air_date, episode, url, created);
    }
}