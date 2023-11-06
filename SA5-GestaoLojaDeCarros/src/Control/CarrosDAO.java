package Control;

import java.sql.Connection;

import Connection.ConnectionFactory;

public class CarrosDAO {
    // Códigos para o banco de dados
    private Connection connection;

    // Construtor
    public CarrosDAO(Connection connection) {
        this.connection = ConnectionFactory.getConnection();
    }

    



    
}
