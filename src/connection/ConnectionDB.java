package connection;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionDB {

	public static Connection getConnection() {
		
		try {
			
			/*
			 * Credenciais de conexão com o banco de dados
			 * */
			
			Properties prop = getProperties();
			
			final String url = prop.getProperty("banco.url");
			final String user = prop.getProperty("banco.user");
			final String password = prop.getProperty("banco.password");
			
			/*
			 * Retornando uma instância de conexão com o banco de dados
			 * */
			return DriverManager.getConnection(url, user, password);
			
		} catch(SQLException | IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	private static Properties getProperties() throws IOException {
		Properties prop = new Properties();
		String path = "/connection.properties";
		prop.load(ConnectionDB.class.getResourceAsStream(path));
		return prop;
	}
}
