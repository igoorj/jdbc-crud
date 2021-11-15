package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {

	public static Connection getConnection() {
		
		try {
			
			/*
			 * Credenciais de conexão com o banco de dados
			 * */
			
			final String url = "jdbc:mysql://localhost/jdbc_crud?verifyServerCertificate=false&useSSL=true";
			final String user = "root";
			final String password = "admin";
			
			/*
			 * Retornando uma instância de conexão com o banco de dados
			 * */
			return DriverManager.getConnection(url, user, password);
			
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
