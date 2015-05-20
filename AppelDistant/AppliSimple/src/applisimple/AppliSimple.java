/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package applisimple;


import java.io.IOException;
import net.cofares.libc.MessagesVecteurs;
import net.cofares.libc.Vecteur;
import net.cofares.metier.FonctionsSurVecteur;


/**
 *
 * @author pascalfares
 */
public class AppliSimple {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        Vecteur v1 = new Vecteur();
        Vecteur v2 = new Vecteur();
        
        //Initialisation des données (aquérir)
        v1.setX(10);
        v1.setY(20);
        
        v2.setX(15);
        v2.setY(25);
        
        //Appel du traitement En local
        Vecteur resadd = FonctionsSurVecteur.add(v1, v2);
        
        //Presenter les résultat
        System.out.println("En local "+ v1 + v2 + resadd);
        
        //Appel du traitement a distance (utilisation d'un stub (proxy)
        Vecteur resDistant= net.cofares.stub.FonctionsSurVecteur.add(v1, v2);
         System.out.println("A distance "+ v1 + v2 + resadd);
        
        System.out.println("Unmarshal {10,20} = "+Vecteur.unmarshal("{10,20}"));
        MessagesVecteurs mv = MessagesVecteurs.unmarshallMessageVecteur("{{10,20},{15,20}}");
        System.out.println("Unmarsjal coupe vecteur {{10,20},{15,20}"+ mv);
        System.out.println(mv.getV1());
        System.out.println(mv.getV2());
    }
    
}
