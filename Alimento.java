package modelo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Subclase Alimento
 * Representa productos alimenticios en el inventario.
 */
public class Alimento extends Producto {

    private LocalDate fechaCaducidad;
    private boolean esRefrigerado;
    private String categoria;

    public Alimento(String id, String nombre, double precio, int cantidad,
                    String proveedor, LocalDate fechaCaducidad, boolean esRefrigerado, String categoria) {
        super(id, nombre, precio, cantidad, proveedor);
        this.fechaCaducidad = fechaCaducidad;
        this.esRefrigerado = esRefrigerado;
        this.categoria = categoria;
    }

    @Override
    public String getTipo() {
        return "Alimento";
    }

    @Override
    public double calcularImpuesto() {
        // Los alimentos básicos tienen impuesto del 0%, procesados del 8%
        return esRefrigerado ? precio * 0.08 : 0.0;
    }

    public boolean estaCaducado() {
        return LocalDate.now().isAfter(fechaCaducidad);
    }

    @Override
    public boolean estaDisponible() {
        return cantidad > 0 && !estaCaducado();
    }

    @Override
    public void mostrarDetalles() {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println("  ┌─────────────────────────────────────────");
        System.out.println("  │ PRODUCTO ALIMENTO");
        System.out.println("  │ ID         : " + id);
        System.out.println("  │ Nombre     : " + nombre);
        System.out.println("  │ Categoría  : " + categoria);
        System.out.println("  │ Caducidad  : " + fechaCaducidad.format(fmt));
        System.out.println("  │ Refrigerado: " + (esRefrigerado ? "Sí" : "No"));
        System.out.println("  │ Caducado   : " + (estaCaducado() ? "SÍ ⚠" : "No"));
        System.out.println("  │ Precio     : $" + String.format("%.2f", precio));
        System.out.println("  │ Impuesto   : $" + String.format("%.2f", calcularImpuesto()));
        System.out.println("  │ Precio c/imp: $" + String.format("%.2f", getPrecioConImpuesto()));
        System.out.println("  │ Stock      : " + cantidad + " unidades");
        System.out.println("  │ Proveedor  : " + proveedor);
        System.out.println("  │ Disponible : " + (estaDisponible() ? "Sí" : "No"));
        System.out.println("  └─────────────────────────────────────────");
    }

    @Override
    public String generarReporte() {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return String.format("ALIMENTO | %s | Caduca: %s | Refrigerado: %s | Precio: $%.2f | Stock: %d",
                nombre, fechaCaducidad.format(fmt), esRefrigerado ? "Sí" : "No",
                getPrecioConImpuesto(), cantidad);
    }
}
