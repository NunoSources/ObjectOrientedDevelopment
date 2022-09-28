package oochess.app.domain;

import java.time.LocalDateTime;

public abstract class Partida {

	private LocalDateTime datahora;
	private String msg;
	private String usernameAdversario;
	private String result;
	
	protected Partida(String username, LocalDateTime datahora) {
		this.usernameAdversario = username;
		this.datahora = datahora;
	}

	public String getAdversario() {
		return usernameAdversario;
	}
	
	public String getCodigo() {
		return null;
	}
	
	public String getMessage() {
		return this.msg;
	}
	
	public String getResultado() {
		return this.result;
	}
	
	public LocalDateTime getDataHora() {
		return this.datahora;
	}
	

	public void registaResultado(String resultado) {
		if(!resultado.equals("VITORIA") && !resultado.equals("EMPATE") && !resultado.equals("DERROTA")) {
			System.out.println("O Resultado eh invalido");
		}else {
			this.result = resultado;
		}
	}

	protected abstract void setCodigo(String codigo);
	

}
