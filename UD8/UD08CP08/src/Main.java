import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
           Editor editor = new Editor();
           editor.setVisible(true);
        });
    }
}
