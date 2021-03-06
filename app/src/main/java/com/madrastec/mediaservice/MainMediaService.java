package com.madrastec.mediaservice;

import android.graphics.Bitmap;

import java.util.ArrayList;

public class MainMediaService {

    public static class Audio {

        String[] extension = new String[]{".mp3",".aac",".wav"};

        MainFileRetriever fileRetriever;

        public Audio (String mFolder) {
            fileRetriever = new MainFileRetriever(mFolder, extension);
        }

        public ArrayList<String> getAudioList() {
            return  fileRetriever.getFileList();
        }

        public ArrayList<String> getAudioPath() {
            return  fileRetriever.getFilePath();
        }

        public ArrayList<Bitmap> getAudioBitmap() {
            return  fileRetriever.getFileBitmap();
        }
    }

    public static class Video {

        String[] extension = new String[]{".mp4",".3gp",".mpeg4"};

        MainFileRetriever fileRetriever;

        public Video (String mFolder) {
            fileRetriever = new MainFileRetriever(mFolder, extension);
        }

        public ArrayList<String> getVideoList() {
            return  fileRetriever.getFileList();
        }

        public ArrayList<String> getVideoPath() {
            return  fileRetriever.getFilePath();
        }

        public ArrayList<Bitmap> getVideoBitmap() {
            return  fileRetriever.getFileBitmap();
        }
    }

    public static class Image {

        String[] extension = new String[]{".jpg",".jpeg",".png"};

        MainFileRetriever fileRetriever;

        public Image (String mFolder) {
            fileRetriever = new MainFileRetriever(mFolder, extension);

        }

        public ArrayList<String> getImageList() {
            return  fileRetriever.getFileList();
        }

        public ArrayList<String> getImagePath() {
            return  fileRetriever.getFilePath();
        }

        public ArrayList<Bitmap> getImageBitmap() {
            return  fileRetriever.getFileBitmap();
        }
    }

}
