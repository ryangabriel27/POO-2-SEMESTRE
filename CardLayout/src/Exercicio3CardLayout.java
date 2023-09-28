    import java.awt.BorderLayout;
    import java.awt.CardLayout;
    import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

    import javax.swing.JButton;
    import javax.swing.JFrame;
    import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JLabel;

    public class Exercicio3CardLayout extends JFrame {

        String cardAtual;
        public Exercicio3CardLayout() {
            super("Exercicio 3");
            
            JPanel tudo = new JPanel(new FlowLayout(FlowLayout.CENTER));
            this.add(tudo);
            JPanel posicoes = new JPanel(new BorderLayout(0,5));
            tudo.add(posicoes);
            JPanel btts = new JPanel(new FlowLayout());
            posicoes.add(btts, BorderLayout.NORTH);
            JPanel mainP = new JPanel();
            mainP.setSize(500, 500);
            posicoes.add(mainP, BorderLayout.CENTER);

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
            mainP.add(home,"Tela Inicial");


            JPanel login = new JPanel(new BorderLayout(0,2));
            login.add(new JLabel("Login"),BorderLayout.NORTH);
            JPanel camposLogin = new JPanel(new GridLayout(2,2,1,2));
            camposLogin.add(new JLabel("Email:"));
            camposLogin.add(new JTextField());
            camposLogin.add(new JLabel("Senha:"));
            camposLogin.add(new JPasswordField());
            login.add(camposLogin, BorderLayout.CENTER);
            login.add(new JButton("Fazer Login"), BorderLayout.SOUTH);
            mainP.add(login,"Login");

            JPanel cadastro = new JPanel(new BorderLayout(0, 2));
            cadastro.add(new JLabel("Cadastro"),BorderLayout.NORTH);
            JPanel camposCadastro = new JPanel(new GridLayout(4,2,1,2));
            camposCadastro.add(new JLabel("Nome:"));
            camposCadastro.add(new JTextField());
            camposCadastro.add(new JLabel("Email:"));
            camposCadastro.add(new JTextField());
            camposCadastro.add(new JLabel("Senha:"));
            camposCadastro.add(new JPasswordField());
            camposCadastro.add(new JLabel("Confirmar Senha: "));
            camposCadastro.add(new JPasswordField());
            cadastro.add(camposCadastro, BorderLayout.CENTER);
            cadastro.add(new JButton("Cadastrar"), BorderLayout.SOUTH);
            mainP.add(cadastro,"Cadastro");

            bHome.setVisible(false);

            bHome.addActionListener(e -> {
                cl.show(mainP,"Tela Inicial");
                cardAtual = "Tela Inicial";
                if (cardAtual.equals("Tela Inicial")){
                    bHome.setVisible(false);
                    bHome.setEnabled(false);
                    bLogin.setVisible(true);
                    bLogin.setEnabled(true);
                    bCadastro.setVisible(true);
                    bCadastro.setEnabled(true);
                }
            });
            bLogin.addActionListener(e -> {
                cl.show(mainP, "Login");
                cardAtual = "Login";
                if (cardAtual.equals("Login")){
                    bLogin.setVisible(false);
                    bLogin.setEnabled(false);
                    bHome.setVisible(true);
                    bHome.setEnabled(true);
                    bCadastro.setVisible(true);
                    bCadastro.setEnabled(true);
                }
            });
            bCadastro.addActionListener(e -> {
                cl.show(mainP, "Cadastro");
                cardAtual = "Cadastro";
                if (cardAtual.equals("Cadastro")){
                    bCadastro.setVisible(false);
                    bCadastro.setEnabled(false);
                    bHome.setVisible(true);
                    bHome.setEnabled(true);
                    bLogin.setVisible(true);
                    bLogin.setEnabled(true);
                }
            });

            // set do frame
            this.setDefaultCloseOperation(2);
            this.setBounds(100, 100, 300, 300);
            this.setVisible(true);

        }
    }
