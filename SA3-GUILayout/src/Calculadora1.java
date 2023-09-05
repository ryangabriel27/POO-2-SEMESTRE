import javax.swing.*;
import java.awt.*;

public class Calculadora1 extends JPanel {
    public Calculadora1() {
        super();
        // IMC
        // Peso(KG)/Altura²(m²)
        JPanel painel1 = new JPanel(new BorderLayout());
        this.add(painel1);
        painel1.add(new JLabel("Calculadora 1"), BorderLayout.NORTH);
        JPanel campos = new JPanel(new GridLayout(1, 4));
        painel1.add(campos, BorderLayout.CENTER);
        campos.add(new JLabel("Insira seu peso:"));
        JTextField campoPeso = new JTextField(8);
        campos.add(campoPeso);
        campos.add(new JLabel("Insira sua altura:"));
        JTextField campoAltura = new JTextField(8);
        campos.add(campoAltura);
        JButton calcular = new JButton("Calcular");
        painel1.add(calcular, BorderLayout.AFTER_LAST_LINE);
        JPanel resultado = new JPanel(new GridLayout(1,1));
        JTextField display = new JTextField();
        display.setEditable(false);;
        painel1.add(resultado,BorderLayout.AFTER_LINE_ENDS);
        resultado.setVisible(true);
        calcular.addActionListener(e -> {
            double imc = 0;
            if (campoPeso.getText() != "" && campoAltura.getText() != "") {
                double peso = Double.parseDouble(campoPeso.getText());
                double altura = Double.parseDouble(campoAltura.getText());

                imc = peso / (altura * altura);
                
            }
            display.setText(String.valueOf(imc));
            resultado.add(display);
            campoPeso.setText("");
            campoAltura.setText("");
        });

    }
}
