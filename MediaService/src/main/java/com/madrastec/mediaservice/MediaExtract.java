package com.madrastec.mediaservice;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.provider.MediaStore;

import java.util.ArrayList;

public class MediaExtract {

    //AUDIO
    public static class AudioExtractor {

        String[] mSelectionArgs = null;
        String mSelection = null;
        String mSortType = MediaStore.Audio.Media.TITLE;
        ArrayList<String> mAudioNameList = new ArrayList<>();
        ArrayList<Long> mAudioIdList = new ArrayList<>();
        ArrayList<Uri> mAudioUriList = new ArrayList<>();

        public AudioExtractor(Context context, String mFolderName, String mUserSortType) {

            String[] mProjection = {
                    MediaStore.Audio.AudioColumns.DISPLAY_NAME,
                    MediaStore.Audio.AudioColumns._ID,
                    MediaStore.Audio.AudioColumns.DATA};// Can include more data for more details and check it.

            //folder name
            if ( mFolderName != null ) {
                mSelection = MediaStore.Audio.Media.DATA+" like?";
                mSelectionArgs = new String[]{"%"+mFolderName+"%"};
            }

            if ( mUserSortType != null)
                mSortType = new SortUriControl().getSortUri("AUDIO", mUserSortType);

            //query
            Cursor mCursor = context.getContentResolver().query(
                    MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
                    mProjection,
                    mSelection,
                    mSelectionArgs,
                    mSortType);

            //retriving data from cursor
            if (mCursor != null) {
                if (mCursor.moveToFirst()) {
                    do {
                        //retrieve data from column
                        mAudioNameList.add(mCursor.getString(0));
                        mAudioIdList.add(mCursor.getLong(1));
                        mAudioUriList.add(Uri.parse(mCursor.getString(2)));
                    } while (mCursor.moveToNext());
                }
            }
            assert mCursor != null;
            mCursor.close();
        }

        //returns audio name
        public ArrayList<String> getAudioNameList() {
            return mAudioNameList;
        }

        //returns audio id
        public ArrayList<Long> getAudioIdList() {
            return mAudioIdList;
        }

        //return audio uri path
        public ArrayList<Uri> getAudioUriList() {
            return mAudioUriList;
        }
    }

    //VIDEO
    public static class VideoExtractor {

        String[] mSelectionArgs = null;
        String mSelection = null;
        String mSortType = MediaStore.Video.Media.TITLE;
        ArrayList<String> mVideoNameList = new ArrayList<>();
        ArrayList<Long> mVideoIdList = new ArrayList<>();
        ArrayList<Uri> mVideoUriList = new ArrayList<>();
        ArrayList<Bitmap> mVideoBitmapList = new ArrayList<>();

        public VideoExtractor(Context mContext, String mFolderName, String mUserSortType) {

            String[] mProjection = {
                    MediaStore.Video.VideoColumns.TITLE,
                    MediaStore.Video.VideoColumns._ID,
                    MediaStore.Video.VideoColumns.DATA};

            //folder name
            if ( mFolderName != null ) {
                mSelection = MediaStore.Video.Media.DATA+" like?";
                mSelectionArgs = new String[]{"%"+mFolderName+"%"};
            }

            if ( mUserSortType != null)
                mSortType = new SortUriControl().getSortUri("VIDEO", mUserSortType);

            //query
            Cursor mCursor = mContext.getContentResolver().query(
                    MediaStore.Video.Media.EXTERNAL_CONTENT_URI,
                    mProjection,
                    mSelection,
                    mSelectionArgs,
                    mSortType);

            //retriving data from cursor
            if (mCursor != null) {
                if (mCursor.moveToFirst()) {
                    do {
                        //retrieve data from column
                        mVideoNameList.add(mCursor.getString(0));
                        mVideoIdList.add(mCursor.getLong(1));
                        mVideoUriList.add(Uri.parse(mCursor.getString(2)));
                        mVideoBitmapList.add(ThumbnailUtils.createVideoThumbnail(
                                mCursor.getString(2),
                                MediaStore.Video.Thumbnails.MICRO_KIND));
                    } while (mCursor.moveToNext());
                }
            }
            assert mCursor != null;
            mCursor.close();
        }

        //returns video name
        public ArrayList<String> getVideoNameList() {
            return mVideoNameList;
        }

        //returns video id
        public ArrayList<Long> getVideoIdList() {
            return mVideoIdList;
        }

        //returns video path
        public ArrayList<Uri> getVideoUriList() {
            return mVideoUriList;
        }

    }

    public static class ImageExtractor {

        String[] mSelectionArgs = null;
        String mSelection = null;
        String mSortType = MediaStore.Images.Media.TITLE;
        ArrayList<String> mImageNameList = new ArrayList<>();
        ArrayList<Long> mImageIdList = new ArrayList<>();
        ArrayList<Uri> mImageUriList = new ArrayList<>();
        ArrayList<Bitmap> mImageBitmapList = new ArrayList<>();

        public ImageExtractor(Context mContext, String mFolderName, String mUserSortType) {

            String[] mProjection = {
                    MediaStore.Images.ImageColumns.TITLE,
                    MediaStore.Images.ImageColumns._ID,
                    MediaStore.Images.ImageColumns.DATA};

            //folder name
            if ( mFolderName != null ) {
                mSelection = MediaStore.Images.Media.DATA+" like?";
                mSelectionArgs = new String[]{"%"+mFolderName+"%"};
            }

            if ( mUserSortType != null )
                mSortType = new SortUriControl().getSortUri("IMAGE", mUserSortType);

            //query
            Cursor mCursor = mContext.getContentResolver().query(
                    MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                    mProjection,
                    mSelection,
                    mSelectionArgs,
                    mSortType);

            //retriving data from cursor
            if (mCursor != null) {
                if (mCursor.moveToFirst()) {
                    do {
                        //retrieve data from column
                        mImageNameList.add(mCursor.getString(0));
                        mImageIdList.add(mCursor.getLong(1));
                        mImageUriList.add(Uri.parse(mCursor.getString(2)));
                        mImageBitmapList.add(ThumbnailUtils.createVideoThumbnail(
                                mCursor.getString(2),
                                MediaStore.Images.Thumbnails.MICRO_KIND));
                    } while (mCursor.moveToNext());
                }
            }
            assert mCursor != null;
            mCursor.close();
        }

        //returns video name
        public ArrayList<String> getImageNameList() {
            return mImageNameList;
        }

        //returns video id
        public ArrayList<Long> getImageIdList() {
            return mImageIdList;
        }

        //returns video path
        public ArrayList<Uri> getImageUriList() {
            return mImageUriList;
        }

    }
}
