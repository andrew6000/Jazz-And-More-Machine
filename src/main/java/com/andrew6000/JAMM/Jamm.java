package com.andrew6000.JAMM;

public class Jamm {

    Song song;
    int songTime;

    public Jamm (){
        this.songTime = 0;
    }

    public void update(){
        if (this.songTime % 20 == 0) {
            Main.midiHandler.getMidiChannels()[0].noteOn(60, 100);//On channel 0, play note number 60 with velocity 100
        }else if (this.songTime % 20 == 10){
            Main.midiHandler.getMidiChannels()[0].noteOff(60);//turn of the note
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
