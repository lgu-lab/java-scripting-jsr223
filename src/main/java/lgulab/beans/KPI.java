package lgulab.beans;

public class KPI {

	public double CAFDO ;
	public double CAFDR ; 
	public double CAFDRE ; 
	public double CAFVD = 0.0 ; // ( QTE x PPHT ) + LPC
	public double RCA   = 0.0 ; // CAFDP + CAFDRE
	public double CAFDF ;
	public double CAFDP = 0.0 ; // CAFDF + CAFDRE
	public double CAFA  = 0.0 ; // CAFDP + CAFVD
	
	public double QTE ;
	public double PPHT ;
	public double LPC ;

	/**
	 * Default constructor 
	 * NB : Zero Argument Constructor is mandatory for each bean 
	 */
	public KPI() {
		super();
	}

	@Override
	public String toString() {
		return "KPI [CAFDO=" + CAFDO + ", CAFDR=" + CAFDR + ", CAFDRE=" + CAFDRE + ", CAFVD=" + CAFVD + ", RCA=" + RCA
				+ ", CAFDF=" + CAFDF + ", CAFDP=" + CAFDP + ", CAFA=" + CAFA + ", QTE=" + QTE + ", PPHT=" + PPHT
				+ ", LPC=" + LPC + "]";
	}

}
