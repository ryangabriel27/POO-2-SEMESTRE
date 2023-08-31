import javax.swing.JFrame;

public class JFrameExemplo extends JFrame{
    public JFrameExemplo() {
        super("Minha primeira janela JFrame GUISwing");

        this.setSize(500, 500);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
