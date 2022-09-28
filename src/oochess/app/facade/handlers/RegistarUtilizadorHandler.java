package oochess.app.facade.handlers;

import oochess.app.discordintegration.MyConfiguration;
import oochess.app.domain.CatUtilizadores;
import oochess.app.elostrategies.EloStrategy;

public class RegistarUtilizadorHandler {
	
	private CatUtilizadores catUtilizadores;

	public RegistarUtilizadorHandler(CatUtilizadores catUtilizadores) {
		this.catUtilizadores = catUtilizadores;
	}

	/**
	 * Regista um utilizador normal.
	 * @param discordUsername 
	 * @param Username
	 * @param Password
	 * @ensures existe um utilizador com esse username
	 */
	public void registarUtilizador(String username, String password, String discordUsername) {
		
		EloStrategy eloS = MyConfiguration.getClass("ELO_STRATEGY");
		
        this.catUtilizadores.adicionaUtilizador(username, password, discordUsername, eloS.getStartingELO());
        
        //System.out.println(username + ":" + eloS.getStartingELO());
		
	}

}
