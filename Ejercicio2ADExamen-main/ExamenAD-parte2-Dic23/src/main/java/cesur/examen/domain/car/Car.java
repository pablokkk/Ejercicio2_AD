package cesur.examen.domain.car;

import cesur.examen.domain.client.Client;
import jakarta.persistence.*;
import lombok.Getter;

import java.io.Serializable;
import java.util.List;

/**
 * EXAMEN DE ACCESO A DATOS
 * Diciembre 2023
 *
 * Nombre del alumno: Pablo Robles Lorenzo
 * Fecha: 11/12/2023
 */

@Entity
@Table(name = "garaje")
public class Car implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Getter
    @Column(name = "matricula")
    private String plate;

    @Getter
    @Column(name = "modelo")
    private String model;

    @Getter
    @Column(name = "fabricante")
    private String manufacturer;

    @Getter
    @ManyToOne
    @JoinColumn(name = "cliente")
    private Client client;
    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", plate='" + plate + '\'' +
                ", model='" + model + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", client=" + client.getName() +
                '}';
    }
    public void setClient(Client client) {
        if (this.client != null) {
            this.client.getCars().remove(this);
        }
        this.client = client;
        if (client != null) {
            client.getCars().add(this);
        }
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }
}



