package oochess.app.domain;

import java.time.LocalDateTime;
import java.util.List;


public class Utilizador {

	private double elo;
	private ListaPartidas listaPartidas;
	private String username;
	private String password;
	private String discordUsername;
	
	public Utilizador(String username, String password, String discordUsername, double startingELO) {
		this.username = username;
		this.password = password;
		this.elo = startingELO;
		this.discordUsername = discordUsername;
		this.listaPartidas = new ListaPartidas();
	}

	public boolean eloAceitavel(int delta, double elo) {
		return Math.abs(this.elo - elo) < delta;
	}

	public String getNomeEElo() {
		return this.username + ": " + elo;
	}

	public ListaPartidas getListaPartidas() {
		return listaPartidas;
	}
	
	public boolean hasPassword(String password) {
		return this.password.contentEquals(password);
	}
	
	public String getUsername() {
		return this.username;
	}
	
	public String getDiscordUsername() {
		return this.discordUsername;
	}
	
	public double getElo() {
		return this.elo;
	}
	
	public void setElo(double elo) {
		this.elo = elo;
	}
	
	public Partida criaPartida(LocalDateTime datahora, String username, String codigo) {
        return this.listaPartidas.criaDesafio(datahora, username, codigo);
    }

	public Partida criaPartidaEspontanea(LocalDateTime datahora, String username) {
		return this.listaPartidas.criaPartidaEspontanea(username, datahora);
		
	}
	
	public Partida getPartida(String codigo) {
		return this.listaPartidas.getPartida(codigo);
	}
	
	public List<String> getCincoUltimosUsernames(){
		return this.listaPartidas.getCincoUltimosUsernames();
	}
}
