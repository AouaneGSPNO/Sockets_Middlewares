package e3;


import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.net.UnknownHostException;

public class Ville  implements Serializable {

  String nom ;
  int nbre_hab ;


  public Ville(String nom, int nbre_hab) {
    super();
    this.nom = nom;
    this.nbre_hab = nbre_hab;
  }

  @Override
  public String toString() {
    return "Ville:[nom = " + nom + ", nombre_d'habitants = " + nbre_hab + "]";
  }


  public static void main(String[] args) {
    // TODO Auto-generated method stub

    Socket s;
    try {
      s = new Socket("localhost", 2468);
      OutputStream ou = s.getOutputStream();
      ObjectOutputStream oos = new ObjectOutputStream(ou);
      Ville v = new Ville("Rabat" , 2000000);
      oos.writeObject(v);

      InputStream is = s.getInputStream();
      ObjectInputStream ois = new ObjectInputStream(is);
      try {
        Ville vv = (Ville) ois.readObject();
        System.out.println("J'ai recu depuis le serveur cette ville : " + vv);
      } catch (ClassNotFoundException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }


    } catch (UnknownHostException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

}

