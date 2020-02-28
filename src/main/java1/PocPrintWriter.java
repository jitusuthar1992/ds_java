package main.java1;

import java.io.*;
import java.util.Base64;

/**
 * @author jitendra.kumar01
 * 17/02/20
 */
public class PocPrintWriter {


    public static void main(String[] args) throws IOException {

        File file = new File("test2.txt");

        FileInputStream fis = new FileInputStream(file);
        //System.out.println(file.exists() + "!!");
        //InputStream in = resource.openStream();
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte[] buf = new byte[1024];
        Base64.Decoder mimeDecoder = Base64.getMimeDecoder();
        try {
            for (int readNum; (readNum = fis.read(buf)) != -1;) {

                bos.write(buf, 0, readNum); //no doubt here is 0
                //Writes len bytes from the specified byte array starting at offset off to this byte array output stream.
                System.out.println("read " + readNum + " bytes,");
            }
        } catch (IOException ex) {
            System.out.println(ex);
        }
        byte[] bytes = mimeDecoder.decode(bos.toByteArray());

        //below is the different part
        File someFile = new File("java2.pdf");
        FileOutputStream fos = new FileOutputStream(someFile);
        fos.write(bytes);
        fos.flush();
        fos.close();
    }
}
