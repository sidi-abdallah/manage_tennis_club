package fr.ensicaen.sidiabdallah.tennis.entities;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "Tournoi", schema = "sidi-abdallah", catalog = "clinique")
public class TournoiEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "codeTournoi")
    private int codeTournoi;
    @Basic
    @Column(name = "Nom")
    private String nom;
    @Basic
    @Column(name = "Date ")
    private Date date;
    @Basic
    @Column(name = "Lieu")
    private String lieu;
    @Basic
    @Column(name = "new_column")
    private Integer newColumn;

    public int getCodeTournoi() {
        return codeTournoi;
    }

    public void setCodeTournoi(int codeTournoi) {
        this.codeTournoi = codeTournoi;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public Integer getNewColumn() {
        return newColumn;
    }

    public void setNewColumn(Integer newColumn) {
        this.newColumn = newColumn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TournoiEntity that = (TournoiEntity) o;

        if (codeTournoi != that.codeTournoi) return false;
        if (nom != null ? !nom.equals(that.nom) : that.nom != null) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;
        if (lieu != null ? !lieu.equals(that.lieu) : that.lieu != null) return false;
        if (newColumn != null ? !newColumn.equals(that.newColumn) : that.newColumn != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = codeTournoi;
        result = 31 * result + (nom != null ? nom.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (lieu != null ? lieu.hashCode() : 0);
        result = 31 * result + (newColumn != null ? newColumn.hashCode() : 0);
        return result;
    }
}
