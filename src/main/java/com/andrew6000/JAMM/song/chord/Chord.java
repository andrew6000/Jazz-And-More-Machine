package com.andrew6000.JAMM.song.chord;

import com.andrew6000.JAMM.song.Note;
import com.andrew6000.JAMM.song.SongKey;

public class Chord {
   protected int degree;
   protected Note root;

    public Chord ( int degree, SongKey key ){
        degree -= 1;
        // "Chord" with no other notes, just the root
        this.degree = degree;
        this.root = new Note( key.getDegrees()[degree] );
    }

    public int getDegree() {
        return degree;
    }

    public Note getRoot() {
        return root;
    }
}
