package e4;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
public class Server  extends Thread{

  private int nbClients;


  public static void main(String[] args) {
    // TODO Auto-generated method stub
    new Server().start();
  }

  @Override
  public void run() {

    try {

      ServerSocket ss = new ServerSocket(2468);
      System.out.println("Demmarage du serveur sur le port 2468");

      while(true) {
        Socket s = ss.accept();
        nbClients ++;
        new Connexions(s,nbClients).start();
      }

    } catch (Exception e) {
      // TODO: handle exception
      e.printStackTrace();
    }

  }


  class Connexions extends Thread{

    private Socket socket;
    private int num;

    public Connexions(Socket socket , int num) {
      super();
      this.socket = socket;
      this.num = num;
    }

    @Override
    public void run() {

      try {
        InputStream is = socket.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);

        OutputStream os = socket.getOutputStream();
        PrintWriter pw = new PrintWriter(os,true);
        String ip = socket.getRemoteSocketAddress().toString();
        System.out.println("Connexion du client " + num + ", son adresse IP est :" + ip);
        pw.println("Bienvenue le client " + num);

        while(true) {
          String req = br.readLine();
          pw.println("Le serveur a recu le message : " + req);
        }


      } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }


    }
  }

}

