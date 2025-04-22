package examen;

import javax.swing.*;
import java.io.*;

public class Lector extends JFrame {
    private JPanel panelizq;
    private JPanel paneldrch;
    private JLabel lblPrecio;
    private JLabel lblCaro;
    private JTextArea areaTexto;
    private JButton btnCargar;
    private JLabel lblCateogoria;
    private JComboBox cbCategoria;
    private JPanel panel1;
    private Producto[] productos;
    private int numProductos;
    private double precioMedio;
    private double productoCaro;


    public Lector() {
        setTitle("Lector de productos -txt");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(450, 500);
        setLocationRelativeTo(null);
        setContentPane(panel1);
        productos = new Producto[30];
        numProductos = 0;
        cbCategoria.addItem("Todas");
        cbCategoria.addItem("alimento");
        cbCategoria.addItem("tecnología");

        btnCargar.addActionListener(e -> {
            cargarProductos();

        });
        cbCategoria.addActionListener(e -> {
            filtrarProductos();

        });
    }
    private void filtrarProductos(){
        StringBuilder texto =new StringBuilder();
        areaTexto.setText("");
        for(int i=0; i< numProductos; i++){
            if(cbCategoria.getSelectedItem().equals("Todas")){
                texto.append(productos[i].toString()).append("\n");
            }else{
                if(cbCategoria.getSelectedItem().equals(productos[i].getCategoria())){
                    texto.append(productos[i].toString()).append("\n");
                }

            }
            areaTexto.setText(texto.toString());

        }

    }

    private void cargarProductos() {
        File archivo = new File("productos.txt");
        if (archivo.exists()) {
            BufferedReader br = null;
            try {
                br = new BufferedReader(new FileReader(archivo));
                String linea = br.readLine();
                StringBuilder resultado = new StringBuilder();
                while (linea != null) {
                    String[] datos = linea.split(",");
                    Producto producto = new Producto(datos[0], datos[1], datos[2]);
                    productos[numProductos] = producto;
                    numProductos++;
                    resultado.append(producto).append("\n");
                    linea = br.readLine();
                }
                areaTexto.setText(resultado.toString());

            } catch (FileNotFoundException e) {
                JOptionPane.showMessageDialog(panel1, "No se encuentra el archivo");
            } catch (IOException e) {
                JOptionPane.showMessageDialog(panel1, "Error al leer del archivo");
            } finally {
                try {
                    if (br != null) {
                        br.close();
                    }
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(panel1, "Error al cerrar el archivo");
                }
            }

        } else
            JOptionPane.showMessageDialog(panel1, "Archivo de contactos no encontrado");

    }

}