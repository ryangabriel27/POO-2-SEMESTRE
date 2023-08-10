package LojasCarroList;

import java.util.*;

import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) {
        List<Carros> listaCarro = new ArrayList<>();
        List<String> marcas = new ArrayList<>();
        List<String> modelo = new ArrayList<>();
        List<String> ano = new ArrayList<>();
        List<String> cor = new ArrayList<>();

        boolean menu = true;
        while (menu) {
            JOptionPane.showMessageDialog(null, "Bem-Vindo", null, JOptionPane.INFORMATION_MESSAGE);
            int acao = Integer
                    .parseInt(JOptionPane.showInputDialog("O que você deseja fazer? " + "\n 1: Ver a lista de carros"
                            + "\n 2: Cadastrar um carro" + "\n 3: Consultar um carro" + "\n 4: Excluir um carro"
                            + "\n 5: Sair"));
            if (acao == 1) {
                // Listar
                for (int i = 0; i < listaCarro.size(); i++) {
                    System.out.println(listaCarro.get(i).getMarca() + " " + listaCarro.get(i).getModelo() + " "
                            + listaCarro.get(i).getAno() + " " + listaCarro.get(i).getCor());
                }
            } else if (acao == 2) {
                // Cadastrar
                JOptionPane.showMessageDialog(null, "Vamos cadastrar um carro!", "Cadastro",
                        JOptionPane.INFORMATION_MESSAGE);

                Carros carros = new Carros(JOptionPane.showInputDialog("Digite a marca do carro"),
                        JOptionPane.showInputDialog("Digite o modelo do carro"),
                        JOptionPane.showInputDialog("Digite a cor do carro"),
                        JOptionPane.showInputDialog("Digite o ano do carro"));
                listaCarro.add(carros);
                JOptionPane.showMessageDialog(null, "Carro cadastrado com sucesso!", "Cadastro",
                        JOptionPane.INFORMATION_MESSAGE);
            } else if (acao == 3) {
                // Consultar
                String carroConsulta = JOptionPane.showInputDialog("Digite o modelo do carro que será consultado: ");
                boolean carroEncontrado = false;
                int iCarroEncontrado = 0;
                for (int i = 0; i < listaCarro.size(); i++) {
                    if (carroConsulta.equals(listaCarro.get(i).getModelo())) {
                        carroEncontrado = true;
                        iCarroEncontrado = i;
                    } else {
                        carroEncontrado = false;
                    }  
                }
                if (carroEncontrado == true) {
                    JOptionPane.showMessageDialog(null, "Carro encontrado!!", "Consulta",
                            JOptionPane.INFORMATION_MESSAGE);
                    JOptionPane.showMessageDialog(null,
                            "Marca: " + listaCarro.get(iCarroEncontrado).getMarca() + "\n Modelo: "
                                    + listaCarro.get(iCarroEncontrado).getModelo() + "\n Ano: "
                                    + listaCarro.get(iCarroEncontrado).getAno() + "\n Cor: "
                                    + listaCarro.get(iCarroEncontrado).getCor());
                } else {
                    JOptionPane.showMessageDialog(null, "Carro não encontrado, tente novamente!!", "Consulta",
                            JOptionPane.ERROR_MESSAGE);
                }
            } else if (acao == 4) {
                // Apagar
                String carroApagar = JOptionPane.showInputDialog("Digite o modelo do carro que será apagado: ");
                boolean carroEncontrado2 = false;
                int iCarroEncontrado2 = 0;
                for (int i = 0; i < listaCarro.size(); i++) {
                    if (carroApagar.equals(listaCarro.get(i).getModelo())) {
                        carroEncontrado2 = true;
                        iCarroEncontrado2 = i;
                    } else {
                        carroEncontrado2 = false;
                    }
                }
                if (carroEncontrado2 == true) {
                    JOptionPane.showMessageDialog(null, "Carro encontrado!!", "Consulta",
                            JOptionPane.INFORMATION_MESSAGE);
                    JOptionPane.showMessageDialog(null,
                            "Marca: " + listaCarro.get(iCarroEncontrado2).getMarca() + "\n Modelo: "
                                    + listaCarro.get(iCarroEncontrado2).getModelo() + "\n Ano: "
                                    + listaCarro.get(iCarroEncontrado2).getAno() + "\n Cor: "
                                    + listaCarro.get(iCarroEncontrado2).getCor());
                    int n = JOptionPane.showConfirmDialog(
                            null,
                            "Tem certeza que deseja apagar esse Carro?",
                            "Apagar",
                            JOptionPane.YES_NO_OPTION);

                    if (true) {
                        listaCarro.remove(iCarroEncontrado2);
                        JOptionPane.showMessageDialog(null, "Carro apagado!!", "Consulta",
                            JOptionPane.INFORMATION_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Carro não encontrado, tente novamente!!", "Consulta",
                            JOptionPane.ERROR_MESSAGE);
                }

            } else {
                JOptionPane.showMessageDialog(null, "Digite um número válido", "ERRO!", JOptionPane.ERROR_MESSAGE);
            }
        }

    }

}
