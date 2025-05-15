public class Videojuego implements Mostrable {
    private String titulo;
    private String genero;
    private String consola;

    public Videojuego(String titulo, String genero, String consola) {
        this.titulo = titulo;
        this.genero = genero;
        this.consola = consola;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getGenero() {
        return genero;
    }

    public String getConsola() {
        return consola;
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("Título: " + titulo + "\nGénero: " + genero + "\nConsola: " + consola);
    }

    @Override
    public String toString() {
        return "Título: " + titulo + "\nGénero: " + genero + "\nConsola: " + consola+"\n";
    }

    @Override
    public boolean equals(Object obj) {
        boolean resultado;
        Videojuego that;
        if (this == obj)
            resultado= true;
        else if (obj == null || getClass() != obj.getClass()) resultado = false;
        else {
            that = (Videojuego) obj;
            resultado = titulo.equalsIgnoreCase(that.titulo) && consola.equalsIgnoreCase(that.consola);
        }
        return resultado;
    }

}
