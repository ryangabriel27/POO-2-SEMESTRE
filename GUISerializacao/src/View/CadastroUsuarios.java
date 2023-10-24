package View;

import java.util.ArrayList;
import java.util.List;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Model.Usuario;

public class CadastroUsuarios extends JFrame {

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
        setTitle("Cadastro de Usuários");
        setSize(600, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

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

        // ;
    }

    public void run(){
        pack();
        setVisible(true);
    }
}
