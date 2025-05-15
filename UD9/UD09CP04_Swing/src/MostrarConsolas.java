import javax.swing.*;
import java.util.Objects;

public class MostrarConsolas extends JFrame {
    private final Consola[] listaConsolas;
    private final int numConsolas;
    private JPanel panelMostrarConsolas;
    private JTextArea areaTexto;
    private JComboBox<String> cbTipoConsola;

    public MostrarConsolas(Consola[] listaConsolas, int numConsolas) {
        setTitle("Consolas");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400,300);
        setLocationRelativeTo(null);
        setContentPane(panelMostrarConsolas);
        this.listaConsolas = listaConsolas;
        this.numConsolas = numConsolas;
        cbTipoConsola.addItem("Todas");
        cbTipoConsola.addItem("Sobremesa");
        cbTipoConsola.addItem("Portátil");
        filtrarConsolas();
        cbTipoConsola.addActionListener(_ -> filtrarConsolas());
    }

    private void filtrarConsolas() {
        StringBuilder texto = new StringBuilder();
        for (int i = 0; i < numConsolas; i++) {
            if (Objects.equals(cbTipoConsola.getSelectedItem(), "Todas"))
                texto.append(listaConsolas[i]).append("\n");
            else if (Objects.requireNonNull(cbTipoConsola.getSelectedItem()).toString().equals(listaConsolas[i].getTipoConsola()))
                texto.append(listaConsolas[i]).append("\n");
        }
        areaTexto.setText(texto.toString());
    }

}
