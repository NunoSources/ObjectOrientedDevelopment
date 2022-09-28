package oochess.app.elostrategies;



public class TenPercent implements EloStrategy{

	private static final double STARTING_ELO = 50.0;

	private static final double PERCENTAGE = 0.1;
	
	private static final double DRAW_PERCENTAGE = 0.05;
	
	private static final int NUM_ELOS = 2;
	
	@Override
	public double[] atualizaElo(double eloUser, double eloAdversario, String result) {
		
		double[] resultados = new double[NUM_ELOS];
		
		double dif = Math.abs(eloUser - eloAdversario);
		
		double value = (dif * PERCENTAGE) + 5.0;
		
		double drawValue = dif * DRAW_PERCENTAGE;
		
		switch(result) {
		
		case("VITORIA"):
			resultados[0] = eloUser + value;
			resultados[1] = eloAdversario - value;
			break;
			
		case("DERROTA"):
			resultados[0] = eloUser - value;
			resultados[1] = eloAdversario + value;
			break;
		
		case("EMPATE"):
			if(eloUser > eloAdversario) {
				resultados[0] = eloUser - drawValue;
				resultados[1] = eloAdversario + drawValue;
			}else if(eloAdversario > eloUser) {
				resultados[0] = eloUser + drawValue;
				resultados[1] = eloAdversario - drawValue;
			}else {
				resultados[0] = eloUser;
				resultados[1] = eloAdversario;
			}
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
