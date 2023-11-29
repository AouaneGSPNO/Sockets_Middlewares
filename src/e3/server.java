package e3;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class server {
  public static void main(String[] args) {
    // TODO Auto-generated method stub

    ServerSocket ss;
    Socket s;
    try {
      ss = new ServerSocket(2468);
      System.out.println("Demmarage du serveur sur le port 2468");
      s = new Socket();
      s = ss.accept();

      // Read the object sent by the client
      InputStream is = s.getInputStream();
      ObjectInputStream ois = new ObjectInputStream(is);
      Ville receivedVille = (Ville) ois.readObject();
      System.out.println("Voici la ville du client  : " + receivedVille + "\n Maintenant je vais lui envoyer une ville qui lui est  proche: ");

      // Send a response object to the client
      OutputStream ou = s.getOutputStream();
      ObjectOutputStream oos = new ObjectOutputStream(ou);
      Ville responseVille = new Ville("Salé", 1500000);
      oos.writeObject(responseVille);

    } catch (UnknownHostException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
  }
}

