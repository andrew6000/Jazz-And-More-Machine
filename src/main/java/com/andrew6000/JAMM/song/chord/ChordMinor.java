package com.andrew6000.JAMM.song.chord;

import com.andrew6000.JAMM.Jamm;
import com.andrew6000.JAMM.song.EnumAccidental;
import com.andrew6000.JAMM.song.Note;
import com.andrew6000.JAMM.song.NoteVals;
import com.andrew6000.JAMM.song.SongKey;

public class ChordMinor extends Chord {

    public ChordMinor(int degree) {
        super(degree);

        Note third = new Note(NoteVals.addInterval( root.getValue(), 3 ) );
        this.chordTones.add(third);

        Note fifth = new Note(NoteVals.addInterval( root.getValue(), 7 ) );
        this.chordTones.add(fifth);
    }
}
