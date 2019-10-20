package main.designpattern.decorator.lowercaseinputstream;

import java.io.*;

public class LowerCaseInputStream  extends FilterInputStream {
    /**
     * Creates a <code>FilterInputStream</code>
     * by assigning the  argument <code>in</code>
     * to the field <code>this.in</code> so as
     * to remember it for later use.
     *
     * @param in the underlying input stream, or <code>null</code> if
     *           this instance is to be created without an underlying stream.
     */
    protected LowerCaseInputStream(InputStream in) {
        super(in);
    }
    public int read() throws IOException{
        int c = super.read();
        return  (c == -1 ? c :Character.toLowerCase((char)c));
    }

    public static void main(String[] args) {
        int c ;
        try{
            InputStream in = new LowerCaseInputStream(
                    new BufferedInputStream(
                            new FileInputStream("/Users/jitendra.kumar01/Desktop/assignCreditNoteToSuborder.txt")
                    )
            );
            while ((c=in.read())>0){
                System.out.print((char)c);
            }
        }catch (IOException e){
            System.out.println(e);
        }
    }
}
