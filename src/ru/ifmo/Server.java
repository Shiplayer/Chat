package ru.ifmo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.util.ArrayList;

/**
 * Created by Freemahn on 20.02.2015.
 */
public class Server {
    static ServerSocket serverSocket;
    ArrayList<Client> clients;

    public Server(int port) {
        try {
            serverSocket = new ServerSocket(port);
            System.out.println(serverSocket.getInetAddress());
            clients = new ArrayList<Client>();
        } catch (IOException e) {
            System.err.println("port " + port + " is closed");
        }
    }

    public void start(){
        while(true){
            try {
                System.out.println("waiting for host");
                Client client = new Client(serverSocket.accept());
                clients.add(client);
                System.out.println("read message");
                System.out.println(new BufferedReader(new InputStreamReader(client.clientThread.is)).readLine());
            } catch (IOException e) {
                System.err.println("Client is unavailable :(");
            }
        }
    }

    public static void main(String[] args) {
        new Server(3456).start();

    }
}
