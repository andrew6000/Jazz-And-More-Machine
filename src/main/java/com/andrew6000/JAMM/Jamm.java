package com.andrew6000.JAMM;

import com.andrew6000.JAMM.song.Note;
import com.andrew6000.JAMM.song.Song;
import com.andrew6000.JAMM.song.chord.Chord;
import com.andrew6000.JAMM.song.event.EventChordChange;
import com.andrew6000.JAMM.song.event.SongEvent;

public class Jamm {

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
                    for (Note note : chord.getChordTones()) {
                        Main.midiHandler.getMidiChannels()[0].noteOn(note.getMidiValue(), 100);//On channel 0, play note number 60 with velocity 100
                    }
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
}
