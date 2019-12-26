package com.andrew6000.JAMM;

import javax.sound.midi.*;

// Thank you to user2955146 and double-beep at stack overflow for helping get me started:
// https://stackoverflow.com/questions/16462854/midi-beginner-need-to-play-one-note

public class MidiHandler {
    MidiChannel[] midiChannels;

    public MidiHandler() {
        try{
            /* Create a new Sythesizer and open it. Most of
             * the methods you will want to use to expand on this
             * example can be found in the Java documentation here:
             * https://docs.oracle.com/javase/7/docs/api/javax/sound/midi/Synthesizer.html
             */
            Synthesizer midiSynth = MidiSystem.getSynthesizer();
            midiSynth.open();

            //get and load default instrument and channel lists
            Instrument[] instr = midiSynth.getDefaultSoundbank().getInstruments();
            midiChannels = midiSynth.getChannels();

            midiSynth.loadInstrument(instr[0]);//load an instrument

        } catch (MidiUnavailableException e) {}
    }

    public MidiChannel[] getMidiChannels() {
        return midiChannels;
    }
}
