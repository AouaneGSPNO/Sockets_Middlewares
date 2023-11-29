package e2;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class envoiChaineCaract {
  public static void main(String[] args) {

    // Creation of client
    Socket s;
    try {
      s = new Socket("localhost", 2468);

      // Send message to the server
      OutputStream out = s.getOutputStream();
      PrintWriter pw = new PrintWriter(out, true);
      pw.println("Bonjour je suis votre client !!!");

      // Read response from the server
      InputStream is = s.getInputStream();
      InputStreamReader isr = new InputStreamReader(is);

      int data;
      StringBuilder receivedMessage = new StringBuilder();

      while ((data = isr.read()) != -1) {
        receivedMessage.append((char) data);
      }

      System.out.println("Reponse du serveur : " + receivedMessage.toString());

      // Close the resources
      isr.close();
      is.close();
      pw.close();
      out.close();
      s.close();
    } catch (UnknownHostException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}
