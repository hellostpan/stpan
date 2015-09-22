package com.example.stpan.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Environment;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * ���ܣ�
 * ����ʱ��:2015/9/22 14:41
 * ����:pst
 * ��Ȩ: sowell,onegcloud
 */
public class FileUtils {
    private static FileUtils fileUtils;

    public static FileUtils getInstance(){
        if (fileUtils==null){
            fileUtils = new FileUtils();
        }
        return fileUtils;
    }

    /**
     * ����Ƿ����SD��
     *
     * @return
     */
    public boolean hasSdcard() {
        String state = Environment.getExternalStorageState();
        return state.equals(Environment.MEDIA_MOUNTED);
    }

    /**
     * ����Ŀ¼
     *
     * @param context �ļ�������
     * @return
     */
    public File createFileDir(Context context) {
        String filePath;
        // ��SD���Ѵ��ڣ���洢����֮����dataĿ¼��
        if (hasSdcard()) {
            // SD��·��
            filePath = Environment.getExternalStorageDirectory().getAbsolutePath() + "/zhsq";
        } else {
            filePath = context.getCacheDir().getPath() + "/zhsq";
        }
        File destDir = new File(filePath);
        if (!destDir.exists()) {
            destDir.mkdirs();
        }
        return destDir;
    }

    public String getCacheDir(Context context) {
        return hasSdcard() ? context.getExternalCacheDir().getPath() : context.getCacheDir().getPath();
    }

    /**
     * ɾ���ļ�����ΪĿ¼����ݹ�ɾ����Ŀ¼���ļ���
     *
     * @param file
     * @param delThisPath true����ɾ������ָ��file��false����������ָ��file
     */
    public void delFile(File file, boolean delThisPath) {
        if (!file.exists()) {
            return;
        }
        if (file.isDirectory()) {
            File[] subFiles = file.listFiles();
            if (subFiles != null) {
                int num = subFiles.length;
                // ɾ����Ŀ¼���ļ�
                for (int i = 0; i < num; i++) {
                    delFile(subFiles[i], true);
                }
            }
        }
        if (delThisPath) {
            file.delete();
        }
    }

    /**
     * ��ȡ�ļ���С����λΪbyte����ΪĿ¼�������������Ŀ¼���ļ���
     *
     * @param file
     * @return
     */
    public long getFileSize(File file) {
        long size = 0;
        if (file.exists()) {
            if (file.isDirectory()) {
                File[] subFiles = file.listFiles();
                if (subFiles != null) {
                    int num = subFiles.length;
                    for (int i = 0; i < num; i++) {
                        size += getFileSize(subFiles[i]);
                    }
                }
            } else {
                size += file.length();
            }
        }
        return size;
    }

    /**
     * ����Bitmap��ָ��Ŀ¼
     *
     * @param dir      Ŀ¼
     * @param fileName �ļ���
     * @param bitmap
     * @throws IOException
     */
    public void saveBitmap(File dir, String fileName, Bitmap bitmap) {
        if (bitmap == null) {
            return;
        }
        File file = new File(dir, fileName);
        try {
            file.createNewFile();
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file));
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, bos);
            bos.flush();
            bos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * �ж�ĳĿ¼���ļ��Ƿ����
     *
     * @param dir      Ŀ¼
     * @param fileName �ļ���
     * @return
     */
    public boolean isFileExists(File dir, String fileName) {
        return new File(dir, fileName).exists();
    }
}
