package oochess.app.facade.handlers;

import java.time.LocalDateTime;
import java.util.List;

import oochess.app.discordintegration.MsgSenderMethod;
import oochess.app.discordintegration.MyConfiguration;
import oochess.app.domain.CatTorneios;
import oochess.app.domain.CatUtilizadores;
import oochess.app.domain.Partida;
import oochess.app.domain.Torneio;
import oochess.app.domain.Utilizador;


/**
 * 
 * @author Nuno Fontes - fc46413
 *
 */
public class DesafiarHandler {

	private CatUtilizadores catUtilizadores;
	private Torneio t;
	private CatTorneios catTorneios;
	private Utilizador adv;
	private Utilizador currentUser;
	private boolean existeTorneio;

	public DesafiarHandler(Utilizador currentUser, CatUtilizadores catUtilizadores, CatTorneios catTorneios) {
		this.currentUser = currentUser;
		this.catUtilizadores = catUtilizadores;
		this.catTorneios = catTorneios;
	}

	public void indicaTorneio(String nome) {
		this.t = this.catTorneios.getTorneio(nome);
		if(this.t == null)
			throw new NullPointerException("Torneio inexistente");
		existeTorneio = true;
	}

	public List<String> indicaDeltaElo(int delta) { 
		return this.catUtilizadores.getUtilizadores(delta);
	}

	public void indicaJogador(String nome) {
		this.adv = this.catUtilizadores.getUtilizador(nome);
	}

	public String indicaDetalhes(LocalDateTime datahora, String msg) {
		String codigo;
		codigo = this.currentUser.getUsername() + this.adv.getUsername() + datahora;
		
		Partida p = this.currentUser.criaPartida(datahora, this.adv.getUsername(), codigo);
		this.adv.criaPartida(datahora, this.currentUser.getUsername(), codigo);
		
		if(existeTorneio)
			this.t.addPartida(p);
		
		MsgSenderMethod msgSender = MyConfiguration.getClass("DISCORD_CLASS");

		msgSender.sendMessage(this.adv.getDiscordUsername(), "O jogador " + currentUser.getUsername() + " convidou-o para uma partida de xadrez em " + datahora + ":" + msg);
		
		return codigo;
		
	}
}
