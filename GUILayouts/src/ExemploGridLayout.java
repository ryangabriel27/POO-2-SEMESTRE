import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.GridLayout;

public class ExemploGridLayout extends JFrame{
    public ExemploGridLayout() {
        super("Janela principal");
        JPanel painel1 = new JPanel();
        this.add(painel1);
        // Mudar o layout do JPanel ( Flow => Grid)
        GridLayout grid1 = new GridLayout(3,3);
        painel1.setLayout(grid1);
        // adicionar componentes ao layout
        for (int i = 0; i < 9; i++) {
            painel1.add(new JButton(""+(i+1)));
        }
        // set do frame
        this.pack();
        this.setDefaultCloseOperation(2);
        this.setVisible(true);


    }
}
