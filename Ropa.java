package modelo;

/**
 * Subclase Ropa
 * Representa productos de ropa y vestimenta en el inventario.
 */
public class Ropa extends Producto {

    private String talla;
    private String material;
    private String genero;
    private String color;

    public Ropa(String id, String nombre, double precio, int cantidad,
                String proveedor, String talla, String material, String genero, String color) {
        super(id, nombre, precio, cantidad, proveedor);
        this.talla = talla;
        this.material = material;
        this.genero = genero;
        this.color = color;
    }

    @Override
    public String getTipo() {
        return "Ropa";
    }

    @Override
    public double calcularImpuesto() {
        // La ropa tiene un impuesto del 10%
        return precio * 0.10;
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("  ┌─────────────────────────────────────────");
        System.out.println("  │ PRODUCTO ROPA");
        System.out.println("  │ ID        : " + id);
        System.out.println("  │ Nombre    : " + nombre);
        System.out.println("  │ Talla     : " + talla);
        System.out.println("  │ Material  : " + material);
        System.out.println("  │ Género    : " + genero);
        System.out.println("  │ Color     : " + color);
        System.out.println("  │ Precio    : $" + String.format("%.2f", precio));
        System.out.println("  │ Impuesto  : $" + String.format("%.2f", calcularImpuesto()) + " (10%)");
        System.out.println("  │ Precio c/imp: $" + String.format("%.2f", getPrecioConImpuesto()));
        System.out.println("  │ Stock     : " + cantidad + " unidades");
        System.out.println("  │ Proveedor : " + proveedor);
        System.out.println("  │ Disponible: " + (estaDisponible() ? "Sí" : "No"));
        System.out.println("  └─────────────────────────────────────────");
    }

    @Override
    public String generarReporte() {
        return String.format("ROPA | %s | Talla: %s | Material: %s | Color: %s | Precio: $%.2f | Stock: %d",
                nombre, talla, material, color, getPrecioConImpuesto(), cantidad);
    }
}
