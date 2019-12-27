package com.andrew6000.JAMM.song;

import com.andrew6000.JAMM.Jamm;

public class Note {
    private int midiValue;
    private int octave;
    private NoteVals value;
    private EnumAccidental accidental;

    public Note (NoteVals value, EnumAccidental accidental, int octave) {
        this.value = value;
        this.midiValue = (octave * 12) + this.value.ordinal() - 3;
        this.accidental = accidental;
        this.octave = octave;
    }

    public Note (NoteVals value){
        this(value, EnumAccidental.NATURAL, 5);
    }
    public Note (NoteVals value, int octave){
        this(value, EnumAccidental.NATURAL, octave);
    }

    public int getMidiValue() {
        if (accidental == EnumAccidental.FLAT){
            return this.midiValue - 1;
        }else if (accidental == EnumAccidental.SHARP){
            return this.midiValue + 1;
        }else{
            return this.midiValue;
        }
    }

    public NoteVals getValue() {
        return value;
    }

    public EnumAccidental getAccidental() {
        return accidental;
    }

    public void setAccidental(EnumAccidental accidental) {
        this.accidental = accidental;
    }

    public int getOctave() {
        return octave;
    }
}
