package cesur.examen.common;

import java.util.List;

/**
 * EXAMEN DE ACCESO A DATOS
 * Diciembre 2023
 *
 * Nombre del alumno: Pablo Robles Lorenzo
 * Fecha: 11/12/2023
 */
public interface DAO<T> {
    T save( T t);
    T update( T t);

    boolean remove(T t);

    T get( Long id);
    List<T> getAll();

}
