package fr.ensicaen.sidiabdallah.tennis;

import fr.ensicaen.sidiabdallah.tennis.entities.AdherentEntity;
import fr.ensicaen.sidiabdallah.tennis.entities.TournoiEntity;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        EntityManager em = Persistence.createEntityManagerFactory("TennisUnit").createEntityManager();
        Query query = em.createQuery("from TournoiEntity");
        List<TournoiEntity> list = (List<TournoiEntity>) query.getResultList();
        System.out.println(list.size());
    }
}
