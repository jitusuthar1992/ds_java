package main.systemdesign.MusicPlayer;

/**
 * @author jitendra.kumar01
 * 22/01/20
 */
public class Song {
    int songID;
    String name;
    String singerName;
    Genre type;

    public Song(int songID, String name, String singerName, Genre type) {
        this.songID = songID;
        this.name = name;
        this.singerName = singerName;
        this.type = type;
    }
}
