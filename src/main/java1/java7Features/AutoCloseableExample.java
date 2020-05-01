package main.java1.java7Features;

import java.io.*;

/**
 * @author jitendra.kumar01
 * 10/11/19
 */
public class AutoCloseableExample {
    private final static String INPUT = "in.txt";
    private final static String OUTPUT = "out.txt";


    public static void main(String[] args) {
        try(BufferedReader rd = new BufferedReader(new FileReader(INPUT));
            PrintStream stream = new PrintStream(new File(OUTPUT)))
        {
            String inputLine = null;

            // Print the content of the input file and in parallel,
            // execute the copy procedure line-by-line.
            System.out.println("The input file contains the following lines:");
            while((inputLine = rd.readLine()) != null) {
                System.out.println(inputLine);
                stream.write((inputLine + "\n").getBytes());
            }

            // Make sure that every data is written to the output file.
            stream.flush();

            System.out.println("\nThe copy procedure has been successfully completed!");
        }
        catch (IOException ex) {
            System.err.println("An IOException was caught: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}
