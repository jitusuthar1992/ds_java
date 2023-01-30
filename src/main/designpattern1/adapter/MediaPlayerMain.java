package main.designpattern1.adapter;

import main.designpattern1.adapter.impl.MediaPlayerImpl;

public class MediaPlayerMain {
    public static void main(String[] args) {
        MediaPlayer mediaPlayer = new MediaPlayerImpl();
        //mediaPlayer.play("mysong","mp3");
        mediaPlayer.play("mysongInNewFormat","avi");
    }
}
