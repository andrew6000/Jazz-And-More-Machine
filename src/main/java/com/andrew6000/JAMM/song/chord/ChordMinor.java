package com.andrew6000.JAMM.song.chord;

import com.andrew6000.JAMM.song.Note;

public class ChordMinor extends Chord {
    public ChordMinor (Note root){
        super(root);
        this.chordTones = new Note[] { root, new Note(root.getMidiValue() + 3), new Note (root.getMidiValue() + 7) };
    }
}
