package oochess.app.elostrategies;



public class ByOne implements EloStrategy {
	
	private static final double STARTING_ELO = 5.0;
	
	private static final int NUM_ELOS = 2;
	
	private static final double ONE = 1.0;
	
	@Override
	public double[] atualizaElo(double eloUser, double eloAdversario, String result) {
		
		double [] resultados = new double[NUM_ELOS];
		
		switch(result) {
			
		case("VITORIA"):
			resultados[0] = eloUser + ONE;
			resultados[1] = eloAdversario - ONE;
			break;
			
		case("DERROTA"):
			resultados[0] = eloUser - ONE;
			resultados[1] = eloAdversario + ONE;
			break;
			
		case("EMPATE"):
			resultados[0] = eloUser;
			resultados[1] = eloAdversario;
			break;
			
		default:
			resultados[0] = eloUser;
			resultados[1] = eloAdversario;
		}
		
		return resultados;
	}

	@Override
	public double getStartingELO() {
		return STARTING_ELO;
	}

}
