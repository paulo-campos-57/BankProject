package BankProject;

public class CartaoDebito {

	private Conta info;
	private int numero;
	private int senha;
	
	public Conta getInfo() {
		return info;
	}
	
	public void setInfo(Conta info) {
		this.info = info;
	}
	
	public int getNumero() {
		return numero;
	}
	
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	public int getSenha() {
		return senha;
	}
	
	public void setSenha(int senha) {
		this.senha = senha;
	}
}
