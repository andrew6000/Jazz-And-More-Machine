package com.andrew6000.JAMM.song.chord;

import com.andrew6000.JAMM.song.Note;
import com.andrew6000.JAMM.song.NoteVals;
import com.andrew6000.JAMM.song.SongKey;

public class ChordMajorSeven extends ChordMajor {
    public ChordMajorSeven (int degree){
        super(degree);

        Note seventh = new Note(NoteVals.addInterval( root.getValue(), 11 ) );
        this.chordTones.add(seventh);
    }
}
