public class DiametroSuperiorException extends Exception {
    public DiametroSuperiorException(String mensaje) {
        super("Diametro superior a 100: " + mensaje);
    }
}
