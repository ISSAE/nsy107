/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.cofares;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author pascalfares
 */
@Entity
@Table(name = "payementHistory")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PayementHistory.findAll", query = "SELECT p FROM PayementHistory p"),
    @NamedQuery(name = "PayementHistory.findByToken", query = "SELECT p FROM PayementHistory p WHERE p.token = :token"),
    @NamedQuery(name = "PayementHistory.findByNoEtud", query = "SELECT p FROM PayementHistory p WHERE p.noEtud = :noEtud"),
    @NamedQuery(name = "PayementHistory.findByAuditeursId", query = "SELECT p FROM PayementHistory p WHERE p.auditeursId = :auditeursId"),
    @NamedQuery(name = "PayementHistory.findByNomComplet", query = "SELECT p FROM PayementHistory p WHERE p.nomComplet = :nomComplet"),
    @NamedQuery(name = "PayementHistory.findByMontant", query = "SELECT p FROM PayementHistory p WHERE p.montant = :montant"),
    @NamedQuery(name = "PayementHistory.findByDateLimitePayement", query = "SELECT p FROM PayementHistory p WHERE p.dateLimitePayement = :dateLimitePayement"),
    @NamedQuery(name = "PayementHistory.findByEtat", query = "SELECT p FROM PayementHistory p WHERE p.etat = :etat"),
    @NamedQuery(name = "PayementHistory.findByIdCentre", query = "SELECT p FROM PayementHistory p WHERE p.idCentre = :idCentre"),
    @NamedQuery(name = "PayementHistory.findByDebutTraitement", query = "SELECT p FROM PayementHistory p WHERE p.debutTraitement = :debutTraitement"),
    @NamedQuery(name = "PayementHistory.findByFindTraitement", query = "SELECT p FROM PayementHistory p WHERE p.findTraitement = :findTraitement"),
    @NamedQuery(name = "PayementHistory.findByPrisEnCompte", query = "SELECT p FROM PayementHistory p WHERE p.prisEnCompte = :prisEnCompte"),
    @NamedQuery(name = "PayementHistory.findByOmtPayementId", query = "SELECT p FROM PayementHistory p WHERE p.omtPayementId = :omtPayementId"),
    @NamedQuery(name = "PayementHistory.findByGenerePar", query = "SELECT p FROM PayementHistory p WHERE p.generePar = :generePar"),
    @NamedQuery(name = "PayementHistory.findByDateCreationModification", query = "SELECT p FROM PayementHistory p WHERE p.dateCreationModification = :dateCreationModification"),
    @NamedQuery(name = "PayementHistory.findByIdEmploye", query = "SELECT p FROM PayementHistory p WHERE p.idEmploye = :idEmploye"),
    @NamedQuery(name = "PayementHistory.findByCommit", query = "SELECT p FROM PayementHistory p WHERE p.commit = :commit"),
    @NamedQuery(name = "PayementHistory.findByPrecedent", query = "SELECT p FROM PayementHistory p WHERE p.precedent = :precedent")})
public class PayementHistory implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "token")
    private String token;
    @Basic(optional = false)
    @Column(name = "NoEtud")
    private int noEtud;
    @Basic(optional = false)
    @Column(name = "auditeursId")
    private String auditeursId;
    @Basic(optional = false)
    @Column(name = "NomComplet")
    private String nomComplet;
    @Basic(optional = false)
    @Column(name = "montant")
    private int montant;
    @Basic(optional = false)
    @Column(name = "dateLimitePayement")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateLimitePayement;
    @Basic(optional = false)
    @Column(name = "etat")
    private Character etat;
    @Column(name = "idCentre")
    private Short idCentre;
    @Column(name = "debutTraitement")
    @Temporal(TemporalType.TIMESTAMP)
    private Date debutTraitement;
    @Column(name = "findTraitement")
    @Temporal(TemporalType.TIMESTAMP)
    private Date findTraitement;
    @Column(name = "prisEnCompte")
    private Short prisEnCompte;
    @Column(name = "omtPayementId")
    private String omtPayementId;
    @Basic(optional = false)
    @Column(name = "generePar")
    private String generePar;
    @Basic(optional = false)
    @Column(name = "dateCreationModification")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreationModification;
    @Column(name = "idEmploye")
    private Short idEmploye;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "commit")
    private Integer commit;
    @Column(name = "precedent")
    private Integer precedent;
    @JoinColumn(name = "payId", referencedColumnName = "payId")
    @ManyToOne(optional = false)
    private Payementlog payId;

    public PayementHistory() {
    }

    public PayementHistory(Integer commit) {
        this.commit = commit;
    }

    public PayementHistory(Integer commit, int noEtud, String auditeursId, String nomComplet, int montant, Date dateLimitePayement, Character etat, String generePar, Date dateCreationModification) {
        this.commit = commit;
        this.noEtud = noEtud;
        this.auditeursId = auditeursId;
        this.nomComplet = nomComplet;
        this.montant = montant;
        this.dateLimitePayement = dateLimitePayement;
        this.etat = etat;
        this.generePar = generePar;
        this.dateCreationModification = dateCreationModification;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getNoEtud() {
        return noEtud;
    }

    public void setNoEtud(int noEtud) {
        this.noEtud = noEtud;
    }

    public String getAuditeursId() {
        return auditeursId;
    }

    public void setAuditeursId(String auditeursId) {
        this.auditeursId = auditeursId;
    }

    public String getNomComplet() {
        return nomComplet;
    }

    public void setNomComplet(String nomComplet) {
        this.nomComplet = nomComplet;
    }

    public int getMontant() {
        return montant;
    }

    public void setMontant(int montant) {
        this.montant = montant;
    }

    public Date getDateLimitePayement() {
        return dateLimitePayement;
    }

    public void setDateLimitePayement(Date dateLimitePayement) {
        this.dateLimitePayement = dateLimitePayement;
    }

    public Character getEtat() {
        return etat;
    }

    public void setEtat(Character etat) {
        this.etat = etat;
    }

    public Short getIdCentre() {
        return idCentre;
    }

    public void setIdCentre(Short idCentre) {
        this.idCentre = idCentre;
    }

    public Date getDebutTraitement() {
        return debutTraitement;
    }

    public void setDebutTraitement(Date debutTraitement) {
        this.debutTraitement = debutTraitement;
    }

    public Date getFindTraitement() {
        return findTraitement;
    }

    public void setFindTraitement(Date findTraitement) {
        this.findTraitement = findTraitement;
    }

    public Short getPrisEnCompte() {
        return prisEnCompte;
    }

    public void setPrisEnCompte(Short prisEnCompte) {
        this.prisEnCompte = prisEnCompte;
    }

    public String getOmtPayementId() {
        return omtPayementId;
    }

    public void setOmtPayementId(String omtPayementId) {
        this.omtPayementId = omtPayementId;
    }

    public String getGenerePar() {
        return generePar;
    }

    public void setGenerePar(String generePar) {
        this.generePar = generePar;
    }

    public Date getDateCreationModification() {
        return dateCreationModification;
    }

    public void setDateCreationModification(Date dateCreationModification) {
        this.dateCreationModification = dateCreationModification;
    }

    public Short getIdEmploye() {
        return idEmploye;
    }

    public void setIdEmploye(Short idEmploye) {
        this.idEmploye = idEmploye;
    }

    public Integer getCommit() {
        return commit;
    }

    public void setCommit(Integer commit) {
        this.commit = commit;
    }

    public Integer getPrecedent() {
        return precedent;
    }

    public void setPrecedent(Integer precedent) {
        this.precedent = precedent;
    }

    public Payementlog getPayId() {
        return payId;
    }

    public void setPayId(Payementlog payId) {
        this.payId = payId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (commit != null ? commit.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PayementHistory)) {
            return false;
        }
        PayementHistory other = (PayementHistory) object;
        if ((this.commit == null && other.commit != null) || (this.commit != null && !this.commit.equals(other.commit))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "net.cofares.PayementHistory[ commit=" + commit + " ]";
    }
    
}
