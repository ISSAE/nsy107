/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.cofares.libc;

import java.io.IOException;
import java.io.StreamTokenizer;
import java.io.StringReader;

/**
 *
 * @author pascalfares
 */
public class MessagesVecteurs {
    
    private Vecteur v1;
    private Vecteur v2;
    public static String marshall (Vecteur v1, Vecteur v2) {
        return "{"+v1.marshaling()+"," + v2.marshaling()+ "}";
    }
    
    public static MessagesVecteurs unmarshallMessageVecteur (String message) throws IOException {
        MessagesVecteurs mv = new MessagesVecteurs();
        StreamTokenizer s = new StreamTokenizer (new StringReader(message));
        s.nextToken();
        //On doit avoir {
        if (s.ttype != '{') return null;
        s.nextToken(); //skip { prepare le prohain token
        //Un premier vecteur
        mv.v1= Vecteur.unmarshal(s);
        if (s.ttype != ',') return null;
        s.nextToken();
        //un deixieme vecteur
        mv.v2 = Vecteur.unmarshal(s);
        //On doit terminer par }
        if (s.ttype != '}') return null;
        s.nextToken();
        return mv;
    }

    /**
     * @return the v1
     */
    public Vecteur getV1() {
        return v1;
    }

    /**
     * @return the v2
     */
    public Vecteur getV2() {
        return v2;
    }
    
}
