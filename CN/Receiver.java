import java.io.*;
import java.net.*;

public class Receiver {
    private static final int PORT = 12345;
    private static final int TIMEOUT = 10000; // 10 seconds

    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket(PORT);
            socket.setSoTimeout(TIMEOUT); // Set timeout for socket operations

            byte[] data = new byte[1024];
            DatagramPacket packet = new DatagramPacket(data, data.length);
            try {
                socket.receive(packet);
                System.out.println("Message received: " + new String(packet.getData()));

                InetAddress address = packet.getAddress();
                int port = packet.getPort();
                byte[] ackData = "ACK".getBytes();
                DatagramPacket ackPacket = new DatagramPacket(ackData, ackData.length, address, port);
                socket.send(ackPacket);
                System.out.println("ACK sent.");
            } catch (SocketTimeoutException e) {
                System.out.println("Timeout reached. No message received.");
            }

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
