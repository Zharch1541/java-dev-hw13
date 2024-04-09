package services;

import entity.Planet;
import hibernate.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class PlanetCrudService {
    public boolean createPlanet(Planet planet) {
        boolean result = false;
        try (Session session = HibernateUtils.getInstance().getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            try {
                session.persist(planet);
                transaction.commit();
                result = true;
            } catch(Exception ex) {
                ex.printStackTrace();
                transaction.rollback();
            }
        }
        return result;
    }

    public void deletePlanet(Planet planet) {
        try (Session session = HibernateUtils.getInstance().getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.remove(planet);
            transaction.commit();
        }
    }

    public Planet getPlanetById(String planetId) {
        try (Session session = HibernateUtils.getInstance().getSessionFactory().openSession()) {
            return session.get(Planet.class, planetId);
        }
    }
}
