package e2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class server {

  public static void main(String[] args) {
    // TODO Auto-generated method stub


    // TODO Auto-generated method stub

    //Creation de server
    ServerSocket ss;
    Socket s;
    try {
      ss = new ServerSocket(2468);
      System.out.println("Demmarage du serveur sur le port 2468");
      s = ss.accept();
      InputStream is = s.getInputStream();
      InputStreamReader isr = new InputStreamReader(is);
      BufferedReader br = new BufferedReader(isr);
      String st = br.readLine();
      System.out.println("Message recu du client : " + st);

      OutputStream out = s.getOutputStream();
      PrintWriter pw = new PrintWriter( out , true);
      pw.println("Bonjour je suis le serveur.");

      // Close the resources
      br.close();
      isr.close();
      is.close();
      pw.close();
      out.close();
      s.close();
      ss.close();


    } catch (UnknownHostException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

  }

}

