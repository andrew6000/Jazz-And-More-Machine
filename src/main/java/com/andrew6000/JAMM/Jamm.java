package com.andrew6000.JAMM;

import com.andrew6000.JAMM.song.EnumNote;
import com.andrew6000.JAMM.song.Note;
import com.andrew6000.JAMM.song.Song;
import com.andrew6000.JAMM.song.chord.Chord;
import com.andrew6000.JAMM.song.event.EventChordChange;
import com.andrew6000.JAMM.song.event.SongEvent;

public class Jamm {

    static final EnumNote[] notes = new EnumNote[]{ EnumNote.A, EnumNote.B, EnumNote.C, EnumNote.D, EnumNote.E, EnumNote.F, EnumNote.G };
    static final int[] midiValues = new int[] { 57, 59, 60, 62, 64, 65, 67 };

    Song song;
    int songTime;
    int beat;

    public Jamm (){
        this.songTime = 0;
        this.beat = 0;
    }

    public void update(){
        SongEvent event = song.getSongEvents().get(songTime);
        if (event != null){

            Main.midiHandler.getMidiChannels()[0].allNotesOff();
            if (event instanceof EventChordChange){
                Chord chord = ((EventChordChange) event).getChord();
                if (chord != null) {
                    Main.midiHandler.getMidiChannels()[0].noteOn(chord.getRoot().getMidiValue(), 100);//On channel 0, play note number 60 with velocity 100
                }

            }

        }

        this.songTime++;
        this.songTime %= song.getLength();
    }

    public void setSong(Song song) {
        this.song = song;
    }

    public int getSongTime() {
        return songTime;
    }

    public static EnumNote[] getNotes() {
        return notes;
    }

    public static int[] getMidiValues() {
        return midiValues;
    }
}
