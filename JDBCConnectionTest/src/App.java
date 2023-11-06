import javax.swing.JOptionPane;

import Connection.ConnectionDAO;

public class App {
    public static void main(String[] args) throws Exception {
        ConnectionDAO conecta = new ConnectionDAO();
        boolean menu = true;

        while (menu) {

            JOptionPane.showMessageDialog(null, "Bem-Vindo", "Menu", JOptionPane.INFORMATION_MESSAGE);

            int escolha = Integer.parseInt(JOptionPane.showInputDialog(
                    "O que você deseja fazer? \n1- Criar uma tabela \n2- Apagar uma tabela \n3- Inserir dados na tabela \n4- Buscar pelo Id \n5- Sair"));

            switch (escolha) {
                case 1:
                    conecta.criaTabela();
                    break;
                case 2:
                    conecta.apagarTabela();
                    break;
                case 3:
                    conecta.inserir(JOptionPane.showInputDialog("Insira o nome do usuário:"),
                            JOptionPane.showInputDialog("Insira o email do usuário:"));
                    break;
                case 4:
                    conecta.buscarPorId(
                            Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o id ser procurado")));
                    JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!", null, escolha);
                    break;
                case 5:
                    JOptionPane.showMessageDialog(null, "Você escolheu sair", "Sair", JOptionPane.CLOSED_OPTION);
                    menu = false;
                default:
                    break;
            }

        }

    }
}
