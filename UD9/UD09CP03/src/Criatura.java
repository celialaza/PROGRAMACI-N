import java.util.Random;

public abstract class Criatura {
    private String nombre;
    private int fuerza;
    private int vidaActual;
    private int vidaMaxima;
    private Random rand = new Random();

    public Criatura(String nombre, int fuerza, int vida) {
        this.nombre = nombre;
        this.fuerza = fuerza;
        this.vidaActual = vida;
        this.vidaMaxima = vida;
    }

    public int getFuerza() {
        return fuerza;
    }

    public int getVidaActual() {
        return vidaActual;
    }

    public void setVidaActual(int vidaActual) {
        this.vidaActual = vidaActual;
    }

    @Override
    public String toString() {
        return "Criatura{" +
                "nombre='" + nombre + '\'' +
                ", fuerza=" + fuerza +
                ", vidaActual=" + vidaActual +
                ", vidaMaxima=" + vidaMaxima +
                '}';
    }

    public void luchar(Criatura c) throws InterruptedException {

        while (this.vidaActual>=0 && c.vidaActual>=0){
            Thread.sleep(rand.nextInt(1000));
            this.vidaActual-=c.getFuerza();
            System.out.println(c.nombre+" pega a "+this.nombre);
            System.out.println("Vida actual the "+this.nombre+" : "+this.vidaActual);
            if (this.vidaActual>=0){
                Thread.sleep(rand.nextInt(1000));
                c.vidaActual-=this.getFuerza();
                System.out.println(this.nombre+" pega a "+c.nombre);
                System.out.println("Vida actual the "+c.nombre+" : "+c.vidaActual);

            }
            if (this.vidaActual>=0 && c.vidaActual>=0){
                int probabilidad = rand.nextInt(100);
                if (probabilidad<=5){
                    if (probabilidad%2==0) {
                        this.descansar();
                        System.out.println(this.nombre+" ha descansado. Vida actual: "+this.vidaActual);
                    }else {
                        c.descansar();
                        System.out.println(c.nombre+" ha descansado. Vida actual: "+c.vidaActual);
                    }
                }
                if (probabilidad<=15){
                    if (probabilidad%2==0) {
                        this.recuperar();
                        System.out.println(this.nombre + " ha recuperado. Vida actual: " + this.vidaActual);
                    }else {
                        c.recuperar();
                        System.out.println(c.nombre+" ha recuperado. Vida actual: "+this.vidaActual);

                    }
                }
            }
        }
    }

    private void recuperar(){
        int cantidad = rand.nextInt(this.vidaMaxima)+1;
        this.vidaActual+=cantidad;
        if (this.vidaActual>this.vidaMaxima)
            this.vidaActual=this.vidaMaxima;
    }

    public void descansar(){
        this.vidaActual=this.vidaMaxima;
    }
}
