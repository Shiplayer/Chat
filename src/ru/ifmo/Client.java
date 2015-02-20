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
        //ttt
    }

    //sends message to server only ;(
    void sendMessage(String message) {
        try {
            clientThread.outs.write(message.getBytes());
        }
        catch (IOException e){
            System.err.println("error when sendind message");
        }

    }
}
