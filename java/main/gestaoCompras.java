package site.main;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class gestaoCompras {
	
	public static Boolean apresentacao(boolean d) {
		SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		Date data = new Date();
		if(d == false) {
			System.out.println("Programa iniciado em: " + formatador.format(data));
		}else {
			System.out.println("\nPrograma finalizado em: " + formatador.format(data));
		}
		System.out.println("******* NOSSA TRIP - AGENCIA DE VIAGEM *******\n");
		System.out.println("************ Gestão de Compras ***************");
		System.out.println("Desenhado por Antonio Barboza - RecodePro");
		return d;
	}
	
	public static String menu() {
		Scanner scan = new Scanner(System.in);
		String opcao;
		System.out.println("\n********************************************");
		System.out.println("* DIGITE O NÚMERO OPÇÃO DA OPERAÇÃO DESEJADA *");
		System.out.println("**********************************************");
		System.out.println("*             1 - Registrar                  *");
		System.out.println("*             2 - Listar                     *");
		System.out.println("*             3 - Atualizar                  *");
		System.out.println("*             4 - Deletar                    *");
		System.out.println("*             5 - Sair                       *");
		System.out.println("**********************************************");
		System.out.println(" -> ");
		opcao = scan.nextLine();
		return opcao;
	}
	
	public static void cod() {
		Scanner scan = new Scanner(System.in);
		int fim = 0;
		int i = 0;
		int atu = 0;
		int del = 0;
		int id_cliente = 0;
		char ctz = 'n';
		String nome_cliente;
		String cpf;
		String email;
		String contato;
		String [][] clientes = new String[100][10];
		do {
			switch(menu()) {
			case "1":;
				//Registrar
				System.out.println("\n----------------------------------");
				System.out.println("--          Registrar             --");
				System.out.println("------------------------------------");
				System.out.println("\nNome");
				System.out.println(" -> ");
				nome_cliente = scan.nextLine();
				System.out.println("CPF");
				System.out.println(" -> ");
				cpf = scan.nextLine();
				System.out.println("E-mail");
				System.out.println(" -> ");
				email = scan.nextLine();
				System.out.println("Contato");
				System.out.println(" -> ");
				contato = scan.nextLine();
				id_cliente = i;
				clientes[i][0] = "ID: " + Integer.toString(id_cliente);
				clientes[i][1] = "Nome: " + nome_cliente;
				clientes[i][2] = "CPF: " + cpf;
				clientes[i][3] = "E-mail: " + email;
				clientes[i][4] = "Contato: " + contato;
				i++;
				fim = 1;
				System.out.println("\n-- Resgistrado com sucesso! --\n");
				break;
			case "2":
				//Listar
				System.out.println("\n--------------------------------");
				System.out.println("--     Listagem dos clientes    --");
				System.out.println("--------------------------------\n");
				for (int l = 0; l < clientes.length; l++) {
					for(int c = 0; c < clientes[c].length; c++) {
						if(clientes[l][c] != null) {	
							if(c < 5) {
								System.out.println("- " + clientes[l][c]);
							}
						}else {
							break;
						}
					}
				}
				System.out.println("----------------------------------");
				fim = 2;
				break;
			case "3":
				//Atualizar
				System.out.println("\n---------------------------------");
				System.out.println("-- Informe o ID a ser atualizado --");
				System.out.println("---------------------------------\n");
				System.out.println(" -> ");
				atu = scan.nextInt();
				scan.nextLine();
				if(atu < i) {
					System.out.println("Nome");
					System.out.println(" -> ");
					nome_cliente = scan.nextLine();
					System.out.println("CPF");
					System.out.println(" -> ");
					cpf = scan.nextLine();
					System.out.println("E-mail");
					System.out.println(" -> ");
					email = scan.nextLine();
					System.out.println("Contato");
					System.out.println(" -> ");
					contato = scan.nextLine();
					clientes[atu][0] = "ID: " + Integer.toString(id_cliente);
					clientes[atu][1] = "Nome: " + nome_cliente;
					clientes[atu][2] = "CPF: " + cpf;
					clientes[atu][3] = "Contato: " + contato;
					System.out.println("\n-- Informações atualizadas --\n");
				}else {
					System.out.println("\n--     ID não existente      --");
				}
				fim = 3;
				break;
			case "4":
				//Deletar
				System.out.println("Tem certeza que deseja deletar algum item? \n[S/N]");
				System.out.println(" -> ");
				ctz = scan.next().charAt(0);
				if(ctz == 's' || ctz == 'S') {
					System.out.println("\n-------------------------------");
					System.out.println("-- Informe o ID a ser deletado --");
					System.out.println("-------------------------------\n");
					System.out.println(" -> ");
					del = scan.nextInt();
					scan.nextLine();
					if(
						del < i && clientes[del][0] != null) {
						clientes[del][0] = null;
						clientes[del][1] = null;
						clientes[del][2] = null;
						clientes[del][3] = null;
						System.out.println("\n-- Informações deletadas com sucesso! --\n");
					}else {
						System.out.println("\n--   ID não existente   --");
					}
				}
				fim = 4;
				break;
			case "5":
				fim = 5;
				break;
			default:
				System.out.println("\n-- Digite um número correspondente à operação desejada --");
		}
	}while(fim < 5);
}		

	public static void main(String[] args) {
		apresentacao(false);
		cod();
		apresentacao(true);
	}

}
