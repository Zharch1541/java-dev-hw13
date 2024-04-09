package hibernate;

import entity.Client;
import entity.Planet;
import org.flywaydb.core.Flyway;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import props.PropertyReader;

public class HibernateUtils {
    private static final HibernateUtils INSTANCE = new HibernateUtils();
    private SessionFactory sessionFactory;

    private HibernateUtils() {
        this.sessionFactory = new Configuration()
                .addAnnotatedClass(Client.class)
                .addAnnotatedClass(Planet.class)
                .buildSessionFactory();
        flywayMigration(PropertyReader.getConnectionUrlForH2(), null, null);
    }

    public static HibernateUtils getInstance() {
        return INSTANCE;
    }

    public SessionFactory getSessionFactory() {
        return this.sessionFactory;
    }

    public void closeSessionFactory() {
        this.sessionFactory.close();
    }
    private void flywayMigration(String connectionUrl, String username, String password) {
        Flyway flyway = Flyway.configure().dataSource(connectionUrl, username, password).load();
        flyway.migrate();
    }
}
