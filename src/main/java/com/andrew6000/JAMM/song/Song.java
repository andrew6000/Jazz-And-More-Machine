package com.andrew6000.JAMM.song;

import com.andrew6000.JAMM.song.event.SongEvent;

import java.util.HashMap;

public class Song {
    private float tempo;
    private int timeSig;
    private int length;

    private HashMap<Integer, SongEvent> songEvents;

    public Song (int length) {
        this.tempo = 120;
        this.timeSig = 4;
        this.length = length;

        this.songEvents = new HashMap<>();

    }

    public float getTempo() {
        return tempo;
    }

    public int getTimeSig() {
        return timeSig;
    }

    public HashMap<Integer, SongEvent> getSongEvents() {
        return songEvents;
    }

    public int getLength() {
        return length;
    }
}
