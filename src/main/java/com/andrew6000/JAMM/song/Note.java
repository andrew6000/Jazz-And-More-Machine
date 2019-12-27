package com.andrew6000.JAMM.song;

import com.andrew6000.JAMM.Jamm;

public class Note {
    private int midiValue;
    private EnumNote value;
    private EnumAccidental accidental;

    public Note (EnumNote value) {
        this.value = value;
        this.midiValue = Jamm.getMidiValues()[this.value.ordinal()];
    }

    public int getMidiValue() {
        return midiValue;
    }
}
