import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ServiceClient extends Thread {
         private int numero;
         private Socket client;
    public ServiceClient(Socket client, int nbclient) {
       super();
       this.numero=nbclient;
       this.client =client;
    }
      public void run(){
        try (InputStream is = client.getInputStream()) {
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            OutputStream os = client.getOutputStream();
            PrintWriter pw = new PrintWriter(os,true);
            System.out.println("connexion du client Num :" +numero);
            // envoyer une chaine de caractere au client:
            pw.println("vous etes le client numero"+numero);
            // serveur a besoin d'atteindre la reponse du client
            while (true) {
                  
                String req = br.readLine();// le serveur attend une chiane de caractere
                pw.println(req.length());//le client attend la reponse
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
      }
}
