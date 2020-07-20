package com.jiading.util;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

public class QiniuyunUtilTest {
    @Test
    public void testUploadFile(){
        String string = QiniuyunUtil.uploadObject("E:\\安装步骤.jpg");
        System.out.println(string);
    }

    @Test
    public void testUploadBytes() throws UnsupportedEncodingException {
        String string = QiniuyunUtil.uploadObject("hello world".getBytes("utf-8"));
        System.out.println(string);
    }

    @Test
    public void testUploadStream() throws FileNotFoundException {
        InputStream inputStream = new FileInputStream("E:\\安装步骤.jpg");
        String string = QiniuyunUtil.uploadObject(inputStream);
        System.out.println(string);
    }
}
