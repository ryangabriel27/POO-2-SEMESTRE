
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ContainersComponent extends JFrame {
    public ContainersComponent() {
        super("Janela Principal");
        // adicionar um outro container
        JPanel panel1 = new JPanel();
        this.getContentPane().add(panel1);
        // adicionar componentes ao painel
        panel1.add(new JLabel("Informe um nº:"));
        JTextField campo1 = new JTextField(25);
        panel1.add(campo1);
        JButton botao1 = new JButton("Enviar!!");
        botao1.addActionListener(e -> {
            int qntd = Integer.parseInt(campo1.getText());
            for (int i = 1; i < (qntd+1); i++) {
                panel1.add(new JButton(""+i));
            }
            this.pack();
        }
        );
        panel1.add(botao1);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }

}
