import javax.swing.*;
import java.awt.*;

public class Calculadora1 extends JPanel {
    public Calculadora1() {
        super();
        // IMC
        // Peso(KG)/Altura²(m²)
        JPanel tudo = new JPanel(new FlowLayout(FlowLayout.CENTER));
        tudo.setSize(300, 300);
        this.add(tudo);
        JPanel painel1 = new JPanel(new BorderLayout());
        tudo.add(painel1);
        painel1.add(new JLabel("Calculadora de IMC"), BorderLayout.NORTH);
        JPanel calculadora = new JPanel(new BorderLayout());
        painel1.add(calculadora,BorderLayout.CENTER);
        JPanel campos = new JPanel(new GridLayout(2, 2));
        calculadora.add(campos, BorderLayout.NORTH);
        campos.add(new JLabel("Insira seu peso (Kg):"));
        JTextField campoPeso = new JTextField();
        campos.add(campoPeso);
        campos.add(new JLabel("Insira sua altura (m):"));
        JTextField campoAltura = new JTextField();
        campos.add(campoAltura);
        JButton calcular = new JButton("Calcular");
        calculadora.add(calcular, BorderLayout.CENTER);
        JTextField display = new JTextField();
        display.setEditable(false);
        calculadora.add(display,BorderLayout.SOUTH);
        calcular.addActionListener(e -> {
            double imc = 0;
            try {
                if (campoPeso.getText() != "" && campoAltura.getText() != "") {
                double peso = Double.parseDouble(campoPeso.getText());
                double altura = Double.parseDouble(campoAltura.getText());

                imc = peso / (altura * altura);
                display.setText("Seu IMC é de: "+String.valueOf(imc));
                
                }
            } catch (Exception i){
                display.setText("Preencha os campos corretamente , por favor");
            }
            
            
            campoPeso.setText("");
            campoAltura.setText("");
        });

    }
}
