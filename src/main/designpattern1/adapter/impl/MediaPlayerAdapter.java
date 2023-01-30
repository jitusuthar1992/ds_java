package main.designpattern1.adapter.impl;

import main.designpattern1.adapter.AdvanceMediaPlayer;
import main.designpattern1.adapter.MediaPlayer;
import main.designpattern1.adapter.model.AdvanceFormat;

public class MediaPlayerAdapter implements MediaPlayer {
    AdvanceMediaPlayer advanceMediaPlayer;
    AdvanceFormat advanceFormat;
    public MediaPlayerAdapter(AdvanceFormat advanceFormat) {
        advanceMediaPlayer = new AviPlayer();
        this.advanceFormat = advanceFormat;
    }

    @Override
    public void play(String fileToPlay, String formatToPlay) {
        advanceFormat.setFileToPlay(fileToPlay);
        advanceFormat.setFormatToPlay(formatToPlay);
        advanceMediaPlayer.playAdvanceFormat(advanceFormat);
    }
}
