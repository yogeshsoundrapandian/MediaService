package com.madrastec.mediaservice;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import java.io.File;
import java.util.ArrayList;

public class MainMediaService {

    public static class Audio {

        ArrayList<String> audioList;
        ArrayList<String> audioPath;
        File[] mFiles;

        String[] extension = new String[]{".mp3",".aac",".wav"};

        Audio (String mFolder) {
            mFiles = FileRetriever.fileRetriever(mFolder, extension);

            for (File file : mFiles) {
                audioList.add(file.getName());
                audioPath.add(file.getPath());
            }
        }

        public ArrayList<String> getAudioList()
        {
            return  audioList;
        }

        public ArrayList<String> getAudioPath()
        {
            return  audioPath;
        }
    }

    public static class Video {

        ArrayList<String> videoList;
        ArrayList<String> videoPath;
        File[] mFiles;

        String[] extension = new String[]{".mp4",".3gp",".mpeg4"};

        Video (String mFolder) {
            mFiles = FileRetriever.fileRetriever(mFolder, extension);

            for (File file : mFiles) {
                videoList.add(file.getName());
                videoPath.add(file.getPath());
            }
        }

        public ArrayList<String> getVideoList()
        {
            return  videoList;
        }

        public ArrayList<String> getVideoPath()
        {
            return  videoPath;
        }
    }

    public static class Image {

        ArrayList<String> imageList = new ArrayList<>();
        ArrayList<String> imagePath = new ArrayList<>();;
        ArrayList<Bitmap> imageBitmap = new ArrayList<>();;
        String fileName = "";
        File[] mFiles;

        String[] extension = new String[]{".jpg",".jpeg",".png"};

        public Image (String mFolder)
        {
            mFiles = FileRetriever.fileRetriever(mFolder, extension);

            for (File file : mFiles) {
                imageList.add(file.getName());
                imagePath.add(file.getPath());
                imageBitmap.add(BitmapFactory.decodeFile(file.getPath()));
            }
        }

        public ArrayList<String> getImageList()
        {
            return  imageList;
        }

        public ArrayList<String> getImagePath()
        {
            return  imagePath;
        }

        public ArrayList<Bitmap> getImageBitmap()
        {
            return  imageBitmap;
        }
    }
}
