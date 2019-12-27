package com.andrew6000.JAMM.util;

import com.andrew6000.JAMM.song.Note;

public class NoteUtil {
    public static int getSemitones(Note note1, Note note2){
        return Math.abs(note1.getMidiValue() - note2.getMidiValue());
    }
}
