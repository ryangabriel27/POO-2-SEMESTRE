import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;

public class Exercicio3CardLayout extends JFrame {
    public Exercicio3CardLayout() {
        super("Exercicio 3");
        
        JPanel tudo = new JPanel(new BorderLayout());
        this.add(tudo);
        JPanel btts = new JPanel(new FlowLayout());
        tudo.add(btts, BorderLayout.NORTH);
        JPanel mainP = new JPanel();
        tudo.add(mainP, BorderLayout.CENTER);

        CardLayout cl = new CardLayout();
        mainP.setLayout(cl);

        JButton bHome = new JButton("Tela Inicial");
        JButton bLogin = new JButton("Login");
        JButton bCadastro = new JButton("Cadastro");
        btts.add(bHome);
        btts.add(bLogin);
        btts.add(bCadastro);

        JPanel home = new JPanel();
        home.add(new JLabel("Home"));
        mainP.add(home);

        JPanel login = new JPanel();
        login.add(new JLabel("Login"));
        mainP.add(login);

        JPanel cadastro = new JPanel();
        cadastro.add(new JLabel("Cadastro"));
        mainP.add(cadastro);


        bHome.addActionListener(e -> {
            cl.show(home, "Home");
        });
        bLogin.addActionListener(e -> {
            cl.show(login, "Login");
        });
        bCadastro.addActionListener(e -> {
            cl.show(cadastro, "Cadastro");
        });

        // set do frame
        this.setDefaultCloseOperation(2);
        this.setBounds(100, 100, 300, 300);
        this.setVisible(true);

    }
}
