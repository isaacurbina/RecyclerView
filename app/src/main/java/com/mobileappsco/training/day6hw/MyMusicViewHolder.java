package com.mobileappsco.training.day6hw;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by admin on 3/2/2016.
 */
public class MyMusicViewHolder extends RecyclerView.ViewHolder {
    TextView song_title;
    TextView song_artist;

    public MyMusicViewHolder(View view) {
        super(view);
        this.song_title = (TextView) view.findViewById(R.id.item_title);
        this.song_artist = (TextView) view.findViewById(R.id.item_artist);
    }
}