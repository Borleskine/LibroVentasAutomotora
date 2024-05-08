package vehiculos;

public class Vehiculo {
    private String color;
    private String patente;

    // Constructor con parámetros
    public Vehiculo(String color, String patente) {
        this.color = color;
        this.patente = patente;
    }

    // Getters y Setters
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }
}
