import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.lang.*;

public class Server {

    static final int port = 1200;

    public static void main(String[] args) throws Exception {

        // Listen to a specific port

        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("Waiting for connection");
        Socket socClient = serverSocket.accept(); // Accept a client socket
        System.out.println("Connection established");

        // Initialize in / out
        BufferedReader inServer = new BufferedReader(new InputStreamReader(socClient.getInputStream()));
        PrintWriter outServer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socClient.getOutputStream())), true);

        // todo: implement the scenario
        //2ème étape
        String mymsg = inServer.readLine();
        StringBuffer sbf = new StringBuffer(mymsg);
        for (int i=0 ; i< sbf.length();i++){

            if (sbf.charAt(i) =='a' || sbf.charAt(i) == 'e'||sbf.charAt(i) =='i' ||sbf.charAt(i) =='o'||sbf.charAt(i) =='u'||sbf.charAt(i) =='y'|| sbf.charAt(i) =='A' || sbf.charAt(i) == 'E'||sbf.charAt(i) =='I' ||sbf.charAt(i) =='O'||sbf.charAt(i) =='U'||sbf.charAt(i) =='Y'){
                sbf.deleteCharAt(i);
                i--;
            }
        }
        mymsg= sbf.toString();
        outServer.println(mymsg);

        // Close in / out
        inServer.close();
        outServer.close();

        // Close client socket
        socClient.close();
        serverSocket.close();
    }
}
