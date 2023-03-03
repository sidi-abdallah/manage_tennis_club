package fr.ensicaen.sidiabdallah.tennis.entities;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "Inscription", schema = "sidi-abdallah", catalog = "clinique")
public class InscriptionEntity {
    @Basic
    @Column(name = "numeroAdherent")
    private int numeroAdherent;
    @Basic
    @Column(name = "DateInscription")
    private Date dateInscription;
    @Basic
    @Column(name = "codeTournoi")
    private int codeTournoi;
    @Basic
    @Id
    @Column(name = "id")
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getNumeroAdherent() {
        return numeroAdherent;
    }

    public void setNumeroAdherent(int numeroAdherent) {
        this.numeroAdherent = numeroAdherent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InscriptionEntity that = (InscriptionEntity) o;

        if (numeroAdherent != that.numeroAdherent) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return numeroAdherent;
    }

    public Date getDateInscription() {
        return dateInscription;
    }

    public void setDateInscription(Date dateInscription) {
        this.dateInscription = dateInscription;
    }

    public int getCodeTournoi() {
        return codeTournoi;
    }

    public void setCodeTournoi(int codeTournoi) {
        this.codeTournoi = codeTournoi;
    }
}
