package lgulab.scripting;

import java.util.List;

import javax.script.ScriptEngineFactory;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Engines {

	public static void main(String[] args) throws ScriptException {
		printAvailableEngines();
	}
	
	public static void printAvailableEngines() throws ScriptException {
		ScriptEngineManager mgr = new ScriptEngineManager();
        List<ScriptEngineFactory> factories = mgr.getEngineFactories();

        for (ScriptEngineFactory factory : factories) {

            System.out.println("ScriptEngineFactory Info");

            String engName = factory.getEngineName();
            String engVersion = factory.getEngineVersion();
            String langName = factory.getLanguageName();
            String langVersion = factory.getLanguageVersion();

            System.out.printf("\tScript Engine: %s (%s) \n", engName, engVersion);
            System.out.printf("\tLanguage: %s (%s) \n", langName, langVersion);

            List<String> extensions = factory.getExtensions();
            if (extensions.size() > 0) {
                System.out.println("\tEngine supports the following extensions:");
                for (String e : extensions) {
                    System.out.println("\t\t" + e);
                }
            }
            List<String> shortNames = factory.getNames();
            if (shortNames.size() > 0) {
                System.out.println("\tEngine has the following short names:");
                for (String n : factory.getNames()) {
                    System.out.println("\t\t" + n);
                }
            }
        }
	}

}
