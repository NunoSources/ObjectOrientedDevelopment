package oochess.app.facade.handlers;

import java.time.LocalDateTime;
import java.util.List;


import oochess.app.discordintegration.MyConfiguration;
import oochess.app.domain.CatUtilizadores;
import oochess.app.domain.Partida;
import oochess.app.domain.Utilizador;
import oochess.app.elostrategies.EloStrategy;


/**
 * 
 * @author Goncalo Santos - fc51962
 *
 */
public class RegistarResultadoHandler {

	//Utilizador corrente
	private Utilizador currentUser;
	
	//Utilizador adversario
	private Utilizador advUser;
	
	//Catalogo de Utilizadores
	private CatUtilizadores catU;
	
	//Partida Corrente
	private Partida p;
	
	
	public RegistarResultadoHandler(Utilizador currentUser, CatUtilizadores catU) {
		this.currentUser = currentUser;
		this.catU = catU;
	}

	public void indicaDesafio(String codigoDesafio) {

		
		this.p = this.currentUser.getPartida(codigoDesafio);
		advUser = catU.getUtilizador(this.p.getAdversario());
		
	}

	public List<String> indicaPartidaEspontanea() {
		return this.currentUser.getCincoUltimosUsernames();

	}

	
	
	public void indicaDetalhes(String username, LocalDateTime datahora) {
		
		this.p = this.currentUser.criaPartidaEspontanea(datahora, username);
		
		this.advUser = catU.getUtilizador(username);
		this.advUser.criaPartidaEspontanea(datahora, currentUser.getUsername());
		
	}

	public double indicarResultado(String resultado) {
		
		EloStrategy eloS = MyConfiguration.getClass("ELO_STRATEGY");
		
		this.p.registaResultado(resultado);
        
        double[] results = eloS.atualizaElo(currentUser.getElo(), advUser.getElo(), this.p.getResultado()); 
	 
        //Atribuir aos 2 users os seus novos elos
        this.currentUser.setElo(results[0]);
        this.advUser.setElo(results[1]);
	
	 
        return results[0];
	}
}
