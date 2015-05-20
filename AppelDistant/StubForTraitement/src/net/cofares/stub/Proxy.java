/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.cofares.stub;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * @author pascalfares
 */
public class Proxy {
    String name;
    int port;
    
    public Proxy(String add, int p){
        name=add;
        port=p;
    }
    
    public String sendReceive(String message) throws IOException{
        System.out.println("Connect before");
        Socket sc = new Socket(name, port);
        
        //Retour apres socket
        System.out.println("Connect OK");
        //System.out.println(message);
        PrintWriter pw = new PrintWriter (sc.getOutputStream(),true);
        
        //Avant envoie trace
        System.out.println("===Appel" + message);
        pw.println(message);
        
        BufferedReader in =
                new BufferedReader(
                    new InputStreamReader(sc.getInputStream()));
        String rep= in.readLine();
        
        //ce qui est revenu
        System.out.println(rep);
        return rep;
    }
}
