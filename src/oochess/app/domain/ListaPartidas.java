package oochess.app.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ListaPartidas {

	private List<Partida> partidas = new ArrayList<>();
	

	public Partida criaDesafio(LocalDateTime datahora, String username, String codigo) {
		Partida p = new Desafio(datahora, username);
		p.setCodigo(codigo);
		this.partidas.add(p);
		
		return p;
	}

	public Partida criaPartidaEspontanea(String username ,LocalDateTime datahora ) {
		Partida p = new PartidaEspontanea(username,datahora);
		this.partidas.add(p);
		
		return p;
	}

	public Partida getPartida(String codigoDesafio) {
		for(Partida p: partidas) {
			if(p.getCodigo().equals(codigoDesafio)) {
				return p;
			}
		}
		return null;
	}

	public List<String> getCincoUltimosUsernames() {
		
		List<String> ultimosCinco = new ArrayList<>();
		
		for(int i=1; i<6 && i<this.partidas.size()-1 ; i++) {
				
			Partida corrente = this.partidas.get(this.partidas.size() - i); 
			ultimosCinco.add(corrente.getAdversario());
		}
		return ultimosCinco;
	}

	
}
