package main.array;

import java.util.HashMap;

public class NutBoltProblem {
    static void nutboltmatch(char nuts[], char bolts[], int n)
    {
        HashMap<Character, Integer> hash = new HashMap<>();

        // creating a hashmap for nuts
        for (int i = 0; i < n; i++)
            hash.put(nuts[i], i);

        // searching for nuts for each bolt in hash map
        for (int i = 0; i < n; i++)
            if (hash.containsKey(bolts[i]))
                nuts[i] = bolts[i];

        // print the result
        System.out.println("matched nuts and bolts are-");
        for (int i = 0; i < n; i++)
            System.out.print(nuts[i] + " ");
        System.out.println();
        for (int i = 0; i < n; i++)
            System.out.print(bolts[i] + " ");
    }

    // Driver code
    public static void main(String[] args)
    {
        char nuts[] = { '@', '#', '$', '%', '^', '&' };
        char bolts[] = { '$', '%', '&', '^', '@', '#' };
        int n = nuts.length;
        nutboltmatch(nuts, bolts, n);
    }
}
