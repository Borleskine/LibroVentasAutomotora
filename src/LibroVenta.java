import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import vehiculos.Cliente;
import vehiculos.Vehiculo;

public class LibroVenta {
    private String nombreVenta;
    private String fechaVenta; // Formato "01102020"

    // Constructor con parámetros
    public LibroVenta(String nombreVenta, String fechaVenta) {
        this.nombreVenta = nombreVenta;
        this.fechaVenta = fechaVenta;
    }

    // Getters y Setters
    public String getNombreVenta() {
        return nombreVenta;
    }

    public void setNombreVenta(String nombreVenta) {
        this.nombreVenta = nombreVenta;
    }

    public String getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(String fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    // Operación guardarVenta
    public void guardarVenta(Cliente cliente, Vehiculo vehiculo) {
        String directorio = "ficheros/";
        File directorioArchivo = new File(directorio);

        // Crear el directorio "ficheros" si no existe
        if (!directorioArchivo.exists()) {
            directorioArchivo.mkdir();
        }

        // El archivo debe llamarse según el atributo "nombreVenta" y tener extensión ".txt"
        String nombreArchivo = directorio + nombreVenta + ".txt";

        try (FileWriter writer = new FileWriter(nombreArchivo)) {
            // Guardar la información en el archivo
            writer.write("Patente del vehículo: " + vehiculo.getPatente() + "\n");
            writer.write("Edad del cliente: " + cliente.getEdad() + "\n");
            writer.write("Fecha de la venta: " + fechaVenta + "\n");
            writer.write("Nombre de venta: " + nombreVenta + "\n");
        } catch (IOException e) {
            System.out.println("Error al guardar la venta: " + e.getMessage());
        }
    }

    // Prueba de la clase
    public static void main(String[] args) {
        // Ejemplo de uso
        Cliente cliente = new Cliente("12345678-9", "Juan Pérez", 35);
        Vehiculo vehiculo = new Vehiculo("AB123CD", "Rojo");

        LibroVenta libroVenta = new LibroVenta("Venta001", "01102020");
        libroVenta.guardarVenta(cliente, vehiculo);

        System.out.println("Venta guardada exitosamente.");
    }
}
