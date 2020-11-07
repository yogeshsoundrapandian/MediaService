package com.madrastec.mediaservice;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.provider.MediaStore;

import java.util.ArrayList;

public class MainMediaService {

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
                    MediaStore.Audio.Media._ID,
                    MediaStore.Audio.Media.DISPLAY_NAME};// Can include more data for more details and check it.

            //folder name
            if ( mFolderName != null ) {
                mSelection = MediaStore.Audio.Media.DATA+" like?";
                mSelectionArgs = new String[]{"%"+mFolderName+"%"};
            }

            if ( mUserSortType != null)
                mSortType = new SortUriController().getSortUri("AUDIO", mUserSortType);

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
                        //get column index
                        int mAudioIndex = mCursor.getColumnIndexOrThrow(MediaStore.Audio.Media.DISPLAY_NAME);
                        int mAudioIdIndex = mCursor.getColumnIndexOrThrow(MediaStore.Audio.Media._ID);
                        int mAudioUriIndex = mCursor.getColumnIndexOrThrow(MediaStore.Video.Media.DATA);

                        //retrieve data from column
                        mAudioNameList.add(mCursor.getString(mAudioIndex));
                        mAudioIdList.add(mCursor.getLong(mAudioIdIndex));
                        mAudioUriList.add(Uri.parse(mCursor.getString(mAudioUriIndex)));
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
                    MediaStore.Video.Media.TITLE,
                    MediaStore.Video.Media._ID,
                    MediaStore.Video.Media.DATA};

            //folder name
            if ( mFolderName != null ) {
                mSelection = MediaStore.Video.Media.DATA+" like?";
                mSelectionArgs = new String[]{"%"+mFolderName+"%"};
            }

            if ( mUserSortType != null)
                mSortType = new SortUriController().getSortUri("VIDEO", mUserSortType);

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
                        //get column index
                        int mVideoIndex = mCursor.getColumnIndexOrThrow(MediaStore.Video.Media.TITLE);
                        int mVideoIdIndex = mCursor.getColumnIndexOrThrow(MediaStore.Video.Media._ID);
                        int mVideoUriIndex = mCursor.getColumnIndexOrThrow(MediaStore.Video.Media.DATA);

                        //retrieve data from column
                        mVideoNameList.add(mCursor.getString(mVideoIndex));
                        mVideoIdList.add(mCursor.getLong(mVideoIdIndex));
                        mVideoUriList.add(Uri.parse(mCursor.getString(mVideoUriIndex)));
                        mVideoBitmapList.add(ThumbnailUtils.createVideoThumbnail(
                                mCursor.getString(mVideoUriIndex),
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
                    MediaStore.Images.Media.TITLE,
                    MediaStore.Images.Media._ID,
                    MediaStore.Images.Media.DATA};

            //folder name
            if ( mFolderName != null ) {
                mSelection = MediaStore.Images.Media.DATA+" like?";
                mSelectionArgs = new String[]{"%"+mFolderName+"%"};
            }

            if ( mUserSortType != null )
                mSortType = new SortUriController().getSortUri("IMAGE", mUserSortType);

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
                        //get column index
                        int mImageIndex = mCursor.getColumnIndexOrThrow(MediaStore.Images.Media.TITLE);
                        int mImageIdIndex = mCursor.getColumnIndexOrThrow(MediaStore.Images.Media._ID);
                        int mImageUriIndex = mCursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);

                        //retrieve data from column
                        mImageNameList.add(mCursor.getString(mImageIndex));
                        mImageIdList.add(mCursor.getLong(mImageIdIndex));
                        mImageUriList.add(Uri.parse(mCursor.getString(mImageUriIndex)));
                        mImageBitmapList.add(ThumbnailUtils.createVideoThumbnail(
                                mCursor.getString(mImageUriIndex),
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
