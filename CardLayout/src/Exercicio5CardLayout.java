import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Exercicio5CardLayout extends JFrame {

    int contAcertos = 0;
    int contErros = 0;

    public Exercicio5CardLayout() {
        super();
        // Jogo QUIZ
        // 1 tela inicial para começar o jogo
        // 1 tela com um painel com a pergunta ; 1 TextField , para a resposta ; e 1
        // JButton para avancar e verificar se a resposta está correta

        CardLayout cl = new CardLayout();

        JPanel tudo = new JPanel();
        this.add(tudo);

        JPanel mainP = new JPanel();
        mainP.setSize(200, 200);
        mainP.setLayout(cl);
        tudo.add(mainP);

        // Criando cards (Tela inicial, 5 perguntas e pontuação)

        JPanel home = new JPanel(new BorderLayout()); // -- Home
        JButton bStart = new JButton("Iniciar");
        home.add(bStart, BorderLayout.CENTER);
        mainP.add(home, "Home");

        JPanel pergunta1 = new JPanel(new BorderLayout());// -- Primeira pergunta
        pergunta1.add(new JLabel("Qual o maior time do Brasil?"), BorderLayout.NORTH);
        JTextField resposta1 = new JTextField();
        pergunta1.add(resposta1, BorderLayout.CENTER);
        JButton enviar1 = new JButton("Responder");
        pergunta1.add(enviar1, BorderLayout.SOUTH);
        mainP.add(pergunta1, "Primeira");

        JPanel pergunta2 = new JPanel(new BorderLayout());// -- Segunda pergunta
        pergunta2.add(new JLabel("Quem descobriu o Brasil?"), BorderLayout.NORTH);
        JTextField resposta2 = new JTextField(); 
        pergunta2.add(resposta2, BorderLayout.CENTER);
        JButton enviar2 = new JButton("Responder");
        pergunta1.add(enviar2, BorderLayout.SOUTH);
        mainP.add(pergunta2, "Segunda");

        JPanel pergunta3 = new JPanel(new BorderLayout());// -- Terceira pergunta
        pergunta3.add(new JLabel("2+2x2=?"), BorderLayout.NORTH);
        JTextField resposta3 = new JTextField();
        pergunta1.add(resposta3, BorderLayout.CENTER);
        JButton enviar3 = new JButton("Responder");
        pergunta1.add(enviar3, BorderLayout.SOUTH);
        mainP.add(pergunta3, "Terceira");

        JPanel pergunta4 = new JPanel(new BorderLayout());// -- Quarta pergunta
        pergunta4.add(new JLabel("Quem ganhou a copa de 2022?"), BorderLayout.NORTH);
        JTextField resposta4 = new JTextField();
        pergunta4.add(resposta4, BorderLayout.CENTER);
        JButton enviar4 = new JButton("Responder");
        pergunta4.add(enviar4, BorderLayout.SOUTH);
        mainP.add(pergunta4, "Quarta");

        JPanel pergunta5 = new JPanel(new BorderLayout());// -- Quinta pergunta
        pergunta5.add(new JLabel("Quem foi o campeão da NBA de 2022/2023?"), BorderLayout.NORTH);
        JTextField resposta5 = new JTextField();
        pergunta5.add(resposta5, BorderLayout.CENTER);
        JButton enviar5 = new JButton("Responder");
        pergunta5.add(enviar5, BorderLayout.SOUTH);
        mainP.add(pergunta5, "Quinta");

        JPanel pontuacao = new JPanel(new GridLayout(2, 2));
        JLabel acertos = new JLabel("Acertos:");
        pontuacao.add(acertos);
        JTextField nAcertos = new JTextField();
        nAcertos.setEditable(false);
        pontuacao.add(nAcertos);
        JLabel erros = new JLabel("Erros:");
        pontuacao.add(erros);
        JTextField nErros = new JTextField();
        nErros.setEditable(false);
        pontuacao.add(nErros);
        mainP.add(pontuacao, "Pontuação");

        // ActionListener dos botoes
        bStart.addActionListener(e -> {
            cl.show(mainP, "Primeira");
        });

        enviar1.addActionListener(e -> {
            if ((resposta1.getText()).toLowerCase().equals("são paulo")) {
                contAcertos++;
            } else {
                contErros++;
            }

            cl.show(mainP, "Segunda");

        });

        enviar2.addActionListener(e -> {
            if ((resposta2.getText()).toLowerCase().equals("dom pedro 1")) {
                contAcertos++;
            } else {
                contErros++;
            }
            cl.show(mainP, "Terceira");
        });

        enviar3.addActionListener(e -> {
            if ((resposta3.getText()).toLowerCase().equals("6")) {
                contAcertos++;
            } else {
                contErros++;
            }
            cl.show(mainP, "Quarta");
        });

        enviar4.addActionListener(e -> {
            if ((resposta4.getText()).toLowerCase().equals("argentina")) {
                contAcertos++;
            } else {
                contErros++;
            }
            cl.show(mainP, "Quinta");
        });
        enviar5.addActionListener(e -> {
            if ((resposta5.getText()).toLowerCase().equals("denver nuggets")) {
                contAcertos++;
            } else {
                contErros++;
            }

            nAcertos.setText(String.valueOf(contAcertos));
            nErros.setText(String.valueOf(contErros));

            cl.show(mainP, "Pontuação");
        });

        // set do frame
        this.setDefaultCloseOperation(2);
        this.setBounds(100, 100, 300, 300);
        this.setVisible(true);

    }
}
