/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testthread;

/**
 *
 * @author pascalfares
 */
public class FThread implements Runnable {
    public static final String OUT="Thread ex: ";
    
    int n; 
    public FThread() {     
    }
    
    public FThread(int n) {
        this.n = n;
    }
   
    @Override
    public void run() {
        while (true) {
            System.out.println(OUT+n);
        }
    }
}
