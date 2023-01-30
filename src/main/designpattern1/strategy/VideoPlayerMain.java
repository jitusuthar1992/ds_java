package main.designpattern1.strategy;

import main.designpattern1.strategy.impl.*;

public class VideoPlayerMain {
    public static void main(String[] args) {
        Resolution p480 = new P480();
        Device phone = new Phone();
        VideoPlayer phonePlayer = new PhoneVideoPlayer(phone,p480);
        phonePlayer.display();

        Resolution p720 = new P720();
        Device tv = new TV();
        VideoPlayer tvPlayer = new TVVideoPlayer(tv,p720);
        tv.display();
    }
}
