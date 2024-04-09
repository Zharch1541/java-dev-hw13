package services;

import entity.Client;
import hibernate.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ClientCrudService {
    public boolean createClient(Client client) {
        boolean result = false;
        try (Session session = HibernateUtils.getInstance().getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            try {
                client.setId(null);
                session.persist(client);
                transaction.commit();
                result = true;
            } catch(Exception ex) {
                ex.printStackTrace();
                transaction.rollback();
            }
        }
        return result;
    }

    public void deleteClient(Client client) {
        try (Session session = HibernateUtils.getInstance().getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.remove(client);
            transaction.commit();
        }
    }
    public Client getClientById(Long clientId) {
        try (Session session = HibernateUtils.getInstance().getSessionFactory().openSession()) {
            return session.get(Client.class, clientId);
        }
    }
}
