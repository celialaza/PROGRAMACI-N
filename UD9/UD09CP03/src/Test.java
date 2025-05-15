public class Test {
    public static void main(String[] args) throws InterruptedException {
        Elfo el = new Elfo("Pepito");
        Enano en = new Enano("Juanito");
        Trol tr = new Trol("Jorgito");
        System.out.println("¡¡¡GRAN COMBATE!!!");
        System.out.println("==================");
        el.luchar(tr);
        System.out.println("¡¡¡GRAN COMBATE!!!");
        System.out.println("==================");
        if (el.getVidaActual()>=0) {
            el.descansar();
            el.luchar(en);
        } else {
            tr.descansar();
            tr.luchar(en);
        }
    }
}
