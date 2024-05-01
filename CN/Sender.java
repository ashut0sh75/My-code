import java.io.*;
import java.net.*;

public class Sender {
    private static final int PORT = 12345;
    private static final String HOST = "localhost";
    private static final int TIMEOUT = 10000; // 10 seconds

    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket();
            socket.setSoTimeout(TIMEOUT); // Set timeout for socket operations

            InetAddress address = InetAddress.getByName(HOST);

            byte[] data = "Hello, receiver!".getBytes();
            DatagramPacket packet = new DatagramPacket(data, data.length, address, PORT);
            socket.send(packet);
            System.out.println("Message sent: " + new String(packet.getData()));

            byte[] ackData = new byte[1024];
            DatagramPacket ackPacket = new DatagramPacket(ackData, ackData.length);
            try {
                socket.receive(ackPacket);
                System.out.println("ACK received: " + new String(ackPacket.getData()));
            } catch (SocketTimeoutException e) {
                System.out.println("Timeout reached.");
               
            }
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
