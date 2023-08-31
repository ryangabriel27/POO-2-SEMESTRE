import javax.swing.*;

public class ClickJButton extends JFrame {
    int contClicks = 0;
    public ClickJButton() {
        super("click");
        JPanel painel12 = new JPanel();
        // criar os componentes
        JButton botao1 = new JButton("Clique aqui!!");
        painel12.add(botao1);
        JLabel texto1 = new JLabel("nº de cliques");
        painel12.add(texto1);
        this.getContentPane().add(painel12);
        botao1.addActionListener(e -> {
            contClicks++;
            texto1.setText("Nº de cliques: "+contClicks);
            this.pack();
        });
        //
        this.pack();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
