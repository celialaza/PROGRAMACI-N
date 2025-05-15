import javax.swing.*;
import java.io.*;

public class NuevaConsola extends JFrame {
    private JPanel panelNuevaConsola;
    private JTextField tfNombre;
    private JComboBox<String> cbTipoConsola;
    private JTextField tfDatoAdicional;
    private JTextField tfFabricante;
    private JLabel lblDatoAdicional;
    private JButton btnAgregarConsola;
    private JButton btnCancelarConsola;
    private Consola[] listaConsolas;
    private int numConsolas;

    public NuevaConsola(Consola[] listaConsolas, int numConsolas) {
        setTitle("Nueva Consola");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(450, 300);
        setLocationRelativeTo(null);
        cbTipoConsola.addItem("-- Seleccione el tipo de consola --");
        cbTipoConsola.addItem("Sobremesa");
        cbTipoConsola.addItem("Portátil");
        lblDatoAdicional.setVisible(false);
        tfDatoAdicional.setVisible(false);
        setContentPane(panelNuevaConsola);
        this.listaConsolas = listaConsolas;
        this.numConsolas = numConsolas;
        btnAgregarConsola.addActionListener(e -> {
            agregarConsola();
        });
        cbTipoConsola.addActionListener(e -> {
            if (cbTipoConsola.getSelectedItem().equals("Sobremesa")) {
                lblDatoAdicional.setText("Resolución: ");
                lblDatoAdicional.setVisible(true);
                tfDatoAdicional.setVisible(true);
            }else if (cbTipoConsola.getSelectedItem().equals("Portátil")) {
                lblDatoAdicional.setText("Duración de la batería: ");
                lblDatoAdicional.setVisible(true);
                tfDatoAdicional.setVisible(true);
            }else if (cbTipoConsola.getSelectedItem().equals("-- Seleccione el tipo de consola --")){
                lblDatoAdicional.setVisible(false);
                tfDatoAdicional.setVisible(false);
            }

        });
        btnCancelarConsola.addActionListener(e -> dispose());
    }

    private void agregarConsola() {
        if (tfNombre.getText().isEmpty() || tfFabricante.getText().isEmpty() || tfDatoAdicional.getText().isEmpty()) {
            JOptionPane.showMessageDialog(panelNuevaConsola, "Debe rellenar todos los datos");
        } else if (!existeConsola(tfNombre.getText())) {
            PrintWriter pw = null;
            try {
                pw = new PrintWriter(new FileWriter("./archivos/consolas.csv",true));
                pw.println(tfNombre.getText() + "," + tfFabricante.getText() + "," + tfDatoAdicional.getText() + "," + cbTipoConsola.getSelectedItem());
            } catch (FileNotFoundException e) {
                JOptionPane.showMessageDialog(panelNuevaConsola, "El archivo de consolas no existe");
            } catch (IOException e) {
                JOptionPane.showMessageDialog(panelNuevaConsola,"Error de lectura del archivo");
            } finally {
                if (pw != null)
                    pw.close();
            }
            JOptionPane.showMessageDialog(panelNuevaConsola, "La consola se ha agregado correctamente");
        } else {
            JOptionPane.showMessageDialog(panelNuevaConsola, "La consola ya existe");
        }
        dispose();
    }

    private boolean existeConsola(String nombre) {
        BufferedReader br = null;
        boolean existe = false;
        int indice=0;
        while (indice<numConsolas && !existe) {
            if (nombre.equals(listaConsolas[indice].getNombre())) {
                existe = true;
            } else {
                indice++;
            }
        }
        return existe;
    }
}
