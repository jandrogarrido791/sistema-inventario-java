import modelo.*;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        Producto e1 = new Electronico(
                "E001", "Laptop", 10000, 5,
                "Dell", "Dell", 12, "110V"
        );

        Producto a1 = new Alimento(
                "A001", "Leche", 30, 20,
                "Lala", LocalDate.of(2026, 4, 10), true, "Lácteos"
        );

        Producto r1 = new Ropa(
                "R001", "Camisa", 300, 10,
                "Zara", "M", "Algodón", "Hombre", "Azul"
        );

        Producto[] inventario = {e1, a1, r1};

        System.out.println("=== SISTEMA DE INVENTARIO ===\n");

        for (Producto p : inventario) {
            p.mostrarDetalles();
            System.out.println("Reporte: " + p.generarReporte());
            System.out.println();
        }

        e1.retirarDelInventario(2);
        a1.agregarAlInventario(5);
    }
}
