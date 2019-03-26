package lgulab.ecmascript;

public class JavascriptBenchmark1 {
	
	public static void main(String[] args) throws Exception {
		
		JavascriptFunctions myFunctions = new JavascriptFunctions();
		
		System.out.println("Starting... ");
    	long startTime  = System.currentTimeMillis();
    	System.out.println("startTime : " + startTime ); 	
		int n ; 
		for ( n = 0 ; n < 1000000 ; n++ ) {
			double r = myFunctions.add(n, 123.45);
			int    m = myFunctions.modulo10(n);
			
			if ( n % 10000 == 0 ) {
				System.out.println("work in progress : n = " + n + " r : " + r + " m = " + m);
			}
		}
    	long endTime  = System.currentTimeMillis();
		System.out.println("Done. n = " + n);
		
    	System.out.println("endTime : " + endTime ); 	
    	long duration = (endTime - startTime) ;
    	System.out.println("duration : " + duration / 1000 + " seconds  (" + duration + " ms)"); 	
		
	}
}
