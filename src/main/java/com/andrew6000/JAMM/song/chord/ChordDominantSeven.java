package com.andrew6000.JAMM.song.chord;

import com.andrew6000.JAMM.song.Note;
import com.andrew6000.JAMM.song.NoteVals;
import com.andrew6000.JAMM.song.SongKey;

public class ChordDominantSeven extends ChordMajor {
    public ChordDominantSeven ( int degree) {
        super(degree);

        Note seventh = new Note(NoteVals.addInterval( root.getValue(), 10 ) );
        this.chordTones.add(seventh);
    }
}
