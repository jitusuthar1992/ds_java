package main.java1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/**
 * @author jitendra.kumar01
 * 11/12/19
 */
public class GrepCommandImpl {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println("Usage: Grep pattern file");
            System.exit(1);
        }
        Pattern pattern = null;
        try {
            pattern= Pattern.compile(args[0]);
        }catch (PatternSyntaxException e) {
            System.err.println("Invalid RE syntax: " + e.getDescription());
            System.exit(1);
        }

        BufferedReader br = null;

        try {
            br = new BufferedReader(new InputStreamReader(new FileInputStream(args[1])));
        } catch (FileNotFoundException e) {
            System.err.println("Unable to open file " +
                                       args[1] + ": " + e.getMessage());
            System.exit(1);
        }


        try{
            String s;
            while ((s = br.readLine()) !=null){
                Matcher m = pattern.matcher(s);
                if(m.find()){
                    System.out.println(s);
                }
            }
        }catch (Exception e){
            System.err.println("Error reading line: " + e.getMessage());
            System.exit(1);
        }

    }
}
