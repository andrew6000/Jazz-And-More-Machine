package com.andrew6000.JAMM;

import com.andrew6000.JAMM.song.Note;
import com.andrew6000.JAMM.song.Song;
import com.andrew6000.JAMM.song.chord.Chord;

public class Jamm {

    Song song;
    int songTime;
    int beat;

    public Jamm (){
        this.songTime = 0;
        this.beat = 0;
    }

    public void update(){
        if (this.songTime % 35 == 0) {
            Main.midiHandler.getMidiChannels()[0].allNotesOff();

            int chordIndex = this.beat % (song.getChords().length);
            Chord chord = song.getChords()[chordIndex];
            if (chord != null){
                for (Note note : chord.getChordTones()){
                    Main.midiHandler.getMidiChannels()[0].noteOn(note.getMidiValue(), 100);//On channel 0, play note number 60 with velocity 100
                }
            }

            this.beat++;
        }

        this.songTime++;
    }

    public void setSong(Song song) {
        this.song = song;
    }

    public int getSongTime() {
        return songTime;
    }
}
