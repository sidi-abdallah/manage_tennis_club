package fr.ensicaen.sidiabdallah.tennis.appli;

import fr.ensicaen.sidiabdallah.tennis.entities.InscriptionEntity;
import fr.ensicaen.sidiabdallah.tennis.entities.TournoiEntity;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class DataBase {

    private EntityManager em;

    public DataBase() {
        em = Persistence.createEntityManagerFactory("TennisUnit").createEntityManager();
    }

    public List<TournoiEntity> getTournoiEntity() {
        Query query = em.createQuery("from TournoiEntity");
        List<TournoiEntity> list = (List<TournoiEntity>) query.getResultList();
        return list;

    }
}
