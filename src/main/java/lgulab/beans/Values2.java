package lgulab.beans;

public class Values2 {

	public int a ;
	public int b ; 
	public int c ;
	
	/**
	 * Default constructor 
	 * NB : Zero Argument Constructor is mandatory for each bean 
	 */
	public Values2() {
		super();
	}

	public Values2(int a, int b) {
		super();
		this.a = a;
		this.b = b;
		this.c = 0;
	}

	@Override
	public String toString() {
		return "Values [a=" + a + ", b=" + b + ", c=" + c + "]";
	}
	
}
