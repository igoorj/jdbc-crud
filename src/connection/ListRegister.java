package connection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;

public class ListRegister {

	public static void main(String[] args) throws SQLException {
		
		Connection connection = ConnectionDB.getConnection();
		
		String sql = "SELECT * FROM pessoas";
		
		Statement stmt = connection.createStatement();
		ResultSet resultado = stmt.executeQuery(sql); // retorna um resultSet
		
		List<People> people = new ArrayList<>();
		
		while(resultado.next()) { 					   // enquanto houver registros
			int id = resultado.getInt("id"); 		   // recuperando pelo nome da coluna "id"
			String nome = resultado.getString("nome"); // recuperando pelo nome da coluna "nome"
			
			people.add(new People(id, nome));
		}
		
		for(People p: people) {
			System.out.println(p.getId() +": "+ p.getNome());
		}
		connection.close();
	}
}
