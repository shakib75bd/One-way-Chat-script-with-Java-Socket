import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        try (ServerSocket serverSocket = new ServerSocket(2222)) {
            System.out.println("Server started successfully");

            while(true){
                Socket socket = serverSocket.accept();
                System.out.println("Client connected Successfully");

                ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
                ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());

                //receiving input sms from client
                Object sms = in.readObject();
                System.out.println("Text received "+ (String)sms);

                String newSms = (String)sms;
                newSms = "Your text : "+ sms;

                //sending to client
                out.writeObject(newSms);
            }
        }
        
    }
}
