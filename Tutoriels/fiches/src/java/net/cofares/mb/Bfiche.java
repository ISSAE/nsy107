/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.cofares.mb;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.Persistence;
import net.cofares.FicheDescriptive;
import net.cofares.FicheDescriptiveJpaController;

/**
 *
 * @author pascalfares
 */
@ManagedBean
@SessionScoped
public class Bfiche {
    FicheDescriptiveJpaController fjc;
    /**
     * Creates a new instance of Bfiche
     */
    public Bfiche() {
        fjc =  new FicheDescriptiveJpaController(Persistence.createEntityManagerFactory("fichesPU"));
    }
    
    public int getCount() {
        return fjc.getFicheDescriptiveCount();
    }
    
    public List<FicheDescriptive> getAll() {
        return fjc.findFicheDescriptiveEntities();
    }
    
}
