package com.mobileappsco.training.day6hw;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by admin on 3/2/2016.
 */
public class MusicRVAdapter extends RecyclerView.Adapter<MyMusicViewHolder> {

    private List<Song> songlist;

    public MusicRVAdapter(List<Song> songlist) {
        this.songlist = songlist;
    }

    @Override
    public MyMusicViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.song_item, parent, false);
        return new MyMusicViewHolder(itemView);
    }

    public void addSongtoList(Song song) {
        songlist.add(0, song);
    }

    @Override
    public void onBindViewHolder(MyMusicViewHolder holder, int position) {
        Song song = songlist.get(position);
        holder.song_title.setText(song.title);
        holder.song_artist.setText(song.artist);
    }

    @Override
    public int getItemCount() {
        return songlist.size();
    }
}
