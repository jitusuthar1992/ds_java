package main.systemdesign;

/**
 * @author jitendra.kumar01
 * 25/10/19
 */
public class HitCounter {

    private static final int MAX_COUNT = 300;
    int timeStamp[] = new int[MAX_COUNT];
    int counter[] = new int[MAX_COUNT];

    void hits(int timestamp) {
        int index = timestamp % 300;
        if (timeStamp[index] != timestamp) {
            timeStamp[index] = timestamp;
            counter[index] = 1;
        } else {
            ++counter[index];
        }
    }

    int getHits(int timestamp) {
        int value = 0;

        for (int i = 0; i < MAX_COUNT; i++) {
            if (timestamp - 300 < timeStamp[i]) {
                value += counter[i];
            }
        }

        return value;
    }

    public static void main(String[] args) {

    }
}
