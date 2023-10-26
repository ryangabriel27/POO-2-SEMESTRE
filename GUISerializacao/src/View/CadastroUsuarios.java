package View;

import java.util.ArrayList;
import java.util.List;

import java.awt.BorderLayout;
import java.io.File;

import javax.swing.JButton;
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

import Control.OperacoesUsuario;
import Control.Serializacao;
import Model.Usuario;

public class CadastroUsuarios extends JPanel {

    // atributos
    private JTextField inputNome;
    private JTextField inputIdade;
    private DefaultTableModel tableModel;
    private JTable table;
    private JButton cadastrarButton,
            atualizarButton,
            apagarButton,
            apagarTodosButtons,
            salvarButton;
    private List<Usuario> usuarios = new ArrayList<>();
    private int linhaSelecionada = -1;

    public CadastroUsuarios() {

        // Construir minha tabela
        tableModel = new DefaultTableModel(); // Criando o modelo de tabela
        tableModel.addColumn("Nome"); // Adiciona uma coluna 'nome'
        tableModel.addColumn("Idade"); // Adiciona uma coluna 'idade'

        table = new JTable(tableModel, null, null);// Cria a tabela com model da 'tableModel'
        JScrollPane scrollPane = new JScrollPane(table);// Adiciona a table a um JScrollPane

        // Criar os componentes
        inputNome = new JTextField(20);
        inputIdade = new JTextField(5);
        cadastrarButton = new JButton("Cadastrar");
        atualizarButton = new JButton("Atualizar");
        apagarButton = new JButton("Apagar");
        apagarTodosButtons = new JButton("Apagar Todos");
        salvarButton = new JButton("Salvar");

        // Adicionar os componentes
        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("Nome:"));
        inputPanel.add(inputNome);
        inputPanel.add(new JLabel("Idade:"));
        inputPanel.add(inputIdade);
        inputPanel.add(cadastrarButton);
        inputPanel.add(atualizarButton);
        inputPanel.add(apagarButton);
        inputPanel.add(apagarTodosButtons);
        inputPanel.add(salvarButton);
        setLayout(new BorderLayout());
        add(inputPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        // Criação do arquivo binário
        File arquivo = new File("dados.txt");
        if (arquivo.exists()) {
            usuarios = Serializacao.deserializar("dados.txt");
            atualizarTabela();
        }

        // Tratamento de eventos
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                linhaSelecionada = table.rowAtPoint(evt.getPoint());
                if (linhaSelecionada != -1) {
                    inputNome.setText((String) table.getValueAt(linhaSelecionada, 0));
                    inputIdade.setText(table.getValueAt(linhaSelecionada, 1).toString());

                }
            }
        });
        OperacoesUsuario operacoes = new OperacoesUsuario(usuarios, tableModel, table);
        cadastrarButton.addActionListener(e -> {

            operacoes.cadastrarUsuario(inputNome.getText(), inputIdade.getText());
            inputNome.setText("");
            inputIdade.setText("");

        });
        atualizarButton.addActionListener(e -> {
            operacoes.atualizarUsuario(linhaSelecionada, inputNome.getText(), inputIdade.getText());
        });
        apagarButton.addActionListener(e -> {
            operacoes.apagarUsuario(linhaSelecionada);
        });
        apagarTodosButtons.addActionListener(e -> {
            operacoes.apagarTodosUsuarios();
        });
        salvarButton.addActionListener(e -> {
            operacoes.salvarUsuarios();
        });
    }

    private void atualizarTabela() {
        tableModel.setRowCount(0);
        for (Usuario usuario : usuarios) {
            tableModel.addRow(new Object[] { usuario.getNome(), usuario.getIdade() });
        }
    }
}
