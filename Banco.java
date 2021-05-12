package BankProject;

import java.util.Scanner;

public class Banco {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		ProprietarioConta cliente = new ProprietarioConta();
		System.out.println("Bem vindo ao IBank, para continuar seu cadastro preencha as informações a seguir: ");
		System.out.print("Digite aqui seu nome: ");
		cliente.setNome(in.nextLine());
		System.out.print("Digite aqui o seu sobrenome: ");
		cliente.setSobrenome(in.next());
		System.out.print("Digite aqui o seu CPF: ");
		cliente.setCpf(in.next());
		System.out.print("Digite aqui sua idade: ");
		cliente.setIdade(in.nextInt());
		
		System.out.println("\n--------------------------------------------------------------------------------");
		Endereco end = new Endereco();
		System.out.println("Excelente " + cliente.getNome() + "! Agora preencha os dados de seu endereço: ");
		System.out.print("Digite aqui o seu CEP: ");
		end.setCep(in.next());
		System.out.print("Digite aqui o estado em que você reside: ");
		end.setEstado(in.next());
		System.out.print("Digite aqui a cidade em que você reside: ");
		end.setCidade(in.next());
		in.nextLine();//esvaziar o buffer para testes.
		System.out.print("Digite aqui a rua em que você reside: ");
		end.setRua(in.nextLine());  //Corrigido
		System.out.print("Digite aqui o número de sua residência: ");
		end.setNumero(in.next());
		System.out.print("Digite aqui um complemento de seu endereço (digite '-' caso não haja um): ");
		end.setComplemento(in.next());  //Corrigido
		in.nextLine();//esvaziar o buffer para testes.
		cliente.setEnd(end);
		
		System.out.println("\n--------------------------------------------------------------------------------");
		Conta conta = new Conta();
		conta.setDono(cliente);
		System.out.println("Quase tudo pronto, agora você só precisa cadastrar sua conta! Preencha as informações abaixo:");
		System.out.print("Digite aqui o número de sua conta: ");
		conta.setNumero(in.next());
		System.out.print("Digite aqui a agência de sua conta: ");
		conta.setAgencia(in.next());
		System.out.print("Digite aqui o valor que deseja aplicar na conta: ");
		conta.setSaldo(in.nextDouble());
		System.out.print("Digite aqui o valor do seu salário mensal: ");
		conta.setSalario(in.nextDouble());
		System.out.print("Deseja que sua conta aceite pix? (1-Sim/0-Não): ");
		int op = in.nextInt();
		if(op==1) {
			conta.setPix(true);
		}else {
			conta.setPix(false);
		}
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		
		int i = 1;
		CartaoCredito cartaoC = new CartaoCredito();
		CartaoDebito cartaoD = new CartaoDebito();
		boolean cartaoCredito = false;
		boolean cartaoDebito = false;
		while (i != 0) {
			if (conta.getPix() == false) {
				System.out.println("----------------------------MENU----------------------------");
				System.out.println("1 - Consultar dados do usuário");
				System.out.println("2 - Consultar dados da conta");
				System.out.println("3 - Consultar saldo");
				System.out.println("4 - Solicitar cartão de crédito");
				System.out.println("5 - Solicitar cartão de Débito");
				System.out.println("6 - Pagamento utilizando cartão");
				System.out.println("7 - Realizar depósito");
				System.out.println("8 - Realizar saque");
				System.out.println("0 - Sair");
				System.out.println("Selecione uma das opções e tecle ENTER");
				i = in.nextInt();
				System.out.println("--------------------------------------------------------------------------------");
				System.out.println("");
				System.out.println("");
				System.out.println("");
				System.out.println("");
				switch(i) {
					case 1:
						System.out.println("Informações sobre o proprietário da conta:");
						System.out.println("Nome completo: " + cliente.getNome() + " " + cliente.getSobrenome());
						System.out.println("CPF: " + cliente.getCpf());
						System.out.println("Idade: " + cliente.getIdade());
						System.out.println("CEP: " + cliente.getEnd().getCep());
						System.out.println("Estado: " + cliente.getEnd().getEstado());
						System.out.println("Cidade: " + cliente.getEnd().getCidade());
						System.out.println("Rua: " + cliente.getEnd().getRua());
						System.out.println("Número: " + cliente.getEnd().getNumero());
						System.out.println("Complemento: " + cliente.getEnd().getComplemento());
						break;
					case 2:
						System.out.println("Informações da conta:");
						System.out.println("Proprietário da conta: " + conta.getDono().getNome() + " " + conta.getDono().getSobrenome());
						System.out.println("Número da conta: " + conta.getNumero());
						System.out.println("Agência da conta: " + conta.getAgencia());
						System.out.println("Salário mensal aplicado na conta: " + conta.getSalario());
						if (conta.getPix() == true) {
							System.out.println("A conta aceita Pix.");
						}else {
							System.out.println("A conta não aceita Pix.");
						}
						break;
					case 3:
						System.out.println(conta.consultarSaldo(conta.getSaldo()));
						break;
					case 4:
						System.out.println("Cadastrar Cartão de crédito no sistema:");
						cartaoC.setInfo(conta);
						System.out.print("Digite aqui o número do cartão: ");
						cartaoC.setNumero(in.nextInt());
						System.out.print("Digite a senha que deseja aplicar no cartão (4 dígitos): ");
						cartaoC.setSenha(in.nextInt());
						double lim = (conta.getSalario() / 40);
						cartaoC.setLimite(lim);
						System.out.println("O limite mensal do cartão é: " + cartaoC.getLimite());
						cartaoCredito = true;
						break;
					case 5:
						System.out.println("Cadastrar Cartão de crédito no sistema:");
						cartaoD.setInfo(conta);
						System.out.print("Digite aqui o número do cartão: ");
						cartaoD.setNumero(in.nextInt());
						System.out.print("Digite a senha que deseja aplicar no cartão (4 dígitos): ");
						cartaoD.setSenha(in.nextInt());
						cartaoDebito = true;
						break;
					case 6:
						System.out.println("Selecione o tipo de cartão que deseja usar no pagamento:");
						System.out.println("(1 - Cartão de Crédito/2 - Cartão de Débito)");
						int card = in.nextInt();
						if (card == 1) {
							if(cartaoCredito == false) {
								System.out.println("Não há cartões de crédito registrados nessa conta.");
							}else {
								int confirma = 0;
								while(confirma != 1) {
									System.out.print("Informe o número da conta que deseja fazer a transferência: ");
									int numContaP = in.nextInt();
									System.out.print("Informe a agência da conta que deseja fazer a transferência: ");
									int agenciaContaP = in.nextInt();
									System.out.print("Informe o valor da transferência: ");
									double valorT = in.nextDouble();
									if(valorT > cartaoC.getLimite()) {
										System.out.println("Essa transferência não pode ser realizada.");
										System.out.println("O valor ultrapassa o limite de R$" + cartaoC.getLimite());
										System.out.println("");
										System.out.println("Deseja fazer outra transferência? (0-Sim/1-Não)");
										confirma = in.nextInt();
									}else {
										System.out.println("Confirme as informações da transferência:");
										System.out.println("Número da conta destino: " + numContaP);
										System.out.println("Agência da conta destino: " + agenciaContaP);
										System.out.println("Valor da transferência: " + valorT);
										System.out.println("");
										System.out.println("Digite 1 para confirmar, caso haja alguma informação incorreta, digite 0 para preencher novamente:");
										confirma = in.nextInt();
									}
								}
							}
						}else if (card == 2) {
							if(cartaoDebito == false) {
								System.out.println("Não há cartões de débito registrados nessa conta.");
							}else {
								int confirma = 0;
								while(confirma != 1) {
									System.out.print("Informe o número da conta que deseja fazer a transferência: ");
									int numContaP = in.nextInt();
									System.out.print("Informe a agência da conta que deseja fazer a transferência: ");
									int agenciaContaP = in.nextInt();
									System.out.print("Informe o valor da transferência: ");
									double valorT = in.nextDouble();
									if(valorT > cartaoD.getInfo().getSaldo()) {
										System.out.println("Essa transferência não pode ser realizada.");
										System.out.println("O valor ultrapassa o saldo da conta de R$" + cartaoD.getInfo().getSaldo());
										System.out.println("");
										System.out.println("Deseja fazer outra transferência? (0-Sim/1-Não)");
										confirma = in.nextInt();
									}else {
										System.out.println("Confirme as informações da transferência:");
										System.out.println("Número da conta destino: " + numContaP);
										System.out.println("Agência da conta destino: " + agenciaContaP);
										System.out.println("Valor da transferência: " + valorT);
										System.out.println("");
										System.out.println("Digite 1 para confirmar, caso haja alguma informação incorreta, digite 0 para preencher novamente:");
										confirma = in.nextInt();
									}
								}
							}
						}else {
							System.out.println("Opção inválida.");
						}
						break;
					case 7:
						System.out.print("Digite aqui o valor que deseja depositar na conta: ");
						double deposito = in.nextDouble();
						double valorDeposito;
						valorDeposito = conta.getSaldo() + deposito;
						conta.setSaldo(valorDeposito);
						System.out.println("Depósito efetuado com sucesso!");
						System.out.println("O valor do saldo após o depósito é: " + conta.getSaldo());
						break;
					case 8:
						System.out.print("Digite aqui o valor que deseja sacar: ");
						double saque = in.nextDouble();
						if(saque > conta.getSaldo()) {
							System.out.println("O valor do saque é maior que o saldo presente na conta.");
							System.out.println("Não é possível realizar a operação.");
						}else {
							double valorSaque;
							valorSaque = conta.getSaldo() - saque;
							conta.setSaldo(valorSaque);
							System.out.println("Operação realizada com sucesso.");
							System.out.println("O valor atual do saldo é de: " + conta.getSaldo());
						}
						break;
				}
			}else {
				System.out.println("----------------------------MENU----------------------------");
				System.out.println("1 - Consultar dados do usuário");
				System.out.println("2 - Consultar dados da conta");
				System.out.println("3 - Consultar saldo");
				System.out.println("4 - Solicitar cartão de crédito");
				System.out.println("5 - Solicitar cartão de Débito");
				System.out.println("6 - Pagamento utilizando cartão");
				System.out.println("7 - Realizar depósito");
				System.out.println("8 - Realizar saque");
				System.out.println("9 - Pagamento via Pix");
				System.out.println("0 - Sair");
				System.out.println("Selecione uma das opções e tecle ENTER");
				i = in.nextInt();
				System.out.println("--------------------------------------------------------------------------------");
				System.out.println("");
				System.out.println("");
				System.out.println("");
				System.out.println("");
				switch(i) {
					case 1:
						System.out.println("Informações sobre o proprietário da conta:");
						System.out.println("Nome completo: " + cliente.getNome() + " " + cliente.getSobrenome());
						System.out.println("CPF: " + cliente.getCpf());
						System.out.println("Idade: " + cliente.getIdade());
						System.out.println("CEP: " + cliente.getEnd().getCep());
						System.out.println("Estado: " + cliente.getEnd().getEstado());
						System.out.println("Cidade: " + cliente.getEnd().getCidade());
						System.out.println("Rua: " + cliente.getEnd().getRua());
						System.out.println("Número: " + cliente.getEnd().getNumero());
						System.out.println("Complemento: " + cliente.getEnd().getComplemento());
						break;
					case 2:
						System.out.println("Informações da conta:");
						System.out.println("Proprietário da conta: " + conta.getDono().getNome() + " " + conta.getDono().getSobrenome());
						System.out.println("Número da conta: " + conta.getNumero());
						System.out.println("Agência da conta: " + conta.getAgencia());
						System.out.println("Salário mensal aplicado na conta: " + conta.getSalario());
						if (conta.getPix() == true) {
							System.out.println("A conta aceita Pix.");
						}else {
							System.out.println("A conta não aceita Pix.");
						}
						break;
					case 3:
						System.out.println(conta.consultarSaldo(conta.getSaldo()));
						break;
					case 4:
						System.out.println("Cadastrar Cartão de crédito no sistema:");
						cartaoC.setInfo(conta);
						System.out.print("Digite aqui o número do cartão: ");
						cartaoC.setNumero(in.nextInt());
						System.out.print("Digite a senha que deseja aplicar no cartão (4 dígitos): ");
						cartaoC.setSenha(in.nextInt());
						double lim = (conta.getSalario() / 40);
						cartaoC.setLimite(lim);
						System.out.println("O limite mensal do cartão é: " + cartaoC.getLimite());
						cartaoCredito = true;
						break;
					case 5:
						System.out.println("Cadastrar Cartão de crédito no sistema:");
						cartaoD.setInfo(conta);
						System.out.print("Digite aqui o número do cartão: ");
						cartaoD.setNumero(in.nextInt());
						System.out.print("Digite a senha que deseja aplicar no cartão (4 dígitos): ");
						cartaoD.setSenha(in.nextInt());
						cartaoDebito = true;
						break;
					case 6:
						System.out.println("Selecione o tipo de cartão que deseja usar no pagamento:");
						System.out.println("(1 - Cartão de Crédito/2 - Cartão de Débito)");
						int card = in.nextInt();
						if (card == 1) {
							if(cartaoCredito == false) {
								System.out.println("Não há cartões de crédito registrados nessa conta.");
							}else {
								int confirma = 0;
								double valorF = 0;
								while(confirma != 1) {
									System.out.print("Informe o número da conta que deseja fazer a transferência: ");
									int numContaP = in.nextInt();
									System.out.print("Informe a agência da conta que deseja fazer a transferência: ");
									int agenciaContaP = in.nextInt();
									System.out.print("Informe o valor da transferência: ");
									double valorT = in.nextDouble();
									if(valorT > cartaoC.getLimite()) {
										System.out.println("Essa transferência não pode ser realizada.");
										System.out.println("O valor ultrapassa o limite de R$" + cartaoC.getLimite());
										System.out.println("");
										System.out.println("Deseja fazer outra transferência? (0-Sim/1-Não)");
										confirma = in.nextInt();
									}else {
										System.out.println("Confirme as informações da transferência:");
										System.out.println("Número da conta destino: " + numContaP);
										System.out.println("Agência da conta destino: " + agenciaContaP);
										System.out.println("Valor da transferência: " + valorT);
										System.out.println("");
										System.out.println("Digite 1 para confirmar, caso haja alguma informação incorreta, digite 0 para preencher novamente:");
										confirma = in.nextInt();
										if (confirma == 1) {
											valorF = valorT;
										}
									}
									double valor = conta.getSaldo() - valorF;
									conta.setSaldo(valor);
								}
							}
						}else if (card == 2) {
							if(cartaoDebito == false) {
								System.out.println("Não há cartões de débito registrados nessa conta.");
							}else {
								int confirma = 0;
								double valorF = 0;
								while(confirma != 1) {
									System.out.print("Informe o número da conta que deseja fazer a transferência: ");
									int numContaP = in.nextInt();
									System.out.print("Informe a agência da conta que deseja fazer a transferência: ");
									int agenciaContaP = in.nextInt();
									System.out.print("Informe o valor da transferência: ");
									double valorT = in.nextDouble();
									if(valorT > cartaoD.getInfo().getSaldo()) {
										System.out.println("Essa transferência não pode ser realizada.");
										System.out.println("O valor ultrapassa o saldo da conta de R$" + cartaoD.getInfo().getSaldo());
										System.out.println("");
										System.out.println("Deseja fazer outra transferência? (0-Sim/1-Não)");
										confirma = in.nextInt();
									}else {
										System.out.println("Confirme as informações da transferência:");
										System.out.println("Número da conta destino: " + numContaP);
										System.out.println("Agência da conta destino: " + agenciaContaP);
										System.out.println("Valor da transferência: " + valorT);
										System.out.println("");
										System.out.println("Digite 1 para confirmar, caso haja alguma informação incorreta, digite 0 para preencher novamente:");
										confirma = in.nextInt();
										if (confirma == 1) {
											valorF = valorT;
										}
									}
									double valor = conta.getSaldo() - valorF;
									conta.setSaldo(valor);
								}
							}
						}else {
							System.out.println("Opção inválida.");
						}
						break;
					case 7:
						System.out.print("Digite aqui o valor que deseja depositar na conta: ");
						double deposito = in.nextDouble();
						double valorDeposito;
						valorDeposito = conta.getSaldo() + deposito;
						conta.setSaldo(valorDeposito);
						System.out.println("Depósito efetuado com sucesso!");
						System.out.println("O valor do saldo após o depósito é: " + conta.getSaldo());
						break;
					case 8:
						System.out.print("Digite aqui o valor que deseja sacar: ");
						double saque = in.nextDouble();
						if(saque > conta.getSaldo()) {
							System.out.println("O valor do saque é maior que o saldo presente na conta.");
							System.out.println("Não é possível realizar a operação.");
						}else {
							double valorSaque;
							valorSaque = conta.getSaldo() - saque;
							conta.setSaldo(valorSaque);
							System.out.println("Operação realizada com sucesso.");
							System.out.println("O valor atual do saldo é de: " + conta.getSaldo());
						}
						break;
					case 9:
						int confirma = 0;
						double valorF = 0;
						while(confirma != 1) {
							System.out.print("Digite aqui o número do Pix que deseja realizar a transferência: ");
							int numPix = in.nextInt();
							System.out.print("Digite aqui o valor que deseja transferir: ");
							double valorPix = in.nextDouble();
							if (valorPix > conta.getSaldo()) {
								System.out.println("Não é possível realizar esta transferência.");
								System.out.println("O valor excede o seu saldo de: " + conta.getSaldo());
								System.out.println("Deseja fazer outra transferência? (0-Sim/1-Não)");
								confirma = in.nextInt();
							}else {
								System.out.println("Confirme as informações abaixo:");
								System.out.println("Número do Pix: " + numPix);
								System.out.println("Valor da transferência: R$ " + valorPix);
								System.out.println("Digite 1 para confirmar, caso haja alguma informaçao incorreta, digite 0:");
								confirma = in.nextInt();
								if (confirma == 1) {
									valorF = valorPix;
								}
							}
							double valor = conta.getSaldo() - valorF;
							conta.setSaldo(valor);
						}
						break;
				}
			}

		}
		
		in.close();
	}
}
