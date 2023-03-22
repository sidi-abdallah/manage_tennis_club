package fr.ensicaen.sidiabdallah.tennis.entities;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

public class InscriptionEntityPK implements Serializable {
    @Column(name = "`codeTournoi`")
    @Id
  //  @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codeTournoi;
    @Column(name = "`numeroAdherent`")
    @Id
  //  @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int numeroAdherent;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InscriptionEntityPK that = (InscriptionEntityPK) o;

        if (codeTournoi != that.codeTournoi) return false;
        if (numeroAdherent != that.numeroAdherent) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = codeTournoi;
        result = 31 * result + numeroAdherent;
        return result;
    }
}
