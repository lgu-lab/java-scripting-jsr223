package lgulab.ecmascript;

public class JavascriptBenchmark1 {
	
	public static void main(String[] args) throws Exception {
		
		MyFunctions myFunctions = new MyFunctions();
		
		System.out.println("Starting... ");
		for ( int n=0 ; n < 1000000 ; n++ ) {
			double r = myFunctions.add(n, 123.45);
			double m = myFunctions.modulo10(n);
			
			if ( n % 10000 == 0 ) {
				System.out.println("work in progress : n = " + n + " r : " + r + " m = " + m);
			}
		}
		System.out.println("Done. ");
	}
}
