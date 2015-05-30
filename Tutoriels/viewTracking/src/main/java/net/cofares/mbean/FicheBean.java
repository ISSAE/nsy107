/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.cofares.mbean;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import net.cofares.control.FicheDescriptiveJpaController;

/**
 *
 * @author pascalfares
 */
@Named(value = "ficheBean")
@SessionScoped
public class FicheBean implements Serializable {

    EntityManagerFactory emf;
    FicheDescriptiveJpaController fjc;
    /**
     * Creates a new instance of FicheBean
     */
    public FicheBean() {
        emf = Persistence.createEntityManagerFactory("net.cofares_viewTracking_war_0PU");
    }
    
    public int getCount() {
        return fjc.getFicheDescriptiveCount();
    }

}
