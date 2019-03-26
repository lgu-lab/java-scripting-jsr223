package lgulab.scripting;

import java.io.File;

import javax.script.ScriptEngine;

/**
 * Abstract class for script functions invocation 
 * 
 * @author lgu
 *
 */
public abstract class ScriptFunctions {

	private final ScriptEngine scriptEngine ;

	protected ScriptFunctions(File file, String languageName) throws Exception  {
		super();
		this.scriptEngine = Util.evalFile(languageName, file);
	}
	
	protected Object invokeFunction(String functionName, Object ... args) throws Exception {
		return Util.invokeFunction(scriptEngine, functionName, args);
	}

}
