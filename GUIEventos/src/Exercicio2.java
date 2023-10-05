import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Exercicio2 extends JFrame {
    // atributos
    JTextField displayLetraDigitada;
    JTextArea displayTextoDigitado;
    JTextField caixaTexto;

    public Exercicio2() {
        super("Exercicio 2 - KeyEvent");

        // set do frame
        this.setVisible(true);
        this.setBounds(100, 100, 300, 300);
        this.setDefaultCloseOperation(2);

        JPanel mainP = new JPanel(new BorderLayout(0, 4));// painel principal
        this.add(mainP);

        JPanel topPanel = new JPanel(new GridLayout(1, 2, 0, 2));// parte de cima do painel principal
        topPanel.add(new JLabel("Letra digitada:"));
        displayLetraDigitada = new JTextField();// campo q a letra digitada irá aparecer
        displayLetraDigitada.setEditable(false);
        topPanel.add(displayLetraDigitada);
        mainP.add(topPanel, BorderLayout.NORTH);

        JPanel centerPanel = new JPanel(new GridLayout(2, 1, 0, 2));// parte central do painel principal
        centerPanel.add(new JLabel("Digite seu texto aqui:"));
        caixaTexto = new JTextField();// campo que o usuário digitará o texto
        centerPanel.add(caixaTexto);
        mainP.add(centerPanel, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel(new GridLayout(2, 1, 2, 2));// parte de baixo do painel principal
        displayTextoDigitado = new JTextArea(5, 10);// display para o texto q será digitado
        displayTextoDigitado.setSize(100, 50);
        displayTextoDigitado.setEditable(false);
        bottomPanel.add(displayTextoDigitado);
        JButton botaoApagar = new JButton("Limpar");
        bottomPanel.add(botaoApagar);
        mainP.add(bottomPanel, BorderLayout.SOUTH);

        botaoApagar.addActionListener(e -> {
            displayLetraDigitada.setText("");
            displayTextoDigitado.setText("");
            caixaTexto.setText("");
        });

        Handler evt = new Handler();
        caixaTexto.addKeyListener(evt);

    }

    // criar um Handler
    public class Handler implements KeyListener {

        @Override
        public void keyPressed(KeyEvent e) {
            char keyPressed = e.getKeyChar(); // peguei o valor da tecla pressionada
            displayLetraDigitada.setText("" + keyPressed);
        }

        @Override
        public void keyReleased(KeyEvent e) {
            // TODO Auto-generated method stub

        }

        @Override
        public void keyTyped(KeyEvent e) {

            displayTextoDigitado.setText(caixaTexto.getText());
        }

    }
}
