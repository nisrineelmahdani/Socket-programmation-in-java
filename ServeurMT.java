import java.net.ServerSocket;
import java.net.Socket;

public class ServeurMT  extends Thread{
    private int nbclient;//This variable (nbclient) is an integer that counts the number of clients who have connected to the server.
              public void run(){
                try {
                    ServerSocket ss = new ServerSocket(456);//it creates a ServerSocket listening on port 456.
                    while (true){//The while (true) loop keeps the server running indefinitely, waiting for new clients to connect. //The server enters a while (true) loop, where it waits for clients to connect.
                        Socket s = ss.accept();//when a client connects, ss.accept() returns a Socket object for that client.
                        nbclient++;
                        //tritement : dans une class apart
                        new ServiceClient(s,nbclient).start();//creates a new ServiceClient thread for each client,
                        
                    }
                } catch (Exception e) {
                    // TODO: handle exception
                }
              }//ServeurMT class sets up a multi-threaded server that listens for incoming connections on port 456. Each time a client connects, a new Socket object is created in the while loop within the run method.
    public static void main(String[] args) {
        System.out.println("attendons q un  client se connecte");
        new ServeurMT().start(); // objet de serveur multi thread .start(), Java doesn't directly call run(). Instead, .start() tells the Java Virtual Machine (JVM) to start a new thread, which will then call the run() method in that thread. This is important because it allows the code inside run() to execute independently from the main program, letting the server accept connections while the main program can do other things (like manage new clients)
    }
}
