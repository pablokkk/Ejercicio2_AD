package cesur.examen.domain.client;

import cesur.examen.domain.car.Car;
import jakarta.persistence.*;
import lombok.Getter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * EXAMEN DE ACCESO A DATOS
 * Diciembre 2023
 *
 * Nombre del alumno: Javier Sánchez
 * Fecha: 11/12/2023
 */

@Entity
@Table(name = "cliente")
public class Client implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Getter
    @Column(name = "nombre")
    private String name;

    @Column(name = "email")
    private String email;

    @Getter
    @OneToMany(mappedBy = "client", fetch = FetchType.EAGER)
    private List<Car> cars = new ArrayList<>();

        @Override
        public String toString() {
            return "Client{" +
                    "id=" + id +
                    ", email='" + email + '\'' +
                    ", name='" + name + '\'' +
                    '}';
        }

    public void addCar(Car car) {
        car.setClient(this);
        cars.add(car);
    }
}

