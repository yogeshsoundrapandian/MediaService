package com.madrastec.mediaservice;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import java.io.File;
import java.util.ArrayList;

public class MediaService {

    public static class Audio {

        ArrayList<String> audioList;
        ArrayList<String> audioPath;
        File[] mFiles;

        Audio (String mFolder)
        {
            mFiles = FileRetriever.fileRetriever("AUDIO", mFolder);
        }

        public ArrayList<String> getAudioList()
        {
            for (File file : mFiles) {
                audioList.add(file.getName());
            }
            return  audioList;
        }

        public ArrayList<String> getAudioPath()
        {
            for (File file : mFiles) {
                audioPath.add(file.getPath());
            }
            return  audioPath;
        }
    }

    public static class Video {

        ArrayList<String> videoList;
        ArrayList<String> videoPath;
        File[] mFiles;

        Video (String mFolder)
        {
            mFiles = FileRetriever.fileRetriever("VIDEO", mFolder);
        }

        public ArrayList<String> getVideoList()
        {
            for (File file : mFiles) {
                videoList.add(file.getName());
            }
            return  videoList;
        }

        public ArrayList<String> getVideoPath()
        {
            for (File file : mFiles) {
                videoPath.add(file.getPath());
            }
            return  videoPath;
        }
    }

    public static class Image {

        ArrayList<String> imageList = new ArrayList<>();
        ArrayList<String> imagePath = new ArrayList<>();;
        ArrayList<Bitmap> imageBitmap = new ArrayList<>();;
        String fileName = "";
        File[] mFiles;

        Image (String mFolder)
        {
            mFiles = FileRetriever.fileRetriever("IMAGE", mFolder);
        }

        public ArrayList<String> getImageList()
        {
            for (File file : mFiles) {
                imageList.add(file.getName());
            }
            return  imageList;
        }

        public ArrayList<String> getImagePath()
        {
            for (File file : mFiles) {
                imagePath.add(file.getPath());
            }
            return  imagePath;
        }

        public ArrayList<Bitmap> getImageBitmap()
        {
            for (File file : mFiles) {
                imageBitmap.add(BitmapFactory.decodeFile(file.getPath()));
            }
            return  imageBitmap;
        }
    }
}
