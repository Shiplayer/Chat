package ru.ifmo;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created by Freemahn on 20.02.2015.
 */
public class ClientThread extends Thread {
    InputStream is;
    OutputStream outs;

    ClientThread(Socket t) {
        try {
            is = t.getInputStream();
            outs = t.getOutputStream();
        } catch (IOException e) {
            System.out.println("cant initiate");
        }
    }

    @Override
    public void run() {
        //listens another clients
        try {
            while (true) {
                int messageLength = is.available();
                if (messageLength == 0) continue;
                byte[] message = new byte[messageLength];
                //first byte(n) is length
                //other n bytes is message
                is.read(message);
                String text = new String(message);
                System.out.println("GOT SOME TEXT:" + text);
            }
        } catch (IOException e) {
            System.err.println("Error ClientThread:(");
        }
    }
}
