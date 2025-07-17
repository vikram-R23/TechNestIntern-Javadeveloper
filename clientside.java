import java.io.*;
import java.net.*;

public class clientside {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 1234);

        BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        new Thread(() -> {
            try {
                String fromServer;
                while ((fromServer = in.readLine()) != null) {
                    System.out.println(fromServer);
                }
            } catch (IOException e) {
                System.out.println("Server disconnected.");
            }
        }).start();

        System.out.println("Connected. Type your messages:");
        String userMsg;
        while ((userMsg = userInput.readLine()) != null) {
            out.println(userMsg);
        }
    }
}
