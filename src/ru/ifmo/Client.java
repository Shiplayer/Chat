package ru.ifmo;

import java.io.IOException;
import java.net.Socket;

/**
 * Created by Freemahn on 20.02.2015.
 */
public class Client {

    ClientThread clientThread;

    Client(Socket t) {
        clientThread = new ClientThread(t);
        clientThread.run();

    }

    //sends message to server only ;(
    public void sendMessage(String message) {
        try {
            byte[] b = new byte[message.length() + 1];
            b[0] = (byte) message.length();
            for (int i = 0; i < message.length(); i++) {
                b[i + 1] = message.getBytes()[i];
            }
            clientThread.outs.write(b);
        } catch (IOException e) {
            System.err.println("error when sending message");
        }
    }

}
