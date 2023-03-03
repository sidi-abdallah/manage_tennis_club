package fr.ensicaen.sidiabdallah.tennis.appli;

import fr.ensicaen.sidiabdallah.tennis.entities.InscriptionEntity;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;

public class DataBase {

    private EntityManager em;

    public DataBase() {
        em = Persistence.createEntityManagerFactory("TennisUnit").createEntityManager();
    }

    public ArrayList<InscriptionEntity> getInsecriptionEntity() {
        Query query = em.createQuery("from InscriptionEntity");
        ArrayList<InscriptionEntity> list = (ArrayList<InscriptionEntity>) query.getResultList();
        return list;

    }
}
