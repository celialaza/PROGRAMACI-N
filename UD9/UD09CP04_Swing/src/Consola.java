import java.util.Objects;

public abstract class Consola implements Mostrable {
    protected String nombre;
    protected String fabricante;
    private String tipoConsola;

    public Consola(String nombre, String fabricante, String tipoConsola) {
        this.nombre = nombre;
        this.fabricante = fabricante;
        this.tipoConsola = tipoConsola;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipoConsola() {
        return tipoConsola;
    }

}