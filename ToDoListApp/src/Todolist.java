import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Todolist extends JFrame {
    // atributos
    private JPanel mainPanel;
    private JTextField taskInputField;
    private JButton addButton;
    private JList<String> taskList;
    private DefaultListModel<String> listModel;
    private JButton deleteButton;
    private JButton markDoneButton;
    private JComboBox<String> filterComboBox;
    private JButton clearCompletedButton;
    private List<Task> tasks;

    public Todolist() {
        super("TO-DO List App");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(700, 700);
        // Inicializa o painel principal
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        // Inicializa a lista de tasks e a lista de tasks concluídas
        tasks = new ArrayList<>();
        listModel = new DefaultListModel<>();
        taskList = new JList<>(listModel);

        // Inicializa campos de entrada, botões e JComboBox

        taskInputField = new JTextField();
        addButton = new JButton("Adicionar");
        deleteButton = new JButton("Excluir");
        markDoneButton = new JButton("Concluir");
        filterComboBox = new JComboBox<>(new String[] { "Todas", "Ativas",
                "Concluídas" });
        clearCompletedButton = new JButton("Limpar Concluídas");
        // Configuração do painel de entrada
        JPanel inputPanel = new JPanel(new BorderLayout());
        inputPanel.add(taskInputField, BorderLayout.CENTER);
        inputPanel.add(addButton, BorderLayout.EAST);
        inputPanel.add(filterComboBox, BorderLayout.WEST);
        // Configuração do painel de botões
        JPanel buttonPanel = new JPanel();
        BoxLayout bl = new BoxLayout(buttonPanel, BoxLayout.Y_AXIS);
        buttonPanel.setLayout(bl);
        buttonPanel.add(deleteButton);
        buttonPanel.add(markDoneButton);
        //buttonPanel.add(filterComboBox);
        buttonPanel.add(clearCompletedButton);
        // Adiciona os componentes ao painel principal
        mainPanel.add(inputPanel, BorderLayout.NORTH);
        mainPanel.add(new JScrollPane(taskList), BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.WEST);
        // Adiciona o painel principal à janela
        this.add(mainPanel);
        // Configuração de Listener para os Eventos

        addButton.addActionListener(e -> { // ao clicar no botão adicionar

            if (taskInputField.getText() != "") { // Verifica se o campo está vazio
                addTask(); // Executa o método addTask().
            }

        });

        deleteButton.addActionListener(e -> { // ao clicar no botão excluir
            deleteTask();
        });

        markDoneButton.addActionListener(e -> { // ao clicar no botão concluida

            markTaskDone();

        });

        filterComboBox.addActionListener(e -> { // ao clicar no comboBox

            filterTasks();

        });

        clearCompletedButton.addActionListener(e -> { // ao clicar no botão limpar Tarefas concluídas

            int resposta = JOptionPane.showConfirmDialog(null, "Você deseja excluir todas as tarefas concluídas?",
                    getTitle(),
                    JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);
            if (resposta == JOptionPane.YES_OPTION) {
                clearCompletedTasks();
            }

        });

        HandlerEnterText enterText = new HandlerEnterText(); // Handler para adicionar uma task
        taskInputField.addKeyListener(enterText); // Ao digitar no campo e pressionar ENTER adiciona uma tarefa a lista

        HandlerDeleteText deleteText = new HandlerDeleteText(); // Handler para deletar uma task
        taskList.addKeyListener(deleteText);//

        HandlerDblClick doneDblClick = new HandlerDblClick(); // Handler para marcar uma task como concluída com 2
                                                              // clicks
        taskList.addMouseListener(doneDblClick);
    }

    public class HandlerEnterText implements KeyListener {

        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                addTask();
            }

        }

        @Override
        public void keyReleased(KeyEvent e) {
            // TODO Auto-generated method stub

        }

        @Override
        public void keyTyped(KeyEvent e) {
            // TODO Auto-generated method stub

        }

    }

    public class HandlerDeleteText implements KeyListener {

        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_DELETE) {
                deleteTask();
            }

        }

        @Override
        public void keyReleased(KeyEvent e) {
            // TODO Auto-generated method stub

        }

        @Override
        public void keyTyped(KeyEvent e) {
            // TODO Auto-generated method stub

        }

    }

    public class HandlerDblClick implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            // TODO Auto-generated method stub
            if (e.getClickCount() == 2 && e.getButton() == MouseEvent.BUTTON1) { // Ao dar 2 clicks em uma task você
                                                                                 // torna ela em um task concluída
                markTaskDone();
            }

        }

        @Override
        public void mouseEntered(MouseEvent e) {
            // TODO Auto-generated method stub

        }

        @Override
        public void mouseExited(MouseEvent e) {
            // TODO Auto-generated method stub

        }

        @Override
        public void mousePressed(MouseEvent e) {
            // TODO Auto-generated method stub

        }

        @Override
        public void mouseReleased(MouseEvent e) {
            // TODO Auto-generated method stub

        }

    }

    private void addTask() {
        // Adiciona uma nova task à lista de tasks
        String taskDescription = taskInputField.getText().trim();// remove espaços vazios
        if (!taskDescription.isEmpty()) {
            Task newTask = new Task(taskDescription);
            tasks.add(newTask);
            JOptionPane.showMessageDialog(null, "Tarefa adicionada", getTitle(), JOptionPane.INFORMATION_MESSAGE);
            updateTaskList();
            taskInputField.setText("");
        }
    }

    private void deleteTask() {
        // Exclui a task selecionada da lista de tasks
        int selectedIndex = taskList.getSelectedIndex();
        if (selectedIndex >= 0 && selectedIndex < tasks.size()) {

            int resposta = JOptionPane.showConfirmDialog(null, "Você deseja excluir essa tarefa?", getTitle(),
                    JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);

            if (resposta == JOptionPane.YES_OPTION) {
                tasks.remove(selectedIndex);
                JOptionPane.showMessageDialog(null, "Tarefa excluída", getTitle(), JOptionPane.INFORMATION_MESSAGE);
                updateTaskList();
            }

        }
    }

    private void markTaskDone() {
        // Marca a task selecionada como concluída
        int selectedIndex = taskList.getSelectedIndex();
        if (selectedIndex >= 0 && selectedIndex < tasks.size()) {
            Task task = tasks.get(selectedIndex);
            JOptionPane.showMessageDialog(null, "Tarefa concluída", getTitle(), JOptionPane.INFORMATION_MESSAGE);
            task.setDone(true);
            updateTaskList();
        }
    }

    private void filterTasks() {
        // Filtra as tasks com base na seleção do JComboBox
        String filter = (String) filterComboBox.getSelectedItem();
        listModel.clear();
        for (Task task : tasks) {
            if (filter.equals("Todas") || (filter.equals("Ativas") &&
                    !task.isDone()) || (filter.equals("Concluídas") && task.isDone())) {
                listModel.addElement(task.getDescription());
            }
        }
    }

    private void clearCompletedTasks() {
        // Limpa todas as tasks concluídas da lista
        List<Task> completedTasks = new ArrayList<>();
        for (Task task : tasks) {
            if (task.isDone()) {
                completedTasks.add(task);
            }
        }
        tasks.removeAll(completedTasks);
        updateTaskList();
    }

    private void updateTaskList() {
        // Atualiza a lista de tasks exibida na GUI
        listModel.clear();
        for (Task task : tasks) {
            listModel.addElement(task.getDescription() + (task.isDone() ?

                    " (Concluída)" : ""));

        }
    }

    public void run() {
        // Exibe a janela
        this.setVisible(true);
    }
}
