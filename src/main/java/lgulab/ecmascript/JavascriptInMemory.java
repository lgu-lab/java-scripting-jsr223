package lgulab.ecmascript;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class JavascriptInMemory {
	
	private final static String ENGINE_NAME = "javascript";
//	private final static String ENGINE_NAME = "ecmascript";
	
	public static void main(String[] args) throws ScriptException {
		ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
		ScriptEngine scriptEngine = scriptEngineManager.getEngineByName(ENGINE_NAME);
		if ( scriptEngine == null ) {
			System.out.println("ScriptEngine not found for language '" + ENGINE_NAME + "'" );
			return;
		}
		System.out.println("ScriptEngine = " + scriptEngine.toString() );
		
		System.out.println("-----");
		eval(scriptEngine);
		
		System.out.println("-----");
		useContextVariables(scriptEngine);
	}
	
	/**
	 * Get JS result as Java object 
	 * @param scriptEngine
	 * @throws ScriptException
	 */
	public static void eval(ScriptEngine scriptEngine) throws ScriptException {
		
		// Get current month as Java object 
		Double month = (Double) scriptEngine.eval("var date=new Date(); date.getMonth();"); 
		System.out.println("month = " + month );
		
		// Get "s1 + ' world'" as Java object --> "Hello world"
		String s = (String) scriptEngine.eval("var s1 = 'Hello'; s1 + ' world';"); 
		System.out.println("s = " + s );
		
		// Get function result
		int i = (Integer) scriptEngine.eval("function myFunction() { return 123; }; myFunction();"); 
		System.out.println("i = " + i );
		
		// Get nothing
		String r = (String) scriptEngine.eval("");  // Result is null
		System.out.println("r = " + r );
		r = (String) scriptEngine.eval("// nothing to do ");  // Result is null
		System.out.println("r = " + r );
	}
	
	public static void useContextVariables(ScriptEngine jsEngine) throws ScriptException {
		
		// Put variables in JS engine context 
		jsEngine.put("msg", "Hello");
		jsEngine.put("a", 3);

		// Run evaluation 
		jsEngine.eval("var b = a + 2;   var hello = msg + ' world' ; ");

		// Get variables from JS engine context 
		System.out.println("a = " + jsEngine.get("b") );
		System.out.println("hello = " + jsEngine.get("hello") );
	}
	
	
}
