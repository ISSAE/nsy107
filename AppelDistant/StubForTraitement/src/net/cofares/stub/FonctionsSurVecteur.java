/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.cofares.stub;

import java.io.IOException;
import net.cofares.libc.MessagesVecteurs;
import net.cofares.libc.Vecteur;




/**
 *
 * @author pascalfares
 */
public class FonctionsSurVecteur {
    public static Vecteur add(Vecteur v1, Vecteur v2) throws IOException {
       //Préparer le message (marshaling)
        
        Proxy p = new Proxy("localhost", 1111);
        String rep = p.sendReceive(MessagesVecteurs.marshall(v1, v2));
        
        return Vecteur.unmarshal(rep);
    }
}
