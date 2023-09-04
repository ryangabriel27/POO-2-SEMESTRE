import javax.swing.*;
import java.awt.*;

public class ExemploCalculadora extends JFrame{
    public ExemploCalculadora() {
        super("Calculadora");
        JPanel painel1 = new JPanel(new BorderLayout());
        this.add(painel1);
        JTextField visor = new JTextField(15);
        visor.setSize(15, 100);
        painel1.add(visor, BorderLayout.NORTH);
        JPanel numeros = new JPanel(new GridLayout(4,4));
        painel1.add(numeros, BorderLayout.CENTER);
        numeros.add(new JButton("7"));
        numeros.add(new JButton("8"));
        numeros.add(new JButton("9"));
        numeros.add(new JButton("X"));
        numeros.add(new JButton("4"));
        numeros.add(new JButton("5"));
        numeros.add(new JButton("6"));
        numeros.add(new JButton("+"));
        numeros.add(new JButton("1"));
        numeros.add(new JButton("2"));
        numeros.add(new JButton("3"));
        numeros.add(new JButton("-"));
        numeros.add(new JButton("/"));
        numeros.add(new JButton("0"));
        numeros.add(new JButton(","));
        numeros.add(new JButton("="));

        // set do pack
        this.pack();
        this.setDefaultCloseOperation(2);
        this.setVisible(true);
    }
}
