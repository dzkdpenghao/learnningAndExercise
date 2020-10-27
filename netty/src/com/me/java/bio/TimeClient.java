/**
 * Author:   80303990
 * Date:     2020/10/27 14:58
 * Description: BIO的时间客户端
 */
package com.me.java.bio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class TimeClient {
    public static void main(String[] args) {
        int port = 8080;
        Socket socket = null;
        BufferedReader in = null;
        PrintWriter out = null;

        for (int i=0;i<10;i++) {
            try {
                socket=new Socket("127.0.0.1",port);
                in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out=new PrintWriter(socket.getOutputStream(),true);
                out.println("QUERY TIME ORDER");
                System.out.println("Send order to server succeed.");
                String response=in.readLine();
                System.out.println("Now is:"+response);
            } catch (UnknownHostException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                if(out!=null){
                    out.close();
                    out=null;
                }
                if(in!=null){
                    try {
                        in.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    in=null;
                }
                if(socket!=null){
                    try {
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    socket=null;
                }
            }
        }
    }
}