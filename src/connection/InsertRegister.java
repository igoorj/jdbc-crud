package connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertRegister {

	public static void main(String[] args) throws SQLException {
		
		/*
		 * Interação via terminal com Scanner
		 * */
		Scanner input = new Scanner(System.in);
		
		System.out.println("Digite um novo nome: ");
		String nome = input.nextLine();
		
		/*
		 * Instância de conexão
		 * */
		Connection connection = ConnectionDB.getConnection();
		
		/*
		 * Query protegida de SQL Injection
		 * */
		String sql = "INSERT INTO pessoas (nome) VALUES (?)";
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setString(1, nome);
		stmt.execute();
		
		System.out.println("Cadastro realizado com sucesso!");
		input.close();
	}
}
