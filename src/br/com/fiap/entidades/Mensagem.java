package br.com.fiap.entidades;

public class Mensagem {
	private String mensagem;
	private MensagemStatus mensagemStatus;
	
	public enum MensagemStatus {
		RECLAMACAO,
		SUGESTAO
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
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return getMensagemStatus()+ " - " +getMensagem();
	}
}
