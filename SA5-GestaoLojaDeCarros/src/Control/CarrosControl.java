package Control;

import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Model.Carros;

public class CarrosControl {
    // CRUD
    private List<Carros> carros;
    private DefaultTableModel tableModel;
    private JTable table;

    // Construtor
    public CarrosControl(List<Carros> carros, DefaultTableModel tableModel, JTable table) {
        this.carros = carros;
        this.tableModel = tableModel;
        this.table = table;
    }

    // Métodos
    public void cadastrarCarro(String modelo, String marca, int ano, String cor, String placa, double valor) {
        // Adiciona a tabela
        Carros carro = new Carros(modelo.trim(), marca.trim(), ano, cor.trim(), placa.trim(), valor);
        carros.add(carro);
        // -----------------------*
        // Adicionar ao banco de dados 
        


        // -----------------------*
        atualizarTabela();// Atualiza a tabela

        // Atualiza o banco de dados
    }

}
