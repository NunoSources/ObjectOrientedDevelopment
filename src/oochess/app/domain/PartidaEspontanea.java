package oochess.app.domain;

import java.time.LocalDateTime;

public class PartidaEspontanea extends Partida {

	public PartidaEspontanea(String username, LocalDateTime dataHora) {
		super(username, dataHora);
	}

	@Override
	protected void setCodigo(String codigo) { /*Do Nothing*/ }
}
