package com.andrew6000.JAMM.song;

import com.andrew6000.JAMM.song.chord.Chord;

public class Song {
    private float tempo;
    private int timeSig;

    private Chord[] chords;

    public Song ( Chord[] chords ) {
        this.tempo = 120;
        this.timeSig = 4;
        this.chords = chords;
    }

    public float getTempo() {
        return tempo;
    }

    public Chord[] getChords() {
        return chords;
    }

    public int getTimeSig() {
        return timeSig;
    }
}
