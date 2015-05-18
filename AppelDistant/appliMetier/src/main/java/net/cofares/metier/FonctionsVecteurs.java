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
 * Le fonctions  a rélisé sur le domaine métier
 * dans notre cas une addition de 2 vecteurs
 * @author pascalfares
 */
public class FonctionsVecteurs {
    
    /**
     * Adition de 2 vecteur
     * @param v1 : le premier vecteur a additionner
     * @param v2 : Le second vecteur
     * @return un nouveau vecteur = v1+v2
     */
    public static Vecteur add(Vecteur v1, Vecteur v2) {
        Vecteur res = new Vecteur();
        res.setX(v1.getX()+v2.getX());
        res.setY(v1.getY()+v2.getY());
        return res;
    }
}
