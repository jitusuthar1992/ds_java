package main.systemdesign.countminsketch;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadLocalRandom;

public class Producer implements Runnable {

    private BlockingQueue<Character> blockingQueue;

    private static Character[] characters = new Character[26];

    public Producer(BlockingQueue<Character> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    static {
        for (int i = 0; i < 26; i++) {
            characters[i] = (char) (i + 'A');
        }
    }

    @Override
    public void run() {

        while (true) {

            final int randomNumber = ThreadLocalRandom.current().nextInt(26);
            blockingQueue.add(characters[randomNumber]);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
