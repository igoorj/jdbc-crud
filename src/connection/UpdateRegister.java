package connection;

import java.util.Scanner;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.ArrayList;
import java.sql.ResultSet;

public class UpdateRegister {
	
	public static void main(String[] args) throws SQLException {
	
	Scanner input = new Scanner(System.in);
	System.out.println("Digite o nome desejado: ");
	String nomeBuscado = input.nextLine();
	
	// criando a instancia de conexão
	Connection connection = ConnectionDB.getConnection();
	
	// filtrar o nome da pessoa
	String sqlSearch = "SELECT * FROM pessoas WHERE nome = ?";
	PreparedStatement stmt = connection.prepareStatement(sqlSearch);
	stmt.setString(1, nomeBuscado);
	ResultSet resultado = stmt.executeQuery();
	
	// lista de resultados
	List<People> people = new ArrayList<>();
	while(resultado.next()) {
		int id = resultado.getInt("id");
		String nome = resultado.getString("nome");
		people.add(new People(id, nome));
	}
	
	int idBuscado;
	if(people.size() == 0) {
		System.out.println("Nenhum registro encontrado!");
		return;
	} else {
		
		System.out.println("Exibindo resultados!");
		for(People p: people) {
			idBuscado = p.getId();
			System.out.println(p.getId() +": "+ p.getNome());
		
			// Fazer a atualização do nome desta pessoa
			System.out.println("Digite o novo nome: ");
			String novoNome = input.nextLine();
			
			// enviar a atualização para o banco de dados
			String sqlUpdate = "UPDATE pessoas SET nome = ? WHERE id = ?";
			PreparedStatement stmt2 = connection.prepareStatement(sqlUpdate);
			stmt2.setString(1, novoNome);
			stmt2.setInt(2, idBuscado);
			stmt2.execute();
		
			System.out.println("Usuario atualizado com sucesso!");
		}	
	}
	
	input.close();
	connection.close();
	}
}
