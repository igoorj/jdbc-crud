package connection;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class DeleteRegister {

	public static void main(String[] args) throws SQLException {
		
		System.out.println("Informe o id a ser deletado: ");
		Scanner input = new Scanner(System.in);
		int idBuscado = input.nextInt();
		
		Connection connection = ConnectionDB.getConnection();
		
		String sql = "DELETE FROM pessoas WHERE id = ?";
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setInt(1, idBuscado);
		int success = stmt.executeUpdate();
		
		if(success != 0) {
			System.out.println("Usuário deletado com sucesso!");
			
		} else {
			System.out.println("Nenhum registro deletado!");
		}
		
		connection.close();
		input.close();
	}
}
