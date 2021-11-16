package connection;

import java.util.Scanner;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;

public class FilterRegister {

	// SELECT * FROM pessoas WHERE nome LIKE '%...%';
	
	public static void main(String[] args) throws SQLException {
		
		System.out.println("Pesquisar por nome: ");
		Scanner input = new Scanner(System.in);
		String nome = input.nextLine();
		
		Connection connection = ConnectionDB.getConnection();
		
		String sql = "SELECT * FROM pessoas WHERE nome LIKE ?";
		
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setString(1, "%"+nome+"%");
		ResultSet resultado = stmt.executeQuery();
		
		List<People> people = new ArrayList<>();
		
		while(resultado.next()) {
			int id = resultado.getInt("id");
			String nomeRegistro = resultado.getString("nome");
			
			people.add(new People(id, nomeRegistro));
		}
		
		for(People p: people) {
			System.out.println(p.getId() +": "+ p.getNome());
		}
		
		input.close();
		connection.close();
	}
}
