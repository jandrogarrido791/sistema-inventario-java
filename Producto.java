package modelo;

/**
 * Interfaz Inventariable
 * Define el comportamiento que deben tener todos los productos en el inventario.
 */
public interface Inventariable {

    void agregarAlInventario(int cantidad);

    void retirarDelInventario(int cantidad);

    boolean estaDisponible();

    String generarReporte();
}
