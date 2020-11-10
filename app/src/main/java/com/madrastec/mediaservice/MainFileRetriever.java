package com.madrastec.mediaservice;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.ThumbnailUtils;
import android.os.Environment;
import android.provider.MediaStore;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Arrays;

public class MainFileRetriever {

    private ArrayList<String> fileList = new ArrayList<>();
    private ArrayList<String> filePath = new ArrayList<>();
    private ArrayList<Bitmap> fileBitmap = new ArrayList<>();

    private File[] files;

    public MainFileRetriever(String mFolder, final String[] extension){

        ArrayList<String> extensionList = new ArrayList<>(Arrays.asList(extension));

        File folder = new File(Environment.getExternalStorageDirectory() + File.separator + mFolder);

        if (folder.exists()) {
            files = folder.listFiles(new FilenameFilter() {
                public boolean accept(File dir, String name) {
                    for (String s : extension) {
                        if (name.endsWith(s))
                            return true;
                    }
                    return false;
                }
            });
        }

        assert files != null;
        for (File file : files) {
            fileList.add(file.getName());
            filePath.add(file.getPath());
            if ( extensionList.contains(".mp4") || extensionList.contains(".mpeg4") ||
                    extensionList.contains(".mp3") || extensionList.contains(".aac") )
                fileBitmap.add(ThumbnailUtils.createVideoThumbnail(file.getAbsolutePath(), MediaStore.Video.Thumbnails.MINI_KIND));
            else
                fileBitmap.add(BitmapFactory.decodeFile(file.getPath()));
        }
    }

    public ArrayList<String> getFileList() {
        return  fileList;
    }

    public ArrayList<String> getFilePath() {
        return  filePath;
    }

    public ArrayList<Bitmap> getFileBitmap() {
        return  fileBitmap;
    }
}
