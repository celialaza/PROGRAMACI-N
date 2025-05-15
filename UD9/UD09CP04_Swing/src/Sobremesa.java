public class Sobremesa extends Consola {
    private String resolucionMaxima;

    public Sobremesa(String nombre, String fabricante, String resolucionMaxima) {
        super(nombre, fabricante, "Sobremesa");
        this.resolucionMaxima = resolucionMaxima;
    }

    public String getResolucionMaxima() {
        return resolucionMaxima;
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("Consola de Sobremesa: " + nombre + ", Fabricante: " + fabricante + ", Resolución Máxima: " + resolucionMaxima);
    }

    @Override
    public String toString() {
        return "Nombre: " +nombre+
                "\nFabricante: " +fabricante+
                "\nResolución máxima: " +resolucionMaxima+
                "\nTipo de consola: Sobremesa \n";
    }
}