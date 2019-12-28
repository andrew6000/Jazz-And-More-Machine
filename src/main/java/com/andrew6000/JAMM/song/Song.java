package com.andrew6000.JAMM.song;

import com.andrew6000.JAMM.song.event.SongEvent;

import java.util.HashMap;

public class Song {
    private float tempo;
    private float beatLength;
    private int timeSig;
    private int length;
    private SongKey songKey;

    private HashMap<Float, SongEvent> songEvents;

    public Song (int length, float beatLength, SongKey key) {
        this.tempo = 120;
        this.beatLength = beatLength;
        this.timeSig = 4;
        this.length = length;
        this.songKey = key;

        this.songEvents = new HashMap<>();

    }

    public float getTempo() {
        return tempo;
    }

    public int getTimeSig() {
        return timeSig;
    }

    public HashMap<Float, SongEvent> getSongEvents() {
        return songEvents;
    }

    // Returns the length of the song in beats
    public int getLength() {
        return length;
    }

    public SongKey getSongKey() {
        return songKey;
    }

    public float getBeatLength() {
        return beatLength;
    }
}
