package lgulab.python;

import lgulab.scripting.ScriptFunctions;
import lgulab.scripting.Util;

public class PythonFunctions extends ScriptFunctions {

	public PythonFunctions() throws Exception {
		super(Util.getResourceFile("functions.py"), "python");
	}
	
	public Double add(double a, double b) throws Exception {
		Object[] args = {a, b };
		return (Double) invokeFunction( "add", args);
	}

	public Integer modulo10(int a) throws Exception {
		Object[] args = {a};
		return (Integer) invokeFunction( "modulo10", args);
	}

	public boolean isOK(String s) throws Exception {
		Object[] args = {s};
		return (Boolean) invokeFunction( "isOK", args);
	}

}
