package com.lursun.www.app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by lursun on 2017/9/27.
 */

public class Share {
    static String http="http://";
    static String host="192.168.1.5";
    static String port=":8081";

    public static HttpURLConnection getConn(String url)
    {
        try {
            return (HttpURLConnection) new URL(http + host + port + url).openConnection();
        }catch (Exception e){
            Logger.getLogger("Share").log(Level.WARNING,"getConn:" + e.toString());
            return null;
        }
    };
    public static String getBody(final HttpURLConnection conn)
    {

        final StringBuilder result = new StringBuilder();
        Thread thread=new Thread(){
            @Override
            public void run() {
                try {
                    conn.connect();
                    int status = conn.getResponseCode();
                    if(status==200) {
                        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                        String content;
                        while ((content = br.readLine()) != null) {
                            result.append(content);
                        }
                    }
                }catch (IOException e){
                    Logger.getLogger("Share").log(Level.WARNING,"getBody:" + e.toString());

                }
            }
        };
        thread.start();
        try {
            thread.join();
            return result.toString();
        }catch (Exception e){
            Logger.getLogger("Share").log(Level.WARNING,"getBody:" + e.toString());
            return null;
        }
    };
}
