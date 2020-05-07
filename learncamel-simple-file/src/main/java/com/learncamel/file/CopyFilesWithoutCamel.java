package com.learncamel.file;

import java.io.*;

/**
 * Created by Dilip on 4/14/17.
 */
public class CopyFilesWithoutCamel {

    public static void main(String[] args) throws IOException {

        //Step 1 - Create a file Object for the the directories to read and write.
        File inputDirectory = new File("data/input");
        File outputDirectory = new File("data/output");

        outputDirectory.mkdir();

        //Step 2 -  Read the files and Iterate the files
        File[] files = inputDirectory.listFiles();

        for (File source : files) {
            if (source.isFile()) {
                File dest = new File(
                        outputDirectory.getPath()
                                + File.separator
                                + source.getName());
        //Step 3 : Create a Output Stream to write the files.

                OutputStream oStream = new FileOutputStream(dest);
                byte[] buffer = new byte[(int) source.length()];
                FileInputStream iStream = new FileInputStream(source);
                iStream.read(buffer);
                try {
                    oStream.write(buffer);
                } finally {
                    oStream.close();
                    iStream.close();
                }
            }
        }

    }

}
