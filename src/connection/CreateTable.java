package connection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable {
	
	public static void main(String[] args) throws SQLException {
		
		Connection connection = ConnectionDB.getConnection();
		
		String sql = "CREATE TABLE IF NOT EXISTS pessoas ("
					+ "id INT AUTO_INCREMENT PRIMARY KEY,"
					+ "nome VARCHAR(45) NOT NULL"
					+ ");";
		
		Statement stmt = connection.createStatement();
		stmt.execute(sql);
		
		System.out.println("Tabela criada com sucesso!");
		connection.close();
	}

}
