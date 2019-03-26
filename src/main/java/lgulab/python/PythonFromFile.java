package lgulab.python;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

import lgulab.scripting.Util;

public class PythonFromFile {
	
	private final static String ENGINE_NAME = "python";
	
	public static void main(String[] args) throws Exception {
		ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
		ScriptEngine scriptEngine = scriptEngineManager.getEngineByName(ENGINE_NAME);
		
		Util.evalFile(scriptEngine, Util.getResourceFile("test1.py") );
		Util.printContextVariables(scriptEngine);
		// Get variables from JS engine context 
		System.out.println("x = " + scriptEngine.get("x") );
		System.out.println("y = " + scriptEngine.get("y") );
		System.out.println("z = " + scriptEngine.get("z") );
	}
	
}
