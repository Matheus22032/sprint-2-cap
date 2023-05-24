package br.com.fiap.aplicacao;

import java.util.Scanner;

import br.com.fiap.entidades.Mensagem;
import br.com.fiap.entidades.Mensagem.MensagemStatus;
import br.com.fiap.fila.FilaEncadeada;

public class Aplicacao {

	public static void main(String[] args) throws InterruptedException {
		FilaEncadeada filaEncadeada = new FilaEncadeada();
		filaEncadeada.init();
		Scanner input = new Scanner(System.in);

		menu(filaEncadeada, input);
	}

	public static void menu(FilaEncadeada fila, Scanner input) throws InterruptedException {
		int opcao;
		while (true) {
			System.out.println("");
			System.out.println("Deseja enviar um mensagem para a fila de espera para escrita no banco de dados ? (1)");
			System.out.println("Deseja escrever uma mensagem no banco de dados ? (2)");
			System.out.println("Deseja escrever todas as mensagens da fila no banco de dados ? (3)");
			System.out.println("Deseja encerrar o programa ? (4)");
			opcao = input.nextInt();
			switch (opcao) {
			case 1: {
				enviarParaFila(fila, input);
				break;
			}
			case 2: {
				if (!fila.isEmpty()) {
					System.out.println("");
					System.out.println("Escrevendo...");
					Thread.sleep(1000);
					System.out.println("Mesagem escrita: " + fila.dequeue());
					System.out.println("");
				} else
					System.out.println("A fila está vazia!!");
				break;
			}
			case 3: {
				if (!fila.isEmpty()) {
					while(!fila.isEmpty()) {
						System.out.println("");
					System.out.println("Escrevendo...");
					Thread.sleep(1000);
					System.out.println("Mesagem escrita: " + fila.dequeue());
					System.out.println("");
					}
				} else
					System.out.println("A fila está vazia!!");
				break;
			}
			case 4: {
				if (fila.isEmpty()) {
					System.err.println("Encerrando o programa...");
					System.exit(0);
				} else {
					System.out.println("Ainda há mensagens a serem escritas no banco de dados!!!");
					System.out.println("");
				}
				break;
			}
			default:
				System.out.println("Opção invalida!!!");
				break;
			}

		}

	}

	public static void enviarParaFila(FilaEncadeada fila, Scanner input) {
		Mensagem msg = new Mensagem();
		int avaliacao = 0;
		input.nextLine();
		System.out.print("Digite a mensagem :");
		msg.setMensagem(input.nextLine());
		while (avaliacao == 0) {
			System.out.println("Digite o tipo da mensagem (1- Reclamação/2- Sugestão)");
			avaliacao = input.nextInt();
			switch (avaliacao) {
			case 1: {
				msg.setMensagemStatus(MensagemStatus.RECLAMACAO);
				break;
			}
			case 2: {
				msg.setMensagemStatus(MensagemStatus.SUGESTAO);
				break;
			}
			default:
				System.out.println("Opção invalida");
				avaliacao = 0;
				break;
			}
		}
		fila.enqueue(msg);
	}

}
