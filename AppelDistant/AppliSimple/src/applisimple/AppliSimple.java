/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package applisimple;


import net.cofares.libc.Vecteur;


/**
 *
 * @author pascalfares
 */
public class AppliSimple {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Vecteur v1 = new Vecteur();
        Vecteur v2 = new Vecteur();
        
        //Initialisation des données (aquérir)
        v1.setX(10);
        v1.setY(20);
        
        v2.setX(15);
        v2.setY(25);
        
        //Appel du traitement
        Vecteur resadd = FonctionsSurVecteur.add(v1, v2);
        
        //Presenter les résultat
        System.out.println(resadd);
        
    }
    
}
