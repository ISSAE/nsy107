/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.cofares.libc;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.io.StreamTokenizer;
import java.io.StringReader;
import java.io.StringWriter;

/**
 *
 * @author pascalfares
 */
public class Vecteur implements Serializable {
    
    private int x;

    private int y;

    /**
     * Get the value of y
     *
     * @return the value of y
     */
    public int getY() {
        return y;
    }

    /**
     * Set the value of y
     *
     * @param y new value of y
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Get the value of x
     *
     * @return the value of x
     */
    public int getX() {
        return x;
    }

    /**
     * Set the value of x
     *
     * @param x new value of x
     */
    public void setX(int x) {
        this.x = x;
    }

    @Override
    public String toString() {
        return "("+ getX() + "," +getY() +  ")";
    }
    
    public String marshaling() {
        StringWriter sb = new StringWriter();
        PrintWriter printWriter = new PrintWriter(sb);
        printWriter.printf("{%d,%d}", getX(), getY());      
        return sb.toString();
    }
    
    /**
     * Vecteur -> {Entier,Entier}
     * Entier -> Nombre entoer java
     * @param data
     * @return 
     * @throws java.io.IOException 
     */
    public static Vecteur unmarshal(String data) throws IOException{
        
        StreamTokenizer s = new StreamTokenizer (new StringReader(data));
        s.nextToken();
        return unmarshal(s);
    }
    
    //Reconnaitre un vecteur en entrée
    public static Vecteur unmarshal(StreamTokenizer s) throws IOException{
        Vecteur rep = new Vecteur();
        //StreamTokenizer s = new StreamTokenizer (new StringReader(data));
        //On doit avoir {
        if (s.ttype != '{') return null;
        s.nextToken(); //skip { prepare le prohain token
        //on doit avoir un int
        if (s.ttype == StreamTokenizer.TT_NUMBER) {
            rep.setX((int) s.nval);
            s.nextToken();
        } else return null;
        if (s.ttype != ',') return null;
        s.nextToken();
        if (s.ttype == StreamTokenizer.TT_NUMBER) {
            rep.setY((int) s.nval);
            s.nextToken();
        } else return null;
        //On doit terminer par }
        if (s.ttype != '}') return null;
        s.nextToken(); //skip }
        return rep;
    }
    
    
    
}
