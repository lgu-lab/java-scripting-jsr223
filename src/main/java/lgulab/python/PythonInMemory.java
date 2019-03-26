package lgulab.python;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import lgulab.scripting.Util;

public class PythonInMemory {
	
	private final static String ENGINE_NAME = "python";
	
	public static void main(String[] args) throws Exception {
		ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
		ScriptEngine scriptEngine = scriptEngineManager.getEngineByName(ENGINE_NAME);
		if ( scriptEngine == null ) {
			System.out.println("ScriptEngine not found for language '" + ENGINE_NAME + "'" );
			return;
		}
		System.out.println("ScriptEngine = " + scriptEngine.toString() );
		
		System.out.println("-----");
		//eval(scriptEngine);
		
		System.out.println("-----");
		variablesSharing1(scriptEngine);
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
	
	public static void variablesSharing1(ScriptEngine scriptEngine) throws Exception {
		
		// Put variables in JS engine context 
		System.out.println("Init context variables... " );
		scriptEngine.put("msg", "Hello");
		scriptEngine.put("a", 3);
		Util.printContextVariables(scriptEngine);
		
		// Run evaluation 
		System.out.println("Evaluation... " );
		scriptEngine.eval("b = 2 + 2");
		scriptEngine.eval("c = a + 10");
		scriptEngine.eval("d = a + b + 10");
		Util.printContextVariables(scriptEngine);

		// Get variables from JS engine context 
		System.out.println("Retrieve variables ... " );
		System.out.println("b = " + scriptEngine.get("b") );
		System.out.println("c = " + scriptEngine.get("c") );
		
	}
	
}
