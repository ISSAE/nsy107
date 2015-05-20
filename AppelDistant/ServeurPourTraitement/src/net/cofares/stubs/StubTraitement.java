/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.cofares.stubs;

import java.io.IOException;
import net.cofares.libc.MessagesVecteurs;
import net.cofares.libc.Vecteur;
import net.cofares.metier.FonctionsSurVecteur;

/**
 *
 * @author pascalfares
 */
public class StubTraitement {
    public static Vecteur add(String message) throws IOException{
        MessagesVecteurs mv = MessagesVecteurs.unmarshallMessageVecteur(message);
        
        //Appel du traitement coté serveur
        return FonctionsSurVecteur.add(mv.getV1(), mv.getV2());
    }
}
