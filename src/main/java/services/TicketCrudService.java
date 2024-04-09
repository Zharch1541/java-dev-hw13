package services;

import entity.Ticket;
import hibernate.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class TicketCrudService {
    public boolean createTicket(Ticket ticket) {
        boolean result = false;
        try (Session session = HibernateUtils.getInstance().getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            try {
                ticket.setId(null);
                session.persist(ticket);
                transaction.commit();
                result = true;
            } catch(Exception ex) {
                ex.printStackTrace();
                transaction.rollback();
            }
        }
        return result;
    }

    public void deleteTicket(Ticket ticket) {
        try (Session session = HibernateUtils.getInstance().getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.remove(ticket);
            transaction.commit();
        }
    }
}
