package cesur.examen.domain.client;

import java.util.ArrayList;
import java.util.List;

/**
 * EXAMEN DE ACCESO A DATOS
 * Diciembre 2023
 *
 * Nombre del alumno: Javier Sánchez
 * Fecha: 11/12/2023
 */

public class ClientService {

    public static List<Client> hasManufacturer(String manufacturer) {
        var out = new ArrayList<Client>();

        try {
            ClientDAO clientDAO = new ClientDAO();
            out = (ArrayList<Client>) clientDAO.getAllByManufacturer(manufacturer);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return out;
    }
}

