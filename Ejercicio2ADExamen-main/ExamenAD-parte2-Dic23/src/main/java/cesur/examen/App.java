package cesur.examen;

import cesur.examen.common.HibernateUtil;
import cesur.examen.domain.car.Car;
import cesur.examen.domain.car.CarDAO;
import cesur.examen.domain.client.ClientDAO;
import cesur.examen.domain.client.ClientService;

/**
 * EXAMEN DE ACCESO A DATOS
 * Diciembre 2023
 *
 * Nombre del alumno: Pablo Robles Lorenzo
 * Fecha: 11/12/2023
 */
public class App 
{
    /**
     *
     * NO MODIFICAR EL CODIGO DE ESTA CLASE.
     * SI SE MODIFICA NO SE CORREGIRÁ EL RESTO DEL PROYECTO.
     *
     * Descomentar el código conforme se vayan creando los
     * métodos implicados
     *
     */
    static final String STUDENT_NAME = "Pablo Robles Lorenzo";

    public static void main( String[] args )
    {
        System.out.println("----------------------------------------------------------");
        System.out.println(" >>> "+ STUDENT_NAME.toUpperCase() + " Hibernate exercises");
        System.out.println("----------------------------------------------------------\n");

        if(HibernateUtil.getSessionFactory()==null){
            throw new RuntimeException("Start with HibernateUtil, hibernate.config.xml and mapping classes...");
        }
        var clients = (new ClientDAO()).getAll();
        System.out.println("List of clients in database...");
        if(clients.isEmpty()){
            throw new RuntimeException("ClientDAO.getAll() is not implemented");
        }
        clients.forEach(System.out::println);

        System.out.println("Creating a new Car...");
        Car car = new Car();
        car.setModel("C4");
        car.setManufacturer("Citroën");
        car.setPlate("AABBCC");
        clients.get(0).addCar(car);
        (new CarDAO()).save(car);

        clients = (new ClientDAO()).getAll();
        System.out.println("List of clients in database again...");
        clients.forEach(System.out::println);

        System.out.println("List of clients with an car manufactured by Honda...");
        ClientService.hasManufacturer("Honda").forEach(System.out::println);
    }
}
