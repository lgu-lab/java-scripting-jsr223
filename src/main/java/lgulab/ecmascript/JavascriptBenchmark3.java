package lgulab.ecmascript;

import java.util.Hashtable;
import java.util.Map;

import javax.script.Bindings;
import javax.script.Compilable;
import javax.script.CompiledScript;
import javax.script.ScriptContext;
import javax.script.ScriptEngine;
import javax.script.ScriptException;

import lgulab.scripting.Util;

/**
 * Benchmark with a single reusable map
 * 
 * Without script compilation :
 * 5776 ms 
 * 5621 ms
 * 5658 ms
 * 
 * With script compilation :
 * 2952 ms
 * 2904 ms 
 * 2983 ms
 * 
 * @author l.guerin
 *
 */
public class JavascriptBenchmark3 {
	
	private final static Map<String,Object> STATIC_MAP = new Hashtable<>();
	
	public static void main(String[] args) throws Exception {
		
		ScriptEngine scriptEngine = Util.getScriptEngine("javascript");
		
		String script = "" 
				+ ""
				+ "// Compute missing KPI  \n"
				+ "CAFVD = ( QTE * PPHT ) + LPC ; \n"
				+ "CAFDP = CAFDF + CAFDRE ; \n"
				+ "RCA = CAFDP + CAFDRE ; \n"
				+ "CAFA = CAFDP + CAFVD ; \n"					
				+ "// CAFA = 'AAAAA' ; \n"					
				;
		
		Compilable compilable = (Compilable) scriptEngine;
		CompiledScript compiledScript =  compilable.compile(script);

		System.out.println("Starting... ");
    	long startTime  = System.currentTimeMillis();
    	System.out.println("startTime : " + startTime ); 	
		int n ; 
		for ( n = 0 ; n < 1000000 ; n++ ) {
			
			//--- New Map for each iteration : 1053/1145 ms
//			Map<String,Double> map = buildMap(n);
			
//			//--- Always the same Map for each iteration : 916/957 ms
			initValues(STATIC_MAP, n) ;
			Map<String,Object> map = STATIC_MAP ;
			
			//executeScript(scriptEngine, script, map);
			//Map<String,Object> map = executeCompiledScript2(compiledScript, n);
			executeCompiledScript(compiledScript, map);
			
			if ( n % 100000 == 0 ) {
				System.out.println("work in progress : n = " + n + " map = " + map );
				//print( map);
			}
		}
    	long endTime  = System.currentTimeMillis();
		System.out.println("Done. n = " + n);
		
    	System.out.println("endTime : " + endTime ); 	
    	long duration = (endTime - startTime) ;
    	System.out.println("duration : " + duration / 1000 + " seconds  (" + duration + " ms)"); 	
		
	}
	
	public static void executeScript(ScriptEngine scriptEngine, String script, Map<String,Object> map) throws ScriptException {
		
		// Put variables in JS engine context ( map --> context )
		for ( Map.Entry<String,Object> entry : map.entrySet() ) {
			scriptEngine.put(entry.getKey(), entry.getValue());			
		}

		// Run evaluation 
		scriptEngine.eval(script); 

		// Get variables from JS engine context  ( context --> map )
		for ( Map.Entry<String,Object> entry : map.entrySet() ) {
			entry.setValue(scriptEngine.get(entry.getKey()));
		}
	}

	public static void executeCompiledScript(CompiledScript compiledScript, Map<String,Object> map) throws ScriptException {
		
		ScriptEngine scriptEngine = compiledScript.getEngine();
		
		// Put variables in JS engine context ( map --> context )
		for ( Map.Entry<String,Object> entry : map.entrySet() ) {
			scriptEngine.put(entry.getKey(), entry.getValue());			
		}
		
		// Run evaluation 
		//scriptEngine.eval(script); 
		compiledScript.eval(); 

		// Get variables from JS engine context  ( context --> map )
		for ( Map.Entry<String,Object> entry : map.entrySet() ) {
			entry.setValue(scriptEngine.get(entry.getKey()));
		}
		//return map;
	}

	public static Map<String,Object> executeCompiledScript2(CompiledScript compiledScript, int n) throws ScriptException {
		
		ScriptEngine scriptEngine = compiledScript.getEngine();
		
		Bindings bindings = scriptEngine.getBindings(ScriptContext.ENGINE_SCOPE);
		
		bindings.clear();
		Map<String,Object> map = (Map<String,Object>) bindings ;
		
		// Put variables in JS engine context ( map --> context )
//		for ( Map.Entry<String,Object> entry : map.entrySet() ) {
//			scriptEngine.put(entry.getKey(), entry.getValue());			
//		}
		initValues(map, n);
		
		// Run evaluation 
		//scriptEngine.eval(script); 
		compiledScript.eval(bindings); 

		// Get variables from JS engine context  ( context --> map )
//		for ( Map.Entry<String,Object> entry : map.entrySet() ) {
//			entry.setValue(scriptEngine.get(entry.getKey()));
//		}
		return map;
	}

	public static void initValues(Map<String,Object> map, int n) {
		int v = n % 100 ;

		// Values provided
		map.put("CAFDO", (double)v + 0.5) ;
		map.put("CAFDR", 2.0 ) ;
		map.put("CAFDRE", (double)v + 3.5) ;
		map.put("CAFDF", 4.0 );
		map.put("QTE", 12.0 );
		map.put("PPHT", 18.75 );
		map.put("LPC", 3.0 );
		
		// Values to be calculated (initialized with ZERO value)
		map.put("CAFVD", 0.0) ;
		map.put("CAFDP", 0.0) ;
		map.put("RCA", 0.0) ;
		map.put("CAFA", 0.0) ;
		
	}

	public static void print(Map<String,Object> map) {
		for ( Map.Entry<String,Object> entry : map.entrySet() ) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}		
	}
}
