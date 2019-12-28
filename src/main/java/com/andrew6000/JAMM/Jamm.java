package com.andrew6000.JAMM;

import com.andrew6000.JAMM.song.NoteVals;
import com.andrew6000.JAMM.song.Note;
import com.andrew6000.JAMM.song.Song;
import com.andrew6000.JAMM.song.chord.Chord;
import com.andrew6000.JAMM.song.event.EventChordChange;
import com.andrew6000.JAMM.song.event.SongEvent;

public class Jamm {

    public static MidiHandler midiHandler;

    Song song;
    int songTime;
    float beat;

    boolean metEnabled = true;

    public Jamm (){
        midiHandler = new MidiHandler();

        // jazz guitar patch lol
        midiHandler.getMidiChannels()[0].programChange(26);

        this.songTime = 0;
        this.beat = 0;
    }

    public void update(){
        this.beat = this.songTime / song.getBeatLength();
        SongEvent event = song.getSongEvents().get(this.beat);


        if (this.beat - ((int) this.beat) < 0.01){

            midiHandler.getMidiChannels()[9].allNotesOff();
            if ( (int)(this.beat) % song.getTimeSig() == 0 ){
                midiHandler.getMidiChannels()[9].noteOn(34, 100);
            }else{
                midiHandler.getMidiChannels()[9].noteOn(33, 100);
            }



        }

        if (event != null){

            midiHandler.getMidiChannels()[0].allNotesOff();
            if (event instanceof EventChordChange){
                Chord chord = ((EventChordChange) event).getChord();
                if (chord != null) {
                    for (Note note : chord.getChordTones()){
                        midiHandler.getMidiChannels()[0].noteOn(note.getMidiValue(), 50);
                    }
                }

            }

        }

        this.songTime++;
        this.songTime %= (song.getLength() * song.getBeatLength());
    }

    public void setSong(Song song) {
        this.song = song;
    }

    public int getSongTime() {
        return songTime;
    }
}
