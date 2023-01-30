package main.designpattern1.adapter.impl;

import main.designpattern1.adapter.AdvanceMediaPlayer;
import main.designpattern1.adapter.model.AdvanceFormat;

public class AviPlayer implements AdvanceMediaPlayer {
    @Override
    public void playAdvanceFormat(AdvanceFormat advanceFormat) {
        System.out.println("Playing using Advance media player "+advanceFormat.getFileToPlay()+"."+
                advanceFormat.getFormatToPlay() + " in resolution " +advanceFormat.getResolution());
    }
}
