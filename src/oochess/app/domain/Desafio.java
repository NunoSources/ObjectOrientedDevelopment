package oochess.app.domain;

import java.time.LocalDateTime;

public class Desafio extends Partida{

	private String codigo;
	
	public Desafio(LocalDateTime datahora , String username) {
		super(username, datahora);
	}
	
	public void setCodigo(String codigo) {
		this.codigo= codigo;
	}
	
	@Override
	public String getCodigo() {
		return this.codigo;
	}	
	
}
