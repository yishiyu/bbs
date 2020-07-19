package com.yishiyu.util;

import com.jiading.util.QiniuyunUtil;
import com.qiniu.util.Auth;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

public class QiniuyunUtilTest {
    @Test
    public void testUploadFile(){
        String string = QiniuyunUtil.uploadObject("F:\\Code\\由比滨结衣\\3.jpg");
        System.out.println(string);
    }

    @Test
    public void testUploadBytes() throws UnsupportedEncodingException {
        String string = QiniuyunUtil.uploadObject("hello world".getBytes("utf-8"));
        System.out.println(string);
    }

    @Test
    public void testUploadStream() throws FileNotFoundException {
        InputStream inputStream = new FileInputStream("F:\\Code\\由比滨结衣\\2.jpg");
        String string = QiniuyunUtil.uploadObject(inputStream);
        System.out.println(string);
    }
}
