package com.andrew6000.JAMM.song;

public enum NoteVals {
    A, A_SHARP, B, C, C_SHARP, D, D_SHARP, E, F, F_SHARP, G, G_SHARP;

    public static NoteVals[] noteVals = new NoteVals[] {
        A, A_SHARP, B, C, C_SHARP, D, D_SHARP, E, F, F_SHARP, G, G_SHARP
    };

    public static NoteVals addInterval (NoteVals val, int semitones){
        int index = (val.ordinal() + semitones) % noteVals.length;
        return noteVals[index];
    }
}
