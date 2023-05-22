package br.com.fiap.fila;

import br.com.fiap.entidades.Mensagem;

public class FilaEncadeada {
	private No inicio;
	private No fim;

	private class No {
		Mensagem mensagem;
		No prox;
	}

	public void init() {
		inicio = fim = null;
	}

	public void enqueue(Mensagem msg) {
		No no = new No();
		no.mensagem = msg;
		no.prox = null;
		if (isEmpty()) {
			inicio = no;
		} else {
			fim.prox = no;
		}
		fim = no;

	}
	
	public Mensagem dequeue() {
		Mensagem msg = inicio.mensagem;
		inicio = inicio.prox;
		if(inicio == null)
			fim = null;
		return msg;
	}

	public boolean isEmpty() {
		if (inicio == null && fim == null)
			return true;
		return false;
	}

	public Mensagem first() {
		if(!isEmpty())
			return inicio.mensagem;
		return null;
	}
}
