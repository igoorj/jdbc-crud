package connection;

public class People {

	private int id;
	private String nome;
	
	public People(int id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}
	
	// getters methods 
	
	int getId() {
		return this.id;
	}
	
	String getNome() {
		return this.nome;
	}
}
