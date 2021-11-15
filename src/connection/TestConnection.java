package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestConnection {

	public static void main(String[] args) throws SQLException {
		
		/*
		 * Credenciais de conexão com o banco de dados
		 * */
		final String url = "jdbc:mysql://localhost?verifyServerCertificate=false&useSSL=true";
		final String user = "root";
		final String password = "admin";
		
		/*
		 * Instância de conexão com o banco de dados
		 * */
		Connection connection = DriverManager.getConnection(url, user, password);
		
		System.out.println("Conexao realizada com sucesso!");
		connection.close();
	}
}
