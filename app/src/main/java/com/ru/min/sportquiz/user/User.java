package com.ru.min.sportquiz.user;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

@Entity(tableName = "users")
public class User {

    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "name")
    private String name;
    private int score;
    private int actualWallpaper;
    //private List<Integer> purchasedWallpapers;

    public User(String name) {
        this.name = name;
        this.score = 0;
        this.actualWallpaper = 0;
        //this.purchasedWallpapers = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @NotNull
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getActualWallpaper() {
        return actualWallpaper;
    }

    public void setActualWallpaper(int actualWallpaper) {
        this.actualWallpaper = actualWallpaper;
    }

    /*public List<Integer> getPurchasedWallpapers() {
        return purchasedWallpapers;
    }

    public void setPurchasedWallpapers(List<Integer> purchasedWallpapers) {
        this.purchasedWallpapers = purchasedWallpapers;
    }*/

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", score=" + score +
                ", actualWallpaper=" + actualWallpaper +
                '}';
    }
}
