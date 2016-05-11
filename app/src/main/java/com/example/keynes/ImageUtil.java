package com.example.keynes;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by keynes on 2016/5/11.
 */
public class ImageUtil {


    public static Drawable loadImageDrawable(final ImageView imageView,final String urlPath){

        final Handler handler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                imageView.setImageDrawable((Drawable)msg.obj);
            }
        };

        new Thread(){

            public void run() {

                URL url = null;
                InputStream input = null;
                HttpURLConnection conn = null;
                try {

                    url = new URL(urlPath);
                    conn = (HttpURLConnection) url.openConnection();
                    conn.setDoInput(true);
                    conn.connect();
                    input = conn.getInputStream();
                    Drawable drawable = Drawable.createFromStream(input, "src");
                    Message msg = handler.obtainMessage(0, drawable);
                    handler.sendMessage(msg);

                } catch (Exception ex) {
                    ex.printStackTrace();
                    Log.e("ERROR",urlPath + " load image failed");
                } finally {
                    try {
                        if (input != null) input.close();
                        if (conn != null) conn.disconnect();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        }.start();



        return null;
    }


}
