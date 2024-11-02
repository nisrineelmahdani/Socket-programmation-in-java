package tpSockClient;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try {
            Socket s = new Socket("localhost",234);  //2prm: @ip et port
            InputStream is = s.getInputStream();
            OutputStream os = s.getOutputStream();
           //lire les donnes:
           Scanner clavier = new Scanner(System.in);
           System.out.println("donner un nb");
           int nb = clavier.nextInt();
           os.write(nb);// envoyer vers le serveur
           // attend la re ponse:
           int rp= is.read();
           //afficher la réponse
           System.out.println("rep:"+rp);

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } 
    }
}
