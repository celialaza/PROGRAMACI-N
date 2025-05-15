import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Menu extends JFrame {
    private JPanel panel1;
    private JButton btnAgregarConsola;
    private JButton btnAgregarJuego;
    private JButton btnMostrarConsolas;
    private JButton btnMostrarJuegos;
    private JButton btnSalir;
    private Consola[] listaConsolas;
    private int numConsolas=0;
    private Videojuego[] listaVideojuegos;
    private int numJuegos=0;

    public Menu() {
        setTitle("Gestión de Consolas y Videojuegos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 250);
        setLocationRelativeTo(null);
        setContentPane(panel1);
        listaConsolas = new Consola[10];
        cargarConsolas();
        listaVideojuegos = new Videojuego[100];
        cargarJuegos();
        btnAgregarConsola.addActionListener(e -> {
            agregarConsola();
        });
        btnMostrarConsolas.addActionListener(e -> {
            mostrarConsolas();
        });
        btnSalir.addActionListener(e -> {
            JOptionPane.showMessageDialog(panel1,"Gracias por utilizar el gestor de consolas y videojuegos. Hasta pronto!");
            System.exit(0);
        });
        btnMostrarJuegos.addActionListener(e -> {
            mostrarJuegos();
        });
        btnAgregarJuego.addActionListener(e -> {
            nuevoJuego();
        });
    }

    private void nuevoJuego() {
        NuevoJuego nuevoJuego = new NuevoJuego(listaVideojuegos,listaConsolas,numJuegos,numConsolas);
        nuevoJuego.setVisible(true);
    }

    private void mostrarJuegos() {
        listaConsolas = new Consola[10];
        cargarConsolas();
        listaVideojuegos = new Videojuego[100];
        cargarJuegos();
        MostrarJuegos mostrarJuegos = new MostrarJuegos(listaVideojuegos,listaConsolas,numJuegos,numConsolas);
        mostrarJuegos.setVisible(true);
    }

    private void agregarConsola() {
        NuevaConsola nuevaConsola = new NuevaConsola(listaConsolas,numConsolas);
        nuevaConsola.setVisible(true);
    }

    private void mostrarConsolas() {
        listaConsolas = new Consola[10];
        cargarConsolas();
        MostrarConsolas mostrarConsolas = new MostrarConsolas(listaConsolas,numConsolas);
        mostrarConsolas.setVisible(true);
    }

    private void cargarConsolas() {
        numConsolas=0;
        BufferedReader br = null;
        try{
            br = new BufferedReader(new FileReader("./archivos/consolas.csv"));
            String linea = br.readLine();
            while (linea != null) {
                String[] datos = linea.split(",");
                if (datos[3].equals("Sobremesa")) {
                    Sobremesa sobremesa = new Sobremesa(datos[0], datos[1], datos[2]);
                    listaConsolas[numConsolas] = sobremesa;
                    numConsolas++;
                } else if (datos[3].equals("Portátil")) {
                    Portatil portatil = new Portatil(datos[0], datos[1], datos[2]);
                    listaConsolas[numConsolas] = portatil;
                    numConsolas++;
                }
                linea = br.readLine();
            }
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(panel1,"El archivo de consolas no existe");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(panel1,"Error de lectura del archivo");
        } finally {
            try{
                if (br!=null)
                    br.close();
            } catch (IOException e) {
                JOptionPane.showMessageDialog(panel1,"Error al cerrar el archivo");
            }
        }
    }

    private void cargarJuegos() {
        numJuegos=0;
        BufferedReader br = null;
        try{
            br = new BufferedReader(new FileReader("./archivos/videojuegos.csv"));
            String linea = br.readLine();
            while(linea!=null){
                String[] datos = linea.split(",");
                listaVideojuegos[numJuegos] = new Videojuego(datos[0],datos[1],datos[2]);
                numJuegos++;
                linea = br.readLine();
            }
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(panel1,"El archivo de consolas no existe");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(panel1,"Error de lectura del archivo");
        } finally {
            try{
                if (br!=null)
                    br.close();
            } catch (IOException e) {
                JOptionPane.showMessageDialog(panel1,"Error al cerrar el archivo");
            }
        }
    }

}
