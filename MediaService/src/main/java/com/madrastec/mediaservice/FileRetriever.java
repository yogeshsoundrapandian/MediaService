package com.madrastec.mediaservice;

import android.os.Environment;

import java.io.File;
import java.io.FilenameFilter;

public class FileRetriever {

    public static File[] fileRetriever(String mediaType, String mFolder){

        File[] files = null;
        File folder = new File(Environment.getExternalStorageDirectory() + File.separator + mFolder);

        if (folder.exists()) {
            switch (mediaType)
            {
                case "AUDIO" : files = folder.listFiles(new FilenameFilter() {
                                public boolean accept(File dir, String name) {
                                return (name.endsWith(".mp3") || name.endsWith(".aac") || name.endsWith(".wac"));
                                }
                            });
                break;

                case "VIDEO" : files = folder.listFiles(new FilenameFilter() {
                                public boolean accept(File dir, String name) {
                                return (name.endsWith(".mp4") || name.endsWith(".mpeg4") || name.endsWith(".3gp"));
                                }
                                });
                break;

                case "IMAGE" : files = folder.listFiles(new FilenameFilter() {
                                public boolean accept(File dir, String name) {
                                return (name.endsWith(".jpg") || name.endsWith(".jpeg") || name.endsWith(".png"));
                                }
                                });
                break;
            }
        }

        return files;
    }
}
