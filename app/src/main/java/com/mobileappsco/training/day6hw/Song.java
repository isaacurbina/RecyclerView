package com.mobileappsco.training.day6hw;

import com.orm.SugarRecord;

/**
 * Created by admin on 3/2/2016.
 */
public class Song extends SugarRecord {

    String title;
    String artist;

    public Song() {

    }

    public Song(String title, String artist) {
        this.title = title;
        this.artist = artist;
    }
}
