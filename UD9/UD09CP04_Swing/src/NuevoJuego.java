import javax.swing.*;
import java.io.*;

public class NuevoJuego extends JFrame{
    private JPanel panelNuevoJuego;
    private JTextField tfTitulo;
    private JTextField tfGenero;
    private JComboBox<String> cbConsola;
    private JButton btnAgregarJuego;
    private JButton btnCancelar;
    private Videojuego[] listaVideojuegos;
    private Consola[] listaConsolas;
    private int numJuegos=0;
    private int numConsolas=0;

    public NuevoJuego(Videojuego[] listaVideojuegos, Consola[] listaConsolas, int numJuegos, int numConsolas) {
        setTitle("Nuevo Juego");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(450, 250);
        setLocationRelativeTo(null);
        setContentPane(panelNuevoJuego);
        this.listaVideojuegos = listaVideojuegos;
        this.numJuegos = numJuegos;
        this.listaConsolas = listaConsolas;
        this.numConsolas = numConsolas;
        cbConsola.addItem("Seleccione una consola");
        for (int i = 0; i < numConsolas; i++) {
            cbConsola.addItem(listaConsolas[i].getNombre());
        }
        btnAgregarJuego.addActionListener(e -> {
            agregarJuego();
        });
        btnCancelar.addActionListener(e -> {
            dispose();
        });
    }

    private void guardarJuego() {
        PrintWriter pw = null;
        try{
            pw = new PrintWriter(new FileWriter("./archivos/videojuegos.csv",true));
            pw.println(listaVideojuegos[numJuegos-1].getTitulo()+","+listaVideojuegos[numJuegos-1].getGenero()+","+listaVideojuegos[numJuegos-1].getConsola());
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(panelNuevoJuego, "El archivo de juegos no existe");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(panelNuevoJuego,"Error de lectura del archivo");
        } finally {
            if (pw != null)
                pw.close();
        }
        JOptionPane.showMessageDialog(panelNuevoJuego, "El juego se ha agregado correctamente");
        dispose();
    }

    private void agregarJuego() {
        if (tfTitulo.getText().isEmpty() || tfGenero.getText().isEmpty() || cbConsola.getSelectedItem().toString().equals("Seleccione una consola" )) {
            JOptionPane.showMessageDialog(panelNuevoJuego, "Debe rellenar todos los datos");
        } else {
            Videojuego juego = new Videojuego(tfTitulo.getText(), tfGenero.getText(), cbConsola.getSelectedItem().toString());
            insertaJuego(juego);
        }
    }


    private void insertaJuego(Videojuego juego) {
        int i=0;
        boolean encontrado=false;
        while(i<numJuegos && !encontrado){
            if(listaVideojuegos[i].equals(juego)){
                encontrado=true;
            } else {
                i++;
            }
        }
        if(!encontrado){
            listaVideojuegos[numJuegos]=juego;
            numJuegos++;
            guardarJuego();
        }
    }
}
