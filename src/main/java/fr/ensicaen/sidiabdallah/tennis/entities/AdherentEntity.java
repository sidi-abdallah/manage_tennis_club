package fr.ensicaen.sidiabdallah.tennis.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "`Adherent`", schema = "sidi-abdallah", catalog = "clinique")
public class AdherentEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "`numeroAdherent`")
    private int numeroAdherent;
    @Basic
    @Column(name = "`Nom`")
    private String nom;
    @Basic
    @Column(name = "`Prenom`")
    private String prenom;
    @Basic
    @Column(name = "`Adresse`")
    private String adresse;
    @Basic
    @Column(name = "`Telephone`")
    private String telephone;
    @Basic
    @Column(name = "`Email`")
    private String email;
    @Basic
    @Column(name = "`Password`")
    private String password;

//    @OneToMany(mappedBy = "numeroAdherent")
//    private Set<InscriptionEntity> inscriptions;

    public int getNumeroAdherent() {
        return numeroAdherent;
    }

    public void setNumeroAdherent(int numeroAdherent) {
        this.numeroAdherent = numeroAdherent;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

//    public Set<InscriptionEntity> getInscriptions() {
//        return inscriptions;
//    }
//
//    public void setInscriptions(Set<InscriptionEntity> inscriptions) {
//        this.inscriptions = inscriptions;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AdherentEntity that = (AdherentEntity) o;

        if (numeroAdherent != that.numeroAdherent) return false;
        if (nom != null ? !nom.equals(that.nom) : that.nom != null) return false;
        if (prenom != null ? !prenom.equals(that.prenom) : that.prenom != null) return false;
        if (adresse != null ? !adresse.equals(that.adresse) : that.adresse != null) return false;
        if (telephone != null ? !telephone.equals(that.telephone) : that.telephone != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = numeroAdherent;
        result = 31 * result + (nom != null ? nom.hashCode() : 0);
        result = 31 * result + (prenom != null ? prenom.hashCode() : 0);
        result = 31 * result + (adresse != null ? adresse.hashCode() : 0);
        result = 31 * result + (telephone != null ? telephone.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }
}
