package lgulab.ecmascript;

import lgulab.scripting.ScriptFunctions;
import lgulab.scripting.Util;

public class MyFunctions extends ScriptFunctions {

	public MyFunctions() throws Exception {
		super(Util.getResourceFile("functions.js"), "javascript");
	}
	
	public Double add(double a, double b) throws Exception {
		Object[] args = {a, b };
		return (Double) invokeFunction( "add", args);
	}

	public Double modulo10(int a) throws Exception {
		Object[] args = {a};
		return (Double) invokeFunction( "modulo10", args);
	}

	public boolean isOK(String s) throws Exception {
		Object[] args = {s};
		return (Boolean) invokeFunction( "isOK", args);
	}

}
