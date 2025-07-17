import java.io.*;
import java.net.*;
import java.util.*;

public class  serverside {
    static Set<Socket> clientSockets = Collections.synchronizedSet(new HashSet<>());

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(1234);
        System.out.println("Server started...");

        while (true) {
            Socket client = serverSocket.accept();
            clientSockets.add(client);
            new Thread(new ClientHandler(client)).start();
        }
    }

    static class ClientHandler implements Runnable {
        Socket socket;
        BufferedReader in;
        PrintWriter out;

        ClientHandler(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String msg;
                while ((msg = in.readLine()) != null) {
                    System.out.println("Received: " + msg);
                    for (Socket s : clientSockets) {
                        if (s != socket) {
                            PrintWriter pw = new PrintWriter(s.getOutputStream(), true);
                            pw.println("Client says: " + msg);
                        }
                    }
                }
            } catch (IOException e) {
                System.out.println("Client disconnected.");
                clientSockets.remove(socket);
            }
        }
    }
}