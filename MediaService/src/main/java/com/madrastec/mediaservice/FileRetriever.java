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

public class FileRetriever {

    ArrayList<String> fileList = new ArrayList<>();
    ArrayList<String> filePath = new ArrayList<>();;
    ArrayList<Bitmap> fileBitmap = new ArrayList<>();

    File[] files;

    public FileRetriever(String mFolder, final String[] extension){

        ArrayList<String> extensionList = new ArrayList<String>(Arrays.asList(extension));

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

            //check if file is audio, video or image
            if ( extensionList.contains(".mp4") || extensionList.contains(".mpeg4") ||
                    extensionList.contains(".mp3") || extensionList.contains(".aac") ) {
                //thumbnail for audio/video file
                fileBitmap.add(ThumbnailUtils.createVideoThumbnail(file.getAbsolutePath(), MediaStore.Video.Thumbnails.MINI_KIND));
            } else {
                //bitmap for image
                fileBitmap.add(BitmapFactory.decodeFile(file.getPath()));
            }
        }
    }

    //returns file name
    public ArrayList<String> getFileList() {
        return  fileList;
    }

    //returns file path
    public ArrayList<String> getFilePath() {
        return  filePath;
    }

    //returns file bitmap
    public ArrayList<Bitmap> getFileBitmap() {
        return  fileBitmap;
    }
}
