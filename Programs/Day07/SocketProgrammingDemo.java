package Day07;

import java.io.*;
import java.net.*;

public class SocketProgrammingDemo {
    public static void main(String[] args) {
        Thread serverThread = new Thread(() -> {
            try (ServerSocket serverSocket = new ServerSocket(5000)) {
                System.out.println("Server is listening on port 5000");
                Socket socket = serverSocket.accept();
                System.out.println("Client connected");
                
                BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                System.out.println("Message from client: " + input.readLine());
                
                socket.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

        Thread clientThread = new Thread(() -> {
            try {
                Thread.sleep(1000); // wait for server to start
                try (Socket socket = new Socket("localhost", 5000)) {
                    PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
                    output.println("Hello Server! This is the Client.");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        serverThread.start();
        clientThread.start();
    }
}
