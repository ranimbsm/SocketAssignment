import java.io.*;
import java.net.Socket;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Client {

    static final int port = 1200;

    public static void main(String[] args) throws Exception {

        System.out.println("connection request");

        //Create a client socket
        Socket socket = new Socket("127.0.0.1", port);
        System.out.println("Connection established");

        // create in / out
        BufferedReader inClient = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter outClient = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);

        // todo: implement the scenario
        //1ère étape
        Scanner msg = new Scanner(System.in);
        System.out.println("Write your message: ");
        String mymsg = msg.nextLine();
        outClient.println(mymsg);
        //3ème étape
        String resultat= inClient.readLine();
        System.out.println(resultat);
        //close in / out
        inClient.close();
        outClient.close();

        // close client socket
        socket.close();
    }
}
