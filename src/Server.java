import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;

public class Server {
    private ServerSocket serverSocket;
    private DataInputStream in;
    private DataOutputStream out;

    public Server() throws IOException {
        start();
    }

    private void start() throws IOException {
        try {
            serverSocket = new ServerSocket(8443);
            System.out.println("Server is up and run...");
            System.out.println("Server info: " + serverSocket);

            System.out.println("Server is waiting for a connection...");
            Socket client = serverSocket.accept();
            System.out.println("Client accepted: " + client);
            System.out.println("You can use command '-exit' to shut down " +
                    "a server and make client disconnect from server");

            in = new DataInputStream(client.getInputStream());
            out = new DataOutputStream(client.getOutputStream());

            new Thread(() -> {
                try {
                    while (true) {
                        String message = in.readUTF();
                        if (message.startsWith("-exit")) {
                            System.out.println("cmd EXIT from Client: Client is unavailable. Connection closed");
                            break;
                        }
                        System.out.println("From Client: " + message);
                    }
                } catch (IOException e) {
                    System.out.println("cmd EXIT: System shutdown");
                    System.exit(0);
                } finally {
                    close();
                }
            }).start();
            Scanner scanner = new Scanner(System.in);
            while (true) {
                String message = scanner.nextLine();
                out.writeUTF(message);
            }

        } catch (SocketException e){
            System.out.println("cmd EXIT: System shutdown");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            close();
        }
    }

    private void close() {
        try {
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
