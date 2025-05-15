import javax.swing.*;
import java.util.Objects;

public class MostrarJuegos extends JFrame {

    private final Videojuego[] listaVideojuegos;
    private final int numJuegos;
    private JPanel panelJuegos;
    private JComboBox<String> cbConsola;
    private JTextArea areaTexto;

    public MostrarJuegos(Videojuego[] listaVideojuegos, Consola[] listaConsolas, int numJuegos, int numConsolas) {
        setTitle("Vídeojuegos");
        setSize(400,300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setContentPane(panelJuegos);
        this.listaVideojuegos = listaVideojuegos;
        this.numJuegos = numJuegos;
        cbConsola.addItem("Todas");
        filtrarJuegos();
        for (int i = 0; i < numConsolas; i++) {
            cbConsola.addItem(listaConsolas[i].getNombre());
        }
        cbConsola.addActionListener(_ -> filtrarJuegos());
    }

    private void filtrarJuegos() {
        StringBuilder texto = new StringBuilder();
        String seleccionada = cbConsola.getSelectedItem().toString().trim();
        String consola="";
        for (int i = 0; i < numJuegos; i++) {
            consola=listaVideojuegos[i].getConsola().trim();
            if (seleccionada.equals("Todas")) {
                texto.append(listaVideojuegos[i]).append("\n");
            } else if (seleccionada.equals(consola)) {
                texto.append(listaVideojuegos[i]).append("\n");
            }
        }
        areaTexto.setText(texto.toString());
    }

}
