package com.andrew6000.JAMM.song.chord;

import com.andrew6000.JAMM.Main;
import com.andrew6000.JAMM.song.Note;
import com.andrew6000.JAMM.song.SongKey;

import java.util.ArrayList;

public class Chord {
   protected int degree;
   protected Note root;
   protected ArrayList<Note> chordTones;

    public Chord ( int degree ){
        degree -= 1;
        // "Chord" with no other notes, just the root
        this.degree = degree;
        this.root = new Note( Main.song.getSongKey().getDegrees()[degree] );
        this.chordTones = new ArrayList<>();
        this.chordTones.add(root);
    }

    public int getDegree() {
        return degree;
    }

    public Note getRoot() {
        return root;
    }

    public ArrayList<Note> getChordTones() {
        return chordTones;
    }
}
