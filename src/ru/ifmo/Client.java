package ru.ifmo;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

/**
 * Created by Freemahn on 20.02.2015.
 */
public class Client extends Thread {

    InpThread clientThread;

    Client(Socket t) {
        clientThread = new InpThread(t);

        clientThread.start();

    }

    //sends message to server only ;(
    public void sendMessage(String message) {
        try {
            byte[] b = new byte[message.length() + 1];
            b[0] = (byte) message.length();
            for (int i = 0; i < message.length(); i++) {
                b[i + 1] = message.getBytes()[i];
            }
            System.out.println("send message");
            clientThread.outs.write(b);
            clientThread.outs.flush();
            System.out.println("end");
        } catch (IOException e) {
            System.err.println("error when sending message");
        }
    }

    public static void main(String[] args) throws IOException {
        InetAddress hostname = InetAddress.getByName(null);
        System.out.println(hostname.getHostAddress());
        Socket socket = new Socket(hostname.getHostAddress(),3456);
        System.out.println("socket");
        Client c = new Client(socket);
        System.out.println("sendMessage");
        c.sendMessage("hui");
    }

}
