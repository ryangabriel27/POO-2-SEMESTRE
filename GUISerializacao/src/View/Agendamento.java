package View;

import java.util.ArrayList;
import java.util.List;

import java.awt.BorderLayout;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import Control.OperacoesAgendamento;
import Control.Serializacao;
import Model.Agenda;
import Model.Usuario;

public class Agendamento extends JPanel {
    // Atributos
    private JTextField inputData, inputHora, inputDescricao, inputUsuario;
    private DefaultTableModel tableModel;
    private JTable table;
    private JButton cadastrarButton,
            atualizarButton,
            apagarButton,
            salvarButton;
    private List<Agenda> agendas = new ArrayList<>();
    private int linhaSelecionada = -1;

    // Construtor
    public Agendamento() {
        // Construir minha tabela
        tableModel = new DefaultTableModel(); // Criando o modelo de tabela
        tableModel.addColumn("Usuario"); // Adiciona uma coluna 'nome'
        tableModel.addColumn("Data"); // Adiciona uma coluna 'idade'
        tableModel.addColumn("Hora");
        tableModel.addColumn("Descrição");
        table = new JTable(tableModel, null, null);// Cria a tabela com model da 'tableModel'
        JScrollPane scrollPane = new JScrollPane(table);// Adiciona a table a um JScrollPane

        // Criar os componentes
        inputUsuario = new JTextField(8);
        inputData = new JTextField(12);
        inputHora = new JTextField(5);
        inputDescricao = new JTextField(12);
        cadastrarButton = new JButton("Cadastrar");
        atualizarButton = new JButton("Atualizar");
        apagarButton = new JButton("Apagar");
        salvarButton = new JButton("Salvar");

        // Adicionar os componentes
        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("Data:"));
        inputPanel.add(inputData);
        inputPanel.add(new JLabel("Hora:"));
        inputPanel.add(inputHora);
        inputPanel.add(new JLabel("Usuario:"));
        inputPanel.add(inputUsuario);
        inputPanel.add(new JLabel("Descrição:"));
        inputPanel.add(inputDescricao);
        inputPanel.add(cadastrarButton);
        inputPanel.add(atualizarButton);
        inputPanel.add(apagarButton);
        inputPanel.add(salvarButton);
        setLayout(new BorderLayout());
        add(inputPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        // Criação do arquivo binário
        File arquivoAgendamento = new File("dadosAgendamento.txt");
        if (arquivoAgendamento.exists()) {
            agendas = Serializacao.deserializar2("dadosAgendamento.txt");
            atualizarTabela();
        }

        // Tratamento de eventos
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                linhaSelecionada = table.rowAtPoint(evt.getPoint());
                if (linhaSelecionada != -1) {
                    inputUsuario.setText((String) table.getValueAt(linhaSelecionada, 0));
                    inputData.setText(table.getValueAt(linhaSelecionada, 1).toString());
                    inputHora.setText((String) table.getValueAt(linhaSelecionada, 2));
                    inputDescricao.setText(table.getValueAt(linhaSelecionada, 3).toString());

                }
            }
        });
        OperacoesAgendamento operacoes = new OperacoesAgendamento(agendas, tableModel, table);
        cadastrarButton.addActionListener(e -> {

            operacoes.cadastrarAgenda(inputUsuario.getText(), inputData.getText(), inputHora.getText(),
                    inputDescricao.getText());       
            inputUsuario.setText("");
            inputData.setText("");
            inputHora.setText("");
            inputDescricao.setText("");

        });
        atualizarButton.addActionListener(e -> {
            operacoes.atualizarAgenda(linhaSelecionada, inputUsuario.getText(),
                    inputData.getText(), inputHora.getText(), inputDescricao.getText());
        });
        apagarButton.addActionListener(e -> {
            operacoes.apagarAgenda(linhaSelecionada);
        });
        salvarButton.addActionListener(e -> {
            operacoes.salvarAgenda();
        });
    }

    private void atualizarTabela() {
        tableModel.setRowCount(0);
        for (Agenda usuario : agendas) {
            tableModel.addRow(new Object[] { usuario.getUsuario(), usuario.getData(), usuario.getHora(),
                    usuario.getDescricao() });
        }
    }
}