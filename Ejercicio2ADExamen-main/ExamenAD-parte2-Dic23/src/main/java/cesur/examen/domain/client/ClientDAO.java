package cesur.examen.domain.client;

import cesur.examen.common.DAO;
import cesur.examen.common.HibernateUtil;
import lombok.extern.java.Log;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * EXAMEN DE ACCESO A DATOS
 * Diciembre 2023
 *
 * Nombre del alumno: Javier Sánchez
 * Fecha: 11/12/2023
 */

@Log
public class ClientDAO implements DAO<Client> {

    public List<Client> getAllByManufacturer(String manufacturer) {
        var out = new ArrayList<Client>();

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "SELECT DISTINCT c FROM Client c JOIN c.cars car WHERE car.manufacturer = :manufacturer";
            Query<Client> query = session.createQuery(hql, Client.class);
            query.setParameter("manufacturer", manufacturer);
            out = (ArrayList<Client>) query.getResultList();
        } catch (Exception e) {
            log.severe("Error getting clients by manufacturer: " + e.getMessage());
            throw new RuntimeException("Error getting clients by manufacturer");
        }

        return out;
    }

    @Override
    public Client save(Client client) {
        return null;
    }

    @Override
    public Client update(Client client) {
        return null;
    }

    @Override
    public boolean remove(Client client) {
        return false;
    }

    @Override
    public Client get(Long id) {
        return null;
    }

    @Override
    public List<Client> getAll() {
        List<Client> out = new ArrayList<>();

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Client> query = session.createQuery("FROM Client", Client.class);
            out = query.getResultList();
        } catch (Exception e) {
            log.severe("Error getting all clients: " + e.getMessage());
            throw new RuntimeException("Error getting all clients");
        }

        return out != null ? out : Collections.emptyList();
    }

}



