package connection;

import java.util.Scanner;
import java.sql.Connection;
import java.sql.Statement;
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
		
		String sql = "SELECT * FROM pessoas WHERE nome LIKE '%"+nome+"%'";
		
		Statement stmt = connection.createStatement();		
		ResultSet resultado = stmt.executeQuery(sql);
		
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
