package ru.ifmo;

import java.io.IOException;
import java.net.ServerSocket;

/**
 * Created by Freemahn on 20.02.2015.
 */
public class Server {
    ServerSocket serverSocket;

    public Server(int port) {
        try {
            serverSocket = new ServerSocket(port);
        } catch (IOException e) {
            System.err.println("port " + port + " is closed");
        }
    }

    public void start(){
        while(true){
            try {
                Client client = new Client(serverSocket.accept());
            } catch (IOException e) {
                System.err.println("Client is unavailable :(");
            }
        }
    }
}
