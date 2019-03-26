package lgulab.beans;

public class Values {

	private int a ;
	private int b ; 
	private int c ;
	
	/**
	 * Default constructor 
	 * NB : Zero Argument Constructor is mandatory for each bean 
	 */
	public Values() {
		super();
	}

	public Values(int a, int b) {
		super();
		this.a = a;
		this.b = b;
		this.c = 0;
	}

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	public int getB() {
		return b;
	}

	public void setB(int b) {
		this.b = b;
	}

	public int getC() {
		return c;
	}

	public void setC(int c) {
		this.c = c;
	}

	@Override
	public String toString() {
		return "Values [a=" + a + ", b=" + b + ", c=" + c + "]";
	}
	
}
