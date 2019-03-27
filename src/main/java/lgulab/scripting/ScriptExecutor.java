package lgulab.scripting;

import java.util.Map;

import javax.script.Compilable;
import javax.script.CompiledScript;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class ScriptExecutor {

	private final CompiledScript compiledScript ;
	
	public ScriptExecutor(String script) throws Exception {
		super();
		ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
		ScriptEngine scriptEngine = scriptEngineManager.getEngineByName("javascript");
		Compilable compilable = (Compilable) scriptEngine;
		
		try {
			compiledScript =  compilable.compile(script);
		} catch (ScriptException e) {
			throw new Exception("Script compilation error.", e);
		}
	}


	public void execute( Map<String,Object> map ) throws Exception {
		
		ScriptEngine scriptEngine = compiledScript.getEngine();
		
		// Put variables in JS engine context ( map --> context )
		for ( Map.Entry<String,Object> entry : map.entrySet() ) {
			scriptEngine.put(entry.getKey(), entry.getValue());			
		}
		
		// Run script evaluation 
		try {
			compiledScript.eval();
		} catch (ScriptException e) {
			throw new Exception("Script eval error.", e);
		} 

		// Get variables from JS engine context ( context --> map )
		for ( Map.Entry<String,Object> entry : map.entrySet() ) {
			entry.setValue(scriptEngine.get(entry.getKey()));
		}

	}
}
