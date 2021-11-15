package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import connection.ConnectionDB;

public class CreateDB {
public static void main(String[] args) throws SQLException {

		/*
		 * Instância de conexão com o banco de dados
		 * */
		Connection connection = ConnectionDB.getConnection();
		
		/*
		 * Criando um novo banco de dados
		 * */
		Statement stmt = connection.createStatement();
		stmt.execute("CREATE DATABASE IF NOT EXISTS jdbc_crud");
		
		System.out.println("Banco criado novamente com sucesso!");
		connection.close();
	}
}
