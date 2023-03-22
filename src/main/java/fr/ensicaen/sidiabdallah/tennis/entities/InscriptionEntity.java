package fr.ensicaen.sidiabdallah.tennis.entities;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "`Inscription`", schema = "sidi-abdallah", catalog = "clinique")
@IdClass(InscriptionEntityPK.class)
public class InscriptionEntity {
 //   @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "`codeTournoi`")
    private int codeTournoi;
   // @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "`numeroAdherent`")
    private int numeroAdherent;
    @Basic
    @Column(name = "`dateInscription`")
    private Date dateInscription;

    public int getCodeTournoi() {
        return codeTournoi;
    }

    public void setCodeTournoi(int codeTournoi) {
        this.codeTournoi = codeTournoi;
    }

    public int getNumeroAdherent() {
        return numeroAdherent;
    }

    public void setNumeroAdherent(int numeroAdherent) {
        this.numeroAdherent = numeroAdherent;
    }

    public Date getDateInscription() {
        return dateInscription;
    }

    public void setDateInscription(Date dateInscription) {
        this.dateInscription = dateInscription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InscriptionEntity that = (InscriptionEntity) o;

        if (codeTournoi != that.codeTournoi) return false;
        if (numeroAdherent != that.numeroAdherent) return false;
        if (dateInscription != null ? !dateInscription.equals(that.dateInscription) : that.dateInscription != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = codeTournoi;
        result = 31 * result + numeroAdherent;
        result = 31 * result + (dateInscription != null ? dateInscription.hashCode() : 0);
        return result;
    }
}
