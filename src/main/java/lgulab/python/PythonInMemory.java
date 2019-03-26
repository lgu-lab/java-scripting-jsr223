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
	public static void basicEval(ScriptEngine scriptEngine) throws ScriptException {
		
		scriptEngine.eval("import sys");
		scriptEngine.eval("print 'hello'");
		
		scriptEngine.put("a", 42);
		scriptEngine.eval("print a");
		
		scriptEngine.eval("x = 2 + 2");
		scriptEngine.eval("print x");
        
        System.out.println("[Java] a = " + scriptEngine.get("a") );
        System.out.println("[Java] x = " + scriptEngine.get("x") );
		
		System.out.println("[Java] End.");
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
