package Control;

import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Model.Agenda;

public class OperacoesAgendamento {
    // Atributos
    private List<Agenda> agendas;
    private DefaultTableModel tableModel;
    private JTable table;

    // Construtor
    public OperacoesAgendamento(List<Agenda> agendas, DefaultTableModel tableModel, JTable table) {
        this.agendas = agendas;
        this.tableModel = tableModel;
        this.table = table;
    }

    // Métodos do CRUD

    public void cadastrarAgenda(String nome, String data, String hora, String descricao) {
        Agenda usuario = new Agenda(nome, data, hora, descricao);
        agendas.add(usuario);
        atualizarTabela();
    }

    public void atualizarAgenda(int linhaSelecionada, String nome, String data, String hora, String descricao) {
        if (linhaSelecionada != -1) {
            Agenda usuario = new Agenda(nome, data, hora, descricao);
            agendas.set(linhaSelecionada, usuario);
            atualizarTabela();
        }
    }

    public void apagarAgenda(int linhaSelecionada) {
        if (linhaSelecionada != -1) {
            agendas.remove(linhaSelecionada);
            atualizarTabela();
        }
    }

    public void salvarAgenda() {
        Serializacao.serializar2("dadosAgendamento.txt", agendas);
    }

    private void atualizarTabela() {
        tableModel.setRowCount(0);
        for (Agenda usuario : agendas) {
            tableModel.addRow(new Object[] { usuario.getUsuario(), usuario.getData(), usuario.getHora(), usuario.getDescricao() });
        }
    }
}
