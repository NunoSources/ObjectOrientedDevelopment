package oochess.app.domain;

import java.util.HashMap;

public class CatTorneios {

	private HashMap<String, Torneio> torneios = new HashMap<>();
	
	public Torneio getTorneio(String nome) {
		return this.torneios.get(nome);
	}

	public void add(Torneio t) {
		torneios.put(t.getNome(), t);
	}

}
