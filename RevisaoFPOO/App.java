package RevisaoFPOO;

import javax.swing.JOptionPane;

import RevisaoFPOO.Cadastro.Aves;
import RevisaoFPOO.Cadastro.Cachorro;
import RevisaoFPOO.Cadastro.Gato;
import RevisaoFPOO.Cadastro.Outros;
import RevisaoFPOO.Horario.AgendaConsulta;

public class App {

        public static void main(String[] args) {

                boolean menu = true;

                Cachorro cachorro[] = new Cachorro[30];
                Gato gato[] = new Gato[30];
                Aves aves[] = new Aves[30];
                Outros outros[] = new Outros[30];
                AgendaConsulta agendaClientes[] = new AgendaConsulta[50];

                int contCachorro = 0;
                int contGato = 0;
                int contAves = 0;
                int contOutro = 0;
                int contClientes = 0;

                while (menu) {

                        JOptionPane.showMessageDialog(null, "Bem-Vindo!!!",
                                        "Bem-Vindo", JOptionPane.INFORMATION_MESSAGE);
                        int acao = Integer.parseInt(
                                        JOptionPane.showInputDialog(
                                                        "O que você deseja fazer?" + "\n 1: Cadastro do Animal"
                                                                        + "\n 2: Agendar uma consulta" + "\n 3: Sair"));
                        if (acao == 1) {
                                JOptionPane.showMessageDialog(null, "Vamos fazer o cadastro do seu animal",
                                                "Cadastro", JOptionPane.INFORMATION_MESSAGE);
                                int especieAnimal = Integer
                                                .parseInt(JOptionPane.showInputDialog(
                                                                "De qual espécie é o animal que você vai cadastrar?"
                                                                                + "\n 1- Cachorro" + "\n 2- Gato"
                                                                                + "\n 3- Ave" + "\n 4- Outro"));

                                if (especieAnimal == 1) {

                                        cachorro[contCachorro] = new Cachorro();

                                        cachorro[contCachorro].setNome(
                                                        JOptionPane.showInputDialog("Digite o nome do animal:"));
                                        cachorro[contCachorro].setRaca(
                                                        JOptionPane.showInputDialog("Digite a raça do animal:"));
                                        cachorro[contCachorro]
                                                        .setIdade(Integer.parseInt(JOptionPane
                                                                        .showInputDialog("Digite a idade do animal:")));
                                        cachorro[contCachorro].setPorte(
                                                        JOptionPane.showInputDialog("Digite o porte do animal:"));
                                        cachorro[contCachorro]
                                                        .setProprietario(JOptionPane.showInputDialog(
                                                                        "Digite o nome do proprietário do animal:"));
                                        cachorro[contCachorro].setnPaciente(100 + contCachorro);
                                        JOptionPane.showMessageDialog(null,
                                                        "O número do paciente é :"
                                                                        + cachorro[contCachorro].getnPaciente(),
                                                        "Cadastro", JOptionPane.INFORMATION_MESSAGE);

                                        contCachorro++;
                                } else if (especieAnimal == 2) {
                                        gato[contGato] = new Gato();

                                        gato[contGato].setNome(JOptionPane.showInputDialog("Digite o nome do animal:"));
                                        gato[contGato].setRaca(JOptionPane.showInputDialog("Digite a raça do animal:"));
                                        gato[contGato].setIdade(Integer.parseInt(
                                                        JOptionPane.showInputDialog("Digite a idade do animal:")));
                                        gato[contGato].setPorte(
                                                        JOptionPane.showInputDialog("Digite o porte do animal:"));
                                        gato[contGato]
                                                        .setProprietario(JOptionPane.showInputDialog(
                                                                        "Digite o nome do proprietário do animal:"));
                                        gato[contGato].setnPaciente(200 + contGato);
                                        JOptionPane.showMessageDialog(null,
                                                        "O número do paciente é :" + gato[contGato].getnPaciente(),
                                                        "Cadastro", JOptionPane.INFORMATION_MESSAGE);
                                        contGato++;
                                } else if (especieAnimal == 3) {
                                        aves[contAves] = new Aves();

                                        aves[contAves].setNome(JOptionPane.showInputDialog("Digite o nome do animal:"));
                                        aves[contAves].setRaca(JOptionPane.showInputDialog("Digite a raça do animal:"));
                                        aves[contAves].setIdade(Integer.parseInt(
                                                        JOptionPane.showInputDialog("Digite a idade do animal:")));
                                        aves[contAves].setPorte(
                                                        JOptionPane.showInputDialog("Digite o porte do animal:"));
                                        aves[contAves]
                                                        .setProprietario(JOptionPane.showInputDialog(
                                                                        "Digite o nome do proprietário do animal:"));
                                        aves[contAves].setnPaciente(300 + contAves);
                                        JOptionPane.showMessageDialog(null,
                                                        "O número do paciente é :" + aves[contAves].getnPaciente(),
                                                        "Cadastro", JOptionPane.INFORMATION_MESSAGE);
                                        contAves++;
                                } else if (especieAnimal == 4) {
                                        outros[contOutro] = new Outros();

                                        outros[contOutro].setNome(
                                                        JOptionPane.showInputDialog("Digite o nome do animal:"));
                                        outros[contOutro].setRaca(
                                                        JOptionPane.showInputDialog("Digite a espécie do animal:"));
                                        outros[contOutro]
                                                        .setIdade(Integer.parseInt(JOptionPane
                                                                        .showInputDialog("Digite a idade do animal:")));
                                        outros[contOutro].setPorte(
                                                        JOptionPane.showInputDialog("Digite o porte do animal:"));
                                        outros[contOutro]
                                                        .setProprietario(JOptionPane.showInputDialog(
                                                                        "Digite o nome do proprietário do animal:"));
                                        outros[contOutro].setnPaciente(400 + contOutro);
                                        JOptionPane.showMessageDialog(null,
                                                        "O número do paciente é :" + outros[contOutro].getnPaciente(),
                                                        "Cadastro", JOptionPane.INFORMATION_MESSAGE);
                                        contOutro++;
                                } else {
                                        JOptionPane.showMessageDialog(null, "Digite um número válido",
                                                        "ERRO", JOptionPane.ERROR_MESSAGE);
                                }
                        } else if (acao == 2) {
                                agendaClientes[contClientes] = new AgendaConsulta();
                                boolean agenda = false;
                                agendaClientes[contClientes].setNomeCliente(
                                                JOptionPane.showInputDialog("Qual é o seu nome?"));
                                agendaClientes[contClientes].setNomeDoPet(
                                                JOptionPane.showInputDialog("Digite o nome do pet?"));
                                String verificaPet = agendaClientes[contClientes].getNomeDoPet();
                                boolean petCadastrado = false;
                                for (int i = 0; i < contCachorro; i++) {
                                        if (verificaPet.equals(cachorro[i].getNome())) {
                                                petCadastrado = true;
                                        }
                                }
                                for (int i = 0; i < contGato; i++) {
                                        if (verificaPet.equals(gato[i].getNome())) {
                                                petCadastrado = true;
                                        }
                                }
                                for (int i = 0; i < contAves; i++) {
                                        if (verificaPet.equals(aves[i].getNome())) {
                                                petCadastrado = true;
                                        }
                                }
                                for (int i = 0; i < contOutro; i++) {
                                        if (verificaPet.equals(outros[i].getNome())) {
                                                petCadastrado = true;
                                        }
                                }

                                if (petCadastrado == true) {
                                        agenda = true;
                                                JOptionPane.showMessageDialog(null, "O seu pet está cadastrado!",
                                                        "Consulta", JOptionPane.INFORMATION_MESSAGE);
                                        while (agenda) {

                                                JOptionPane.showMessageDialog(null, "Vamos agendar uma consulta!",
                                                                "Consulta", JOptionPane.INFORMATION_MESSAGE);
                                                agendaClientes[contClientes].setDataDesejada(
                                                                JOptionPane.showInputDialog(
                                                                                "Em que dia você deseja fazer a consulta? (DD/MM)"));
                                                agendaClientes[contClientes].setHorarioDesejado(
                                                                JOptionPane.showInputDialog(
                                                                                "Em qual horário você deseja fazer a consulta? (HH:MM)"));

                                                for (int j = 0; j < contClientes; j++) {
                                                        if (agendaClientes[contClientes].getAgendamento()
                                                                        .equals(agendaClientes[j]
                                                                                        .getAgendamento())) {
                                                                JOptionPane.showMessageDialog(null,
                                                                                "O horário que você deseja está ocupado! Escolha outro!",
                                                                                "Erro!",
                                                                                JOptionPane.ERROR_MESSAGE);
                                                        } else {
                                                                JOptionPane.showMessageDialog(null,
                                                                                "Horário agendado, aguardamos sua presença : ",
                                                                                "Sucesso",
                                                                                JOptionPane.INFORMATION_MESSAGE);
                                                        }
                                                }
                                                contClientes++;
                                        }

                                } else {
                                        JOptionPane.showMessageDialog(null,
                                                        "O seu pet não está cadastrado! Faça o cadastro para prosseguir!",
                                                        "Consulta", JOptionPane.ERROR_MESSAGE);
                                }
                        } else if (acao == 3) {
                                JOptionPane.showMessageDialog(null, "Você escolheu sair, até a próxima!!",
                                                "Sair", JOptionPane.INFORMATION_MESSAGE);
                                menu = false;
                        } else {
                                JOptionPane.showMessageDialog(null, "Digite um número válido",
                                                "ERRO", JOptionPane.ERROR_MESSAGE);
                        }

                }

        }
}