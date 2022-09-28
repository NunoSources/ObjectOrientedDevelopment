package oochess.app.facade;

import oochess.app.domain.CatTorneios;
import oochess.app.domain.CatUtilizadores;
import oochess.app.domain.Utilizador;
import oochess.app.facade.handlers.DesafiarHandler;
import oochess.app.facade.handlers.ProcessarDesafiosHandler;
import oochess.app.facade.handlers.RegistarResultadoHandler;

public class Sessao {
	
	private CatUtilizadores catUtilizadores = new CatUtilizadores();
	private CatTorneios catTorneios = new CatTorneios();
	private Utilizador currentUser;
	
	public Sessao(Utilizador currentUser, CatUtilizadores catUtilizadores, CatTorneios catTorneios) {
		this.currentUser = currentUser;
		this.catUtilizadores = catUtilizadores;
		this.catTorneios = catTorneios;
	}

	public DesafiarHandler getDesafioParaPartidaHandler() {
		return new DesafiarHandler(this.currentUser, catUtilizadores, catTorneios);
	}

	public RegistarResultadoHandler getRegistarResultadoDePartida() {
		return new RegistarResultadoHandler(this.currentUser, this.catUtilizadores);
	}

	public ProcessarDesafiosHandler getProcessarDesafios() {
		return new ProcessarDesafiosHandler();
	}
}
