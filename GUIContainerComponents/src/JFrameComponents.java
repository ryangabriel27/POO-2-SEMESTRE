import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.FlowLayout;

public class JFrameComponents extends JFrame{
    public JFrameComponents() {
        super("Janela Principal");
        this.setBounds(500, 250, 500,500);
        // Modifiquei o layout do frame
        FlowLayout flow = new FlowLayout();
        this.setLayout(flow);
        // Adicionar os componentes
        for (int i = 1; i < 7; i++) {
            this.add(new JButton(""+i));
        }
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

}
