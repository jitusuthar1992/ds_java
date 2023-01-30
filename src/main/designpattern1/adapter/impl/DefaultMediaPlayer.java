package main.designpattern1.adapter.impl;

import main.designpattern1.adapter.MediaPlayer;

public class DefaultMediaPlayer implements MediaPlayer {
    @Override
    public void play(String fileToPlay, String formatToPlay) {
        System.out.println("Playing "+fileToPlay + "."+formatToPlay);
    }
}
