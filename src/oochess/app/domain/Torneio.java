package oochess.app.domain;

import java.util.ArrayList;
import java.util.List;


public class Torneio {
	
	private String nome;
	private List<Partida> jogos = new ArrayList<>();

	public Torneio(String nome) {
		this.setNome(nome);
	}
	
	public void addPartida(Partida partida) {
		jogos.add(partida);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
