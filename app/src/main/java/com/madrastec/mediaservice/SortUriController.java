package com.madrastec.mediaservice;

import android.net.Uri;
import android.provider.MediaStore;

public class SortUriController {

    public String getSortUri(String mMediaType, String mSortType)
    {
        String mContent = null;
        String audio = "AUDIO";

        if (mMediaType.equals("AUDIO")) {
            switch (mSortType) {
                case "DURATION":
                    mContent = MediaStore.Audio.Media.DURATION;
                    break;
                case "DATE":
                    mContent = MediaStore.Audio.Media.DATE_ADDED;
                    break;
                default:
                    mContent = MediaStore.Audio.Media.DISPLAY_NAME;
            }
        }

        if (mMediaType.equals("VIDEO")) {
            switch (mSortType) {
                case "DURATION":
                    mContent = MediaStore.Video.Media.DURATION;
                    break;
                case "DATE":
                    mContent = MediaStore.Video.Media.DATE_ADDED;
                    break;
                default:
                    mContent = MediaStore.Video.Media.DISPLAY_NAME;
            }
        }

        if (mMediaType.equals("IMAGE")) {
            switch (mSortType) {
                case "SIZE":
                    mContent = MediaStore.Images.Media.SIZE;
                    break;
                case "DATE":
                    mContent = MediaStore.Images.Media.DATE_TAKEN;
                    break;
                default:
                    mContent = MediaStore.Images.Media.DISPLAY_NAME;
            }
        }

        return mContent;
    }
}
