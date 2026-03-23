package modelo;

/**
 * Subclase Electronico
 * Representa productos electrónicos en el inventario.
 */
public class Electronico extends Producto {

    private String marca;
    private int garantiaMeses;
    private String voltaje;

    public Electronico(String id, String nombre, double precio, int cantidad,
                       String proveedor, String marca, int garantiaMeses, String voltaje) {
        super(id, nombre, precio, cantidad, proveedor);
        this.marca = marca;
        this.garantiaMeses = garantiaMeses;
        this.voltaje = voltaje;
    }

    @Override
    public String getTipo() {
        return "Electrónico";
    }

    @Override
    public double calcularImpuesto() {
        // Los electrónicos tienen un impuesto del 16%
        return precio * 0.16;
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("  ┌─────────────────────────────────────────");
        System.out.println("  │ PRODUCTO ELECTRÓNICO");
        System.out.println("  │ ID        : " + id);
        System.out.println("  │ Nombre    : " + nombre);
        System.out.println("  │ Marca     : " + marca);
        System.out.println("  │ Voltaje   : " + voltaje);
        System.out.println("  │ Garantía  : " + garantiaMeses + " meses");
        System.out.println("  │ Precio    : $" + String.format("%.2f", precio));
        System.out.println("  │ Impuesto  : $" + String.format("%.2f", calcularImpuesto()) + " (16%)");
        System.out.println("  │ Precio c/imp: $" + String.format("%.2f", getPrecioConImpuesto()));
        System.out.println("  │ Stock     : " + cantidad + " unidades");
        System.out.println("  │ Proveedor : " + proveedor);
        System.out.println("  │ Disponible: " + (estaDisponible() ? "Sí" : "No"));
        System.out.println("  └─────────────────────────────────────────");
    }

    @Override
    public String generarReporte() {
        return String.format("ELECTRÓNICO | %s | Marca: %s | Garantía: %d meses | Precio: $%.2f | Stock: %d",
                nombre, marca, garantiaMeses, getPrecioConImpuesto(), cantidad);
    }
}
