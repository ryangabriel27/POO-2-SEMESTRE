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
    }
}
