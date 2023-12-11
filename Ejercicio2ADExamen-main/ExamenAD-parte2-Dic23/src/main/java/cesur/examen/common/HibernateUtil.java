package cesur.examen.common;

import lombok.Getter;
import lombok.extern.java.Log;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * EXAMEN DE ACCESO A DATOS
 * Diciembre 2023
 *
 * Nombre del alumno: Pablo Robles Lorenzo
 * Fecha: 11/12/2023
 *
 * No se permite escribir en consola desde las clases DAO, Service y Utils usando System.out.
 * En su lugar, usa log.info(), log.warning() y log.severe() para mostrar información interna
 * o para seguir la traza de ejecución.
 */

@Log
public class HibernateUtil {
    @Getter
    private static final SessionFactory sessionFactory;

    static {
        log.info("Loading Hibernate configuration...");
        try {
            Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
            sessionFactory = configuration.buildSessionFactory();
            log.info("SessionFactory created successfully!");
        } catch (Exception ex) {
            log.severe("Something fails in buildSessionFactory()");
            log.severe(ex.getMessage());
            throw new RuntimeException("Hibernate config error");
        }
    }
}



