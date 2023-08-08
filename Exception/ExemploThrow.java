package Exception;

import javax.swing.JOptionPane;

public class ExemploThrow {
    public static void main(String[] args) throws Exception {

        JOptionPane.showMessageDialog(null, "Bem-vindo ao SENAI!");
        String login = JOptionPane.showInputDialog("Informe seu login:");
        String dataNasc = JOptionPane.showInputDialog("Digite sua data de nascimento [dd/mm/aa]");
        boolean aberto = true;
        while (aberto) {
            try {
                String senha = JOptionPane.showInputDialog("Digite sua senha:");
                dataNasc = dataNasc.replace("/", "");

                if (senha.length() != 6) {
                    throw new Exception("A senha deve conter 6 dígitos!!!");
                }
                if (senha.equals(login)) {
                    throw new Exception("A senha não pode ser igual ao nome!");
                }
                if (senha.equals(dataNasc)) {
                    throw new Exception("A senha não pode ser igual a data de nascimento!");
                }

                if (!senha.matches(".*[a-z].*") || !senha.matches(".*[A-Z].*") ) {
                    throw new Exception("A senha deve conter pelo menos uma letra minúscula e uma maiúscula");
                }

                aberto = false;

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
    }
}
