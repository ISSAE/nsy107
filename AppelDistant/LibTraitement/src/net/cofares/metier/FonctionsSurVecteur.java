/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.cofares.metier;

import net.cofares.libc.Vecteur;




/**
 *
 * @author pascalfares
 */
public class FonctionsSurVecteur {
    public static Vecteur add(Vecteur v1, Vecteur v2) {
       Vecteur res= new Vecteur();
       res.setX(v1.getX()+v2.getX());
       res.setY(v1.getY()+v2.getY());
       return res;
    }
}
