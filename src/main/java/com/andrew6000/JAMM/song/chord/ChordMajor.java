package com.andrew6000.JAMM.song.chord;

import com.andrew6000.JAMM.song.Note;

public class ChordMajor extends Chord {
    public ChordMajor (Note root){
        super(root);
        this.chordTones = new Note[] { root, new Note(root.getMidiValue() + 4), new Note (root.getMidiValue() + 7) };
    }
}
