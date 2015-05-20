/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.cofares.proxy;

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
        Socket sc = new Socket(message, port);
        PrintWriter pw = new PrintWriter (sc.getOutputStream());
        pw.println(message);
        
        BufferedReader in =
                new BufferedReader(
                    new InputStreamReader(sc.getInputStream()));
        return in.readLine();
    }
}
