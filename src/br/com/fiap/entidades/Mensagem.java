package br.com.fiap.entidades;

public class Mensagem {
	private int idMensagem;
	private String mensagem;
	private MensagemStatus mensagemStatus;
	
	public enum MensagemStatus {
		RECLAMACAO,
		SUGESTAO
	}

	public int getIdMensagem() {
		return idMensagem;
	}

	public void setIdMensagem(int idMensagem) {
		this.idMensagem = idMensagem;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public MensagemStatus getMensagemStatus() {
		return mensagemStatus;
	}

	public void setMensagemStatus(MensagemStatus mensagemStatus) {
		this.mensagemStatus = mensagemStatus;
	}
	
	
}
