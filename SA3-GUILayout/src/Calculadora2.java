import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;


public class Calculadora2 extends JPanel {
    private JPanel panel;
    private JLabel originalPriceLabel;
    private JLabel discountRateLabel;
    private JTextField originalPriceField;
    private JTextField discountRateField;
    private JButton calculateButton;
    private JLabel resultLabel;

    public Calculadora2() {
        super();
        JPanel tudo = new JPanel(new BorderLayout());
        this.add(tudo);
        tudo.add(new JLabel("Calculadora De Desconto"), BorderLayout.NORTH);
        panel = new JPanel();
        tudo.add(panel, BorderLayout.CENTER);
        panel.setLayout(new GridLayout(4, 2));

        originalPriceLabel = new JLabel("Preço Original:");
        panel.add(originalPriceLabel);

        originalPriceField = new JTextField();
        originalPriceField.setSize(200, 100);
        panel.add(originalPriceField);

        discountRateLabel = new JLabel("Taxa de Desconto (%):");
        panel.add(discountRateLabel);

        discountRateField = new JTextField();
        panel.add(discountRateField);
        originalPriceField.setSize(200, 100);

        calculateButton = new JButton("Calcular Desconto");
        panel.add(calculateButton);

        resultLabel = new JLabel();
        panel.add(resultLabel);

        calculateButton.addActionListener(e -> {
            try {
                double originalPrice = Double.parseDouble(originalPriceField.getText());
                double discountRate = Double.parseDouble(discountRateField.getText());

                if (discountRate < 0 || discountRate > 100) {
                    resultLabel.setText("A taxa de desconto deve estar entre 0 e 100.");
                } else {
                    double discountAmount = (originalPrice * discountRate) / 100;
                    double finalPrice = originalPrice - discountAmount;

                    DecimalFormat df = new DecimalFormat("#.##");
                    resultLabel.setText("Preço com Desconto: R$ " + df.format(finalPrice));
                }
            } catch (NumberFormatException ex) {
                resultLabel.setText("Valores inválidos. Certifique-se de inserir números válidos.");
            }
        });
    }
}
