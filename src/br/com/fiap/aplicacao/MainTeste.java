package br.com.fiap.aplicacao;

import br.com.fiap.entidades.Mensagem;
import br.com.fiap.fila.FilaEncadeada;

public class MainTeste {

	public static void main(String[] args) {
		FilaEncadeada filaEncadeada = new FilaEncadeada();
		filaEncadeada.init();
		
		for (int i = 1; i <= 10; i++) {
			Mensagem msg = new Mensagem();
			msg.setIdMensagem(i);
			filaEncadeada.enqueue(msg);
		}
		while(!filaEncadeada.isEmpty()) {
			Mensagem msg = filaEncadeada.dequeue();
			System.out.println(msg.getIdMensagem());
		}
	}

}
