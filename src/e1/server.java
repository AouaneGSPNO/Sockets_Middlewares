package e1;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class server {

  public static void main(String[] args) {
    // TODO Auto-generated method stub

    //Creation de server
    ServerSocket ss;
    Socket s;
    try {
      ss = new ServerSocket(2468);
      System.out.println("Demmarage du serveur sur le port  2468");
      s = new Socket();
      s = ss.accept();
      InputStream is = s.getInputStream();
      OutputStream ou = s.getOutputStream();
      int read = is.read();
      int read2 = read*5;
      ou.write(read2);
      System.out.println("Voici votre message : " + read + "\n Je ai multiplié sa valeure  * 5  : " + read2);
    } catch (UnknownHostException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

}

