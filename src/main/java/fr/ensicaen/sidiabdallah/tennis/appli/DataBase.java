package fr.ensicaen.sidiabdallah.tennis.appli;

import fr.ensicaen.sidiabdallah.tennis.entities.AdherentEntity;
import fr.ensicaen.sidiabdallah.tennis.entities.InscriptionEntity;
import fr.ensicaen.sidiabdallah.tennis.entities.TournoiEntity;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.security.NoSuchAlgorithmException;
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

    /**
     *
     * @return a list of all Tournoi table rows
     */
    public static List<TournoiEntity> getTournoiEntities() {
        Query query = em.createQuery("from TournoiEntity");
        List<TournoiEntity> list = (List<TournoiEntity>) query.getResultList();
        return list;

    }

    /**
     *
     * @return a list of all Adherent table rows
     */
    public static List<AdherentEntity> getAdherentEntities() {
        Query query = em.createQuery("from AdherentEntity");
        List<AdherentEntity> list = (List<AdherentEntity>) query.getResultList();
        return list;

    }

    /**
     *
     * @return a list of all Inscription table rows
     */
    public static List<InscriptionEntity> getInscriptionEntities() {
        Query query = em.createQuery("from InscriptionEntity");
        List<InscriptionEntity> list = (List<InscriptionEntity>) query.getResultList();
        return list;

    }

    /**
     *
     * @param adherent whom the tournois will be returned
     * @return the adherent's tournois
     */
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

    /**
     *
     * @param adherent the adherent to register into the tournoi
     * @param codeTournoi the tournoi code
     * @return boolean true if the adherent is already registered into this tournoi, false otherwise
     */
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

    /**
     *
     * @param codeTournoi the code of the tournoi that will be returned
     * @return a tournoi whom code is codeTournoi, otherwise null
     */
    public static TournoiEntity getTournoi(int codeTournoi) {
        for(TournoiEntity tournoi : getTournoiEntities()) {
            if(tournoi.getCodeTournoi() == codeTournoi) {
                return tournoi;
            }
        }
        return null;
    }

    /**
     * @brief remove a row from the Inscription table
     * @param numAdh the adherent number
     * @param codeTournoi the tournoi's code
     */
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

    /**
     * @brief adds an adherent into the database
     * @param lastName
     * @param firstName
     * @param email
     * @param password
     * @param adresse
     * @param tel
     * @return true if the adherent hasn't an account yet and he were been added, false otherwise
     */
    public static boolean insertAdherent(String lastName, String firstName, String email, String password, String adresse, String tel) {
        for(AdherentEntity adherentEntity : getAdherentEntities()) {
            if(adherentEntity.getEmail().equals(email)) {
                return false;
            }
        }
        AdherentEntity adherent = new AdherentEntity();
        adherent.setAdresse(adresse);
        adherent.setEmail(email);
        adherent.setNom(lastName);
        adherent.setPrenom(firstName);
        adherent.setTelephone(tel);
        String hashedPassword = Hashing.getInstance().hashPassword(password);
        adherent.setPassword(hashedPassword);
        int adherentNb = Hashing.emailToUniqueInt(email);
        adherent.setNumeroAdherent(adherentNb);
        try {
            em.getTransaction().begin();
            em.persist(adherent);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.err.println("Erreur: " + e.getMessage());
        }

        return true;
    }


}
