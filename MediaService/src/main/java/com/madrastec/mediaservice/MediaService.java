package com.madrastec.mediaservice;

import android.graphics.Bitmap;

import java.util.ArrayList;

public class MediaService {

    //AUDIO
    public static class Audio {

        FileRetriever fileRetriever;

        public Audio (String folderPath) {
            String[] extension = new String[]{".mp3",".aac",".wav"};
            fileRetriever = new FileRetriever(folderPath, extension);
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

    //VIDEO
    public static class Video {

        FileRetriever fileRetriever;

        public Video (String folderPath) {
            String[] extension = new String[]{".mp4",".3gp",".mpeg4"};
            fileRetriever = new FileRetriever(folderPath, extension);
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

    //IMAGE
    public static class Image {

        FileRetriever fileRetriever;

        public Image (String folderPath) {
            String[] extension = new String[]{".jpg",".jpeg",".png"};
            fileRetriever = new FileRetriever(folderPath, extension);
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
