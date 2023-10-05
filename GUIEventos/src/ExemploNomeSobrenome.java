import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExemploNomeSobrenome extends JFrame {
    // atributos
    private JTextField caixaNome;
    private JTextField caixaSobrenome;
    private JLabel texto;

    public ExemploNomeSobrenome() {
        super("Exemplo 1");
        // Exemplo nome e sobrenome

        // set do frame
        this.setDefaultCloseOperation(2);
        this.setBounds(100, 100, 300, 300);
        this.setVisible(true);

        JPanel mainP = new JPanel(new GridLayout(3, 2)); // painel principal
        this.add(mainP); // adicionando o painel principal ao frame

        // criar os componentes
        mainP.add(new JLabel("Nome:"));
        caixaNome = new JTextField();
        mainP.add(caixaNome);
        mainP.add(new JLabel("Sobrenome:"));
        caixaSobrenome = new JTextField();
        mainP.add(caixaSobrenome);
        JButton botao1 = new JButton("Concatenar", null);
        mainP.add(botao1);
        texto = new JLabel();
        mainP.add(texto);

        // tratamento de eventos (3 formas)

        // 1ª forma: e -> {evento} 'CallBack'
        // botao1.addActionListener(e -> {
        // texto.setText(caixaNome.getText()+" "+caixaSobrenome.getText());
        // caixaNome.setText("");
        // caixaSobrenome.setText("");
        // });

        // 2ª forma: 'new ActionListener' -> actionPerformed(ActionEvent)
        // botao1.addActionListener(new ActionListener() {
        // public void actionPerformed(ActionEvent e) {
        // texto.setText(caixaNome.getText() + " " + caixaSobrenome.getText());
        // caixaNome.setText("");
        // caixaSobrenome.setText("");
        // }
        // });

        // 3ª forma: Handler(manipulador)
        // Vou criar uma classe para tratar o evento-> chamar o listener
        Handler evt = new Handler();
        botao1.addActionListener(evt);
    }

    // Criar classe Handler
    public class Handler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            texto.setText(caixaNome.getText() + " " + caixaSobrenome.getText());
            caixaNome.setText("");
            caixaSobrenome.setText("");
        }
    }
}
