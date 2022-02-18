package Programa;

import java.util.ArrayList;
import java.util.Scanner;

public class AgenciaBancaria {
	
	
	static Scanner entrada = new Scanner(System.in);
	static ArrayList<Conta> contasBancarias;
	public static void main(String[] args) {
	
		contasBancarias = new ArrayList<Conta>();
		operacoes();
	}
	
	public static void operacoes() {
		
		System.out.println("☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰");
		System.out.println("―――――――――――――――――――― Seja Bem Vindo ――――――――――――――――――――");
		System.out.println("☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰");
		System.out.println("┈┈┈┈┈ Qual dessas operações você pretende realizar? ┈┈┈┈");
		System.out.println("☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰");
		System.out.println("->                 Opção 1 - Criar Conta              <-");
		System.out.println("->                 Opção 2 - Depositar                <-");
		System.out.println("->                 Opção 3 - Sacar                    <-");
		System.out.println("->                 Opção 4 - Tranferir                <-");
		System.out.println("->                 Opção 5 - Listar                   <-");
		System.out.println("->                 Opção 6 - Sair                     <-");
		
		int operacao = entrada.nextInt();
		
		switch(operacao) {
		case 1:
			criarConta();
			break;
		case 2:
			Depositar();
			break;
		case 3:
			Sacar();
			break;
		case 4:
			Transferir();
			break;
		case 5:
			listarContas();
			break;
		case 6:
			System.out.println("A operação foi realizado com sucesso");
			System.exit(0);
			
			default:
				System.out.println("Opção inválida!");
				operacoes();
				break;
		}
	}
	
	public static void criarConta() {
		
		System.out.println("\nNome: ");
		String nome = entrada.next();
		
		System.out.println("\nDigita o seu CPF: ");
		String cpf = entrada.next();
		
		System.out.println("\nEmail: ");
		String email = entrada.next();
		
		Pessoa pessoa = new Pessoa(nome, cpf, email);
		
		Conta conta = new Conta(pessoa);
		contasBancarias.add(conta);
		System.out.println("Sua conta foi criada com sucesso!");
		
		operacoes();
		
	}
	
	private static Conta encontrarConta(int numeroConta) {
		Conta conta = null;
		if(contasBancarias.size() > 0) {
			for(Conta c: contasBancarias) {
				if(c.getNumeroConta() == numeroConta);
				conta = c;
			}
		}
		return conta;
	}
	
	public static void Depositar() {
		System.out.println("Número da conta: ");
		int numeroConta = entrada.nextInt();
		
		Conta conta = encontrarConta(numeroConta);
		
		if(conta != null) {
			System.out.println("Qual valor deseja depositar? ");
			Double valorDeposito = entrada.nextDouble();
			conta.depositar(valorDeposito);
			System.out.println(" Valor depositado com sucesso! ");
		} else {
			System.out.println(" Conta não encontrada! ");
		}
		operacoes();
		}
	
	public static void Sacar() {
		System.out.println("Número da conta: ");
        int numeroConta = entrada.nextInt();
		
		Conta conta = encontrarConta(numeroConta);
		
		if(conta != null) {
			System.out.println("Qual valor deseja sacar? ");
			Double valorSaque = entrada.nextDouble();
			conta.sacar(valorSaque);
			// System.out.println(" Valor Sacado com sucesso! ");
		} else {
			System.out.println(" Conta não encontrada! ");
		}
		operacoes();
	}
	
	public static void Transferir() {
		System.out.println("Numero da conta do remetente: ");
		int numeroContaRemetente = entrada.nextInt();
		
		Conta contaRemetente = encontrarConta(numeroContaRemetente);
		
		if(contaRemetente != null) {
			System.out.println("Número da conta do destinatário: ");
			int numeroContaDestinatario = entrada.nextInt();
			
			Conta contaDestinatario = encontrarConta(numeroContaDestinatario);
			
			if(contaDestinatario != null) {
				System.out.println("Valor da transferência");
				Double valor = entrada.nextDouble();
				
				contaRemetente.transferir(contaDestinatario, valor);
			}
	     }
		operacoes();
	}
	
	public static void listarContas() {
		if(contasBancarias.size() > 0) {
			for(Conta conta: contasBancarias) {
				System.out.println(conta);
			} 	
		}else {
				System.out.println("Não há contas cadastradas!");	
		}
		operacoes();
	}
}
		
	


