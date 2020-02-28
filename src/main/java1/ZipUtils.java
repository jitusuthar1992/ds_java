/*
package main.java1;
import au.com.bytecode.opencsv.CSVWriter;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.zip.*;
*/
/**
 * @author jitendra.kumar01
 * 14/02/20
 *//*

public class ZipUtils {

    private static final String EXTENSION = ".zip";

    public static String compressFiles(String zipFilePath, List<String> filePaths) throws IOException{

        File firstFile = new File(zipFilePath.concat(EXTENSION));
        String zipFileName = firstFile.getPath();
        FileOutputStream fos = null;
        ZipOutputStream zos = null;
        try {
            fos = new FileOutputStream(zipFileName);
            zos = new ZipOutputStream(fos);
            for (String aFile : filePaths) {
                zos.putNextEntry(new ZipEntry(new File(aFile).getName()));
                byte[] bytes = Files.readAllBytes(Paths.get(aFile));
                zos.write(bytes, 0, bytes.length);
                zos.closeEntry();
            }
        }finally {
            if(null != zos){
                zos.close();
            }
            if(null != fos){
                fos.close();
            }
        }
        return firstFile.getPath();
    }
    public static List<String> deCompressFile(String zipFilePath , String destinationPath) throws IOException {

        List<String> unZippedFilesPath = new ArrayList<>();
        File destDir = new File(destinationPath);
        byte[] buffer = new byte[1024];
        ZipInputStream zis = null;
        try {
            zis = new ZipInputStream(new FileInputStream(zipFilePath));
            ZipEntry zipEntry = zis.getNextEntry();
            while (zipEntry != null) {
                File newFile = newFile(destDir, zipEntry,unZippedFilesPath);
                try(FileOutputStream fos = new FileOutputStream(newFile);) {
                    int len;
                    while ((len = zis.read(buffer)) > 0) {
                        fos.write(buffer, 0, len);
                    }
                    zipEntry = zis.getNextEntry();
                }
            }
            zis.closeEntry();
        }finally {
            if(null != zis){
                zis.close();
            }
        }
        return unZippedFilesPath;
    }

    public static File newFile(File destinationDir, ZipEntry zipEntry,List<String> unZippedFilesPath) throws IOException {
        File destFile = new File(destinationDir, zipEntry.getName());
        String destDirPath = destinationDir.getCanonicalPath();
        String destFilePath = destFile.getCanonicalPath();

        if (!destFilePath.startsWith(destDirPath + File.separator)) {
            throw new IOException("Entry is outside of the target dir: " + zipEntry.getName());
        }

        unZippedFilesPath.add(destFile.getPath());
        return destFile;
    }

    public static String getFileNameFromPath(String filePath){
        File file = new File(filePath);
        return file.getName().concat(EXTENSION);
    }

    public static void main(String[] args) throws IOException {
      //  String name = compressFiles("/Users/jitendra.kumar01/Desktop/ziptest/test", Collections.singletonList("/Users/jitendra.kumar01/Desktop/"
                                                                                                                     // + "ziptest/F31426_Suborder_1.csv"));
       // new File("/Users/jitendra.kumar01/Desktop/ziptest/F31426_Suborder_1.csv").delete();
       // System.out.println(getFileNameFromPath(name));

       // System.out.println(name);
       // System.out.println(deCompressFile("/Users/jitendra.kumar01/Desktop/ziptest/test.zip","/Users/jitendra.kumar01/Desktop/ziptest/"));
      //  System.out.println(deCompressFile("/opt/score/simulation/F133332_Suborder.zip","/opt/score/simulation/"));


        Optional<String> str =  splitFile();
        new File(str.get()).delete();
        System.out.println(str.get());

    }

    private   static void createCsv(String fileName,List<String[]> data) throws IOException {
        File file = new File(fileName);
        FileWriter outputfile = null;
        CSVWriter writer = null;
        try {
            outputfile = new FileWriter(file);
            writer = new CSVWriter(outputfile,',', CSVWriter.NO_QUOTE_CHARACTER);
            // adding header to csv
            String[] header = {"SuborderCode","platformType","originPincode","destinationPincode","MarketingFees","PaymentCollectionFees","LogisticsFees","RTOLogisticsFees","ClosingFees","ShippingCharges",
                    "CashBack","ServiceTax","courierCode","IsAllocated","RateCardName","FwdCost","RTOCost","CodCost","BilledRatio","RTOPercentage","ExpectedGm","ExpectedCost","SCAPriorityNM",
                    "SCAPriorityNMWithLTV","SCAPriorityDelPercentage","GroupName","SlotCode","BucketStart","BucketEnd","IsFallback","filtrationLevel","filtrationDetail",
                    "filtrationValue","isHubMaxCapIncremented","nonfilteredFwdCost","nonfilteredRTOCost","nonfilteredCodCost","nonfilteredBilledRatio","nonfilteredRTOPercentage",
                    "nonfilteredExpectedGm","nonfilteredExpectedCost","nonfilteredSCAPriorityNM","nonfilteredSCAPriorityNMWithLTV","nonfilteredSCAPriorityDelPercentage"};
            writer.writeNext(header);
            writer.writeAll(data);
        }finally {
            if(null != writer){
                writer.close();
            }
            if(null != outputfile){
                outputfile.close();
            }
        }
    }


    public static Optional<String> splitFile() throws IOException {
        Optional<String> optionalPath = Optional.empty();
        List<String> filePaths = new ArrayList<>();
        List<String[]> listStr = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            List<String> lists = Arrays.asList("Test1", "Test2", "Test3");
            Object[] objArr = lists.toArray();
            listStr.add(Arrays.copyOf(objArr, objArr.length, String[].class));
        }

        if (!listStr.isEmpty() && null != listStr) {
            int csvLimit = 30;
            int divisor = listStr.size() / csvLimit;
            int mod = listStr.size() % csvLimit;

            String commonPath = new StringBuilder("/opt/score/simulation/").append("F133322").append("_Suborder").toString();
            String path;

            if (divisor > 0) {
                for (int i = 1; i <= divisor; i++) {
                    //path = new StringBuilder("_").append(commonPath).append(i).append(".csv").toString();
                    path = new StringBuilder(commonPath).append("_").append(i).append(".csv").toString();
                    createCsv(path, listStr.subList((csvLimit * (i - 1)), (csvLimit * i)));
                    filePaths.add(path);
                }

                if (mod > 0) {
                    path = new StringBuilder(commonPath).append(divisor + 1).append(".csv").toString();
                    createCsv(path, listStr.subList((csvLimit * (divisor)), listStr.size()));
                    filePaths.add(path);
                }
            } else {
                path = new StringBuilder(commonPath).append(divisor + 1).append(".csv").toString();
                createCsv(path, listStr.subList(0, listStr.size()));
                filePaths.add(path);
            }

            try {
                String zippedFile = compressFiles(commonPath, filePaths);
                filePaths.stream().forEach(filePath -> new File(filePath).delete());
                return optionalPath.of(zippedFile);
            } catch (IOException ex) {

            }
        }
        return optionalPath;
    }


}
*/
