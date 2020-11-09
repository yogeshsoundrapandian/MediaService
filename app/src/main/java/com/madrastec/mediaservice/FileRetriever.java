package com.madrastec.mediaservice;

import android.os.Environment;

import java.io.File;
import java.io.FilenameFilter;

public class FileRetriever {

    public static File[] fileRetriever(String mFolder, final String[] extension){

        File[] files = null;
        File folder = new File(Environment.getExternalStorageDirectory() + File.separator + mFolder);

        if (folder.exists()) {
            files = folder.listFiles(new FilenameFilter() {
                public boolean accept(File dir, String name) {
                    for (String s : extension) {

                        if (name.endsWith(s))
                            return true;
                    }
                    return false;
                    //return (name.endsWith(".mp3") || name.endsWith(".aac") || name.endsWith(".wac"));
                }
            });
        }

        return files;
    }
}
