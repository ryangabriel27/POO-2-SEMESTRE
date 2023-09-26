import javax.smartcardio.Card;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.CardLayout;
import java.util.logging.Handler;


public class ExemploCardLayout extends JFrame {

    public ExemploCardLayout() {
        super();

        CardLayout cl = new CardLayout();

        JPanel painel1 = new JPanel(); // Criando um painel

        // Criando um comboBox
        String comboBoxItens[] = { "Card1", "Card2" };
        JComboBox cb = new JComboBox(comboBoxItens);

        painel1.add(cb); // Adicionando a comboBox ao painel1

        // Criando cards
        JPanel card1 = new JPanel();
        card1.add(new JButton("Botão 1"));
        card1.add(new JButton("Botão 2"));
        card1.add(new JButton("Botão 3"));
        JPanel card2 = new JPanel();
        card2.add(new JTextField("TextField", 20));

        JPanel cards = new JPanel(cl); // Painel q vai conter os cards

        // Adicionando os cards ao painel cards
        cards.add(card1, "Card1");
        cards.add(card2, "Card2");

        this.add(painel1);
        painel1.add(cards);

        // Set do frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(100, 100, 300, 300);
        this.setVisible(true);


        // Adicionando um ItemListener 
        cb.addItemListener(e -> {
            cards.getLayout();
            cl.show(cards, (String) e.getItem());
        });

    }
}