/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serveurpourtraitement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import net.cofares.libc.MessagesVecteurs;
import net.cofares.libc.Vecteur;
import net.cofares.metier.FonctionsSurVecteur;

/**
 *
 * @author pascalfares
 */
public class ServeurPourTraitement {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        ServerSocket s = new ServerSocket(1111);

        while (true) {
            try (
                    Socket cl = s.accept();
                    PrintWriter out
                    = new PrintWriter(cl.getOutputStream(), true);
                    BufferedReader in = new BufferedReader(
                            new InputStreamReader(cl.getInputStream()))) {

                //Recevoir le couple
                String message = in.readLine();
                System.out.println("Recu" + message);
                //Unmarshal le message 
                MessagesVecteurs mv = MessagesVecteurs.unmarshallMessageVecteur(message);

                //Appel du traitement
                Vecteur rep = FonctionsSurVecteur.add(mv.getV1(), mv.getV2());

                //marshal la reponse et envoi
                out.println(rep.marshaling());

            }

        }
    }

}
