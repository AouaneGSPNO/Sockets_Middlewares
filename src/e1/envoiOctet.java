package e1;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class envoiOctet {

  public static void main(String[] args) {
    // TODO Auto-generated method stub

    //Creation de client
    Socket s;
    try {
      s = new Socket("localhost" , 2468);
      InputStream is = s.getInputStream();
      OutputStream ou = s.getOutputStream();
      ou.write(40);
      int rep = is.read();
      System.out.println("Je suis le client, j'ai recu ce message : " + rep);
    } catch (UnknownHostException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }


    //Creation de serveur

  }

}

