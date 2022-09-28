package oochess.app.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;


public class CatUtilizadores {
	
	private HashMap<String, Utilizador> utilizadores = new HashMap<>();

	public List<String> getUtilizadores(int delta) {
		List<String> jogadoresAdversarios = new ArrayList<>(); //1.1
		for(Utilizador adv : utilizadores.values()) {
			boolean b = adv.eloAceitavel(delta, adv.getElo());//1.2
			if(b) { //1.3
				String n = adv.getNomeEElo();
				jogadoresAdversarios.add(n); //1.4
			}
		}
		return jogadoresAdversarios;
	}

	public Utilizador getUtilizador(String username) {
		return this.utilizadores.get(username);
	}

	public void adicionaUtilizador(String username, String password, String discordUsername, double startingELO) {
		this.utilizadores.put(username, new Utilizador(username, password, discordUsername, startingELO));
	}

	public Optional<Utilizador> tryAuth(String username, String password){
		return Optional.ofNullable(this.utilizadores.get(username)).filter(u -> u.hasPassword(password));
	}
	
}
