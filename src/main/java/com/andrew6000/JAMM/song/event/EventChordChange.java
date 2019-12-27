package com.andrew6000.JAMM.song.event;

import com.andrew6000.JAMM.song.chord.Chord;

public class EventChordChange extends SongEvent {
    private Chord chord;

    public EventChordChange(Chord chord){
        this.chord = chord;
    }

    public Chord getChord() {
        return chord;
    }
}
