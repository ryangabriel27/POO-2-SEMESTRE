package Exception;

import javax.swing.JOptionPane;

public class ExemploThrow {
    public static void main(String[] args) throws Exception { 
        try {
           JOptionPane.showMessageDialog(null, "Bem-vindo ao SENAI!");
        String login = JOptionPane.showInputDialog("Informe seu login:");
        String dataNasc = JOptionPane.showInputDialog("Digite sua data de nascimento [dd/mm/aa]");
        String senha = JOptionPane.showInputDialog("Digite sua senha:");
        dataNasc.replace("/","");
        if (senha.length()!= 6){
            throw new Exception("A senha deve conter 6 dígitos!!!");
        }  else if (senha.equals(login)) {
            throw new Exception("A senha não pode ser igual ao nome!");
        }  else if (senha.equals(dataNasc)) {
            throw new Exception("A senha não pode ser igual a data de nascimento");
        } 
        } catch (Exception e) {
            // TODO: handle exception
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}
