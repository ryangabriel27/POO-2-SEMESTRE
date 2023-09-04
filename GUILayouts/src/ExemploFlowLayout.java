import java.awt.*;
import javax.swing.*;

public class ExemploFlowLayout{    
    public ExemploFlowLayout() {
        JFrame janela = new JFrame("Janela Principal");
        // Mudar o layout 
        FlowLayout flow = new FlowLayout();
        janela.setLayout(flow);
        // adicionar
        janela.add(new JLabel("Informe o valor:"));
        JTextField input1 = new JTextField(25);
        janela.add(input1);
        JButton botao1 = new JButton("Enviar");
        janela.add(botao1);
        janela.pack();
        janela.setDefaultCloseOperation(2);
        janela.setVisible(true);
    }
}
