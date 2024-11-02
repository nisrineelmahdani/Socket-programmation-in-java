
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.*;

public  class Server{
       public static void main(String[] args){
        try{
            ServerSocket ss = new ServerSocket( 234);// La classe ServerSocket est utilisée côté serveur : elle attend simplement les appels du ou des clients
            System.out.println("j'attend une connexion d'un client");
            Socket s = ss.accept(); // attendre la réponse dun client une fois quil est connecté retourne lobjet s qui va communique entre le client et serveur par ex: Through s, the server can read from or write to the client’s data streams. 
            System.out.println("un client est connecté");
             InputStream is = s.getInputStream();
             OutputStream os = s.getOutputStream();
             System.out.println("j'attend un nombre");
             int nb = is.read();
             int rep= nb*3;
             os.write(rep);// send the result back to the client
             
        }
        catch(IOException e){
            e.printStackTrace();
        }

       }          
}