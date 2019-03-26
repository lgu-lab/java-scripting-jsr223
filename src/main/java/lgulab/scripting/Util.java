package lgulab.scripting;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.net.URL;

import javax.script.Bindings;
import javax.script.Invocable;
import javax.script.ScriptContext;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Util {

	public static void printContextVariables(ScriptEngine scriptEngine) throws Exception {

		System.out.println(" | Current script engine context ('ENGINE_SCOPE') : " );
		Bindings bindings = scriptEngine.getContext().getBindings(ScriptContext.ENGINE_SCOPE );
		for ( String key : bindings.keySet() ) {
			System.out.println(" | . '" + key + "' = " + bindings.get(key));
		}		
	}
	
	public static File getResourceFile(String fileName) throws Exception {
		URL fileURL = Util.class.getClassLoader().getResource(fileName); 
		if ( fileURL == null ) {
			throw new Exception("File '" + fileName + "' not found in 'src/main/resources'!");
		}
		File file = new File(fileURL.getFile());
		return file ;
	}
	
	public static ScriptEngine evalFile(String languageName, File file) throws Exception {
		ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
		ScriptEngine scriptEngine = scriptEngineManager.getEngineByName(languageName);	
		evalFile(scriptEngine, file);
		return scriptEngine ;
	}
	
	public static void evalFile(ScriptEngine scriptEngine, File file) throws Exception {
		
		System.out.println( "Script file : " + file.getAbsolutePath() ) ;
		Reader reader;
		try {
			reader = new FileReader( file );
		} catch (FileNotFoundException e1) {
			throw new Exception("File '" + file.getName() + "' not found.");
		}
		
		try {
			scriptEngine.eval(reader);
		}
		finally {
			try {
				reader.close();
			} catch (IOException e1) {
				throw new Exception("Cannot close file '" + file.getName() + "'");
			}				
		}
	}

	public static Object invokeFunction(ScriptEngine scriptEngine, String functionName, Object... args) throws Exception {
		Invocable invocableEngine = (Invocable) scriptEngine ;
		Object result = null ;
		try {
			result = invocableEngine.invokeFunction(functionName, args) ;
		} catch (NoSuchMethodException e1) {
			throw new Exception("Function '" + functionName + "' not found (NoSuchMethodException)", e1) ;
		} catch (ScriptException e1) {
			throw new Exception("Error in function '" + functionName + "' (ScriptException)", e1) ;
		}
		return result ;
	}
	
}
