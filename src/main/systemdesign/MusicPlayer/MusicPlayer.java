package main.systemdesign.MusicPlayer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/**
 * @author jitendra.kumar01
 * 22/01/20
 */
public class MusicPlayer {
    ArrayList<Song> musicList;
    Queue<Song> musicQ;
    int totalSongCount;
    Random random;

    public MusicPlayer() {
        System.out.println("<<<<< Intialialising Music Player >>>>>>");
        this.musicList = new ArrayList<>();
        this.musicQ = new LinkedList<>();
        this.totalSongCount = 0;
        this.random = new Random();
    }

    public void addSong(int id , String singer , String name , Genre type){
        musicList.add(new Song(id,name,singer,type));
        totalSongCount++;
    }

    public void playRandomSong(){
        if(totalSongCount <= 0){
            return;
        }
        int randInt = random.nextInt(totalSongCount);
        Song song = musicList.get(randInt);
        totalSongCount--;
        System.out.println("The song "+song.name + " is been added to playing queue ");
        musicQ.add(song);

    }

    public void playSong(int id , boolean addToQ){
        for (int i = 0; i <totalSongCount ; i++) {
            Song song = musicList.get(i);
            if(song.songID == id){
                musicList.remove(i);
                totalSongCount--;
                if(addToQ){
                    System.out.println("The song "+song.name + " is been added to playing queue ");
                }else {
                    System.out.println("The song "+song.name + " is currently played ");
                }

                musicList.add(song);
                return;
            }
        }

        for (int i = totalSongCount; i <musicList.size() ; i++) {
            Song song = musicList.get(i);
            if(song.songID == id){
                if(addToQ){
                    System.out.println("The song "+song.name + " is been added to playing queue ");
                }else {
                    System.out.println("The song "+song.name + " is currently played ");
                }
                return;
            }
        }
    }


    public void closeMusicPlayer(){
        System.out.println("<<<<<< Closing Music Player >>>>>>");
        musicList.clear();
        totalSongCount= musicList.size();
    }


   public void playMusicFromQueue()
    {
        //Play the song in the front of queue and remove it from the queue,
        //if queue is empty wait till songs come in the queue
        System.out.print("The current queue contains : [ ");
        for(Song s:musicQ)
        {
            System.out.println(s.name+" ");
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        MusicPlayer mp=new MusicPlayer();

        mp.addSong(1,"Maroon5","Memories",Genre.POP);
        mp.addSong(2,"Queen","Bohemian Rhapsody",Genre.ROCK);
        mp.addSong(3,"Led Zeppelin","Stairway to Heaven",Genre.ROCK);
        mp.addSong(4, "Lee Morgan", "Coera", Genre.JAZZ);
        mp.addSong(5,"BennyGoodman","Sing Sing Sing",Genre.JAZZ);
        mp.playMusicFromQueue();

        mp.playRandomSong();
        mp.playRandomSong();
        mp.playRandomSong();
        mp.playSong(3,true);
        mp.playSong(5,false);
        mp.playMusicFromQueue();

        mp.closeMusicPlayer();

        mp.playRandomSong();
        mp.playRandomSong();
        mp.playRandomSong();
        mp.playRandomSong();
        mp.playRandomSong();
        mp.playMusicFromQueue();
    }
}
