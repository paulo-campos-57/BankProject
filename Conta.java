package BankProject;

import java.util.Scanner;

public class Conta {
	
	Scanner in = new Scanner(System.in);
	private String numero;
	private String agencia;
	private ProprietarioConta dono;
	private double saldo;
	private double salario;
	private boolean pix;
	
	public String getNumero() {
		return numero;
	}
	
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	public String getAgencia() {
		return agencia;
	}
	
	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}
	
	public ProprietarioConta getDono() {
		return dono;
	}
	
	public void setDono(ProprietarioConta dono) {
		this.dono = dono;
	}
	
	public double getSaldo() {
		return saldo;
	}
	
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	public double getSalario() {
		return salario;
	}
	
	public void setSalario(double salario) {
		this.salario = salario;
	}
	
	public boolean getPix() {
		return pix;
	}
	
	public void setPix(boolean pix) {
		this.pix = pix;
	}
	
	public String consultarSaldo(double saldo) {
		return ("Saldo da conta: " + this.saldo);
	}
}
