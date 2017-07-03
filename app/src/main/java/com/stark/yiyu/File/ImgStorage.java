package com.stark.yiyu.File;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Environment;
import android.util.Log;

import com.stark.yiyu.MyService;
import com.stark.yiyu.R;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by asus on 2017/7/1.
 */
public class ImgStorage {

    public static Drawable getHead(Context context, Boolean sex) {
        String photoPath = getPhotoPath(context);
        photoPath = photoPath + "image_cir_head.png";
        File imgPath = new File(photoPath);
        if (imgPath.exists()) {
            Log.e("圆形图片路径", "存在");
            Bitmap bitmap = BitmapFactory.decodeFile(photoPath);
            Drawable drawable = new BitmapDrawable(bitmap);
            return drawable;
        }
        Intent intent = new Intent(context, MyService.class);
        intent.putExtra("CMD", "Image");
        context.startService(intent);
//        IntentFilter intentFilter = new IntentFilter();
//        intentFilter.addAction("com.stark.yiyu.File.IMAGE_HEAD");
////        context.registerReceiver(intentFilter);
//        Intent intent = new Intent();
//        intent.setAction("com.stark.yiyu.File.IMAGE_HEAD");
//        context.sendBroadcast(intent);

        if (sex) {
            Log.e("圆形图片路径", "不存在,男");
            return context.getResources().getDrawable(R.drawable.tianqing);
        }
        Log.e("圆形图片路径", "不存在,女");
        return context.getResources().getDrawable(R.drawable.tianqing);
    }

    public static String getPhotoPath(Context context) {
        String photoPath = String.format("data/data/%1$s/imgbases/", context.getApplicationContext().getPackageName());
        return photoPath;
    }

    public static Uri saveBitmap(Bitmap bm, String pathName, String imgName) {
        File filePath = new File(Environment.getExternalStorageDirectory(), pathName);
        if (!filePath.exists()) {
            filePath.mkdir();
        }
        File imgPath = new File(filePath, imgName);
        try {
            FileOutputStream fos = new FileOutputStream(imgPath);
            bm.compress(Bitmap.CompressFormat.PNG, 85, fos);
            fos.flush();
            fos.close();
            return Uri.fromFile(imgPath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    //存储图片
    public static Uri saveBitmap(Bitmap bm, String imgName) {
        File filePath = new File(Environment.getExternalStorageDirectory() + "/com.stark.yiyu.File");
        if (!filePath.exists()) {
            filePath.mkdir();
        }
        File imgPath = new File(filePath, imgName);
        try {
            FileOutputStream fos = new FileOutputStream(imgPath);
            bm.compress(Bitmap.CompressFormat.PNG, 85, fos);
            fos.flush();
            fos.close();
            return Uri.fromFile(imgPath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    //存储图片
    public static void saveCirBitmap(String cirHeadPath, String imgName, Bitmap bm) {
        File filePath = new File(cirHeadPath);
        if (!filePath.exists()) {
            filePath.mkdir();
        }
        File imgPath = new File(filePath, imgName);
        try {
            FileOutputStream fos = new FileOutputStream(imgPath);
            bm.compress(Bitmap.CompressFormat.PNG, 85, fos);
            fos.flush();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
