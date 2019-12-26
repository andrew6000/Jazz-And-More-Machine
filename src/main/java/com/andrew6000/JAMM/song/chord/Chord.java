package com.andrew6000.JAMM.song.chord;

import com.andrew6000.JAMM.song.Note;

public class Chord {
    protected Note root;
    protected Note[] chordTones;

    public Chord ( Note root ){
        this.root = root;

        // "Chord" with no other notes, just the root
        this.chordTones = new Note[] { root };
    }

    public Note getRoot() {
        return root;
    }

    public Note[] getChordTones() {
        return chordTones;
    }
}
