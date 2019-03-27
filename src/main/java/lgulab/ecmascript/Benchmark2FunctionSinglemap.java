package lgulab.ecmascript;

import java.util.Hashtable;
import java.util.Map;

/**
 * Benchmark based on function call 
 * Values are passed as function argument (in a map)
 * Very fast (no mapping with engine context)  
 * 
 * Version with a unique map reused for each call
 * 
 * 953 ms
 * 968 ms
 * 984 ms
 * 969 ms
 * 
 * @author l.guerin
 *
 */
public class Benchmark2FunctionSinglemap {
	
	private final static Map<String,Double> STATIC_MAP = new Hashtable<>();
	
	public static void main(String[] args) throws Exception {
		
		JavascriptFunctions myFunctions = new JavascriptFunctions();
		
		System.out.println("Starting... ");
    	long startTime  = System.currentTimeMillis();
    	System.out.println("startTime : " + startTime ); 	
		int n ; 
		for ( n = 0 ; n < BenchmarkConst.NUMBER_OF_ITERATIONS ; n++ ) {
			
			//--- Always the same Map for each iteration : 916/957 ms
			Map<String,Double> map = STATIC_MAP ;
			initMap(STATIC_MAP, n) ;
			
			myFunctions.calc(map);
			
			if ( n % 100000 == 0 ) {
				System.out.println("work in progress : n = " + n + " map = " + map );
			}
		}
    	long endTime  = System.currentTimeMillis();
		System.out.println("Done. n = " + n);
		
    	System.out.println("endTime : " + endTime ); 	
    	long duration = (endTime - startTime) ;
    	System.out.println("duration : " + duration / 1000 + " seconds  (" + duration + " ms)"); 	
		
	}
	
	public static void initMap(Map<String,Double> map, int n) {
		for ( Map.Entry<String,Double> entry : map.entrySet() ) {
			entry.setValue(0.0);
		}		
		int v = n % 100 ;
		map.put("CAFDO", (double)v ) ;
		map.put("CAFDR", 2.0 ) ;
		map.put("CAFDRE", (double)v + 3.5) ;
		map.put("CAFDF", 4.0 );
		map.put("QTE", 12.0 );
		map.put("PPHT", 18.75 );
		map.put("LPC", 3.0 );
	}
}
