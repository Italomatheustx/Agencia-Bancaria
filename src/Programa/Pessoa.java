package Programa;

public class Pessoa {
	
	private static int counter = 1;
	
	private String  nome;
	private String  cpf;
	private String email;
	
	public Pessoa(String nome, String cPF, String email) {
		super();
		this.nome = nome;
		this.cpf = cPF;
		this.email = email;
		counter += 1;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCPF() {
		return cpf;
	}
	public void setCPF(String cPF) {
		this.cpf = cPF;
	}
	public String getEmail() {
		return email;
	}
	public void getEmail(String email) {
		this.email = email;
	}
	
	public String toString() {
		return "\nNome: " + this.getNome() +
				"\nCPF: " + this.getCPF() +
				"\nCPF: " + this.getEmail();
	}
	

}
