package com.andrew6000.JAMM.song;

import com.andrew6000.JAMM.Jamm;

public class SongKey {
    private Note root;

    // The degrees of the chord, 0 through 6 (really I through vii) lol
    private NoteVals[] degrees;

    // The flats and sharps on each note, 0 thru 6
    private EnumAccidental[] keySignature;

    public SongKey(Note root){
        this.root = root;

        // The scale degrees of a major key (for now)
        this.degrees = new NoteVals[]{
            NoteVals.addInterval(root.getValue(), 0),
            NoteVals.addInterval(root.getValue(), 2),
            NoteVals.addInterval(root.getValue(), 4),
            NoteVals.addInterval(root.getValue(), 5),
            NoteVals.addInterval(root.getValue(), 7),
            NoteVals.addInterval(root.getValue(), 9),
            NoteVals.addInterval(root.getValue(), 11),
        };
        this.keySignature = new EnumAccidental[7];
    }

    public Note getRoot() {
        return root;
    }

    public NoteVals[] getDegrees() {
        return degrees;
    }

    public EnumAccidental[] getKeySignature() {
        return keySignature;
    }
}
