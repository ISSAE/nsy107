/*
 * Copyright (C) 2015 pascalfares
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */
package net.cofares.metier;

import net.cofares.libcommune.Vecteur;

/**
 * une classe de test de l'addition de 2 vecteurs
 * @author pascalfares
 */
public class UtilisationFonctions {
    private Vecteur v1;
    private Vecteur v2;

    public UtilisationFonctions() {
        v1=new Vecteur();
        v2=new Vecteur();
    }
    public UtilisationFonctions (int x1, int y1, int x2, int y2) {
        this();
        //Init vecteur 1
        setVec1(x1,y1);
        
        //init vecteur2
        setVec2(x2,y2);
        
    }
    
    public final void setVec1(int x, int y) {
        v1.setX(x);
        v1.setY(y);
    }
     public final void setVec2(int x, int y) {
        v2.setX(x);
        v2.setY(y);
    }
     
     public Vecteur fonctionAdd() {
         Vecteur res;
         //On récupère la réponse
         res = FonctionsVecteurs.add(v1, v2);
         return res;
              
     }
     
     /**
      * La fonction de dmnstartion de l'utilisation de l'adition
      */
     public static void Utilise() {
         //Création des données
         UtilisationFonctions uf = new UtilisationFonctions();
         uf.setVec1(10, 5);
         uf.setVec2(20, 10);
         
         //utilisation de la fonction
         System.out.println(uf.fonctionAdd());
         
     }
    /**
     * @return the v1
     */
    public Vecteur getV1() {
        return v1;
    }

    /**
     * @param v1 the v1 to set
     */
    public void setV1(Vecteur v1) {
        this.v1 = v1;
    }

    /**
     * @return the v2
     */
    public Vecteur getV2() {
        return v2;
    }

    /**
     * @param v2 the v2 to set
     */
    public void setV2(Vecteur v2) {
        this.v2 = v2;
    }
    
    
    
}
