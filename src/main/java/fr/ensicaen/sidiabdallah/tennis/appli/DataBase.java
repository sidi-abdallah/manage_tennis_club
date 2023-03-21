package fr.ensicaen.sidiabdallah.tennis.appli;

import fr.ensicaen.sidiabdallah.tennis.entities.AdherentEntity;
import fr.ensicaen.sidiabdallah.tennis.entities.InscriptionEntity;
import fr.ensicaen.sidiabdallah.tennis.entities.TournoiEntity;

import javax.persistence.EntityManager;
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
        //String hql = "from TournoiEntity t INNER JOIN InscriptionEntity i ON t.codeTournoi = i.codeTournoi WHERE i.numeroAdherent = :num";
//        String hql = "from TournoiEntity";
        //List<AdherentEntity> adherententities = getAdherentEntity();
        List<InscriptionEntity> inscriptionEntities = getInscriptionEntity();
        List<TournoiEntity> tournoiEntities = getTournoiEntity();
        System.out.println(tournoiEntities.get(0).getCodeTournoi());
        //System.out.println(inscriptionEntities.get(0).getCodeTournoi());
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
//        Query query = em.createQuery(hql);
//        //query.setParameter("num", adherent.getNumeroAdherent());
//        List<TournoiEntity> tournois = (List<TournoiEntity>)query.getResultList();
        return tournois;
    }

    public static void insertIntoInscrption(int numAdherent, Date dateInsc, int codeTournoi) {
        String hql = "INSERT INTO inscriptionEntity (numerAdherent, DateInscription, codeTournoi) VALUES (:numeroAdherent, :DateInscription, :codeTournoi)";
        Query query = em.createQuery(hql);
        query.setParameter("numeroAdherent", numAdherent );
        query.setParameter("dateInscription",dateInsc );
        query.setParameter("codeTournoi", codeTournoi);
        query.executeUpdate();
    }



}
