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
public class TestThread {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       for (int i=0; i< 2; i++) {
           Thread t1 = new Thread(new FThread(i));
           
           t1.start();
       }
        
    }
    
}
