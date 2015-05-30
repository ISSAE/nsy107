/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.cofares.viewtracking;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author pascalfares
 */
@Entity
@Table(name = "Fiche_Descriptive")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FicheDescriptive.findAll", query = "SELECT f FROM FicheDescriptive f"),
    @NamedQuery(name = "FicheDescriptive.findByIdFicheDescriptive", query = "SELECT f FROM FicheDescriptive f WHERE f.idFicheDescriptive = :idFicheDescriptive"),
    @NamedQuery(name = "FicheDescriptive.findByNomCandidat", query = "SELECT f FROM FicheDescriptive f WHERE f.nomCandidat = :nomCandidat"),
    @NamedQuery(name = "FicheDescriptive.findByNoDossier", query = "SELECT f FROM FicheDescriptive f WHERE f.noDossier = :noDossier"),
    @NamedQuery(name = "FicheDescriptive.findByIdSpec", query = "SELECT f FROM FicheDescriptive f WHERE f.idSpec = :idSpec"),
    @NamedQuery(name = "FicheDescriptive.findByDateValidationFiche", query = "SELECT f FROM FicheDescriptive f WHERE f.dateValidationFiche = :dateValidationFiche"),
    @NamedQuery(name = "FicheDescriptive.findByThematique", query = "SELECT f FROM FicheDescriptive f WHERE f.thematique = :thematique"),
    @NamedQuery(name = "FicheDescriptive.findByTitre", query = "SELECT f FROM FicheDescriptive f WHERE f.titre = :titre"),
    @NamedQuery(name = "FicheDescriptive.findByMotsCles", query = "SELECT f FROM FicheDescriptive f WHERE f.motsCles = :motsCles"),
    @NamedQuery(name = "FicheDescriptive.findByPartenaireNomEntreprise", query = "SELECT f FROM FicheDescriptive f WHERE f.partenaireNomEntreprise = :partenaireNomEntreprise"),
    @NamedQuery(name = "FicheDescriptive.findByPartenaireRepresentant", query = "SELECT f FROM FicheDescriptive f WHERE f.partenaireRepresentant = :partenaireRepresentant"),
    @NamedQuery(name = "FicheDescriptive.findByPartenaireResponsabletechnique", query = "SELECT f FROM FicheDescriptive f WHERE f.partenaireResponsabletechnique = :partenaireResponsabletechnique"),
    @NamedQuery(name = "FicheDescriptive.findByPartenairePosteCandidat", query = "SELECT f FROM FicheDescriptive f WHERE f.partenairePosteCandidat = :partenairePosteCandidat"),
    @NamedQuery(name = "FicheDescriptive.findByPartenaireAddresse", query = "SELECT f FROM FicheDescriptive f WHERE f.partenaireAddresse = :partenaireAddresse"),
    @NamedQuery(name = "FicheDescriptive.findByPartenaireTelephone", query = "SELECT f FROM FicheDescriptive f WHERE f.partenaireTelephone = :partenaireTelephone"),
    @NamedQuery(name = "FicheDescriptive.findByPartenaireEmail", query = "SELECT f FROM FicheDescriptive f WHERE f.partenaireEmail = :partenaireEmail"),
    @NamedQuery(name = "FicheDescriptive.findByClientNom", query = "SELECT f FROM FicheDescriptive f WHERE f.clientNom = :clientNom"),
    @NamedQuery(name = "FicheDescriptive.findByClientRepresentant", query = "SELECT f FROM FicheDescriptive f WHERE f.clientRepresentant = :clientRepresentant"),
    @NamedQuery(name = "FicheDescriptive.findByLieuRealisation", query = "SELECT f FROM FicheDescriptive f WHERE f.lieuRealisation = :lieuRealisation"),
    @NamedQuery(name = "FicheDescriptive.findByVisaChefDepInsc", query = "SELECT f FROM FicheDescriptive f WHERE f.visaChefDepInsc = :visaChefDepInsc"),
    @NamedQuery(name = "FicheDescriptive.findByDateVisaCheDepInsc", query = "SELECT f FROM FicheDescriptive f WHERE f.dateVisaCheDepInsc = :dateVisaCheDepInsc"),
    @NamedQuery(name = "FicheDescriptive.findByTuteurResponsablePart", query = "SELECT f FROM FicheDescriptive f WHERE f.tuteurResponsablePart = :tuteurResponsablePart"),
    @NamedQuery(name = "FicheDescriptive.findByTuteurAssociePart", query = "SELECT f FROM FicheDescriptive f WHERE f.tuteurAssociePart = :tuteurAssociePart"),
    @NamedQuery(name = "FicheDescriptive.findByNoEtud", query = "SELECT f FROM FicheDescriptive f WHERE f.noEtud = :noEtud"),
    @NamedQuery(name = "FicheDescriptive.findByNumProfResponsable", query = "SELECT f FROM FicheDescriptive f WHERE f.numProfResponsable = :numProfResponsable"),
    @NamedQuery(name = "FicheDescriptive.findByNumProfAssocie", query = "SELECT f FROM FicheDescriptive f WHERE f.numProfAssocie = :numProfAssocie"),
    @NamedQuery(name = "FicheDescriptive.findBySupprime", query = "SELECT f FROM FicheDescriptive f WHERE f.supprime = :supprime"),
    @NamedQuery(name = "FicheDescriptive.findByAnneeUniversitaire", query = "SELECT f FROM FicheDescriptive f WHERE f.anneeUniversitaire = :anneeUniversitaire"),
    @NamedQuery(name = "FicheDescriptive.findByTypeProjet", query = "SELECT f FROM FicheDescriptive f WHERE f.typeProjet = :typeProjet")})
public class FicheDescriptive implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idFiche_Descriptive")
    private Integer idFicheDescriptive;
    @Size(max = 45)
    @Column(name = "NomCandidat")
    private String nomCandidat;
    @Size(max = 45)
    @Column(name = "NoDossier")
    private String noDossier;
    @Column(name = "IdSpec")
    private Short idSpec;
    @Column(name = "DateValidationFiche")
    @Temporal(TemporalType.DATE)
    private Date dateValidationFiche;
    @Size(max = 100)
    @Column(name = "Thematique")
    private String thematique;
    @Size(max = 100)
    @Column(name = "Titre")
    private String titre;
    @Size(max = 100)
    @Column(name = "MotsCles")
    private String motsCles;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "CahierDesCharges")
    private String cahierDesCharges;
    @Size(max = 45)
    @Column(name = "Partenaire_Nom_Entreprise")
    private String partenaireNomEntreprise;
    @Size(max = 45)
    @Column(name = "Partenaire_Representant")
    private String partenaireRepresentant;
    @Size(max = 45)
    @Column(name = "Partenaire_Responsable_technique")
    private String partenaireResponsabletechnique;
    @Size(max = 45)
    @Column(name = "Partenaire_Poste_Candidat")
    private String partenairePosteCandidat;
    @Size(max = 45)
    @Column(name = "Partenaire_Addresse")
    private String partenaireAddresse;
    @Size(max = 45)
    @Column(name = "Partenaire_Telephone")
    private String partenaireTelephone;
    @Size(max = 45)
    @Column(name = "Partenaire_Email")
    private String partenaireEmail;
    @Size(max = 45)
    @Column(name = "Client_Nom")
    private String clientNom;
    @Size(max = 45)
    @Column(name = "Client_Representant")
    private String clientRepresentant;
    @Size(max = 45)
    @Column(name = "Lieu_Realisation")
    private String lieuRealisation;
    @Column(name = "visa_ChefDep_Insc")
    private Boolean visaChefDepInsc;
    @Column(name = "Date_Visa_CheDep_Insc")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateVisaCheDepInsc;
    @Column(name = "TuteurResponsable_Part")
    private Short tuteurResponsablePart;
    @Column(name = "TuteurAssocie_Part")
    private Short tuteurAssociePart;
    @Column(name = "NoEtud")
    private Integer noEtud;
    @Column(name = "NumProfResponsable")
    private Short numProfResponsable;
    @Column(name = "NumProfAssocie")
    private Short numProfAssocie;
    @Column(name = "supprime")
    private Boolean supprime;
    @Column(name = "Annee_Universitaire")
    private Short anneeUniversitaire;
    @Size(max = 30)
    @Column(name = "Type_Projet")
    private String typeProjet;

    public FicheDescriptive() {
    }

    public FicheDescriptive(Integer idFicheDescriptive) {
        this.idFicheDescriptive = idFicheDescriptive;
    }

    public Integer getIdFicheDescriptive() {
        return idFicheDescriptive;
    }

    public void setIdFicheDescriptive(Integer idFicheDescriptive) {
        this.idFicheDescriptive = idFicheDescriptive;
    }

    public String getNomCandidat() {
        return nomCandidat;
    }

    public void setNomCandidat(String nomCandidat) {
        this.nomCandidat = nomCandidat;
    }

    public String getNoDossier() {
        return noDossier;
    }

    public void setNoDossier(String noDossier) {
        this.noDossier = noDossier;
    }

    public Short getIdSpec() {
        return idSpec;
    }

    public void setIdSpec(Short idSpec) {
        this.idSpec = idSpec;
    }

    public Date getDateValidationFiche() {
        return dateValidationFiche;
    }

    public void setDateValidationFiche(Date dateValidationFiche) {
        this.dateValidationFiche = dateValidationFiche;
    }

    public String getThematique() {
        return thematique;
    }

    public void setThematique(String thematique) {
        this.thematique = thematique;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getMotsCles() {
        return motsCles;
    }

    public void setMotsCles(String motsCles) {
        this.motsCles = motsCles;
    }

    public String getCahierDesCharges() {
        return cahierDesCharges;
    }

    public void setCahierDesCharges(String cahierDesCharges) {
        this.cahierDesCharges = cahierDesCharges;
    }

    public String getPartenaireNomEntreprise() {
        return partenaireNomEntreprise;
    }

    public void setPartenaireNomEntreprise(String partenaireNomEntreprise) {
        this.partenaireNomEntreprise = partenaireNomEntreprise;
    }

    public String getPartenaireRepresentant() {
        return partenaireRepresentant;
    }

    public void setPartenaireRepresentant(String partenaireRepresentant) {
        this.partenaireRepresentant = partenaireRepresentant;
    }

    public String getPartenaireResponsabletechnique() {
        return partenaireResponsabletechnique;
    }

    public void setPartenaireResponsabletechnique(String partenaireResponsabletechnique) {
        this.partenaireResponsabletechnique = partenaireResponsabletechnique;
    }

    public String getPartenairePosteCandidat() {
        return partenairePosteCandidat;
    }

    public void setPartenairePosteCandidat(String partenairePosteCandidat) {
        this.partenairePosteCandidat = partenairePosteCandidat;
    }

    public String getPartenaireAddresse() {
        return partenaireAddresse;
    }

    public void setPartenaireAddresse(String partenaireAddresse) {
        this.partenaireAddresse = partenaireAddresse;
    }

    public String getPartenaireTelephone() {
        return partenaireTelephone;
    }

    public void setPartenaireTelephone(String partenaireTelephone) {
        this.partenaireTelephone = partenaireTelephone;
    }

    public String getPartenaireEmail() {
        return partenaireEmail;
    }

    public void setPartenaireEmail(String partenaireEmail) {
        this.partenaireEmail = partenaireEmail;
    }

    public String getClientNom() {
        return clientNom;
    }

    public void setClientNom(String clientNom) {
        this.clientNom = clientNom;
    }

    public String getClientRepresentant() {
        return clientRepresentant;
    }

    public void setClientRepresentant(String clientRepresentant) {
        this.clientRepresentant = clientRepresentant;
    }

    public String getLieuRealisation() {
        return lieuRealisation;
    }

    public void setLieuRealisation(String lieuRealisation) {
        this.lieuRealisation = lieuRealisation;
    }

    public Boolean getVisaChefDepInsc() {
        return visaChefDepInsc;
    }

    public void setVisaChefDepInsc(Boolean visaChefDepInsc) {
        this.visaChefDepInsc = visaChefDepInsc;
    }

    public Date getDateVisaCheDepInsc() {
        return dateVisaCheDepInsc;
    }

    public void setDateVisaCheDepInsc(Date dateVisaCheDepInsc) {
        this.dateVisaCheDepInsc = dateVisaCheDepInsc;
    }

    public Short getTuteurResponsablePart() {
        return tuteurResponsablePart;
    }

    public void setTuteurResponsablePart(Short tuteurResponsablePart) {
        this.tuteurResponsablePart = tuteurResponsablePart;
    }

    public Short getTuteurAssociePart() {
        return tuteurAssociePart;
    }

    public void setTuteurAssociePart(Short tuteurAssociePart) {
        this.tuteurAssociePart = tuteurAssociePart;
    }

    public Integer getNoEtud() {
        return noEtud;
    }

    public void setNoEtud(Integer noEtud) {
        this.noEtud = noEtud;
    }

    public Short getNumProfResponsable() {
        return numProfResponsable;
    }

    public void setNumProfResponsable(Short numProfResponsable) {
        this.numProfResponsable = numProfResponsable;
    }

    public Short getNumProfAssocie() {
        return numProfAssocie;
    }

    public void setNumProfAssocie(Short numProfAssocie) {
        this.numProfAssocie = numProfAssocie;
    }

    public Boolean getSupprime() {
        return supprime;
    }

    public void setSupprime(Boolean supprime) {
        this.supprime = supprime;
    }

    public Short getAnneeUniversitaire() {
        return anneeUniversitaire;
    }

    public void setAnneeUniversitaire(Short anneeUniversitaire) {
        this.anneeUniversitaire = anneeUniversitaire;
    }

    public String getTypeProjet() {
        return typeProjet;
    }

    public void setTypeProjet(String typeProjet) {
        this.typeProjet = typeProjet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFicheDescriptive != null ? idFicheDescriptive.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FicheDescriptive)) {
            return false;
        }
        FicheDescriptive other = (FicheDescriptive) object;
        if ((this.idFicheDescriptive == null && other.idFicheDescriptive != null) || (this.idFicheDescriptive != null && !this.idFicheDescriptive.equals(other.idFicheDescriptive))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "net.cofares.viewtracking.FicheDescriptive[ idFicheDescriptive=" + idFicheDescriptive + " ]";
    }
    
}
