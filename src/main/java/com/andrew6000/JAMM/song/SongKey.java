package com.andrew6000.JAMM.song;

import com.andrew6000.JAMM.Jamm;

public class SongKey {
    private EnumNote root;

    // The degrees of the chord, 0 through 6 (really I through vii) lol
    private EnumNote[] degrees;

    public SongKey(EnumNote root){
        this.root = root;
        int index = root.ordinal();

        this.degrees = new EnumNote[7];
        for (int i = 0; i < degrees.length; i++){
            this.degrees[i] = Jamm.getNotes()[ (index + i) % 7 ];
        }
    }

    public EnumNote getRoot() {
        return root;
    }

    public EnumNote[] getDegrees() {
        return degrees;
    }
}
