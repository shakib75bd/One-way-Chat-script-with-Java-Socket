import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws UnknownHostException, IOException {
        System.out.println("Client started successfully");
        Socket socket = new Socket("127.0.0.1",2222);
        System.out.println("Client connected successfully");

        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());

        Scanner scn = new Scanner(System.in);
        String sms = scn.nextLine();

        //sending sms to server
        out.writeObject(sms);

        //waiting for server to respond
        //after getting response

        try {
            Object getSms = in.readObject();
            System.out.println("We got- " + (String)getSms);
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
