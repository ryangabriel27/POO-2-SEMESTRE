import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.awt.CardLayout;

public class Exercicio1CardLayout extends JFrame {

    public Exercicio1CardLayout() {
        super("Exercicio 1");
        //criei um painel principal
        JPanel mainP = new JPanel();
        //setLayout - cardLayout
        CardLayout cl = new CardLayout();
        mainP.setLayout(cl);
        JButton bNext1 = new JButton(">");
        JButton bNext2 = new JButton(">");
        JButton bNext3 = new JButton(">");
        JButton bBack1 = new JButton("<");
        JButton bBack2 = new JButton("<");
        JButton bBack3 = new JButton("<");
        //criar Cards para adicionar ao mainP
        JPanel card1 = new JPanel(new FlowLayout());
        card1.add(new JLabel("Card 1"));
        card1.add(bNext1);
        card1.add(bBack1, FlowLayout.LEFT);
        JPanel card2 = new JPanel(new FlowLayout());
        card2.add(new JLabel("Card 2"));
        card2.add(bNext2);
        card2.add(bBack2, FlowLayout.LEFT);
        JPanel card3 = new JPanel(new FlowLayout());
        card3.add(new JLabel("Card 3"));
        card3.add(bNext3);
        card3.add(bBack3, FlowLayout.LEFT);
        //add cards ao mainP
        mainP.add(card1);
        mainP.add(card2);
        mainP.add(card3);
        //set do Frame
        this.add(mainP);
        this.setDefaultCloseOperation(2);
        this.setBounds(100, 100, 300, 300);
        this.setVisible(true);
        //criar ActionListener para o botão
        bNext1.addActionListener(e->{
            cl.next(mainP);
        });
        bNext2.addActionListener(e->{
            cl.next(mainP);
        });
        bNext3.addActionListener(e->{
            cl.next(mainP);
        });
        bBack1.addActionListener(e -> {
            cl.previous(mainP);
        });
        bBack2.addActionListener(e -> {
            cl.previous(mainP);
        });
        bBack3.addActionListener(e -> {
            cl.previous(mainP);
        });

    }
}
