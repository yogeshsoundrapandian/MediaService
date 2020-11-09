package com.madrastec.mediaservice;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;

public class MediaService {

    public static class Audio {

        String[] extension = new String[]{".mp3",".aac",".wav"};

        FileRetriever fileRetriever;

        Audio (String mFolder) {
            fileRetriever = new FileRetriever(mFolder, extension);
        }

        public ArrayList<String> getAudioList()
        {
            return  fileRetriever.getFileList();
        }

        public ArrayList<String> getAudioPath()
        {
            return  fileRetriever.getFilePath();
        }
    }

    public static class Video {

        String[] extension = new String[]{".mp4",".3gp",".mpeg4"};

        FileRetriever fileRetriever;

        Video (String mFolder) {
            fileRetriever = new FileRetriever(mFolder, extension);
        }

        public ArrayList<String> getVideoList()
        {
            return  fileRetriever.getFileList();
        }

        public ArrayList<String> getVideoPath()
        {
            return  fileRetriever.getFilePath();
        }
    }

    public static class Image {

        String[] extension = new String[]{".jpg",".jpeg",".png"};

        FileRetriever fileRetriever;

        public Image (String mFolder)
        {
            fileRetriever = new FileRetriever(mFolder, extension);

        }

        public ArrayList<String> getImageList()
        {
            return  fileRetriever.getFileList();
        }

        public ArrayList<String> getImagePath()
        {
            return  fileRetriever.getFilePath();
        }

        public ArrayList<Bitmap> getImageBitmap()
        {
            return  fileRetriever.getFileBitmap();
        }
    }

    public static class FileRetriever {

        ArrayList<String> fileList = new ArrayList<>();
        ArrayList<String> filePath = new ArrayList<>();;
        ArrayList<Bitmap> fileBitmap = new ArrayList<>();

        File[] files;

        public FileRetriever(String mFolder, final String[] extension){

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
                fileBitmap.add(BitmapFactory.decodeFile(file.getPath()));
            }
        }

        public ArrayList<String> getFileList()
        {
            return  fileList;
        }

        public ArrayList<String> getFilePath()
        {
            return  filePath;
        }

        public ArrayList<Bitmap> getFileBitmap()
        {
            return  fileBitmap;
        }
    }
}
