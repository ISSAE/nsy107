/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.cofares.trucdanssalle;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author pascalfares
 */
@Entity
@Table(name = "TRUC")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Truc.findAll", query = "SELECT t FROM Truc t"),
    @NamedQuery(name = "Truc.findByIdTRUC", query = "SELECT t FROM Truc t WHERE t.idTRUC = :idTRUC"),
    @NamedQuery(name = "Truc.findByNom", query = "SELECT t FROM Truc t WHERE t.nom = :nom"),
    @NamedQuery(name = "Truc.findByType", query = "SELECT t FROM Truc t WHERE t.type = :type"),
    @NamedQuery(name = "Truc.findByTRUCcol", query = "SELECT t FROM Truc t WHERE t.tRUCcol = :tRUCcol")})
public class Truc implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "idTRUC")
    private String idTRUC;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nom")
    private String nom;
    @Size(max = 45)
    @Column(name = "type")
    private String type;
    @Size(max = 45)
    @Column(name = "TRUCcol")
    private String tRUCcol;

    public Truc() {
    }

    public Truc(String idTRUC) {
        this.idTRUC = idTRUC;
    }

    public Truc(String idTRUC, String nom) {
        this.idTRUC = idTRUC;
        this.nom = nom;
    }

    public String getIdTRUC() {
        return idTRUC;
    }

    public void setIdTRUC(String idTRUC) {
        this.idTRUC = idTRUC;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTRUCcol() {
        return tRUCcol;
    }

    public void setTRUCcol(String tRUCcol) {
        this.tRUCcol = tRUCcol;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTRUC != null ? idTRUC.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Truc)) {
            return false;
        }
        Truc other = (Truc) object;
        if ((this.idTRUC == null && other.idTRUC != null) || (this.idTRUC != null && !this.idTRUC.equals(other.idTRUC))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "net.cofares.trucdanssalle.Truc[ idTRUC=" + idTRUC + " ]";
    }
    
}
