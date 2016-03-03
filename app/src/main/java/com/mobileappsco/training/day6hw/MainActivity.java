package com.mobileappsco.training.day6hw;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Song> songlist = new ArrayList<>();
    private RecyclerView recyclerView;
    private MusicRVAdapter mAdapter;
    TextView song_title;
    TextView song_artist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        song_title = (TextView) findViewById(R.id.txtsong_title);
        song_artist = (TextView) findViewById(R.id.txtsong_artist);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        songlist = Song.listAll(Song.class);
        Collections.reverse(songlist);
        mAdapter = new MusicRVAdapter(songlist);
        recyclerView.setAdapter(mAdapter);

        if (Song.count(Song.class) < 1)
            populateDB();
        Log.d("MYAPP", "Songs: "+Song.count(Song.class));
    }

    public void populateDB() {
        Song song = new Song("Free", "Chicago House Masterz");
        song.save();
        songlist.add(song);
    }

    public void addSong(View view) {
        Song song = new Song(song_title.getText().toString(), song_artist.getText().toString());
        song.save();
        song_title.setText("");
        song_title.setText("");
        mAdapter.addSongtoList(song);
        mAdapter.notifyDataSetChanged();
    }
}
