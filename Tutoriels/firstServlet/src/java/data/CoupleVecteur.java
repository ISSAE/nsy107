/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author pascalfares
 */
@XmlRootElement
public class CoupleVecteur implements Serializable {
    private Vecteur v1;
    private Vecteur v2;

    public CoupleVecteur() {
        
    }
    public CoupleVecteur(Vecteur v1, Vecteur v2) {
        this.v1=v1;
        this.v2=v2;
    }
    
    public CoupleVecteur(int x1, int y1, int x2, int y2) {
        this.v1=new Vecteur();
        v1.setX(x1); v1.setY(y1);
        this.v2=new Vecteur();
        v2.setX(x2); v2.setY(y2);
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
