package oochess.app;

import java.util.Optional;

import oochess.app.domain.CatTorneios;
import oochess.app.domain.CatUtilizadores;
import oochess.app.domain.Torneio;
import oochess.app.domain.Utilizador;
import oochess.app.facade.Sessao;
import oochess.app.facade.handlers.RegistarUtilizadorHandler;

/**
 * Esta é a classe do sistema.
 */
public class OOChess {
	
	private CatUtilizadores catUtilizadores = new CatUtilizadores();
	private CatTorneios catTorneios = new CatTorneios();
	
	public OOChess() {
		this.catTorneios.add(new Torneio("Torneio Xadrez da CADI"));
		this.catTorneios.add(new Torneio("Torneio Xadrez da Horta"));
		this.catTorneios.add(new Torneio("Torneio Xadrez do MiniCampus"));
	}

	public RegistarUtilizadorHandler getRegistarUtilizadorHandler() {
		return new RegistarUtilizadorHandler(this.catUtilizadores);
	}
	
	/**
	 * Returns an optional Session representing the authenticated user.
	 * @param username
	 * @param password
	 * @return
	 */
	public Optional<Sessao> autenticar(String username, String password) {
		Optional<Utilizador> currentUser = catUtilizadores.tryAuth(username, password);
		return currentUser.map(u -> new Sessao(u, catUtilizadores, catTorneios));
	}

}
