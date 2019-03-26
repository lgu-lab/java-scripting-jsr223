package lgulab.scripting;

import java.io.File;

import javax.script.ScriptEngine;

public class ScriptFunctions {

	private final ScriptEngine scriptEngine ;

	protected ScriptFunctions(File file, String languageName) throws Exception  {
		super();
//		ScriptEngineManager factory = new ScriptEngineManager();
//		this.scriptEngine = factory.getEngineByName("javascript");
		this.scriptEngine = Util.evalFile(languageName, file);
	}
	
	protected Object invokeFunction(String functionName, Object ... args) throws Exception {
		return Util.invokeFunction(scriptEngine, functionName, args);
	}

//	public String getEntityName(String tableName) throws Exception {
//		Object[] args = {tableName};
//		return (String) Util.invokeFunction(scriptEngine, "getEntityName", args);
//	}
//
//	public boolean isOK(String tableName) throws Exception {
//		Object[] args = {tableName};
//		return (Boolean) Util.invokeFunction(scriptEngine, "isOK", args);
//	}
}
