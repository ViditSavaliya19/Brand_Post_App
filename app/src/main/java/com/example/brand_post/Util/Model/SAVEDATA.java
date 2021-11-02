package com.example.brand_post.Util.Model;

import android.graphics.Bitmap;
import android.net.Uri;

import java.io.File;

public class SAVEDATA {
    Bitmap img;
    File fp;
    String uri;

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public File getFp() {
        return fp;
    }

    public void setFp(File fp) {
        this.fp = fp;
    }

    public Bitmap getImg() {
        return img;
    }

    public void setImg(Bitmap img) {
        this.img = img;
    }
}
