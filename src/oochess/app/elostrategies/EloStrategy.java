package oochess.app.elostrategies;



public interface EloStrategy {

	public double[] atualizaElo(double eloUser, double eloAdversario, String result);
	public double getStartingELO();
	
}
