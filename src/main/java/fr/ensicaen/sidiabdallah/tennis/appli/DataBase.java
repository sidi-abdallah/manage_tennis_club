package fr.ensicaen.sidiabdallah.tennis.appli;

import fr.ensicaen.sidiabdallah.tennis.entities.AdherentEntity;
import fr.ensicaen.sidiabdallah.tennis.entities.InscriptionEntity;
import fr.ensicaen.sidiabdallah.tennis.entities.TournoiEntity;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class DataBase {

    private static EntityManager em;

    public DataBase() {
        em = Persistence.createEntityManagerFactory("TennisUnit").createEntityManager();
    }

    public static List<TournoiEntity> getTournoiEntity() {
        Query query = em.createQuery("from TournoiEntity");
        List<TournoiEntity> list = (List<TournoiEntity>) query.getResultList();
        return list;

    }

    public static List<AdherentEntity> getAdherentEntity() {
        Query query = em.createQuery("from AdherentEntity");
        List<AdherentEntity> list = (List<AdherentEntity>) query.getResultList();
        return list;

    }

    public static List<InscriptionEntity> getInscriptionEntity() {
        Query query = em.createQuery("from InscriptionEntity");
        List<InscriptionEntity> list = (List<InscriptionEntity>) query.getResultList();
        return list;

    }

    public static List<TournoiEntity> getTournois(AdherentEntity adherent) {
        String hql = "SELECT t FROM TournoiEntity t, InscriptionEntity i WHERE t.codeTournoi = i.codeTournoi AND i.numeroAdherent =  adherent.getNumeroAdherent()";
        Query query = em.createQuery(hql);
        query.setParameter("numeroAdherent", adherent.getNumeroAdherent());
        List<TournoiEntity> tournois = query.list();
        return tournois;
    }

}
