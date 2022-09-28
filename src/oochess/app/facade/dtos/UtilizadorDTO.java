package oochess.app.facade.dtos;

public class UtilizadorDTO {
	
	private String username;
	private String discordUsername;
	private int elo;
	
	public UtilizadorDTO(String username, String discordUsername, int elo) {
		this.username = username;
		this.discordUsername = discordUsername;
		this.elo = elo;
	}

	public String getName() {
		return this.username;
	}
	
	public String discordUsername() {
		return this.discordUsername;
	}
	
	public int getElo() {
		return this.elo;
	}

}
