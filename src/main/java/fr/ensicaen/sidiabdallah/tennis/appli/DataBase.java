package fr.ensicaen.sidiabdallah.tennis.appli;

import fr.ensicaen.sidiabdallah.tennis.entities.AdherentEntity;
import fr.ensicaen.sidiabdallah.tennis.entities.InscriptionEntity;
import fr.ensicaen.sidiabdallah.tennis.entities.TournoiEntity;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DataBase {

    private static DataBase instance;
    private static EntityManager em;
    public static DataBase getInstance() {
        if (instance == null) instance = new DataBase();
        return instance;
    }

    public DataBase() {
        em = Persistence.createEntityManagerFactory("TennisUnit").createEntityManager();
    }

    public static List<TournoiEntity> getTournoiEntities() {
        Query query = em.createQuery("from TournoiEntity");
        List<TournoiEntity> list = (List<TournoiEntity>) query.getResultList();
        return list;

    }

    public static List<AdherentEntity> getAdherentEntities() {
        Query query = em.createQuery("from AdherentEntity");
        List<AdherentEntity> list = (List<AdherentEntity>) query.getResultList();
        return list;

    }

    public static List<InscriptionEntity> getInscriptionEntities() {
        Query query = em.createQuery("from InscriptionEntity");
        List<InscriptionEntity> list = (List<InscriptionEntity>) query.getResultList();
        return list;

    }

    public static List<TournoiEntity> getTournois(AdherentEntity adherent) {
        List<InscriptionEntity> inscriptionEntities = getInscriptionEntities();
        List<TournoiEntity> tournoiEntities = getTournoiEntities();
        System.out.println(tournoiEntities.get(0).getCodeTournoi());
        List<TournoiEntity> tournois = new ArrayList<>();
        for(InscriptionEntity inscription : inscriptionEntities) {
            if(inscription.getNumeroAdherent() == adherent.getNumeroAdherent()) {
                for(TournoiEntity tournoi : tournoiEntities) {
                    if(tournoi.getCodeTournoi() == inscription.getCodeTournoi()) {
                        tournois.add(tournoi);
                    }
                }
            }
        }
        return tournois;
    }

    public static boolean insertIntoInscrption(AdherentEntity adherent, int codeTournoi) {
        for(TournoiEntity tournoi : getTournois(adherent)) {
            if(tournoi.getCodeTournoi() == codeTournoi) {
                return true;
            }
        }

        InscriptionEntity inscriptionEntity = new InscriptionEntity();
        inscriptionEntity.setCodeTournoi(codeTournoi);
        inscriptionEntity.setNumeroAdherent(adherent.getNumeroAdherent());
        inscriptionEntity.setDateInscription(new java.sql.Date((new Date()).getTime()));
        try {
            em.getTransaction().begin();
            em.persist(inscriptionEntity);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.err.println("Erreur: " + e.getMessage());
        }
        return false;
    }

    public static TournoiEntity getTournoi(int codeTournoi) {
        for(TournoiEntity tournoi : getTournoiEntities()) {
            if(tournoi.getCodeTournoi() == codeTournoi) {
                return tournoi;
            }
        }
        return null;
    }

    public static void removeFromInscription(int numAdh, int codeTournoi) {
        try {
            Query query = em.createQuery("from InscriptionEntity where numeroAdherent = :numeroAdherent and " +
                    "codeTournoi = :codeTournoi") ;
            query.setParameter("codeTournoi", codeTournoi);
            query.setParameter("numeroAdherent", numAdh);
            InscriptionEntity inscriptionEntity = (InscriptionEntity) query.getSingleResult() ;
            em.getTransaction().begin();
            em.remove(inscriptionEntity);
            em.getTransaction().commit();
        } catch (NoResultException e) {
            System.err.println("Erreur: " + e.getMessage());
        }
    }


}
