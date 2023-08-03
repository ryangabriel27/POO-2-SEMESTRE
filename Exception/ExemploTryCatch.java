package Exception;

import javax.swing.JOptionPane;

public class ExemploTryCatch {
    public static void main(String[] args) {
        boolean calculadora = true;
        while (calculadora) {
            JOptionPane.showMessageDialog(null, "Bem-vindo a Calculadora!");
            int operacao = Integer
                    .parseInt(JOptionPane.showInputDialog("Escolha a operação desejada : " + "\n 1: Adição"
                            + "\n 2: Subtração" + "\n 3: Multiplicação" + "\n Divisão" + "\n Sair"));
            if (operacao == 1) {
                boolean adicao = true;
                while (adicao) {
                    try {
                        JOptionPane.showMessageDialog(null, "Você escolheu a adição");
                        int n1 = Integer.parseInt(JOptionPane.showInputDialog("Digite um número inteiro : "));
                        int n2 = Integer.parseInt(JOptionPane.showInputDialog("Digite outro número inteiro : "));
                        JOptionPane.showMessageDialog(null, "O Resultado é: " + (n1 + n2));
                        adicao = false;
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Erro - valor diferente de inteiro", "ERRO!",
                                JOptionPane.ERROR_MESSAGE);
                    }
                }

            } else if (operacao == 2) {
                boolean subtracao = true;
                while (subtracao) {
                    try {
                        JOptionPane.showMessageDialog(null, "Você escolheu a subtração");
                        int n1 = Integer.parseInt(JOptionPane.showInputDialog("Digite um número inteiro : "));
                        int n2 = Integer.parseInt(JOptionPane.showInputDialog("Digite outro número inteiro : "));
                        JOptionPane.showMessageDialog(null, "O Resultado é: " + (n1 - n2));
                        subtracao = false;
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Erro - valor diferente de inteiro", "ERRO!",
                                JOptionPane.ERROR_MESSAGE);
                    }
                }
            } else if (operacao == 3) {
                boolean multiplicacao = true;
                while (multiplicacao) {
                    try {
                        JOptionPane.showMessageDialog(null, "Você escolheu a multiplicação!");
                        int n1 = Integer.parseInt(JOptionPane.showInputDialog("Digite um número inteiro : "));
                        int n2 = Integer.parseInt(JOptionPane.showInputDialog("Digite outro número inteiro : "));
                        JOptionPane.showMessageDialog(null, "O Resultado é: " + (n1 * n2));
                        multiplicacao = false;
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Erro - valor diferente de inteiro", "ERRO!",
                                JOptionPane.ERROR_MESSAGE);
                    }
                }
            } else if (operacao == 4) {
                boolean divisao = true;
                while (divisao) {
                    try {
                        JOptionPane.showMessageDialog(null, "Você escolheu a multiplicação!");
                        int n1 = Integer.parseInt(JOptionPane.showInputDialog("Digite um número inteiro : "));
                        int n2 = Integer.parseInt(JOptionPane.showInputDialog("Digite outro número inteiro : "));
                        JOptionPane.showMessageDialog(null, "O Resultado é: " + (n1 / n2));
                        divisao = false;
                    } catch (ArithmeticException erro) {
                        JOptionPane.showMessageDialog(null,
                                "Erro - Não dividiras por 0!!!", "ERRO!",
                                JOptionPane.ERROR_MESSAGE);
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null,
                                "Erro - Número diferente de inteiro ", "ERRO!",
                                JOptionPane.ERROR_MESSAGE);
                    }

                }
            }
        }
    }
}
