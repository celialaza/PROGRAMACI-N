public class Portatil extends Consola {
    private String duracionBateria;

    public Portatil(String nombre, String fabricante, String duracionBateria) {
        super(nombre, fabricante, "Portátil");
        this.duracionBateria = duracionBateria;
    }

    public String getDuracionBateria() {
        return duracionBateria;
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("Consola Portátil: " + nombre + ", Fabricante: " + fabricante + ", Duración de Batería: " + duracionBateria + " horas");
    }

    @Override
    public String toString() {
        return "Nombre: " +nombre+
                "\nFabricante: " +fabricante+
                "\nDuración de la batería: " +duracionBateria+
                " horas\nTipo de consola: Portátil\n";
    }
}

